package beans.combat;

import beans.ArmourItem;
import beans.Attribute;
import beans.Botch;
import beans.Character;
import beans.Critical;
import beans.CriticalOutcome;
import beans.Item;
import beans.Skill;
import beans.WeaponItem;
import utils.Utils;
import utils.Tables.Tables;
import utils.Tables.Tables_AT;
import utils.Tables.Tables_Crit;

public class AttackOutcome {
	
	private int rollCalculation;
	private String tableAttackRoll;
	
	/*Roll Outcome*/
	private int lifePointsCaused = 0;

	
	/*Additional Critical Effects*/
	private CriticalOutcome mainCriticalOutcome;
	private CriticalOutcome secondCriticalOutcome;
	
	private Botch botch;
	
	private int resistanceRollModificators;
	
	public AttackOutcome(int rollCalculation, Attack attack) {
		this.rollCalculation = rollCalculation;
		outcome(rollCalculation,  attack);
		
	}

	private void outcome(int rollCalculation, Attack attack) {
		
		String tableOutcome = "";
		
		int enemyArmourType = 0;
		if (attack.getEnemyArmour() == null){
			enemyArmourType = Tables_AT.AT_NOAR;
		}
		
		
		if(attack.getEnemyArmour() != null && attack instanceof AttackMelee){
			
			if(attack.enemyArmour.getType().equalsIgnoreCase("SOFT LEATHER")){
				enemyArmourType = Tables_AT.AT_SOFLEA;
			}else if(attack.enemyArmour.getType().equalsIgnoreCase("RIGID LEATHER")){
				enemyArmourType = Tables_AT.AT_RIGLEA;
			}else if(attack.enemyArmour.getType().equalsIgnoreCase("CHAIN")){
				enemyArmourType = Tables_AT.AT_CHAIN;
			}else if(attack.enemyArmour.getType().equalsIgnoreCase("PLATE")){
				enemyArmourType = Tables_AT.AT_PLATE;
			}
			
			int id_row = 0;
			
			if(attack.getCategory() == Attack.EDGED){
				id_row = checkRow("AT1",rollCalculation);
				tableOutcome = Tables.getTableValue("AT1", id_row, enemyArmourType);
			}else if(attack.getCategory() == Attack.CONCUSSION){
				id_row = checkRow("AT2",rollCalculation);
				tableOutcome = Tables.getTableValue("AT2", id_row, enemyArmourType);
			}else if(attack.getCategory() == Attack.TWO_HANDED){
				id_row = checkRow("AT3",rollCalculation);
				tableOutcome = Tables.getTableValue("AT3", id_row, enemyArmourType);
			}else if(attack.getCategory() == Attack.PROJECTILE){
				id_row = checkRow("AT4",rollCalculation);
				tableOutcome = Tables.getTableValue("AT4", id_row, enemyArmourType);
			}else if(attack.getCategory() == Attack.CLAWS_BITE){
				id_row = checkRow("AT5",rollCalculation);
				tableOutcome = Tables.getTableValue("AT5", id_row, enemyArmourType);
			}else if(attack.getCategory() == Attack.GRIP_UNBALANCE){
				id_row = checkRow("AT6",rollCalculation);
				tableOutcome = Tables.getTableValue("AT6", id_row, enemyArmourType);
			}

			
		}else if(attack instanceof AttackProjectile){
			
		}else if(attack instanceof AttackSpell){
			
		}
		
		this.tableAttackRoll = tableOutcome;
		System.out.println("Resultado obtenido: "+tableOutcome);
		
		String[] tableOutcomeSplit = tableOutcome.split("-");
		lifePointsCaused = Utils.castToInt(tableOutcomeSplit[0]);
		
		if(lifePointsCaused > 0){
			System.out.println("Impacto!! -> El golpe aplica "+lifePointsCaused+" puntos de vida." );
		}else{
			
			System.out.println("El golpe no se consigue dañar al objetivo.");
			
			showAdditionalAttackInformation(attack.getParryBonus(), attack.getActor(),attack.getEnemy());
			
		}
		
		attack.getEnemy().lifePointsLost(lifePointsCaused);
		
		String tableCrit = "";
		if(tableOutcome.contains("-")){
			tableCrit = tableOutcomeSplit[1];
		}
		
		if(!tableCrit.isEmpty()){
			
			WeaponItem weapon = attack.getWeapon();
			/*TODO : Gestionar criticos no relacionado con armas*/
			
			if(weapon.getMainCritical() != null){
				
				mainCriticalOutcome = new CriticalOutcome();
				mainCriticalOutcome.criticalAssess(tableCrit, attack.getEnemy(), attack.getActor(), weapon.getMainCritical());
				/*Añadir al total los daños causados del 1º CRIT*/
				
				mainCriticalOutcome.applyOutcome(attack.getEnemy());
				
				//assaultsStunned = assaultsStunned + mainCritical.getAssaultsStunned();*/
			}
			
			if(weapon.getSecondCritical() != null){
				
				if(mainCriticalOutcome.getCritGravity().equals(Critical.CRITICAL_C) ||
						mainCriticalOutcome.getCritGravity().equals(Critical.CRITICAL_D)
						|| mainCriticalOutcome.getCritGravity().equals(Critical.CRITICAL_E)){
				
					String secondCritMaxGravity = secondCriticalGravityAssess(mainCriticalOutcome.getCritGravity());
						
					System.out.println("GOLPE CRITICO ADICIONAL!! Gravedad : "+secondCritMaxGravity
							+ " de tipo " + Tables.getCritical_type()[weapon.getSecondCritical().getCriticalType()] );
					
					secondCriticalOutcome = new CriticalOutcome();
					secondCriticalOutcome.criticalAssess(secondCritMaxGravity, attack.getEnemy(), attack.getActor(), weapon.getSecondCritical());
	
					/*Añadir al total los daños causados del 2º CRIT*/
					secondCriticalOutcome.applyOutcome(attack.getEnemy());
					//assaultsStunned = assaultsStunned + secondCritical.getAssaultsStunned();*/
				}
				
			}
			

		}
		
	}

	
	/** Show a detailed information about what happened with a Missed Attack*/
	private void showAdditionalAttackInformation(int enemyParryBonus, Character actor, Character enemy) {
		
		
		ArmourItem enemyShield = (ArmourItem)enemy.getEquippedGear().get(Item.SHIELD);
		ArmourItem enemyArmour = (ArmourItem)enemy.getEquippedGear().get(Item.ARMOUR);
		int enemyBDDex = enemy.getAttributes().get(Attribute.AGILITY).getModifTotal();
		
		int enemyShieldBD = 0;
		if(enemyShield!=null)
			enemyShieldBD = enemyShield.getSkillMods()[Skill.BD];
		
		String enemyArmourType= "";
		if(enemyArmour == null){
			enemyArmourType = null;
		}else{
			enemyArmourType = enemyArmour.getType();
		}
		
		int thresold = ArmourItem.calculThresold(enemyArmourType);
		
		if(enemyParryBonus>0 && enemyShield!=null && enemy.isAbleToBlock()){
			
			if(rollCalculation + enemyParryBonus >= thresold){
				System.out.println(actor.getName()+"'s Attack has been PARRIED by "+ enemy.getName() + "'s Ability!!");
			}else if(rollCalculation + enemyParryBonus + enemyShieldBD >= thresold){
				System.out.println(actor.getName()+"'s Attack has been DEFLECTED by "+ enemy.getName() + "'s Shield!!");
			}else if(rollCalculation + enemyParryBonus + enemyShieldBD + enemyBDDex >= thresold){
				System.out.println(actor.getName()+"'s Attack has been DODGED by "+ enemy.getName() + "'s Reflexes !!");
			}else{
				System.out.println(actor.getName()+"'s Attack has MISSED!");
			}
				
		}else if(enemyParryBonus>0 && (enemyShield==null || !enemy.isAbleToBlock())){
			if(rollCalculation + enemyParryBonus >= thresold){
				System.out.println(actor.getName()+"'s Attack has been PARRIED by "+ enemy.getName() + "'s Ability!!");
			}else if(rollCalculation + enemyParryBonus + enemyBDDex >= thresold){
				System.out.println(actor.getName()+"'s Attack has been DODGED by "+ enemy.getName() + "'s Reflexes !!");
			}else{
				System.out.println(actor.getName()+"'s Attack has MISSED!");
			}
		}else if(enemyShield!=null && enemy.isAbleToBlock() && enemyParryBonus == 0){
			if(rollCalculation + enemyShieldBD >= thresold){
				System.out.println(actor.getName()+"'s Attack has been DEFLECTED by "+ enemy.getName() + "'s Shield!!");
			}else if(rollCalculation + enemyShieldBD + enemyBDDex >= thresold){
				System.out.println(actor.getName()+"'s Attack has been DODGED by "+ enemy.getName() + "'s Reflexes !!");
			}else{
				System.out.println(actor.getName()+"'s Attack has MISSED!");
			}
		}else if((enemyShield==null || !enemy.isAbleToBlock()) && enemyParryBonus == 0){
			if(rollCalculation + enemyBDDex >= thresold){
				System.out.println(actor.getName()+"'s Attack has been DODGED by "+ enemy.getName() + "'s Reflexes !!");
			}else{
				System.out.println(actor.getName()+"'s Attack has MISSED!");
			}
		}
		
	}

