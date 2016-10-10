package beans;

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
	

}
