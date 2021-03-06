package beans;

import beans.combat.Attack;
import beans.combat.AttackOutcome;
import utils.Utils;
import utils.Tables.Tables;
import utils.Tables.Tables_Crit;

public class CriticalOutcome {

	private String critGravity;
	private int critLifePoints;
	private int critLifePointsPerAssault;
	private int[] critMalusActivity;
	private int critAssaultsStunned;
	private String critTearItem;
	private int critCauseBodyDisability;
	private int critCauseDeath;
	private int critCauseUnconsc;
	private int critAssaultsToDeath;
	private int critItemProtection;
	private String critDescription;
	private int critRoll;
	private int critRollModified;
	
	public static int critRollTest = 0;
	
	public String getCritGravity() {
		return critGravity;
	}
	public void setCritGravity(String critGravity) {
		this.critGravity = critGravity;
	}
	public int getCritLifePoints() {
		return critLifePoints;
	}
	public void setCritLifePoints(int critLifePoints) {
		this.critLifePoints = critLifePoints;
	}
	public int getCritLifePointsPerAssault() {
		return critLifePointsPerAssault;
	}
	public void setCritLifePointsPerAssault(int critLifePointsPerAssault) {
		this.critLifePointsPerAssault = critLifePointsPerAssault;
	}
	public int[] getCritMalusActivity() {
		return critMalusActivity;
	}
	public void setCritMalusActivity(int[] critMalusActivity) {
		this.critMalusActivity = critMalusActivity;
	}
	public int getCritAssaultsStunned() {
		return critAssaultsStunned;
	}
	public void setCritAssaultsStunned(int critAssaultsStunned) {
		this.critAssaultsStunned = critAssaultsStunned;
	}
	public String getCritTearItem() {
		return critTearItem;
	}
	public void setCritTearItem(String critTearItem) {
		this.critTearItem = critTearItem;
	}
	public int getCritCauseBodyDisability() {
		return critCauseBodyDisability;
	}
	public void setCritCauseBodyDisability(int critCauseBodyDisability) {
		this.critCauseBodyDisability = critCauseBodyDisability;
	}
	public int getCritCauseDeath() {
		return critCauseDeath;
	}
	public void setCritCauseDeath(int critCauseDeath) {
		this.critCauseDeath = critCauseDeath;
	}
	public int getCritCauseUnconsc() {
		return critCauseUnconsc;
	}
	public void setCritCauseUnconsc(int critCauseUnconsc) {
		this.critCauseUnconsc = critCauseUnconsc;
	}
	public int getCritAssaultsToDeath() {
		return critAssaultsToDeath;
	}
	public void setCritAssaultsToDeath(int critAssaultsToDeath) {
		this.critAssaultsToDeath = critAssaultsToDeath;
	}
	public int getCritItemProtection() {
		return critItemProtection;
	}
	public void setCritItemProtection(int critItemProtection) {
		this.critItemProtection = critItemProtection;
	}
	public String getCritDescription() {
		return critDescription;
	}
	public void setCritDescription(String critDescription) {
		this.critDescription = critDescription;
	}

	public int getCritRoll() {
		return critRoll;
	}
	public void setCritRoll(int critRoll) {
		this.critRoll = critRoll;
	}
	public int getCritRollModified() {
		return critRollModified;
	}
	public void setCritRollModified(int critRollModified) {
		this.critRollModified = critRollModified;
	}
	public void criticalAssess(String critGravityin, Character enemy, Character actor, Critical critical) {

		
		String critType = Tables.getCritical_type()[critical.getCriticalType()];
		System.out.println("GOLPE CRITICO !! Gravedad : "+critGravityin
				+ " de tipo " + critType );
		
		String critGravity = Critical.assessGravity(critGravityin,critical.getCriticalMaxGravity());
		setCritGravity(critGravity);
		
		if(!critGravity.equals(critGravityin)){
			System.out.println("CRITICO "+critGravityin+" tiene un tope de "+critGravity+"."
					+ " El critico se calcular� como critico "+critGravity);
		}
		
		int critRoll = 0;
		boolean inputOk;
		
		do{
			try{
				System.out.print("Introduzca el valor de la tirada de critico: ");
				critRoll = critRollTest;
				//TODO: Descomentar critRoll
				/*critRoll = Utils.castToInt(Utils.readFromInputLine());*/
				inputOk = true;
			}catch(NumberFormatException e){
				System.out.println("Valor introducido incorrecto. Debe introducir un valor numerico.");
				inputOk = false;
			}
		}while(inputOk == false);
		
		//int critRoll = Utils.castToInt(Utils.readFromInputLine());
		//critRoll = 50;
		System.out.println("Tirada de Critico: "+critRoll);
		setCritRoll(critRoll);
		critRoll = critRoll + Critical.modifyRollByCritGravity(critGravity);
		setCritRollModified(critRoll);
		System.out.println("Critico Modificado : "+critRoll);
		String[] critOutcome = Tables_Crit.getTableValue(critType, critRoll);
		
		fillOutcome(critOutcome, enemy, actor);
		
				
	}
	
	
	
