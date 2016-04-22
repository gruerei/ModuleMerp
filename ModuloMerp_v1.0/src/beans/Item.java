package beans;

public class Item {
	
	public int id;
	public String name;
	public String type;
	public float weight;
	public boolean used;
	public Price price;
	private int modEssence;
	private int modChanneling;
	private int modPoison;
	private int modDisease;
	
	private int[] skillMods = new int[Skill.SKILLS_TOTAL_NUMBER];
	

	public Item(String type, float weight, Price price) {
		this.type = type;
		this.weight = weight;
		this.price = price;
	}
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
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
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}

	
	
}
