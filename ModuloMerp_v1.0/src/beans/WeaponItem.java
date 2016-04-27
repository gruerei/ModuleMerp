package beans;

import utils.Utils;

public class WeaponItem extends Item{
	
	public static final int EDGED = 5;//Filo
	public static final int CONCUSSION = 6;//Contundentes
	public static final int TWO_HANDED = 7;//A dos manos
	public static final int THROWN = 8;//Arrojadizas
	public static final int PROJECTILE = 9;//Proyectil (Arcos)
	public static final int POLEARM = 10;//De asta
	

	private int category;//Filo, Contundente, 2 Manos, Arrojadiza, Proyectiles ,Asta
	private Botch botch;
	private Critical mainCritical;
	//Si se obtiene un critico mayor de B, puede haber derecho a un critico secundario
	//con dos niveles menos de gravedad. Se hacen tiradas separadas.
	private Critical secondCritical;
	private float range;//alcance
	private int typeMod1;
	private Integer [] typeMod1AppliedTo;
	private int typeMod2;
	private Integer [] typeMod2AppliedTo;
	private int specialMod1;
	private String [] specialMod1AppliedTo;
	private int specialMod2;
	private String [] specialMod2AppliedTo;
	
	//Armas a distancia
	public int reloadAssaults;
	public int malusNotReload;
	
	//Armas que pueden ser usados 2H (ademas de una mano)
	/** If the weapon can be Two Handed used*/
	private boolean usedTwoHanded;//Si puede usarse a 2 manos
	private boolean beingUsedTwoHanded;//Si actualmente es usado a 2 manos
	private Botch twoHandedBotch;
	private Critical twoHandedCritical;
	private int twoHandedMod;

	public WeaponItem(String type, int category, Critical main_critical, Critical second_critical, Botch botch,
			float range, float weight, int typeMod1, String [] typeMod1Applied, int typeMod2,
			String [] typeMod2Applied, int specialMod1, String [] specialMod1Applied, int specialMod2,
			String [] specialMod2Applied, int reloadAssaults, int malusNoReload, Price price_obj
			,boolean usedTwoHanded,Botch twoHandedBotch, Critical twoHandedCritical,int twoHandedMod) {
		
		super(type,weight,price_obj);
		
		this.category = category;
		this.mainCritical = main_critical;
		this.secondCritical = second_critical;
		this.botch = botch;
		this.range = range;
		this.typeMod1 = typeMod1;
		this.typeMod2 = typeMod2;
		this.specialMod1 = specialMod1;
		this.specialMod2 = specialMod2;
		this.reloadAssaults = reloadAssaults;
		this.malusNotReload = malusNoReload;
		this.usedTwoHanded = usedTwoHanded;
		this.twoHandedBotch = twoHandedBotch;
		this.twoHandedCritical = twoHandedCritical;
		this.twoHandedMod = twoHandedMod;
		
		/*
		 	public static final int SOFT_LEATHER = 1;//Cuero
			public static final int RIGID_LEATHER = 2;//Cuero Endurecido
			public static final int CHAIN = 3;//Cota de Malla
			public static final int PLATE = 4;//Coraza
		  
		 */
		if(typeMod1Applied.length > 0 && !typeMod1Applied[0].isEmpty())
		{
			this.typeMod1AppliedTo = new Integer[typeMod1Applied.length];
			for(int i = 0; i < typeMod1Applied.length ; i++ ){
				if(typeMod1Applied[i].equals("NO_ARMOR")){
					this.typeMod1AppliedTo [i] = Skill.NO_ARMOR;
				}else if(typeMod1Applied[i].equals("SOFT_LEATHER")){
					this.typeMod1AppliedTo [i] = Skill.SOFT_LEATHER;
				}else if(typeMod1Applied[i].equals("RIGID_LEATHER")){
					this.typeMod1AppliedTo [i] = Skill.RIGID_LEATHER;
				}else if(typeMod1Applied[i].equals("CHAIN")){
					this.typeMod1AppliedTo [i] = Skill.CHAIN;
				}else if(typeMod1Applied[i].equals("PLATE")){
					this.typeMod1AppliedTo [i] = Skill.PLATE;
				}
			}
		}
		
		if(typeMod2Applied.length > 0 && !typeMod2Applied[0].isEmpty())
		{
			this.typeMod2AppliedTo = new Integer[typeMod2Applied.length];
				for(int i = 0; i < typeMod2Applied.length ; i++ ){
					if(typeMod2Applied[i].equals("NO_ARMOR")){
						this.typeMod2AppliedTo [i] = Skill.NO_ARMOR;
					}else if(typeMod2Applied[i].equals("SOFT_LEATHER")){
						this.typeMod2AppliedTo [i] = Skill.SOFT_LEATHER;
					}else if(typeMod2Applied[i].equals("RIGID_LEATHER")){
						this.typeMod2AppliedTo [i] = Skill.RIGID_LEATHER;
					}else if(typeMod2Applied[i].equals("CHAIN")){
						this.typeMod2AppliedTo [i] = Skill.CHAIN;
					}else if(typeMod2Applied[i].equals("PLATE")){
						this.typeMod2AppliedTo [i] = Skill.PLATE;
					}
				}
		}
		
		if(!specialMod1Applied[0].isEmpty())
			this.specialMod1AppliedTo = specialMod1Applied;
		
		if(!specialMod2Applied[0].isEmpty())
			this.specialMod2AppliedTo = specialMod2Applied;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	public Critical getMainCritical() {
		return mainCritical;
	}
	public void setMainCritical(Critical mainCritical) {
		this.mainCritical = mainCritical;
	}
	public Critical getSecondCritical() {
		return secondCritical;
	}
	public void setSecondCritical(Critical secondCritical) {
		this.secondCritical = secondCritical;
	}
	public int getReloadAssaults() {
		return reloadAssaults;
	}
	public void setReloadAssaults(int reloadAssaults) {
		this.reloadAssaults = reloadAssaults;
	}
	public int getMalusNotReload() {
		return malusNotReload;
	}
	public void setMalusNotReload(int malosNotReload) {
		this.malusNotReload = malosNotReload;
	}
	public float getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}