	public void fillOutcome(String[] critOutcome, Character enemy, Character actor) {

		setCritItemProtection(Utils.castToInt(critOutcome[Tables_Crit.COL_ITEM_PROTECTION]));

		critDescription = critOutcome[Tables_Crit.COL_DESCRIPTION];
		System.out.println(actor.getName()+" causa cr�tico : "+critDescription);
		
		String critLifePoints = critOutcome[Tables_Crit.COL_LIFE_POINTS];
		int calculLP = Utils.calculOutcomeByProtection(critLifePoints,enemy,Tables_Crit.COL_LIFE_POINTS,getCritItemProtection());
		setCritLifePoints(calculLP);
		
		String critLifePointsPerAssault = critOutcome[Tables_Crit.COL_LIFE_POINTS_PER_ASSAULT];
		int calculLifePointsPerAssault = calculOutcomeByProtection(critLifePointsPerAssault,enemy,Tables_Crit.COL_LIFE_POINTS_PER_ASSAULT);
		setCritLifePointsPerAssault(calculLifePointsPerAssault);
		
		String critMalusActivity = critOutcome[Tables_Crit.COL_MALUS_ACTIVITY];
		int[] calculMalusActivity = calculActivity(critMalusActivity);
		setCritMalusActivity(calculMalusActivity);
		
		String critAssaultsStunned = critOutcome[Tables_Crit.COL_STUNNED_ASSAULTS];
		setCritAssaultsStunned(Utils.castToInt(critAssaultsStunned));
		
		
		String critTearItem = critOutcome[Tables_Crit.COL_TEAR_ITEM];
		setCritTearItem(critTearItem);
		
		String critCauseBodyDisability = critOutcome[Tables_Crit.COL_CAUSE_BODY_DISABILITY];
		int calculCauseBodyDisability = calculOutcomeByProtection(critCauseBodyDisability,enemy,Tables_Crit.COL_CAUSE_BODY_DISABILITY);
		setCritCauseBodyDisability(calculCauseBodyDisability);
		
		@SuppressWarnings("unused")
		String critCauseDeath = critOutcome[Tables_Crit.COL_CAUSE_DEATH];
		int calculCauseDeath = calculOutcomeByProtection(critCauseDeath,enemy, Tables_Crit.COL_CAUSE_DEATH);
		setCritCauseDeath(calculCauseDeath);
		int assToDeath= Utils.castToInt(critOutcome[Tables_Crit.COL_ASSAULTS_TO_DEATH]);
		setCritAssaultsToDeath(assToDeath);
	
		
		@SuppressWarnings("unused")
		String critCauseUnconsc = critOutcome[Tables_Crit.COL_CAUSE_UNCONSCIOUSSNESS];
		int calculCauseUnconsc = calculOutcomeByProtection(critCauseUnconsc,enemy,Tables_Crit.COL_CAUSE_UNCONSCIOUSSNESS);
		setCritCauseUnconsc(calculCauseUnconsc);
		

		
	}

