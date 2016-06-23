package beans.combat;

import beans.Botch;
import beans.Character;
import beans.Critical;
import beans.CriticalOutcome;
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
		
		
		if(attack instanceof AttackMelee){
			
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
				tableOutcome = Tables.getTableValue("AT2", rollCalculation, enemyArmourType);
			}else if(attack.getCategory() == Attack.TWO_HANDED){
				tableOutcome = Tables.getTableValue("AT3", rollCalculation, enemyArmourType);
			}else if(attack.getCategory() == Attack.PROJECTILE){
				tableOutcome = Tables.getTableValue("AT4", rollCalculation, enemyArmourType);
			}else if(attack.getCategory() == Attack.CLAWS_BITE){
				tableOutcome = Tables.getTableValue("AT5", rollCalculation, enemyArmourType);
			}else if(attack.getCategory() == Attack.GRIP_UNBALANCE){
				tableOutcome = Tables.getTableValue("AT6", rollCalculation, enemyArmourType);
			}

			
		}else if(attack instanceof AttackProjectile){
			
		}else if(attack instanceof AttackSpell){
			
		}
		
		this.tableAttackRoll = tableOutcome;
		
		String[] tableOutcomeSplit = tableOutcome.split("-");
		lifePointsCaused = Utils.castToInt(tableOutcomeSplit[0]);
		String tableCrit = tableOutcomeSplit[1];
		
		if(lifePointsCaused > 0){
			System.out.println("Impacto!! -> El golpe aplica "+lifePointsCaused+" puntos de vida." );
		}else{
			/*TODO Dar mas informacion sobre que ha pasado con el gope (segun tirada)*/
			System.out.println("El golpe no se consigue dañar al objetivo");
		}
		
		
		if(tableCrit != null){
			
			WeaponItem weapon = attack.getWeapon();
			/*TODO : Gestionar criticos no relacionado con armas*/
			
			if(weapon.getMainCritical() != null){
				
				mainCriticalOutcome = new CriticalOutcome();
				mainCriticalOutcome.criticalAssess(tableCrit, attack, weapon.getMainCritical());
				/*Añadir al total los daños causados del 2º CRIT*/
				//lifePointsCaused = lifePointsCaused + mainCritical.getLifePointsLost();
				//assaultsStunned = assaultsStunned + mainCritical.getAssaultsStunned();*/
			}
			
			if(weapon.getSecondCritical() != null){
				System.out.println("GOLPE CRITICO ADICIONAL!! Gravedad : "+tableOutcomeSplit[1]
						+ " de tipo " + Tables.getCritical_type()[weapon.getSecondCritical().getCriticalType()] );
				
				secondCriticalOutcome = new CriticalOutcome();
				mainCriticalOutcome.criticalAssess(tableCrit, attack, weapon.getSecondCritical());

				/*Añadir al total los daños causados del 2º CRIT*/
				//lifePointsCaused = lifePointsCaused + secondCritical.getLifePointsLost();
				//assaultsStunned = assaultsStunned + secondCritical.getAssaultsStunned();*/
				
			}
			

		}
		
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
		}
		
		
		return rowId;
		
	}
	
	
	
	
}