	public int getTypeMod1() {
		return typeMod1;
	}
	public void setTypeMod1(int typeMod1) {
		this.typeMod1 = typeMod1;
	}
	public Integer[] getTypeMod1AppliedTo() {
		return typeMod1AppliedTo;
	}
	public void setTypeMod1AppliedTo(Integer[] typeMod1AppliedTo) {
		this.typeMod1AppliedTo = typeMod1AppliedTo;
	}
	public int getTypeMod2() {
		return typeMod2;
	}
	public void setTypeMod2(int typeMod2) {
		this.typeMod2 = typeMod2;
	}
	public Integer[] getTypeMod2AppliedTo() {
		return typeMod2AppliedTo;
	}
	public void setTypeMod2AppliedTo(Integer[] typeMod2AppliedTo) {
		this.typeMod2AppliedTo = typeMod2AppliedTo;
	}
	public int getSpecialMod1() {
		return specialMod1;
	}
	public void setSpecialMod1(int specialMod1) {
		this.specialMod1 = specialMod1;
	}
	public String[] getSpecialMod1AppliedTo() {
		return specialMod1AppliedTo;
	}
	public void setSpecialMod1AppliedTo(String[] specialMod1AppliedTo) {
		this.specialMod1AppliedTo = specialMod1AppliedTo;
	}
	public int getSpecialMod2() {
		return specialMod2;
	}
	public void setSpecialMod2(int specialMod2) {
		this.specialMod2 = specialMod2;
	}
	public String[] getSpecialMod2AppliedTo() {
		return specialMod2AppliedTo;
	}
	public void setSpecialMod2AppliedTo(String[] specialMod2AppliedTo) {
		this.specialMod2AppliedTo = specialMod2AppliedTo;
	}
	
	public boolean isUsedTwoHanded() {
		return usedTwoHanded;
	}
	public void setUsedTwoHanded(boolean usedTwoHanded) {
		this.usedTwoHanded = usedTwoHanded;
	}
	public Botch getBotch() {
		return botch;
	}
	public void setBotch(Botch botch) {
		this.botch = botch;
	}
	public void setRange(float range) {
		this.range = range;
	}
	
	public boolean isBeingUsedTwoHanded() {
		return beingUsedTwoHanded;
	}
	public void setBeingUsedTwoHanded(boolean beingUsedTwoHanded) {
		this.beingUsedTwoHanded = beingUsedTwoHanded;
	}
	
	public Botch getTwoHandedBotch() {
		return twoHandedBotch;
	}
	public void setTwoHandedBotch(Botch twoHandedBotch) {
		this.twoHandedBotch = twoHandedBotch;
	}
	public Critical getTwoHandedCritical() {
		return twoHandedCritical;
	}
	public void setTwoHandedCritical(Critical twoHandedCritical) {
		this.twoHandedCritical = twoHandedCritical;
	}
	
	public int getTwoHandedMod() {
		return twoHandedMod;
	}
	public void setTwoHandedMod(int twoHandedMod) {
		this.twoHandedMod = twoHandedMod;
	}
	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer("\n\n").append(type).append(" - ").append(Tables.getSkillCategoryTable()[category][0])
										.append("\nCritico 1º:").append(mainCritical.toString()).append("\t2º:").append(secondCritical.toString())
										.append("\nPifia: ").append(botch.getMin()).append(" - ").append(botch.getMax())
										.append(" Crit. Taken: ").append((botch.getCriticalTaken() == null) ? "NO" : botch.getCriticalTaken().getCriticalMaxGravity())
										.append("\nRange: ").append(range).append(" Weight: ").append(weight)
										.append("\nType Mod1: ").append(typeMod1).append(" Applied To: ").append(Utils.printTable(typeMod1AppliedTo))
										.append("\nType Mod2: ").append(typeMod2).append(" Applied To: ").append(Utils.printTable(typeMod2AppliedTo))
										.append("\nSpecial Mod1: ").append(specialMod1).append(" Applied To: ").append(Utils.printTable(specialMod1AppliedTo))
										.append("\nSpecial Mod2: ").append(specialMod2).append(" Applied To: ").append(Utils.printTable(specialMod2AppliedTo))
										.append("\nReaload Assaults: ").append(reloadAssaults).append(" Malus No Reload: ").append(malusNotReload)
										.append("\nPrice: ").append(super.price.toString());
										;
		if(this.usedTwoHanded){
			sb.append("\n2 HANDED PROPERTIES")
			.append("\nCritico 2H: ").append(twoHandedCritical.toString())
			.append("\nPifia 2H: ").append(twoHandedBotch.getMin()).append(" - ").append(twoHandedBotch.getMax())
			.append(" Crit. Taken: ").append((twoHandedBotch.getCriticalTaken() == null) ? "NO" : twoHandedBotch.getCriticalTaken().getCriticalMaxGravity())
			.append("\n2H Mod: ").append(this.twoHandedMod);
		}
		
		return sb.toString();
		
	}

	
}
