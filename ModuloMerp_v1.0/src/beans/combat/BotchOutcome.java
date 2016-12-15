package beans.combat;

import beans.Botch;
import beans.Character;
import beans.Critical;
import beans.Item;
import beans.WeaponItem;
import utils.Utils;
import utils.Tables.Tables;
import utils.Tables.Tables_Botch;

public class BotchOutcome {

	
	private int botchLifePoints;
	private int botchLifePointsPerAssault;
	private int[] botchMalusActivity;
	private int botchAssaultsStunned;
	private Botch botch;
	private Critical critical;
	private int resistanceRollModificators;
	private Action action;
	
	
	public BotchOutcome(Attack attack) {
		this.action = attack;
	}

	public BotchOutcome() {
	}

	public int getBotchLifePoints() {
		return botchLifePoints;
	}
	public void setBotchLifePoints(int botchLifePoints) {
		this.botchLifePoints = botchLifePoints;
	}
	public int getBotchLifePointsPerAssault() {
		return botchLifePointsPerAssault;
	}
	public void setBotchLifePointsPerAssault(int botchLifePointsPerAssault) {
		this.botchLifePointsPerAssault = botchLifePointsPerAssault;
	}
	public int getBotchAssaultsStunned() {
		return botchAssaultsStunned;
	}

	public void setBotchAssaultsStunned(int botchAssaultsStunned) {
		this.botchAssaultsStunned = botchAssaultsStunned;
	}

	public int[] getBotchMalusActivity() {
		return botchMalusActivity;
	}

	public void setBotchMalusActivity(int[] botchMalusActivity) {
		this.botchMalusActivity = botchMalusActivity;
	}

	public void botchAssess(Character actor) {
		int botchRoll = 0;
		boolean inputOk;
		
		do{
			try{
				System.out.print("Introduzca el valor de la tirada de pifia: ");
				botchRoll = Utils.castToInt(Utils.readFromInputLine());
				inputOk = true;
			}catch(NumberFormatException e){
				System.out.println("Valor introducido incorrecto. Debe introducir un valor numerico.");
				inputOk = false;
			}
		}while(inputOk == false);
		
		String montadoIn = "";
		boolean montado = false;
		do{
			try{
				System.out.print("Combatiente Montado?: Y/N\n");
				montadoIn = Utils.readFromInputLine();
				if(montadoIn.equalsIgnoreCase("Y")){
					System.out.println("Combatiente montado asignado.");
					montado = true;
				}
				
			}catch(NumberFormatException e){
				System.out.println("Valor introducido incorrecto.");
				inputOk = false;
			}
		}while(inputOk == false);
		
		String botchType = "";
		
		if(action instanceof AttackMelee){
			
			botchType = "WEAPON";
			
		}else if(action instanceof AttackProjectile){
			botchType = "PROJECTILE";
		}else if(action instanceof AttackSpell){
			botchType = "SPELL";
		}
		else {
			
			botchType = "MANEUVER";
		}
		
		
		WeaponItem weapon = (WeaponItem) actor.getEquippedGear().get(Item.WEAPON_1);
		

		//botchRoll = 50;
		System.out.println("Tirada de Pifia: "+botchRoll);
		botchRoll =  botchRoll + modifyRollByBotchTable(botchType,weapon.getCategory(),montado);
		System.out.println("Pifia Modificada : "+botchRoll);
		
		if(weapon.getBotch().getCriticalTaken() != null){
			/*TODO: El arma provoca un critico adicional por una pifia*/
			String botchCriticalType = botchType = Tables.getBotch_type()[weapon.getBotch().getCriticalTaken().getCriticalType()];
		}
		
		
		String[] botchOutcome = Tables_Botch.getTableValue(botchType, botchRoll);
		
		
		fillOutcome(botchOutcome, actor);

	}
	
	
	private int modifyRollByBotchTable(String botchType, int weaponCategory, boolean montado) {
		
		int roll = 0;
		
		if(botchType.equals("PROJECTILE")){
			
		}else if(botchType.equals("SPELL")){
				
		}else if(botchType.equals("WEAPON")){
			
			if(montado){
				System.out.println("Mounted (doesn't matter the Weapon used) : +20");
				return 20;
			}else if(weaponCategory == WeaponItem.CONCUSSION){
				System.out.println("Crush Weapons : -20");
				return -20;
			}else if(weaponCategory == WeaponItem.EDGED){
				System.out.println("Edged Weapons : -10");
				return -10;
			}else if(weaponCategory == WeaponItem.TWO_HANDED){
				System.out.println("Two-Handed Weapons : 0");
				return 0;
			}else if(weaponCategory == WeaponItem.POLEARM){
				System.out.println("Polearms : +10");
				return 10;
			}
			
		}else if(botchType.equals("MANEUVER")){
				
		}
		
		return roll;
	}
	