	private int[] calculActivity(String valueIn) {
		int[] valueRetourned = new int[2];
		
		if( valueIn.contains("_")){
			String[] split = valueIn.split("_");
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
	
	private int calculOutcomeByProtection(String valueIn, Character enemy, int effectApplied) {
		int valueRetourned = 0;
		
		if(valueIn.contains("NP")){
			String[] split = valueIn.split("-");
			String valueInNoProtection = split[0].replace("NP", "");
			
			String valueInWithProtection = "";
			if(split.length > 1)
				valueInWithProtection = split[1];
			
			int critItemProtection = getCritItemProtection();
			
			if(critItemProtection > 0){
				if(enemy.getEquippedGear().get(critItemProtection) == null){
					valueRetourned = Utils.castToInt(valueInNoProtection);
					System.out.println("Enemy does not carry "+ Tables.getItem_categories()[critItemProtection] +" protection. "
					+ Tables_Crit.CRIT_EFFECTS[effectApplied] +" APPLIED.");
				}else{
					valueRetourned = Utils.castToInt(valueInWithProtection);
					System.out.println("Enemy carries protection");
				}
			}
		}else{
			
			valueRetourned= Utils.castToInt(valueIn);
		}
			
		
		return valueRetourned;
	}
		
	/* Aplicar Efectos Critico*/
	public void applyOutcome(Character target) {
		CombatStatus cs = null;
		
		//LIFE POINTS
		if(getCritLifePoints() > 0)
			target.lifePointsLost(getCritLifePoints());
		
		//LIFE POINTS PER ASSAULT
		if(getCritLifePointsPerAssault() > 0){
			cs = target.addBleeding(getCritLifePointsPerAssault(), CombatStatus.BLEEDING_WOUND, 0);
			cs.setDescription(this.getCritDescription());
		}
		
		//ACTIVITY MALUS
		if(critMalusActivity[0] != 0){
			if(critMalusActivity[1] == 999){
				cs = new CombatStatus(CombatStatus.ACTIVITY, CombatStatus.ACTIVITY_WOUND); 
			}else{
				cs = new CombatStatus(CombatStatus.ACTIVITY, CombatStatus.ACTIVITY_ASSAULTS);
				cs.setAssaultsLeft(critMalusActivity[1]);
			}
			cs.setActivityModif(critMalusActivity[0]);
			cs.setDescription(this.getCritDescription());
			target.getActivityList().put(target.getActivityList().size() + 1,cs);
			target.setModifTotalActivity(target.getModifTotalActivity() + cs.getActivityModif());
		}
		
		//ASSAULTS STUNNED
		if(getCritAssaultsStunned() > 0){
			cs = new CombatStatus(CombatStatus.STUNNED, 0);
			cs.setDescription(this.getCritDescription());
			cs.setAssaultsLeft(getCritAssaultsStunned());
			
			if(target.getStunned() == null || target.getStunned().getAssaultsLeft()<=getCritAssaultsStunned()){
				target.setStunned(cs);
				System.out.println(target.getName() + " STUNNED for "+getCritAssaultsStunned()+" assaults.");
			}else{
				System.out.println(target.getName() + " already was STUNNED for longer assaults. This STUN won't be applied.");
			}
			
		}
		
		//CAUSE DISABILITY,DEATH/UNCOUN IN ENEMY
		if(getCritCauseBodyDisability()>0 || getCritCauseDeath()>0 || getCritCauseUnconsc()>0){
			
			if(getCritCauseUnconsc()>0){
				target.fallUnconscious(CombatStatus.KNOCKED_OUT_WOUND, 0);
			}
			
			if(getCritCauseBodyDisability()>0){

				int disIdx = getCritCauseBodyDisability();
				if(disIdx == Character.DISABILITY_BOTH_LEGS){
					target.getBodyPartDisabled()[Character.DISABILITY_RIGHT_LEG] = true;
					target.getBodyPartDisabled()[Character.DISABILITY_LEFT_LEG] = true;
					System.out.println(target.getName() + "s' Both Legs have been critically injured and are disabled.");
				}else{
					
					if(target.getBodyPartDisabled()[disIdx] == true){
						disIdx = disIdx+1;
						setCritCauseBodyDisability(disIdx);
					}

					String disStr = Character.disabilityToString(disIdx);
					target.getBodyPartDisabled()[disIdx] = true;
					System.out.println(target.getName() + "'s "+disStr+" has been critically injured and is disabled.");
				}
			}
			
			if(getCritCauseDeath()>0){
				
				if(getCritAssaultsToDeath() > 0){
					target.deathInXassaults(getCritAssaultsToDeath(),this.getCritDescription());
				}else{
					target.death();
				}
				
			}
		}

		//BREAK/UNEQUIP ITEM
		if(getCritTearItem()!= null && !getCritTearItem().equals("0")){
			
			Utils.unequipItem(target, getCritTearItem());
			
		}
		
		
	}
	
	
}
