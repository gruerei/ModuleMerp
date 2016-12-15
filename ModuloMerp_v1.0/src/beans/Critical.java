package beans;

import beans.combat.Attack;
import utils.Tables.Tables;
import utils.Tables.Tables_Crit;

public class Critical {
	
	public static final int CRITICAL_SLASH = 1;
	public static final int CRITICAL_PUNCTURE = 2;
	public static final int CRITICAL_CRUNCH = 3;
	public static final int CRITICAL_GRAPPLE = 4;//PRESA
	public static final int CRITICAL_UNBALANCING = 5;//DESEQUILIBRIO
	
	public static final String CRITICAL_A = "A";
	public static final String CRITICAL_B = "B";
	public static final String CRITICAL_C = "C";
	public static final String CRITICAL_D = "D";
	public static final String CRITICAL_E = "E";
	public static final String CRITICAL_T = "T";
	
	private int criticalType;
	private String criticalGravity;
	private String criticalMaxGravity;
	

	
	public Critical(int criticalType, String criticalMaxGravity) {
		this.criticalType = criticalType;
		this.criticalMaxGravity = criticalMaxGravity;
	}
	
	public int getCriticalType() {
		return criticalType;
	}
	public void setCriticalType(int criticalType) {
		this.criticalType = criticalType;
	}
	public String getCriticalGravity() {
		return criticalGravity;
	}
	public void setCriticalGravity(String criticalGravity) {
		this.criticalGravity = criticalGravity;
	}

	public String getCriticalMaxGravity() {
		return criticalMaxGravity;
	}

	public void setCriticalMaxGravity(String criticalMaxGravity) {
		this.criticalMaxGravity = criticalMaxGravity;
	}
	
	


	public String toString(){
		
		String ret = "";
		if(this.criticalType > 0){
			if( this.criticalType == 1)
				ret = "SL";
			else if( this.criticalType == 2)
				ret = "PU";
			else if( this.criticalType == 3)
				ret = "CR";
			else if( this.criticalType == 4)
				ret = "GR";
			
			ret = ret + " - " + this.criticalMaxGravity;
		}else{
			ret = "NO";
		}
		
		return ret;
	}
	
	
	public static int assesCriticalType(String chain){
		if(chain.contains("SL"))
			return Critical.CRITICAL_SLASH;
		else if(chain.contains("PU")){
			return Critical.CRITICAL_PUNCTURE;
		}else if(chain.contains("CR")){
			return Critical.CRITICAL_CRUNCH;
		}else if(chain.contains("GR")){//PR en español
			return Critical.CRITICAL_GRAPPLE;
		}else if(chain.contains("UN")){//DE en español
			return Critical.CRITICAL_UNBALANCING;
		}else{
			return 0;
		}
		
	}
	


public static int modifyRollByCritGravity(String critGravity2) {
	int roll = 0;
	if(critGravity2.equals(Critical.CRITICAL_A)){
		System.out.println("Critico A : -20");
		return -20;
	}else if(critGravity2.equals(Critical.CRITICAL_B)){
		System.out.println("Critico B : -10");
		return -10;
	}else if(critGravity2.equals(Critical.CRITICAL_C)){
		System.out.println("Critico C : 0");
		return 0;
	}else if(critGravity2.equals(Critical.CRITICAL_D)){
		System.out.println("Critico D : +10");
		return 10;
	}else if(critGravity2.equals(Critical.CRITICAL_E)){
		System.out.println("Critico E : +20");
		return 20;
	}else if(critGravity2.equals(Critical.CRITICAL_T)){
		System.out.println("Critico T : -50");
		return -50;
	}
	return roll;
}

public static String assessGravity(String tableRoll, String weaponCritMaxGravity) {
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
	

}
