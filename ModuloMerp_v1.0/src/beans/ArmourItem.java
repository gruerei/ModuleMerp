package beans;

public class ArmourItem extends Item{
	
	public static final int ARMOUR = 0;
	public static final int SHIELD = 1;
	public static final int HELMET = 2;
	public static final int BRACERS = 3;
	public static final int GREAVES = 4;
	
	public int BD;//Bonus defensivo
	public int type;//Escudo, Armadura, Grebas, Brazales
	public int material;//Cuero, Madera, Metal
	public String bonusArmourMagic1;//Normalmente bonus a BD
	public String bonusArmourMagic1AppliedTo;
	public String bonusArmourMagic2;
	public String bonusArmourMagic2AppliedTo;
	
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getBonusArmourMagic1() {
		return bonusArmourMagic1;
	}
	public void setBonusArmourMagic1(String bonusArmourMagic1) {
		this.bonusArmourMagic1 = bonusArmourMagic1;
	}
	public String getBonusArmourMagic1AppliedTo() {
		return bonusArmourMagic1AppliedTo;
	}
	public void setBonusArmourMagic1AppliedTo(String bonusArmourMagic1AppliedTo) {
		this.bonusArmourMagic1AppliedTo = bonusArmourMagic1AppliedTo;
	}
	public String getBonusArmourMagic2() {
		return bonusArmourMagic2;
	}
	public void setBonusWeaponMagic2(String bonusArmourMagic2) {
		this.bonusArmourMagic2 = bonusArmourMagic2;
	}
	public String getBonusArmourMagic2AppliedTo() {
		return bonusArmourMagic2AppliedTo;
	}
	public void setBonusArmourMagic2AppliedTo(String bonusArmourMagic2AppliedTo) {
		this.bonusArmourMagic2AppliedTo = bonusArmourMagic2AppliedTo;
	}
	
	public void setBonusArmourMagic2(String bonusArmourMagic2) {
		this.bonusArmourMagic2 = bonusArmourMagic2;
	}

	
	
}