	private String secondCriticalGravityAssess(String critGravity) {
		String ret = "";
		if(critGravity.equals(Critical.CRITICAL_C)){
			return Critical.CRITICAL_A;
		}else if(critGravity.equals(Critical.CRITICAL_D)){
			return Critical.CRITICAL_B;
		}else if(critGravity.equals(Critical.CRITICAL_E)){
			return Critical.CRITICAL_C;
		}
		return ret;
	}

	public String getTableAttackRoll() {
		return tableAttackRoll;
	}

	public void setTableAttackRoll(String tableAttackRoll) {
		this.tableAttackRoll = tableAttackRoll;
	}
	
	
	
	
	public CriticalOutcome getMainCriticalOutcome() {
		return mainCriticalOutcome;
	}

	public void setMainCriticalOutcome(CriticalOutcome mainCriticalOutcome) {
		this.mainCriticalOutcome = mainCriticalOutcome;
	}

	public CriticalOutcome getSecondCriticalOutcome() {
		return secondCriticalOutcome;
	}

	public void setSecondCriticalOutcome(CriticalOutcome secondCriticalOutcome) {
		this.secondCriticalOutcome = secondCriticalOutcome;
	}

	public static int checkRow(String table, int rollCalculation) {
		int rowId = 0;
		
		if(table.equals("AT1")){
		
			if(rollCalculation <= 8){
				rowId = 0;
			}else if(rollCalculation >8 && rollCalculation <= 45){
				rowId = 1;
			}else if(rollCalculation >45 && rollCalculation <= 50){
				rowId = 2;
			}else if(rollCalculation >50 && rollCalculation <= 55){
				rowId = 3;
			}else if(rollCalculation >55 && rollCalculation <= 60){
				rowId = 4;
			}else if(rollCalculation >60 && rollCalculation <= 65){
				rowId = 5;
			}else if(rollCalculation >65 && rollCalculation <= 70){
				rowId = 6;
			}else if(rollCalculation >70 && rollCalculation <= 75){
				rowId = 7;
			}else if(rollCalculation >75 && rollCalculation <= 80){
				rowId = 8;
			}else if(rollCalculation >80 && rollCalculation <= 85){
				rowId = 9;
			}else if(rollCalculation >85 && rollCalculation <= 90){
				rowId = 10;
			}else if(rollCalculation >90 && rollCalculation <= 95){
				rowId = 11;
			}else if(rollCalculation >95 && rollCalculation <= 100){
				rowId = 12;
			}else if(rollCalculation >100 && rollCalculation <= 105){
				rowId = 13;
			}else if(rollCalculation >105 && rollCalculation <= 110){
				rowId = 14;
			}else if(rollCalculation >110 && rollCalculation <= 115){
				rowId = 15;
			}else if(rollCalculation >115 && rollCalculation <= 120){
				rowId = 16;
			}else if(rollCalculation >120 && rollCalculation <= 125){
				rowId = 17;
			}else if(rollCalculation >125 && rollCalculation <= 130){
				rowId = 18;
			}else if(rollCalculation >130 && rollCalculation <= 135){
				rowId = 19;
			}else if(rollCalculation >135 && rollCalculation <= 140){
				rowId = 20;
			}else if(rollCalculation >140 && rollCalculation <= 145){
				rowId = 21;
			}else if(rollCalculation >145){
				rowId = 22;
			}
		}else if(table.equals("AT2")){
		
			if(rollCalculation <= 8){
				rowId = 0;
			}else if(rollCalculation >8 && rollCalculation <= 35){
				rowId = 1;
			}else if(rollCalculation >35 && rollCalculation <= 40){
				rowId = 2;
			}else if(rollCalculation >40 && rollCalculation <= 45){
				rowId = 3;
			}else if(rollCalculation >45 && rollCalculation <= 50){
				rowId = 4;
			}else if(rollCalculation >50 && rollCalculation <= 55){
				rowId = 5;
			}else if(rollCalculation >55 && rollCalculation <= 60){
				rowId = 6;
			}else if(rollCalculation >60 && rollCalculation <= 65){
				rowId = 7;
			}else if(rollCalculation >65 && rollCalculation <= 70){
				rowId = 8;
			}else if(rollCalculation >70 && rollCalculation <= 75){
				rowId = 9;
			}else if(rollCalculation >75 && rollCalculation <= 80){
				rowId = 10;
			}else if(rollCalculation >80 && rollCalculation <= 85){
				rowId = 11;
			}else if(rollCalculation >85 && rollCalculation <= 90){
				rowId = 12;
			}else if(rollCalculation >90 && rollCalculation <= 95){
				rowId = 13;
			}else if(rollCalculation >95 && rollCalculation <= 100){
				rowId = 14;
			}else if(rollCalculation >100 && rollCalculation <= 105){
				rowId = 15;
			}else if(rollCalculation >105 && rollCalculation <= 110){
				rowId = 16;
			}else if(rollCalculation >110 && rollCalculation <= 115){
				rowId = 17;
			}else if(rollCalculation >115 && rollCalculation <= 120){
				rowId = 18;
			}else if(rollCalculation >120 && rollCalculation <= 125){
				rowId = 19;
			}else if(rollCalculation >125 && rollCalculation <= 130){
				rowId = 20;
			}else if(rollCalculation >130 && rollCalculation <= 135){
				rowId = 21;
			}else if(rollCalculation >135 && rollCalculation <= 140){
				rowId = 22;
			}else if(rollCalculation >140 && rollCalculation <= 145){
				rowId = 23;
			}else if(rollCalculation >145){
				rowId = 24;
			}
		}else if(table.equals("AT3")){
			if(rollCalculation <= 8){
				rowId = 0;
			}else if(rollCalculation >8 && rollCalculation <= 55){
				rowId = 1;
			}else if(rollCalculation >55 && rollCalculation <= 60){
				rowId = 2;
			}else if(rollCalculation >60 && rollCalculation <= 65){
				rowId = 3;
			}else if(rollCalculation >65 && rollCalculation <= 70){
				rowId = 4;
			}else if(rollCalculation >70 && rollCalculation <= 75){
				rowId = 5;
			}else if(rollCalculation >75 && rollCalculation <= 80){
				rowId = 6;
			}else if(rollCalculation >80 && rollCalculation <= 85){
				rowId = 7;
			}else if(rollCalculation >85 && rollCalculation <= 90){
				rowId = 8;
			}else if(rollCalculation >90 && rollCalculation <= 95){
				rowId = 9;
			}else if(rollCalculation >95 && rollCalculation <= 100){
				rowId = 10;
			}else if(rollCalculation >100 && rollCalculation <= 105){
				rowId = 11;
			}else if(rollCalculation >105 && rollCalculation <= 110){
				rowId = 12;
			}else if(rollCalculation >110 && rollCalculation <= 115){
				rowId = 13;
			}else if(rollCalculation >115 && rollCalculation <= 120){
				rowId = 14;
			}else if(rollCalculation >120 && rollCalculation <= 125){
				rowId = 15;
			}else if(rollCalculation >125 && rollCalculation <= 130){
				rowId = 16;
			}else if(rollCalculation >130 && rollCalculation <= 135){
				rowId = 17;
			}else if(rollCalculation >135 && rollCalculation <= 140){
				rowId = 18;
			}else if(rollCalculation >140 && rollCalculation <= 145){
				rowId = 19;
			}else if(rollCalculation >145){
				rowId = 20;
			}
		}
		
		
		return rowId;
		
	}
	
	
	
	
}
