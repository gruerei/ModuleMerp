package beans;

import utils.Utils;
import utils.Tables.Tables;

public class Race {
	
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
	private int modFire;
	private int modCold;
	

	public Race(String name, String culture) {
		this.name = name;
		this.culture = culture;
		int race = 0;
		
		if(name.equalsIgnoreCase("HOBBIT")){
			race = Tables.HOBBIT_BT3;
		}
		else if(name.equalsIgnoreCase("UMLI")){
			race = Tables.UMLI_BT3;
		}
		else if(name.equalsIgnoreCase("DWARF")){
			race = Tables.DWARF_BT3;
		}
		else if(name.equalsIgnoreCase("WOSE")){
			race = Tables.WOSE_BT3;
		}
		else if(name.equalsIgnoreCase("HUMAN")){
			race = Tables.HUMAN_BT3;
		}
		else if(name.equalsIgnoreCase("DUNEDAIN")){
			race = Tables.DUNEDAIN_BT3;
		}
		else if(name.equalsIgnoreCase("HALF_ELF")){
			race = Tables.HALF_ELF_BT3;
		}
		else if(name.equalsIgnoreCase("SILVAN_ELF")){
			race = Tables.SILVAN_ELF_BT3;
		}
		else if(name.equalsIgnoreCase("SINDARIN_ELF")){
			race = Tables.SINDARIN_ELF_BT3;
		}
		else if(name.equalsIgnoreCase("NOLDOR_ELF")){
			race = Tables.NOLDOR_ELF_BT3;
		}
		else if(name.equalsIgnoreCase("HALF_ORC")){
			race = Tables.HALF_ORC_BT3;
		}
		else if(name.equalsIgnoreCase("ORC")){
			race = Tables.ORC_BT3;
		}
		else if(name.equalsIgnoreCase("HALF_TROLL")){
			race = Tables.HALF_TROLL_BT3;
		}
		else if(name.equalsIgnoreCase("TROLL")){
			race = Tables.TROLL_BT3;
		}
		else if(name.equalsIgnoreCase("OLOG_HAI")){
			race = Tables.OLOG_HAI_BT3;
		}
		
		modStrength=Utils.castToInt(Tables.getTableValue("BT3",race,Tables.STR_BT3));
		modAgility=Utils.castToInt(Tables.getTableValue("BT3",race,Tables.AGI_BT3));
		modConstitution=Utils.castToInt(Tables.getTableValue("BT3",race,Tables.CON_BT3));
		modIntelligence=Utils.castToInt(Tables.getTableValue("BT3", race, Tables.INT_BT3));
		modIntuition=Utils.castToInt(Tables.getTableValue("BT3",race,Tables.I_BT3));
		
		modCharisma=Utils.castToInt(Tables.getTableValue("BT3",race,Tables.CHAR_BT3));
		modPresence=Utils.castToInt(Tables.getTableValue("BT3",race,Tables.CHAR_BT3));
		
		modEssence=Utils.castToInt(Tables.getTableValue("BT3",race,Tables.ESE_BT3));
		modChanneling=Utils.castToInt(Tables.getTableValue("BT3",race,Tables.CHAN_BT3));
		modPoison=Utils.castToInt(Tables.getTableValue("BT3",race,Tables.POI_BT3));
		modDisease=Utils.castToInt(Tables.getTableValue("BT3",race,Tables.ILL_BT3));
		modCold=Utils.castToInt(Tables.getTableValue("BT3",race,Tables.COLD_BT3));
		modFire=Utils.castToInt(Tables.getTableValue("BT3",race,Tables.FIRE_BT3));
		
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
	
	public int getModFire() {
		return modFire;
	}

	public int getModCold() {
		return modCold;
	}

	public String getCulture() {
		return culture;
	}

	public void setCulture(String culture) {
		this.culture = culture;
	}


	
	
	
}
