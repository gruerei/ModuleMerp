package beans;

public class Item implements Cloneable{


	public static final int WEAPON_1 = 1;
	public static final int WEAPON_2 = 2;
	public static final int ARMOUR = 3;
	public static final int SHIELD = 4;
	public static final int HELMET = 5;
	public static final int BRACERS = 6;
	public static final int GREAVES = 7;
	public static final int RING_1 = 8;
	public static final int RING_2 = 9;
	public static final int AMULET = 10;
	public static final int OTHER1 = 11;
	public static final int OTHER2 = 12;
	public static final int OTHER3 = 13;
	
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
	private int modCold;
	private int modFire;
	
	protected int[] skillMods = new int[Skill.SKILLS_TOTAL_NUMBER];

	public Item(String type, float weight, Price price, int[] skillMods) {
		this.type = type;
		this.weight = weight;
		this.price = price;
		this.skillMods = skillMods;
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

	/**broadsword, dagger, Soft Leather, Rigid Leather , etc*/
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
	
	public int getModCold() {
		return modCold;
	}

	public void setModCold(int modCold) {
		this.modCold = modCold;
	}

	public int getModFire() {
		return modFire;
	}

	public void setModFire(int modFire) {
		this.modFire = modFire;
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


	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		final Item item = (Item) obj;

		if (this.id != item.id) {
			return false;
		}

		return true;
	}
	
	@Override
	public  Item clone(){
		Item clon = new Item(this.type, this.weight, this.price, new int[Skill.SKILLS_TOTAL_NUMBER]);
		return clon;
	};
	
	public static String getItemTypeToString(int itemType){
		
		String itmType = "";
		
		switch(itemType){
		  case WEAPON_1:  itmType = "MAIN WEAPON";
          	break;
		  case WEAPON_2:  itmType = "SECONDARY WEAPON";
        	break;
		  case ARMOUR:  itmType = "ARMOUR";
      		break;
		  case SHIELD:  itmType = "SHIELD";
    		break;
		  case HELMET:  itmType = "HELMET";
  			break;
		  case BRACERS:  itmType = "BRACERS";
			break;
		  case GREAVES:  itmType = "GREAVES";
			break;
		  case RING_1:  itmType = "RING 1";
			break;
		  case RING_2:  itmType = "RING 2";
			break;
		  case AMULET:  itmType = "AMULET";
			break;
		  case OTHER1:  itmType = "OTHER1";
			break;
		  case OTHER2:  itmType = "OTHER2";
			break;
		  case OTHER3:  itmType = "OTHER3";
			break;
		}
		return itmType;
	}

}
