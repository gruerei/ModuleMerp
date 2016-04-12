package beans;

public class Item {
	
	public int id;
	public String name;
	public String description;
	public String weight;
	public boolean used;
	public Price basePrice;
	private int modEssence;
	private int modChanneling;
	private int modPoison;
	private int modDisease;
	
	private int[] skillMods = new int[Skill.SKILLS_TOTAL_NUMBER];
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public Price getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(Price basePrice) {
		this.basePrice = basePrice;
	}
	public boolean isUsed() {
		return used;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
	public int getModEssence() {
		return modEssence;
	}
	public void setModEssence(int modEssence) {
		this.modEssence = modEssence;
	}
	public int getModChanneling() {
		return modChanneling;
	}
	public void setModChanneling(int modChanneling) {
		this.modChanneling = modChanneling;
	}
	public int getModPoison() {
		return modPoison;
	}
	public void setModPoison(int modPoison) {
		this.modPoison = modPoison;
	}
	public int getModDisease() {
		return modDisease;
	}
	public void setModDisease(int modDisease) {
		this.modDisease = modDisease;
	}
	public int[] getSkillMods() {
		return skillMods;
	}
	public void setSkillMods(int[] skillMods) {
		this.skillMods = skillMods;
	}

	
	
}
