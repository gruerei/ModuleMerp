package beans;

public class Race {
	
	/*BT3 - ROWS*/
	public static final int HOBBIT = 0;
	public static final int UMLI = 1;
	public static final int DWARF = 2;
	public static final int WOSE = 3;
	public static final int HUMAN = 4;
	public static final int DUNEDAIN = 5;
	public static final int HALF_ELF = 6;
	public static final int SILVAN_ELF = 7;
	public static final int SINDARIN_ELF = 8;
	public static final int NOLDOR_ELF = 9;
	public static final int HALF_ORC = 10;
	public static final int ORC = 11;
	public static final int URUK_HAI = 12;
	public static final int HALF_TROLL = 13;
	public static final int TROLL = 14;
	public static final int OLOG_HAI = 15;
	
	/*BT3 - COLUMNS*/
	public static final int STR = 0;
	public static final int AGI = 1;
	public static final int CON = 2;
	public static final int INT = 3;
	public static final int I   = 4;
	public static final int CHAR = 5;
	public static final int ESE = 6;
	public static final int CHAN = 7;
	public static final int POI = 8;
	public static final int ILL = 9;
	 
	
	private String name;
	private String culture;//SUBRACE
	private int modStrength;
	private int modAgility;
	private int modConstitution;
	private int modIntelligence;
	private int modIntuition;
	private int modCharisma;
	
	private int modPresence;
	
	private int modEssence;
	private int modChanneling;
	private int modPoison;
	private int modDisease;
	
	

	public Race(String name, String culture) {
		this.name = name;
		this.culture = culture;
		int race = 0;
		
		if(name.equalsIgnoreCase("HOBBIT")){
			race = HOBBIT;
		}
		else if(name.equalsIgnoreCase("UMLI")){
			race = UMLI;
		}
		else if(name.equalsIgnoreCase("DWARF")){
			race = DWARF;
		}
		else if(name.equalsIgnoreCase("WOSE")){
			race = WOSE;
		}
		else if(name.equalsIgnoreCase("HUMAN")){
			race = HUMAN;
		}
		else if(name.equalsIgnoreCase("DUNEDAIN")){
			race = DUNEDAIN;
		}
		else if(name.equalsIgnoreCase("HALF_ELF")){
			race = HALF_ELF;
		}
		else if(name.equalsIgnoreCase("SILVAN_ELF")){
			race = SILVAN_ELF;
		}
		else if(name.equalsIgnoreCase("SINDARIN_ELF")){
			race = SINDARIN_ELF;
		}
		else if(name.equalsIgnoreCase("NOLDOR_ELF")){
			race = NOLDOR_ELF;
		}
		else if(name.equalsIgnoreCase("HALF_ORC")){
			race = HALF_ORC;
		}
		else if(name.equalsIgnoreCase("ORC")){
			race = ORC;
		}
		else if(name.equalsIgnoreCase("HALF_TROLL")){
			race = HALF_TROLL;
		}
		else if(name.equalsIgnoreCase("TROLL")){
			race = TROLL;
		}
		else if(name.equalsIgnoreCase("OLOG_HAI")){
			race = OLOG_HAI;
		}
		
		modStrength=Tables.getTableValue("BT3",race,STR);
		modAgility=Tables.getTableValue("BT3",race,AGI);
		modConstitution=Tables.getTableValue("BT3",race,CON);
		modIntelligence=Tables.getTableValue("BT3", race, INT);
		modIntuition=Tables.getTableValue("BT3",race,I);
		
		modCharisma=Tables.getTableValue("BT3",race,CHAR);
		modPresence=Tables.getTableValue("BT3",race,CHAR);
		
		modEssence=Tables.getTableValue("BT3",race,ESE);
		modChanneling=Tables.getTableValue("BT3",race,CHAN);
		modPoison=Tables.getTableValue("BT3",race,POI);
		modDisease=Tables.getTableValue("BT3",race,ILL);
		
	}

	public String getName() {
		return name;
	}

	public int getModStrength() {
		return modStrength;
	}

	public int getModAgility() {
		return modAgility;
	}


	public int getModConstitution() {
		return modConstitution;
	}


	public int getModIntelligence() {
		return modIntelligence;
	}


	public int getModIntuition() {
		return modIntuition;
	}


	public int getModCharisma() {
		return modCharisma;
	}


	public int getModPresence() {
		return modPresence;
	}

	public int getModEssence() {
		return modEssence;
	}

	public int getModChanneling() {
		return modChanneling;
	}

	public int getModPoison() {
		return modPoison;
	}


	public int getModDisease() {
		return modDisease;
	}

	public String getCulture() {
		return culture;
	}

	public void setCulture(String culture) {
		this.culture = culture;
	}

	
	
	
}
