package beans;

import beans.combat.Attack;
import beans.combat.AttackOutcome;
import utils.Utils;
import utils.Tables.Tables;
import utils.Tables.Tables_Crit;

public class CriticalOutcome {

	private String critGravity;
	private int critLifePoints;
	private String critLifePointsPerAssault;
	private String critMalusActivity;
	private String critAssaultsStunned;
	private String critTearItem;
	private String critCauseBodyDisability;
	private String critCauseDeath;
	private String critCauseUnconsc;
	private String critAssaultsToDeath;
	private int critItemProtection;
	private String critDescription;
	
	
	
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
	public String getCritLifePointsPerAssault() {
		return critLifePointsPerAssault;
	}
	public void setCritLifePointsPerAssault(String critLifePointsPerAssault) {
		this.critLifePointsPerAssault = critLifePointsPerAssault;
	}
	public String getCritMalusActivity() {
		return critMalusActivity;
	}
	public void setCritMalusActivity(String critMalusActivity) {
		this.critMalusActivity = critMalusActivity;
	}
	public String getCritAssaultsStunned() {
		return critAssaultsStunned;
	}
	public void setCritAssaultsStunned(String critAssaultsStunned) {
		this.critAssaultsStunned = critAssaultsStunned;
	}
	public String getCritTearItem() {
		return critTearItem;
	}
	public void setCritTearItem(String critTearItem) {
		this.critTearItem = critTearItem;
	}
	public String getCritCauseBodyDisability() {
		return critCauseBodyDisability;
	}
	public void setCritCauseBodyDisability(String critCauseBodyDisability) {
		this.critCauseBodyDisability = critCauseBodyDisability;
	}
	public String getCritCauseDeath() {
		return critCauseDeath;
	}
	public void setCritCauseDeath(String critCauseDeath) {
		this.critCauseDeath = critCauseDeath;
	}
	public String getCritCauseUnconsc() {
		return critCauseUnconsc;
	}
	public void setCritCauseUnconsc(String critCauseUnconsc) {
		this.critCauseUnconsc = critCauseUnconsc;
	}
	public String getCritAssaultsToDeath() {
		return critAssaultsToDeath;
	}
	public void setCritAssaultsToDeath(String critAssaultsToDeath) {
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
	
	public void criticalAssess(String tableCrit, Attack attack, Critical critical) {

			
			String critType = Tables.getCritical_type()[critical.getCriticalType()];
			System.out.println("GOLPE CRITICO !! Gravedad : "+tableCrit
					+ " de tipo " + critType );
			
			String critGravity = assessGravity(tableCrit,critical.getCriticalMaxGravity());
			setCritGravity(critGravity);
			
			if(!critGravity.equals(tableCrit)){
				System.out.println("CRITICO "+tableCrit+" tiene un tope de "+critGravity+"."
						+ " El critico se calculará como critico "+critGravity);
			}
			
			/*TODO: Tirada de critico1*/
			
			//int critRoll = Utils.castToInt(Utils.readFromInputLine());
			int critRoll = 50;
			System.out.println("Tirada de Critico: "+critRoll);
			String[] critOutcome = Tables_Crit.getTableValue(critType, critRoll);
			
			fillOutcome(critOutcome, attack.getEnemy());
			
			//lifePointsCaused = lifePointsCaused + mainCritical.getLifePointsLost();
			//assaultsStunned = assaultsStunned + mainCritical.getAssaultsStunned();
					
		}
	
	private String assessGravity(String tableRoll, String weaponCritMaxGravity) {
		if(tableRoll.equals("T") || weaponCritMaxGravity.equals("T")){
			return "T";
		}else{
			if(tableRoll.toUpperCase().compareTo(weaponCritMaxGravity.toUpperCase()) <= 0){
				return tableRoll;
			}else{
				return weaponCritMaxGravity;
			}
		}
	}
	
	private void fillOutcome(String[] critOutcome, Character enemy) {

		setCritItemProtection(Utils.castToInt(critOutcome[Tables_Crit.COL_ITEM_PROTECTION]));
		
		String critLifePoints = critOutcome[Tables_Crit.COL_LIFE_POINTS];
		
		critDescription = critOutcome[Tables_Crit.COL_DESCRIPTION];
		System.out.println(critDescription);
		
		int calculLPcaus = calculLifePointsCaused(critLifePoints,enemy);
		setCritLifePoints(calculLPcaus);
		
	
		String critLifePointsPerAssault = critOutcome[Tables_Crit.COL_LIFE_POINTS_PER_ASSAULT];
		String critMalusActivity = critOutcome[Tables_Crit.COL_MALUS_ACTIVITY];
		String critAssaultsStunned = critOutcome[Tables_Crit.COL_STUNNED_ASSAULTS];
		String critTearItem = critOutcome[Tables_Crit.COL_TEAR_ITEM];
		String critCauseBodyDisability = critOutcome[Tables_Crit.COL_CAUSE_BODY_DISABILITY];
		String critCauseDeath = critOutcome[Tables_Crit.COL_CAUSE_DEATH];
		String critCauseUnconsc = critOutcome[Tables_Crit.COL_CAUSE_UNCONSCIOUSSNESS];
		String critAssaultsToDeath = critOutcome[Tables_Crit.COL_ASSAULTS_TO_DEATH];
		
	}

	private int calculLifePointsCaused(String critLifePointsIn, Character enemy) {
		int lpCaused = 0;
		if(critLifePointsIn.contains("NP")){
			String[] split = critLifePointsIn.split("-");
			String lifePointsNoProtection = split[0].replace("NP", "");
			String lifePointsWithProtection = split[1];
			
			int critItemProtection = getCritItemProtection();
			
			if(critItemProtection > 0){
				if(enemy.getEquippedGear().get(critItemProtection) == null){
					lpCaused = Utils.castToInt(lifePointsNoProtection);
					System.out.println("Enemy does not carry "+ Tables.getItem_categories()[critItemProtection] +" protection");
				}else{
					lpCaused = Utils.castToInt(lifePointsWithProtection);
					System.out.println("Enemy carries protection");
				}
			}
		}else{
			lpCaused= Utils.castToInt(critLifePointsIn);
		}
		return lpCaused;
	}
	
	
}