	private void fillOutcome(String[] botchOutcome, Character actor) {
		
		String botchDescription = botchOutcome[Tables_Botch.COL_DESCRIPTION];
		System.out.println(actor.getName() + " : "+botchDescription);
		
		String botchLifePoints = botchOutcome[Tables_Botch.COL_LIFE_POINTS];
		int calculLP= Utils.castToInt(botchLifePoints);
		setBotchLifePoints(calculLP);
		
		String botchLifePointsPerAssault = botchOutcome[Tables_Botch.COL_LIFE_POINTS_PER_ASSAULT];
		int calculLifePointsPerAssault = Utils.castToInt(botchLifePointsPerAssault);
		setBotchLifePointsPerAssault(calculLifePointsPerAssault);
		
		String botchMalusActivity = botchOutcome[Tables_Botch.COL_MALUS_ACTIVITY];
		int[] calculMalusActivity = calculActivity(botchMalusActivity);
		setBotchMalusActivity(calculMalusActivity);

		String botchAssaultsStunned = botchOutcome[Tables_Botch.COL_STUNNED_ASSAULTS];
		setBotchAssaultsStunned(Utils.castToInt(botchAssaultsStunned));
		
		String critTearItem = botchOutcome[Tables_Botch.COL_TEAR_ITEM];
		String critCauseBodyDisability = botchOutcome[Tables_Botch.COL_CAUSE_BODY_DISABILITY];
		String critCauseDeath = botchOutcome[Tables_Botch.COL_CAUSE_CRIT];
		String critCauseUnconsc = botchOutcome[Tables_Botch.COL_CAUSE_UNCONSCIOUSSNESS];
		String critAssaultsToDeath = botchOutcome[Tables_Botch.COL_ASSAULTS_TO_DEATH];
	
	}
	
	private int[] calculActivity(String valueIn) {
		int[] valueRetourned = new int[2];
		
		if( valueIn.contains("-")){
			String[] split = valueIn.split("-");
			valueRetourned[0] = Utils.castToInt(split[0]);
			
			/*El tipo de Malus a la Actividad(H - Heridas / A - Asaltos)*/
			if(split[1].equals("H")){
				valueRetourned[1] = 999;
			}else if(split[1].contains("A")){
				valueRetourned[1] =  Utils.castToInt(split[1].replace("A",""));
			}else{
				valueRetourned[0] = 0;
				valueRetourned[1] = 0;
			}
			
		}else{
			valueRetourned[0] = 0;
			valueRetourned[1] = 0;
		}
		
		return valueRetourned;
	}
	/*TODO: Aplicar Efectos Pifia*/
	public void applyOutcome(Character actor) {
		//LIFE POINTS
		if(getBotchLifePoints() >= 0)
			actor.lifePointsLost(getBotchLifePoints());
		
		//LIFE POINTS PER ASSAULT
		
		//ACTIVITY MALUS
		
		//ASSAULTS STUNNED
	}

}
