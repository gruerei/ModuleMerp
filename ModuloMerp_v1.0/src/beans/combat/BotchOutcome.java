package beans.combat;

import beans.Botch;
import beans.Character;
import beans.Critical;
import beans.Item;
import beans.WeaponItem;
import utils.Utils;
import utils.Tables.Tables;
import utils.Tables.Tables_Botch;
import utils.Tables.Tables_Crit;

public class BotchOutcome {

	private int lifePointsCaused;
	private Botch botch;
	private Critical critical;
	private int resistanceRollModificators;
	private Attack attack;
	
	public BotchOutcome(Attack attack) {
		this.attack = attack;
	}

	public BotchOutcome() {
		// TODO Auto-generated constructor stub
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
		
		WeaponItem weapon = (WeaponItem) actor.getEquippedGear().get(Item.WEAPON_1);
		
		String botchtype = "";
		if(weapon.getCategory() == WeaponItem.PROJECTILE){
			botchtype = "PROJECTILE";
		}else
		{
			botchtype = "WEAPON";
		}
		
		String botchType = Tables.getBotch_type()[weapon.getBotch().getCriticalTaken().getCriticalType()];
		String[] botchOutcome = Tables_Botch.getTableValue(botchType, botchRoll);
		fillOutcome(botchOutcome, actor);
		
	}
	
	private void fillOutcome(String[] botchOutcome, Character enemy) {
		/*
		setCritItemProtection(Utils.castToInt(critOutcome[Tables_Crit.COL_ITEM_PROTECTION]));

		critDescription = critOutcome[Tables_Crit.COL_DESCRIPTION];
		System.out.println(critDescription);
		
		String critLifePoints = critOutcome[Tables_Crit.COL_LIFE_POINTS];
		int calculLP = calculOutcomeByProtection(critLifePoints,enemy,Tables_Crit.COL_LIFE_POINTS);
		setCritLifePoints(calculLP);
		
		String critLifePointsPerAssault = critOutcome[Tables_Crit.COL_LIFE_POINTS_PER_ASSAULT];
		int calculLifePointsPerAssault = calculOutcomeByProtection(critLifePointsPerAssault,enemy,Tables_Crit.COL_LIFE_POINTS_PER_ASSAULT);
		setCritLifePointsPerAssault(calculLifePointsPerAssault);
		
		String critMalusActivity = critOutcome[Tables_Crit.COL_MALUS_ACTIVITY];
		int[] calculMalusActivity = calculActivity(critMalusActivity);
		setCritMalusActivity(calculMalusActivity);
		
		String critAssaultsStunned = critOutcome[Tables_Crit.COL_STUNNED_ASSAULTS];
		String critTearItem = critOutcome[Tables_Crit.COL_TEAR_ITEM];
		String critCauseBodyDisability = critOutcome[Tables_Crit.COL_CAUSE_BODY_DISABILITY];
		String critCauseDeath = critOutcome[Tables_Crit.COL_CAUSE_DEATH];
		String critCauseUnconsc = critOutcome[Tables_Crit.COL_CAUSE_UNCONSCIOUSSNESS];
		String critAssaultsToDeath = critOutcome[Tables_Crit.COL_ASSAULTS_TO_DEATH];
		*/
	}

}
