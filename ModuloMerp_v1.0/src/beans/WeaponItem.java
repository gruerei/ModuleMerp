package beans;

import utils.Utils;
import utils.Tables.Tables;

public class WeaponItem extends Item implements Cloneable{
	
	/**TODO Los casos donde un arma puede usarse de dos formas:
	 * Por defecto se usará lo que viene en el .properties en su categoria
	 * Bastard Sword and Double Axe : Por defecto (EDGED - 1 HAND)
	 * DAGGER, AXE : Por defecto (EDGED - 1 HAND) 
	 * 
	 * Modificable en el Combate
	 * */
	
	public static final int EDGED = 5;//Filo
	public static final int CONCUSSION = 6;//Contundentes
	public static final int TWO_HANDED = 7;//A dos manos
	public static final int THROWN = 8;//Arrojadizas
	public static final int PROJECTILE = 9;//Proyectil (Arcos)
	public static final int POLEARM = 10;//De asta
	
	public static final int BROADSWORD = 1;
	public static final int DAGGER = 2;
	public static final int AXE = 3;
	public static final int SCIMITAR = 4;
	public static final int SHORTSWORD = 5;
	public static final int CLUB = 6;
	public static final int MACE = 7;
	public static final int MORNINGSTAR = 8;
	public static final int NET = 9;
	public static final int WARHAMMER = 10;
	public static final int WHIP = 11;
	public static final int JAVELIN = 12;
	public static final int SPEAR = 13;
	public static final int LANCE = 14;
	public static final int HALBERD = 15;
	public static final int BATTLEAXE = 16;
	public static final int FLAIL = 17;
	public static final int STAFF = 18;
	public static final int GREATSWORD = 19;
	public static final int BOLAS = 20;
	public static final int COMPOSITEBOW = 21;
	public static final int SHORTBOW = 22;
	public static final int LONGBOW = 23;
	public static final int CROSSBOW = 24;
	public static final int SLING = 25;
	public static final int BASTARDSWORD = 26;
	public static final int DOUBLEAXE = 27;
	
	
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
	private int BO;
	
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
	
	private StringBuffer outputBOChain;

	public WeaponItem(String type, int category, Critical main_critical, Critical second_critical, Botch botch,
			float range, float weight, int typeMod1, Integer [] typeMod1Applied, int typeMod2,
			Integer [] typeMod2Applied, int specialMod1, String [] specialMod1Applied, int specialMod2,
			String [] specialMod2Applied, int reloadAssaults, int malusNoReload, Price price_obj
			,boolean usedTwoHanded,Botch twoHandedBotch, Critical twoHandedCritical,int twoHandedMod, int [] skillMods) {
		
		super(type,weight,price_obj,skillMods);
		
		this.category = category;
		this.mainCritical = main_critical;
		this.secondCritical = second_critical;
		this.botch = botch;
		this.range = range;
		this.specialMod1 = specialMod1;
		this.specialMod2 = specialMod2;
		this.reloadAssaults = reloadAssaults;
		this.malusNotReload = malusNoReload;
		this.usedTwoHanded = usedTwoHanded;
		this.twoHandedBotch = twoHandedBotch;
		this.twoHandedCritical = twoHandedCritical;
		this.twoHandedMod = twoHandedMod;
		
		this.typeMod1 = typeMod1;
		this.typeMod2 = typeMod2;
		this.typeMod1AppliedTo = typeMod1Applied;
		this.typeMod2AppliedTo = typeMod2Applied;
		
		if(specialMod1Applied != null && specialMod1Applied[0] != null && !specialMod1Applied[0].isEmpty())
			this.specialMod1AppliedTo = specialMod1Applied;
		
		if(specialMod2Applied != null && specialMod2Applied[0] != null && !specialMod2Applied[0].isEmpty())
			this.specialMod2AppliedTo = specialMod2Applied;
	}
	
