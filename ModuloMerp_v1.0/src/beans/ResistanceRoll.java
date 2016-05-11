package beans;

import java.util.HashMap;
import java.util.Map;

public class ResistanceRoll {
	

	public static final String ESSENCE = "ESSENCE";//ESENCIA
	public static final String CHANNELLING = "CHANNELLING";//CANALIZACION
	public static final String POISON = "POISON";//VENENO
	public static final String DISEASE = "DISEASE";//ENFERMEDAD
	
	public Map<Integer, Item> equippedGear = new HashMap<Integer, Item>();
	Map<String, Attribute> attributes = new HashMap<String, Attribute>();
	public Race race;
	
	private String name;
	private int bonusAttribute;
	private int bonusObjects;
	private int bonusSpecial;
	private int bonusTotal;
	
	
	
	public ResistanceRoll(String name, Race race, Map<Integer, Item> equippedGear, Map<String, Attribute> attributes ) {
		this.name = name;
		this.race = race;
		this.equippedGear = equippedGear;
		this.attributes = attributes;
		
		if(getName().equals(ESSENCE)){
			bonusAttribute = attributes.get(Attribute.INTELLIGENCE).getModifTotal();
		}else if(getName().equals(CHANNELLING)){
			bonusAttribute = attributes.get(Attribute.INTUITION).getModifTotal();
		}else if(getName().equals(POISON)){
			bonusAttribute = attributes.get(Attribute.CONSTITUTION).getModifTotal();
		}else if(getName().equals(DISEASE)){
			bonusAttribute = attributes.get(Attribute.CONSTITUTION).getModifTotal();
		}
	}
	
	public String getName() {
		return name;
	}
	public int getBonusAttribute() {
		return bonusAttribute;
	}
	public int getBonusObjects() {
		return bonusObjects;
	}
	public int getBonusSpecial() {
		return bonusSpecial;
	}
	public int getBonusTotal() {
		return bonusTotal;
	}
	
	
	public void calculTotalBonus(Map<String, Integer> totalGearResistances){
	
		if(getName().equals(ESSENCE)){
			bonusObjects = totalGearResistances.get(ESSENCE).intValue();
			bonusSpecial = bonusSpecial + race.getModEssence();
		}else if(getName().equals(CHANNELLING)){
			bonusObjects = totalGearResistances.get(CHANNELLING).intValue();
			bonusSpecial = bonusSpecial + race.getModChanneling();
		}else if(getName().equals(POISON)){
			bonusObjects = totalGearResistances.get(POISON).intValue();
			bonusSpecial = bonusSpecial + race.getModPoison();
		}else if(getName().equals(DISEASE)){
			bonusObjects = totalGearResistances.get(DISEASE).intValue();
			bonusSpecial = bonusSpecial + race.getModDisease();
		}else{
			//Habria que sacar un error
			System.out.println("Resistance Roll Uknown");
		}
		
		bonusTotal = bonusAttribute + bonusObjects + bonusSpecial;
	}
	
	
	
}
