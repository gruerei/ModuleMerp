package beans;

public class ArmourItem extends Item{
	
	
	public int BD;//Bonus defensivo
	public int category;//Armour, Shield, Helmet, Bracers, Greaves
	public int material;//Cuero, Madera, Metal
	public int bonusArmourMagic1;//Normalmente bonus a BD
	public int bonusArmourMagic1AppliedTo;
	public int bonusArmourMagic2;
	public int bonusArmourMagic2AppliedTo;
	
	
	public ArmourItem(String type, float weight, Price price) {
		super(type, weight, price);
	}
	
	public int getBD() {
		return BD;
	}
	public void setBD(int bD) {
		BD = bD;
	}
	
	public int getMaterial() {
		return material;
	}
	public void setMaterial(int material) {
		this.material = material;
	}

	public int getBonusArmourMagic1() {
		return bonusArmourMagic1;
	}
	public void setBonusArmourMagic1(int bonusArmourMagic1) {
		this.bonusArmourMagic1 = bonusArmourMagic1;
	}
	public int getBonusArmourMagic1AppliedTo() {
		return bonusArmourMagic1AppliedTo;
	}
	public void setBonusArmourMagic1AppliedTo(int bonusArmourMagic1AppliedTo) {
		this.bonusArmourMagic1AppliedTo = bonusArmourMagic1AppliedTo;
	}
	public int getBonusArmourMagic2() {
		return bonusArmourMagic2;
	}
	public void setBonusWeaponMagic2(int bonusArmourMagic2) {
		this.bonusArmourMagic2 = bonusArmourMagic2;
	}
	public int getBonusArmourMagic2AppliedTo() {
		return bonusArmourMagic2AppliedTo;
	}
	public void setBonusArmourMagic2AppliedTo(int bonusArmourMagic2AppliedTo) {
		this.bonusArmourMagic2AppliedTo = bonusArmourMagic2AppliedTo;
	}
	
	public void setBonusArmourMagic2(int bonusArmourMagic2) {
		this.bonusArmourMagic2 = bonusArmourMagic2;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}

	
	
	
}