	public WeaponItem(String type, int category, Critical main_critical, Critical second_critical, Botch botch,
			float range, float weight, int specialMod1, String [] specialMod1Applied, int specialMod2,
			String [] specialMod2Applied, int reloadAssaults, int malusNoReload, Price price_obj
			,boolean usedTwoHanded,Botch twoHandedBotch, Critical twoHandedCritical,int twoHandedMod, int [] skillMods) {
		
		super(type,weight,price_obj,skillMods);
		
		this.category = category;
		this.mainCritical = main_critical;
		this.secondCritical = second_critical;
		this.botch = botch;
		this.range = range;
		this.specialMod1 = specialMod1;
		this.specialMod2 = specialMod2;
		this.reloadAssaults = reloadAssaults;
		this.malusNotReload = malusNoReload;
		this.usedTwoHanded = usedTwoHanded;
		this.twoHandedBotch = twoHandedBotch;
		this.twoHandedCritical = twoHandedCritical;
		this.twoHandedMod = twoHandedMod;
		
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
	
	public int getBO() {
		return BO;
	}

	public void setBO(int bO) {
		BO = bO;
	}

	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer("\n\n").append(name == null ? "" : name+ " - ")
										.append(type).append(" - ").append(Tables.getSkillCategoryTable()[category][0])
										.append(outputBOChain)
										.append("\nCritico 1º:").append(mainCritical.toString()).append("\t2º:").append(secondCritical != null ? secondCritical.toString() : "")
										.append("\nPifia: ").append(botch.getMin()).append(" - ").append(botch.getMax())
										.append(" Crit. Taken: ").append((botch.getCriticalTaken() == null) ? "NO" : botch.getCriticalTaken().getCriticalMaxGravity())
										.append("\nRange: ").append(range).append(" Weight: ").append(weight).append(" kg.")
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
	@Override
	public boolean equals(Object obj) {
		
		boolean ret = super.equals(obj);
		
		if(ret == true){
			WeaponItem wi = (WeaponItem)obj;
			if(this.category != wi.getCategory()){
				ret = false;
			}
			if(!this.type.equals(wi.getType())){
				ret = false;
			}
			return ret;	
		}else{
			return ret;
		}
		
	}
	
	public void conversionTypeMod(int selector, String [] typeModApplied){
		
		if(typeModApplied.length > 0 && !typeModApplied[0].isEmpty())
		{
			if(selector == 1){
					this.typeMod1AppliedTo = new Integer[typeModApplied.length];
					for(int i = 0; i < typeModApplied.length ; i++ ){
						if(typeModApplied[i].equals("NO_ARMOR")){
							this.typeMod1AppliedTo [i] = Skill.NO_ARMOR;
						}else if(typeModApplied[i].equals("SOFT_LEATHER")){
							this.typeMod1AppliedTo [i] = Skill.SOFT_LEATHER;
						}else if(typeModApplied[i].equals("RIGID_LEATHER")){
							this.typeMod1AppliedTo [i] = Skill.RIGID_LEATHER;
						}else if(typeModApplied[i].equals("CHAIN")){
							this.typeMod1AppliedTo [i] = Skill.CHAIN;
						}else if(typeModApplied[i].equals("PLATE")){
							this.typeMod1AppliedTo [i] = Skill.PLATE;
						}
					}
			}else if(selector == 2){
				this.typeMod2AppliedTo = new Integer[typeModApplied.length];
				for(int i = 0; i < typeModApplied.length ; i++ ){
					if(typeModApplied[i].equals("NO_ARMOR")){
						this.typeMod2AppliedTo [i] = Skill.NO_ARMOR;
					}else if(typeModApplied[i].equals("SOFT_LEATHER")){
						this.typeMod2AppliedTo [i] = Skill.SOFT_LEATHER;
					}else if(typeModApplied[i].equals("RIGID_LEATHER")){
						this.typeMod2AppliedTo [i] = Skill.RIGID_LEATHER;
					}else if(typeModApplied[i].equals("CHAIN")){
						this.typeMod2AppliedTo [i] = Skill.CHAIN;
					}else if(typeModApplied[i].equals("PLATE")){
						this.typeMod2AppliedTo [i] = Skill.PLATE;
					}
				}
			}
		}
		
	}
	
	@Override
	public WeaponItem clone(){
		WeaponItem clon = new WeaponItem(this.type, this.category, this.mainCritical, this.secondCritical,
				this.botch, this.range, this.weight, this.typeMod1, this.typeMod1AppliedTo, this.typeMod2,
				this.typeMod2AppliedTo, 0, new String[10], 0,new String[10],
				this.reloadAssaults, this.malusNotReload, this.price,
				this.usedTwoHanded,this.twoHandedBotch, this.twoHandedCritical,this.twoHandedMod, new int[Skill.SKILLS_TOTAL_NUMBER]);
		return clon;
	}

	public void setoutputBOChain(StringBuffer bOchain) {
		outputBOChain = bOchain;
		
	}
	


	
}
