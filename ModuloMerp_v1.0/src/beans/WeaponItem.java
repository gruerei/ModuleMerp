package beans;

public class WeaponItem extends Item{
	
	public static final int EDGED = 5;//Filo
	public static final int CONCUSSION = 6;//Contundentes
	public static final int TWO_HANDED = 7;//A dos manos
	public static final int THROWN = 8;//Arrojadizas
	public static final int PROJECTILE = 9;//Proyectil (Arcos)
	public static final int POLEARM = 10;//De asta
	
	public static final int CRITICAL_SLASH = 1;
	public static final int CRITICAL_PUNCTURE = 2;
	public static final int CRITICAL_CRUNCH = 3;
	
	private int category;//Filo, Contundente, 2 Manos, Arrojadiza, Proyectiles ,Asta
	private Botch botch;
	private String mainCritical;
	private String secondCritical;
	private int range;//alcance
	private int typeMod1;
	private int [] typeMod1AppliedTo;
	private int typeMod2;
	private int [] typeMod2AppliedTo;
	private int specialMod1;
	private String [] specialMod1AppliedTo;
	private int specialMod2;
	private String [] specialMod2AppliedTo;
	
	//Armas a distancia
	public int reloadAssaults;
	public int malusNotReload;
	

	public WeaponItem(String type, int category, String main_critical, String second_critical, Botch botch,
			int range, float weight, int typeMod1, String [] typeMod1Applied, int typeMod2,
			String [] typeMod2Applied, int specialMod1, String [] specialMod1Applied, int specialMod2,
			String [] specialMod2Applied, int reloadAssaults, int malusNoReload, Price price_obj) {
		
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
		
		/*
		 	public static final int SOFT_LEATHER = 1;//Cuero
			public static final int RIGID_LEATHER = 2;//Cuero Endurecido
			public static final int CHAIN = 3;//Cota de Malla
			public static final int PLATE = 4;//Coraza
		  
		 */
		if(typeMod1Applied.length > 0)
		{
			for(int i = 0; i < typeMod1Applied.length ; i++ ){
				if(typeMod1Applied[i].equals("SOFT_LEATHER")){
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
		
		if(typeMod2Applied.length > 0)
		{
				for(int i = 0; i < typeMod2Applied.length ; i++ ){
					if(typeMod2Applied[i].equals("SOFT_LEATHER")){
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
		

		this.specialMod1AppliedTo = specialMod1Applied;
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
	
	public String getMainCritical() {
		return mainCritical;
	}
	public void setMainCritical(String mainCritical) {
		this.mainCritical = mainCritical;
	}
	public String getSecondCritical() {
		return secondCritical;
	}
	public void setSecondCritical(String secondCritical) {
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
	public int getRange() {
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
	public int[] getTypeMod1AppliedTo() {
		return typeMod1AppliedTo;
	}
	public void setTypeMod1AppliedTo(int[] typeMod1AppliedTo) {
		this.typeMod1AppliedTo = typeMod1AppliedTo;
	}
	public int getTypeMod2() {
		return typeMod2;
	}
	public void setTypeMod2(int typeMod2) {
		this.typeMod2 = typeMod2;
	}
	public int[] getTypeMod2AppliedTo() {
		return typeMod2AppliedTo;
	}
	public void setTypeMod2AppliedTo(int[] typeMod2AppliedTo) {
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
	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer(type).append(" - ").append(category)
										.append("Critico 1º:").append(mainCritical).append(" 2º:").append(secondCritical)
										.append("Pifia: ").append(botch.getMin()).append(" - ").append(botch.getMax())
										.append(" Crit. Taken: ").append((botch.getCriticalTakenGravity().isEmpty()) ? "NO" : botch.getCriticalTakenGravity())
										.append("Range: ").append(range).append("Weight: ").append(weight)
										.append("Type Mod1: ").append(typeMod1).append(" Applied To: ").append(typeMod1AppliedTo)
										.append("Type Mod2: ").append(typeMod2).append(" Applied To: ").append(typeMod2AppliedTo)
										.append("Special Mod1: ").append(specialMod1).append(" Applied To: ").append(specialMod1AppliedTo)
										.append("Special Mod2: ").append(specialMod2).append(" Applied To: ").append(specialMod2AppliedTo)
										.append("Reaload Assaults: ").append(reloadAssaults).append(" Malus No Reload: ").append(malusNotReload)
										.append("Price: ").append(super.price.toString());
										;

		
		return sb.toString();
		
	}

	
}
