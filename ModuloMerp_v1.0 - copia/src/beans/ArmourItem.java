package beans;

import utils.Utils;
import utils.Tables.Tables;
import utils.Tables.Tables_AT;

public class ArmourItem extends Item implements Cloneable{
	
	public static final int NO_ARMOUR = 0;
	public static final int SOFT_LEATHER = 1;
	public static final int RIGID_LEATHER = 2;
	public static final int CHAIN = 3;
	public static final int PLATE = 4;
	
	public static final int GREAT_SHIELD = 5;
	public static final int MEDIUM_SHIELD = 6;
	public static final int SMALL_SHIELD = 7;
	
	public static final int LEATHER_HELMET = 8;
	public static final int METAL_HELMET = 9;
	
	public static final int LEATHER_BRACERS = 10;
	public static final int METAL_BRACERS = 11;
	
	public static final int LEATHER_GREAVERS = 12;
	public static final int METAL_GREAVERS = 13;
	
	public static final int BIG = 1;
	public static final int MEDIUM = 2;
	public static final int SMALL = 3;
	
	private int category;//Armour, Shield, Helmet, Bracers, Greaves
	private String material;//Cuero, Madera, Metal
	private int bonusMagic1;//Normalmente bonus a BD
	private String [] bonusMagic1AppliedTo;
	private int bonusMagic2;
	private String [] bonusMagic2AppliedTo;
	private int bonusBO;
	
	
	public ArmourItem(String type, float weight, Price price, int category, String material, int[] skillMods, int BO) {
		
		super(type, weight, price , skillMods);
		
		this.category = category;
		this.material = material;
		this.bonusBO = BO;
	}
	

	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}

	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}

	public int getBonusMagic1() {
		return bonusMagic1;
	}

	public void setBonusMagic1(int bonusMagic1) {
		this.bonusMagic1 = bonusMagic1;
	}

	public int getBonusMagic2() {
		return bonusMagic2;
	}

	public void setBonusMagic2(int bonusMagic2) {
		this.bonusMagic2 = bonusMagic2;
	}

	public String[] getBonusMagic1AppliedTo() {
		return bonusMagic1AppliedTo;
	}

	public void setBonusMagic1AppliedTo(String[] bonusMagic1AppliedTo) {
		this.bonusMagic1AppliedTo = bonusMagic1AppliedTo;
	}

	public String[] getBonusMagic2AppliedTo() {
		return bonusMagic2AppliedTo;
	}

	public void setBonusMagic2AppliedTo(String[] bonusMagic2AppliedTo) {
		this.bonusMagic2AppliedTo = bonusMagic2AppliedTo;
	}
	

	public int getBonusBO() {
		return bonusBO;
	}


	public void setBonusBO(int bonusBO) {
		this.bonusBO = bonusBO;
	}


	@Override
	public Item clone() {
		ArmourItem clone = new ArmourItem(this.type, this.weight, this.price, this.category, this.material, this.skillMods, this.bonusBO);
		return clone;
	}
	

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("\n\n").append(name == null ? "" : name + " - ").append(type).append(" - ").append(Tables.getItem_categories()[category])
				.append("\nBD: ").append(getSkillMods()[Skill.BD]).append(" BO: ").append(bonusBO)
				.append(" Weight: ").append(weight).append(" kg. Material: ").append(material)
				.append("\nMagic Mod1: ").append(bonusMagic1).append(" Applied To: ").append(Utils.printTable(bonusMagic1AppliedTo))
				.append("\nMagic Mod2: ").append(bonusMagic2).append(" Applied To: ").append(Utils.printTable(bonusMagic2AppliedTo))
				.append("\nPrice: ").append(super.price.toString());
				;
		
		return sb.toString();
	}

	
	public static int getMovementSkillByArmour(String armourType){
		int ret = 0;
		
		if(armourType == null){
			ret = Skill.NO_ARMOR;
		}else if(armourType.equalsIgnoreCase("SOFT LEATHER")){
			ret = Skill.SOFT_LEATHER;
		}else if(armourType.equalsIgnoreCase("RIGID LEATHER")){
			ret = Skill.RIGID_LEATHER;
		}else if(armourType.equalsIgnoreCase("CHAIN")){
			ret = Skill.CHAIN;
		}else if(armourType.equalsIgnoreCase("PLATE")){
			ret = Skill.PLATE;
		}
		return ret;
	}
	
	
}
