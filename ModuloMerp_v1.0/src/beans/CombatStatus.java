package beans;

public class CombatStatus {
	
	public static final int ASSAULTS_TO_DIE = 6;
	
	public static final String ACTIVITY = "ACTIVITY";
	public static final String KNOCKED_OUT = "KNOCKED_OUT";
	public static final String BLEEDING = "BLEEDING";
	public static final String DEAD = "DEAD";
	public static final String STUNNED = "STUNNED";
	
	public static final int ACTIVITY_ASSAULTS = 1;
	public static final int ACTIVITY_WOUND = 2;
	public static final int ACTIVITY_PERMANENT = 3;
	
	public static final int DEAD_FINAL = 0;
	public static final int DEAD_ASSAULTS = 1;
	
	public static final int KNOCKED_OUT_ASSAULTS = 1;
	public static final int KNOCKED_OUT_WOUND = 2;//Caused by being crippled by a Critical Strike
	//public static final int KNOCKED_OUT_UNCONSCIOUS = 3;//Specifically caused by a Critical Strike
	public static final int KNOCKED_OUT_LIFE_BELOW_ZERO = 4;//Life Below Zero
	public static final int KNOCKED_OUT_PERMANENT = 5;//Probably not used, by it would be possible for being in a coma
	
	public static final int BLEEDING_ASSAULTS = 1;
	public static final int BLEEDING_WOUND = 2;
	
	private static final String [] ACTIVITY_TYPES = {"","ASSAULTS","WOUNDS","PERMAMENT"};
	private static final String [] KNOCKED_OUT_TYPES = {"","Temporal Effect","Being Crippled","Unconscious Critical-Strike","Unconscious Life-Below-Zero","Is in a Coma"};
	private static final String [] BLEEDING_TYPES = {"","ASSAULTS","WOUNDS"};
	
	public static final int BANDAGE_EFFECT_LOW = 1;
	public static final int BANDAGE_EFFECT_MEDIUM = 2;
	public static final int BANDAGE_EFFECT_HIGH = 3;
	public static final int BANDAGE_EFFECT_TOTAL = 4;
	
	public static final int ZERO_LIFE_ACTIVICTY_MODIF = -60;
	
	private String name;
	private int type;
	private int assaultsLeft;
	private int activityModif;
	private int lifePointLostPerAssault;
	private int key;
	private String description;
	
	public CombatStatus(String name, int type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getAssaultsLeft() {
		return assaultsLeft;
	}
	public void setAssaultsLeft(int assaultsLeft) {
		this.assaultsLeft = assaultsLeft;
	}
	public int getActivityModif() {
		return activityModif;
	}
	public void setActivityModif(int activityModif) {
		this.activityModif = activityModif;
	}
	
	public int getLifePointLostPerAssault() {
		return lifePointLostPerAssault;
	}

	public void setLifePointLostPerAssault(int lifePointLostPerAssault) {
		this.lifePointLostPerAssault = lifePointLostPerAssault;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static String activityType(int idx){
		return ACTIVITY_TYPES[idx];
	}
	
	public static String knockedOutType(int idx){
		return KNOCKED_OUT_TYPES[idx];
	}
	
	public static String bleedingType(int idx){
		return BLEEDING_TYPES[idx];
	}

	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	
	

}
