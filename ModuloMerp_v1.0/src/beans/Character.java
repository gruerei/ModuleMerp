package beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import utils.Utils;
import utils.Tables.Tables;

public class Character {
	

	public static String WEAPON1_USED = "WEAPON1_USED";
	public static String WEAPON2_USED = "WEAPON2_USED";
	public static String SHIELD_USED= "SHIELD_USED";
	public static String GREAVES_USED = "GREAVES_USED";//GREBAS
	public static String GLOVES_USED = "GLOVES_USED";//GUANTES
	public static String HELMET_USED = "HELMET_USED";//CASCO
	public static String RING1_USED = "RING1_USED";//ANILLO_1
	public static String RING2_USED = "RING2_USED";//ANILLO_2
	public static String ARMOR_USED = "ARMOR_USED";//ARMADURA
	public static String TALISMAN_USED = "TALISMAN_USED";//TALISMAN
	
	public static int RIGHT_HANDED = 1;
	public static int LEFT_HANDED = 2;
	public static int BOTH_HANDED = 3;
	
	private int id;
	
	/*Principales*/
	private String name;
	private String player;
	private Race race;
	private Profession profession;//Guerrero, Explorador, Montaraz, Bardo, etc
	private int level;
	private int PX = 10000;//Experiencia. Se empieza con 10.000 px de inicio
	private int PP;//Puntos de poder
	
	private List<Integer> MAGICAL_DOMAIN = new ArrayList<Integer>();//CANALIZACION o ESENCIA
	
	/*Descripcion Personaje*/
	private int gender;//Hombre/Mujer
	private int age;
	private int height;//centimetros
	private int weight;//kilos
	private String hair;
	private String eyes;
	private String physicalLook;
	private String personality;
	private String motivation;
	private String alignment;//bueno, neutral, malo
	private List<String> special;//para poner cualquier cosa adicional
	private String origin;//Procedencia
	private String family;//Clan,familia
	private String religion;
	private String gods;
	
	//ATRIBUTOS
	/** Para equilibrar se podia aceptar como regla de la casa que para crear 
	 * un personaje nuevo lo minimo sean dos 90s o su equivalente(bono total por attrib de +20)*/
	private Map<String, Attribute> attributes = new HashMap<String, Attribute>();
	
	//LENGUAJES
	private List<Language> languages = new ArrayList<Language>();
	
	//CARGA
	private float loadlimit;
	private float load;
	
	/*COMBATE*/
	private Life life;//vida total
	private int gradesLife;//vida obtenida a partir de las tiradas de dados
	
	private int totalBD;//BD con escudo
	private int totalNoShield;//BD sin escudo
	private int movSpeed;//Movimiento
	private int loadPenal;//PenalizadorCarga
	private int woundPenal;//PenalizadorHeridas
	
	private boolean flanked = false;
	private boolean attackedFromBehind = false;
	private boolean offGuarded = false;
	private boolean ableToParry = true;
	private boolean ableToBlock = true;
	private boolean isBigCreature = false;
	
	
	private boolean leftArmDisabled = false;
	private boolean rightArmDisabled = false;
	private boolean leftLegDisabled = false;
	private boolean rightLegDisabled = false;
	
	/*Derecho = 1, Zurdo = 2 o Ambos = 3*/
	private int mainHandedUsed = RIGHT_HANDED;
	private int parryBonusInUse = 0;
	
	/*ACTIVITY*/
	private CombatStatus activity;
	
	/*KNOCKED OUT*/
	private CombatStatus knockedOut;
	
	/*STUNNED*/
	private CombatStatus stunned;
	
	/*DEAD*/
	//private CombatStatus 
	private CombatStatus dead;
	
	/*INVENTARIO*/
	private List<Item> inventory = new ArrayList<Item>();
	
	/*EQUIPO EN USO*/
	private Map<Integer, Item> equippedGear = new HashMap<Integer, Item>();
	
	/*GEAR SKILL MODS*/
	private Map<Integer, Integer> totalGearSkillMods  = new HashMap<Integer, Integer>();
	
	/*SKILLS */
	private int[] skillGrades = new int[Skill.SKILLS_TOTAL_NUMBER];
	private Map<Integer, Skill> skills  = new HashMap<Integer, Skill>();
	
	
	
	/*ASCENDANCY/HISTORICAL*/
	/*1. NO PROFESSIONAL SKILL
	 * 	 1.1 PRIMARY
	 *   1.2 SECONDARY 
	 *  
	 *2. ATTRIBUTES  
	 *	 2.1 (Una caracteristicas aumenta en 2)
	 *   2.2 (Tres caracteristicas aumentan en 1)
	 *  
	 *3. LANGUAGES
	 *	 3.1 One Language 5 grades
	 *
	 *4. SPECIAL ABILITIES
	 *
	 *5. SPECIAL ITEMS
	 *   1. Item +10
	 *   2. Item +15
	 *   3. Others
	 *6. MONEY*/
	
	

	/*RESISTANCES*/
	private Map<String, ResistanceRoll> resistanceRolls = new HashMap<String, ResistanceRoll>();
	
	public CombatStatus getActivity() {
		return activity;
	}


	public void setActivity(CombatStatus activity) {
		this.activity = activity;
	}


	public Character(String name, String player) {
		this.name = name;
		this.player = player;
	}

			
	public Character(String name, String player, int lvl, int PX, String raceIn, String cultureIn, String professionIn, Map<Integer, Item> equippedGear , int sTR, int aGI, int cON, int iNT, int i,
			int cAR, int aP, int baseLife, String magicalDomainChoosen,int[] skillGrades ,int[][] specialSkillModif){

		this.name = name;
		this.player = player;
		this.level = lvl;
		this.PX = PX;

		Race race = new Race(raceIn, cultureIn);
		this.setRace(race);
		
		/*Calcula modificadores por atributos*/
		Attribute strength =new Attribute(Attribute.STRENTGTH, sTR);
		Attribute agility =new Attribute(Attribute.AGILITY, aGI);
		Attribute constitution =new Attribute(Attribute.CONSTITUTION, cON);
		Attribute intelligence =new Attribute(Attribute.INTELLIGENCE, iNT);
		Attribute intuition =new Attribute(Attribute.INTUITION, i);
		Attribute appear = new Attribute(Attribute.APPEARANCE, aP);
		Attribute charis = new Attribute(Attribute.CHARISMA, cAR);
		/*Al carisma le sumo-resto la apariencia*/
		
		/**Calcular modifTotal*/
		strength.calculModifTotal(race.getModStrength());
		agility.calculModifTotal(race.getModAgility());
		constitution.calculModifTotal(race.getModConstitution());
		intelligence.calculModifTotal(race.getModIntelligence());
		intuition.calculModifTotal(race.getModIntuition());
		
		/** Regla Nueva: Al carisma le sumo el bono de Apariencia*/
		if(Attribute.isCharismaBeneficiedByAppearance()){
			appear.setModifTotal(race.getModCharisma());
			charis.setModifAtt(charis.getModifAtt() + appear.getModifAtt());
			
		}else{
			/*Por defecto*/
			appear.setModifTotal(0);
		}

		charis.calculModifTotal(race.getModCharisma());
		
		this.getAttributes().put(Attribute.STRENTGTH, strength);
		this.getAttributes().put(Attribute.AGILITY, agility);
		this.getAttributes().put(Attribute.CONSTITUTION, constitution);
		this.getAttributes().put(Attribute.INTELLIGENCE, intelligence);
		this.getAttributes().put(Attribute.INTUITION, intuition);
		this.getAttributes().put(Attribute.CHARISMA , charis);
		//this.getAttributes().put(Attribute.PRESENCE , charis);
		this.getAttributes().put(Attribute.APPEARANCE, appear);
		
		/**Regla : avisar si el pj tiene menos de 20 de modificador positivo por attributos (para recrearlo)*/
		notifyWeakChar(this.attributes);
		
		Profession p = new Profession(professionIn,this, magicalDomainChoosen);
		this.setProfession(p);
		
		this.setEquippedGear(equippedGear);
		
		this.skillGrades = skillGrades;
		/*Calcular bonos a skills de los objetos en uso*/
		
		
		this.skills = calculSkills(this.skillGrades,this.profession, this.race, this.level, baseLife, this.attributes
				,equippedGear,specialSkillModif);
		
	
		int totalLife = this.skills.get(Skill.BODY_DEVELOPMENT).getModifTotal();
		this.life = new Life(baseLife,totalLife);
		
		this.totalBD = this.skills.get(Skill.BD).getModifTotal();
		ArmourItem shield = (ArmourItem)this.equippedGear.get(Item.SHIELD);
		this.totalNoShield = totalBD - shield.getSkillMods()[Skill.BD];
		
		WeaponItem weapon = (WeaponItem)this.equippedGear.get(Item.WEAPON_1);
		
		weapon.setBO(this.skills.get(weapon.getCategory()).getModifTotal());
		
		
		/*Calcula Resistance Rolls*/
		this.setResistanceRolls(calculResistanceRolls());
		

	}
	
	private Map<Integer, Skill> calculSkills(int[] skillGrades2, Profession profession2, Race race, int level2, int gradesLife,
			Map<String, Attribute> attributes2, Map<Integer, Item> equippedGear2,int[][] specialSkillModif2) {
		
		Map<Integer, Skill> skills = new HashMap<Integer, Skill>();
		
		for(int skillidx = 0; skillidx < Skill.SKILLS_TOTAL_NUMBER ; skillidx++){
			Skill skill = new Skill(skillidx,skillGrades2[skillidx]);
			skill.calculGradesModifier(gradesLife);
			skill.calculAttribModifier(attributes2,race);
			skill.calculProfessionModifier(profession2.getName(), level2);
			skill.calculSkillObjectMods(equippedGear2);
			skill.calculSpecialModifiers(specialSkillModif2);
			skill.calculTotalModifiers();
			skills.put(skillidx, skill);
		}
		
		return skills;
	}

	/*Calcula las Tiradas de Resistancia de un personaje*/
	private Map<String, ResistanceRoll> calculResistanceRolls() {
		
		Map<String, ResistanceRoll> rRolls = new  HashMap<String, ResistanceRoll>();
		
		ResistanceRoll essenceRR = new ResistanceRoll(ResistanceRoll.ESSENCE, race, equippedGear, attributes);
		ResistanceRoll chanRR = new ResistanceRoll(ResistanceRoll.CHANNELLING, race, equippedGear, attributes);
		ResistanceRoll poisonRR = new ResistanceRoll(ResistanceRoll.POISON, race, equippedGear, attributes);
		ResistanceRoll diseaseRR = new ResistanceRoll(ResistanceRoll.DISEASE, race, equippedGear, attributes);
		ResistanceRoll coldRR = new ResistanceRoll(ResistanceRoll.COLD, race, equippedGear, attributes);
		ResistanceRoll fireRR = new ResistanceRoll(ResistanceRoll.FIRE, race, equippedGear, attributes);
		
		Map<String, Integer> totalGearResistances  = calculTotalGearResistances(equippedGear);
		
		essenceRR.calculTotalBonus(totalGearResistances);
		chanRR.calculTotalBonus(totalGearResistances);
		poisonRR.calculTotalBonus(totalGearResistances);
		diseaseRR.calculTotalBonus(totalGearResistances);
		coldRR.calculTotalBonus(totalGearResistances);
		fireRR.calculTotalBonus(totalGearResistances);
		
		rRolls.put(ResistanceRoll.ESSENCE, essenceRR);
		rRolls.put(ResistanceRoll.CHANNELLING, chanRR);
		rRolls.put(ResistanceRoll.POISON,poisonRR);
		rRolls.put(ResistanceRoll.DISEASE, diseaseRR);
		rRolls.put(ResistanceRoll.COLD, coldRR);
		rRolls.put(ResistanceRoll.FIRE, fireRR);
		
		return rRolls;
	}

	private void notifyWeakChar(Map<String, Attribute> attributes) {
		int attribAcum = 0;
		for(Map.Entry<String, Attribute> entry : attributes.entrySet()){
			if(entry.getKey()!= Attribute.APPEARANCE && entry.getKey()!= Attribute.PRESENCE)
				attribAcum = attribAcum + entry.getValue().getModifAtt();
		}
		if(attribAcum < 20 ){
			/*Notificar en el LOG de que el pj es debil*/
			System.out.println("ATENCION: Este personaje tiene un bono por Atributos menor de 20. Se aconseja rehacer tiradas.\n");
		}
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPlayer() {
		return player;
	}

	public Race getRace() {
		return race;
	}

	public Profession getProfession() {
		return profession;
	}

	public int getLevel() {
		return level;
	}

	public int getPX() {
		return PX;
	}

	public int getPP() {
		return PP;
	}

	public List<Integer> getMAGICAL_DOMAIN() {
		return MAGICAL_DOMAIN;
	}


	public int getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	public String getHair() {
		return hair;
	}

	public String getEyes() {
		return eyes;
	}

	public String getPhysicalLook() {
		return physicalLook;
	}

	public String getPersonality() {
		return personality;
	}

	public String getMotivation() {
		return motivation;
	}

	public String getAlignment() {
		return alignment;
	}

	public List<String> getSpecial() {
		return special;
	}

	public String getOrigin() {
		return origin;
	}

	public String getFamily() {
		return family;
	}

	public String getReligion() {
		return religion;
	}

	public String getGods() {
		return gods;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public float getLoadlimit() {
		return loadlimit;
	}

	public float getLoad() {
		return load;
	}


	public int getTotalBD() {
		return totalBD;
	}

	public int getTotalNoShield() {
		return totalNoShield;
	}

	public int getMovSpeed() {
		return movSpeed;
	}

	public int getLoadPenal() {
		return loadPenal;
	}

	public int getWoundPenal() {
		return woundPenal;
	}


	public Map<Integer, Item> getEquippedGear() {
		return equippedGear;
	}


	public List<Item> getInventory() {
		return inventory;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setPX(int pX) {
		PX = pX;
	}

	public void setPP(int pP) {
		PP = pP;
	}

	public void setMAGICAL_DOMAIN(List<Integer> mAGICAL_DOMAIN) {
		MAGICAL_DOMAIN = mAGICAL_DOMAIN;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setHair(String hair) {
		this.hair = hair;
	}

	public void setEyes(String eyes) {
		this.eyes = eyes;
	}

	public void setPhysicalLook(String physicalLook) {
		this.physicalLook = physicalLook;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public void setSpecial(List<String> special) {
		this.special = special;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public void setGods(String gods) {
		this.gods = gods;
	}

	public void setAttributes(Map<String, Attribute> attributes) {
		this.attributes = attributes;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public void setLoadlimit(float loadlimit) {
		this.loadlimit = loadlimit;
	}

	public void setLoad(float load) {
		this.load = load;
	}


	public void setTotalBD(int totalBD) {
		this.totalBD = totalBD;
	}

	public void setTotalNoShield(int totalNoShield) {
		this.totalNoShield = totalNoShield;
	}

	public void setMovSpeed(int movSpeed) {
		this.movSpeed = movSpeed;
	}

	public void setLoadPenal(int loadPenal) {
		this.loadPenal = loadPenal;
	}

	public void setWoundPenal(int woundPenal) {
		this.woundPenal = woundPenal;
	}


	public Life getLife() {
		return life;
	}


	public void setLife(Life life) {
		this.life = life;
	}


	public int getGradesLife() {
		return gradesLife;
	}


	public void setGradesLife(int gradesLife) {
		this.gradesLife = gradesLife;
	}


	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}

	public void setEquippedGear(Map<Integer, Item> equippedGear) {
		this.equippedGear = equippedGear;
	}

	public void setResistanceRolls(Map<String, ResistanceRoll> resistanceRolls) {
		this.resistanceRolls = resistanceRolls;
	}

	public Map<String, Attribute> getAttributes() {
		return attributes;
	}

	public Map<String, ResistanceRoll> getResistanceRolls() {
		return resistanceRolls;
	}


	
	
	public boolean isBigCreature() {
		return isBigCreature;
	}


	public void setBigCreature(boolean isBigCreature) {
		this.isBigCreature = isBigCreature;
	}


	/*Recorre el equipo en uso y obtiene y suma el total de las resistencias de todos estos objetos*/
	public Map<String, Integer> calculTotalGearResistances(Map<Integer, Item> inUseGear){
		
		Map<String, Integer> totalGearResistances = new HashMap<String, Integer>();
		int essenceRes = 0;
		int channelRes = 0;
		int poisonRes = 0;
		int diseaseRes = 0;
		int coldRes = 0;
		int fireRes = 0;

		for (Map.Entry<Integer, Item> entry : inUseGear.entrySet()) {
			//String key = entry.getKey();
			Item item = entry.getValue();
			essenceRes = essenceRes + item.getModEssence();
			channelRes = channelRes + item.getModChanneling();
			poisonRes = poisonRes + item.getModPoison();
			diseaseRes = diseaseRes + item.getModDisease();
			coldRes = coldRes + item.getModCold();
			fireRes = fireRes + item.getModFire();
		}
		
		totalGearResistances.put(ResistanceRoll.ESSENCE, essenceRes);
		totalGearResistances.put(ResistanceRoll.CHANNELLING, channelRes);
		totalGearResistances.put(ResistanceRoll.POISON, poisonRes);
		totalGearResistances.put(ResistanceRoll.DISEASE, diseaseRes);
		totalGearResistances.put(ResistanceRoll.COLD, coldRes);
		totalGearResistances.put(ResistanceRoll.FIRE, fireRes);
		return totalGearResistances;

	}

	public Map<Integer, Integer> getTotalGearSkillMods() {
		return totalGearSkillMods;
	}


	public Map<Integer, Skill> getSkills() {
		return skills;
	}
	
	
	public void setSkills(Map<Integer, Skill> skills) {
		this.skills = skills;
	}
	
	public void addPx(int px){
		this.PX = this.PX + px;
	}
	
	

	public boolean isFlanked() {
		return flanked;
	}


	public void setFlanked(boolean flanked) {
		this.flanked = flanked;
	}


	public boolean isAttackedFromBehind() {
		return attackedFromBehind;
	}


	public void setAttackedFromBehind(boolean attackedFromBehind) {
		this.attackedFromBehind = attackedFromBehind;
	}


	public boolean isOffGuarded() {
		return offGuarded;
	}


	public void setOffGuarded(boolean offGuarded) {
		this.offGuarded = offGuarded;
	}


	public CombatStatus getStunned() {
		return stunned;
	}


	public void setStunned(CombatStatus stunned) {
		this.stunned = stunned;
	}

	
	public boolean isAbleToParry() {
		return ableToParry;
	}


	public void setAbleToParry(boolean ableToParry) {
		this.ableToParry = ableToParry;
	}
	
	

	public boolean isAbleToBlock() {
		return ableToBlock;
	}


	public void setAbleToBlock(boolean ableToBlock) {
		this.ableToBlock = ableToBlock;
	}
	
	/*Romper el item (en un combate)*/
	public void tearItem(int key){
		equippedGear.remove(key);
	}

	
	public boolean isLeftArmDisabled() {
		return leftArmDisabled;
	}


	public void setLeftArmDisabled(boolean leftArmDisabled) {
		this.leftArmDisabled = leftArmDisabled;
	}


	public boolean isRightArmDisabled() {
		return rightArmDisabled;
	}


	public void setRightArmDisabled(boolean rightArmDisabled) {
		this.rightArmDisabled = rightArmDisabled;
	}


	public boolean isLeftLegDisabled() {
		return leftLegDisabled;
	}


	public void setLeftLegDisabled(boolean leftLegDisabled) {
		this.leftLegDisabled = leftLegDisabled;
	}


	public boolean isRightLegDisabled() {
		return rightLegDisabled;
	}


	public void setRightLegDisabled(boolean rightLegDisabled) {
		this.rightLegDisabled = rightLegDisabled;
	}


	public int getMainHandedUsed() {
		return mainHandedUsed;
	}


	public void setMainHandedUsed(int mainHandedUsed) {
		this.mainHandedUsed = mainHandedUsed;
	}


	public int getParryBonusInUse() {
		return parryBonusInUse;
	}


	public void setParryBonusInUse(int parryBonusInUse) {
		this.parryBonusInUse = parryBonusInUse;
	}
	

	public CombatStatus getKnockedOut() {
		return knockedOut;
	}


	public void setKnockedOut(CombatStatus knockedOut) {
		this.knockedOut = knockedOut;
	}


	public void show() {
		
		Attribute str = getAttributes().get(Attribute.STRENTGTH);
		Attribute agi = getAttributes().get(Attribute.AGILITY);
		Attribute cons = getAttributes().get(Attribute.CONSTITUTION);
		Attribute inte = getAttributes().get(Attribute.INTELLIGENCE);
		Attribute intui = getAttributes().get(Attribute.INTUITION);
		Attribute charis = getAttributes().get(Attribute.CHARISMA);
		Attribute appea = getAttributes().get(Attribute.APPEARANCE);
		
		ResistanceRoll essence = getResistanceRolls().get(ResistanceRoll.ESSENCE);
		ResistanceRoll channel = getResistanceRolls().get(ResistanceRoll.CHANNELLING);
		ResistanceRoll poison = getResistanceRolls().get(ResistanceRoll.POISON);
		ResistanceRoll disease = getResistanceRolls().get(ResistanceRoll.DISEASE);
		ResistanceRoll cold = getResistanceRolls().get(ResistanceRoll.COLD);
		ResistanceRoll fire = getResistanceRolls().get(ResistanceRoll.FIRE);
		
		StringBuffer sbDomain = new StringBuffer();
		for(int i=0 ; i<getMAGICAL_DOMAIN().size();i++){
			String magicRealm = Tables.getMagicRealmsDescripTable()[getMAGICAL_DOMAIN().get(i)];
			sbDomain.append(magicRealm).append(" ");
		}
		
		StringBuffer sbGear = new StringBuffer();
		for (Map.Entry<Integer, Item> entry : this.getEquippedGear().entrySet()) {
			//String key = entry.getKey();
			Item item = entry.getValue();
			sbGear.append(item.toString()).append("\n");
		}
		
		String deadInfo = getDead() != null ? " (Dead)" : "";
		
		StringBuffer sb = new StringBuffer();
		sb.append("-------------------------------------------------------------------------------------------------")
			.append("\nName: \t\t\t").append(getName())
			.append("\nPlayer: \t\t").append(getPlayer())
			.append("\nRace/Culture: \t\t").append(getRace().getName()).append(" ").append(getRace().getCulture())
			.append("\nProfession: \t\t").append(getProfession().getName())
			.append("\nMagic Realm: \t\t").append(sbDomain.toString())
			
			.append("\n\nLevel: \t\t\t").append(getLevel())
			.append("\nPX: \t\t\t").append(getPX())
			.append("\nPP: \t\t\t").append(getPP())
			.append("\nLife:\t\t\t").append(life.getCurrentLife()).append("/").append(life.getTotalLife())
			.append(deadInfo)
			.append("\nBD:\t\t\t").append(getTotalBD())
			
			
			.append("\n\n---------------------------------------ATTRIBUTES---------------------------------------------------")
			.append("\n\n\t\t\tBase\tAttrib.\tRacial\t Total")
			.append("\nStrength: \t\t").append(str.getValue()).append("\t")
			.append(str.getModifAtt()).append("\t ").append(getRace().getModStrength()).append("\t ").append(str.getModifTotal())
			.append("\nAgility: \t\t").append(agi.getValue()).append("\t")
			.append(agi.getModifAtt()).append("\t ").append(getRace().getModAgility()).append("\t ").append(agi.getModifTotal())
			.append("\nConstitution: \t\t").append(cons.getValue()).append("\t")
			.append(cons.getModifAtt()).append("\t ").append(getRace().getModConstitution()).append("\t ").append(cons.getModifTotal())
			.append("\nIntelligence: \t\t").append(inte.getValue()).append("\t")
			.append(inte.getModifAtt()).append("\t ").append(getRace().getModIntelligence()).append("\t ").append(inte.getModifTotal())
			.append("\nIntuition: \t\t").append(intui.getValue()).append("\t")
			.append(intui.getModifAtt()).append("\t ").append(getRace().getModIntuition()).append("\t ").append(intui.getModifTotal());
			
			if(!Attribute.isCharismaBeneficiedByAppearance()){
				/*Por defecto*/
				sb.append("\nCharisma: \t\t").append(charis.getValue()).append("\t")
				.append(charis.getModifAtt()).append("\t ").append(getRace().getModCharisma()).append("\t ").append(charis.getModifTotal())
				.append("\n\n\t\t\tNormal\tCharis\t Total")
				.append("\nAppearance: \t\t").append(appea.getValue()).append("\t")
				.append(charis.getModifTotal()).append("\t ")
				.append(appea.getValue() + charis.getModifTotal());
			}else{
				/*Nueva*/
				sb.append("\n\nAppearance: \t\t").append(appea.getValue()).append("\t")
				.append(appea.getModifAtt()).append("\t ").append(" ").append("\t ").append(appea.getModifTotal())
				.append("\n\t\t\tBase\tAtt+App\tRacial\t Total")
				.append("\nCharisma: \t\t").append(charis.getValue()).append("\t")
				.append(charis.getModifAtt()).append("\t ").append(getRace().getModCharisma()).append("\t ").append(charis.getModifTotal());
			}
			
			
			sb.append("\n\n------------------------------CARRIED GEAR---------------------------------------------------")
			.append(sbGear)
			
			.append("\n\n------------------------------------------------------------------------------------------")
			.append("\n\t\t\tAttrib.\tObjects\tSpecial\t Total")
			.append("\nTR Essence: \t\t").append(essence.getBonusAttribute()).append("\t")
			.append(essence.getBonusObjects()).append("\t ").append(essence.getBonusSpecial()).append("\t ").append(essence.getBonusTotal())
			.append("\nRR Channeling: \t\t").append(channel.getBonusAttribute()).append("\t")
			.append(channel.getBonusObjects()).append("\t ").append(channel.getBonusSpecial()).append("\t ").append(channel.getBonusTotal())
			.append("\nRR Poison: \t\t").append(poison.getBonusAttribute()).append("\t")
			.append(poison.getBonusObjects()).append("\t ").append(poison.getBonusSpecial()).append("\t ").append(poison.getBonusTotal())
			.append("\nRR Disease: \t\t").append(disease.getBonusAttribute()).append("\t")
			.append(disease.getBonusObjects()).append("\t ").append(disease.getBonusSpecial()).append("\t ").append(disease.getBonusTotal())
			.append("\nRR Cold: \t\t").append(cold.getBonusAttribute()).append("\t")
			.append(cold.getBonusObjects()).append("\t ").append(cold.getBonusSpecial()).append("\t ").append(cold.getBonusTotal())
			.append("\nRR Fire: \t\t").append(fire.getBonusAttribute()).append("\t")
			.append(fire.getBonusObjects()).append("\t ").append(fire.getBonusSpecial()).append("\t ").append(fire.getBonusTotal())

			.append("\n\n------------------------------------------------------------------------------------------")
			.append("\n\nHabilidad.\t\tGrades\tBf.Grad\tBf.Att\tBf.Prof\tBf.Obj\tBf.Spec\tBf.Spec2\tBf.Activ\t Bf.Total")
			.append("\nMOVEMENT_MANEUVERS\n");
			
		
		int prevCategory = Skill.MOVEMENT_MANEUVERS;
		int newCategory = Skill.MOVEMENT_MANEUVERS;
		
		List<Integer> rangedSkills = new ArrayList<Integer>(skills.keySet());
		Collections.sort(rangedSkills);
		
		//for (Map.Entry<Integer, Skill> entry : skills.entrySet()) {
		for (int key : rangedSkills){
			//Skill sk = entry.getValue();
			Skill sk = skills.get(key);
			newCategory = sk.getCategory();
			
			if(newCategory >= Skill.SECONDARY )
				newCategory = Skill.SECONDARY; 
			
			if(newCategory != prevCategory){
				sb.append("\n------------------------------------------------------------------------------------------")
				  .append("\n").append(Tables.getSkillCategories()[newCategory]).append("\n");
			}

			int modifTotalSkill = sk.applyBonifActivityToTotal(this);

			
			sb.append("\n").append(Utils.padRight(sk.getDescription(), 20)).append("\t").append(sk.getGrades()).append("\t").append(sk.getModifGrades()).append("\t")
				.append(sk.getModifAttributes()).append("\t").append(sk.getModifClass()).append("\t").append(sk.getModifObjects()).append("\t")
				.append(sk.getModifSpecial()).append("\t").append(sk.getModifSpecial2()).append("\t\t").append(sk.getModifActivity())
				.append("\t\t ").append(modifTotalSkill);
		
			prevCategory = newCategory;
		}
		
		System.out.println(sb.toString());
		System.out.println("\n------------------------------------------------------------------------------------------"
				 + "\n------------------------------------------------------------------------------------------");
	}
	
	
	
	public CombatStatus getDead() {
		return dead;
	}


	public void setDead(CombatStatus dead) {
		this.dead = dead;
	}


	public void showCombatStatus() {
		
		Attribute str = getAttributes().get(Attribute.STRENTGTH);
		Attribute agi = getAttributes().get(Attribute.AGILITY);
		Attribute cons = getAttributes().get(Attribute.CONSTITUTION);
		Attribute inte = getAttributes().get(Attribute.INTELLIGENCE);
		Attribute intui = getAttributes().get(Attribute.INTUITION);
		Attribute charis = getAttributes().get(Attribute.CHARISMA);
		Attribute appea = getAttributes().get(Attribute.APPEARANCE);
		
		ResistanceRoll essence = getResistanceRolls().get(ResistanceRoll.ESSENCE);
		ResistanceRoll channel = getResistanceRolls().get(ResistanceRoll.CHANNELLING);
		ResistanceRoll poison = getResistanceRolls().get(ResistanceRoll.POISON);
		ResistanceRoll disease = getResistanceRolls().get(ResistanceRoll.DISEASE);
		ResistanceRoll cold = getResistanceRolls().get(ResistanceRoll.COLD);
		ResistanceRoll fire = getResistanceRolls().get(ResistanceRoll.FIRE);
	
		WeaponItem weapon = (WeaponItem) getEquippedGear().get(Item.WEAPON_1);
		String weaponName = (weapon.getName() == null ? weapon.getType() : weapon.getName());
		ArmourItem shield = (ArmourItem)getEquippedGear().get(Item.SHIELD);
		ArmourItem armour = (ArmourItem)getEquippedGear().get(Item.ARMOUR);
		ArmourItem helmet = (ArmourItem)getEquippedGear().get(Item.HELMET);
		ArmourItem bracers = (ArmourItem)getEquippedGear().get(Item.BRACERS);
		ArmourItem greaves = (ArmourItem)getEquippedGear().get(Item.GREAVES);
		
		int movSkillId = ArmourItem.getMovementSkillByArmour(armour.getType());
		Skill skill = getSkills().get(movSkillId);
		
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n/******************************************************************************************************"
				+ "\n*****************************************************************************************************/\n")
		.append("\nName: \t\t\t").append(getName())
		.append("\t\tPlayer: \t\t").append(getPlayer())
		.append("\nRace/Culture: \t\t").append(getRace().getName()).append(" ").append(getRace().getCulture())
		.append("\t\tProfession: \t\t").append(getProfession().getName());
		
		StringBuffer sbDomain = new StringBuffer();
		for(int i=0 ; i<getMAGICAL_DOMAIN().size();i++){
			String magicRealm = Tables.getMagicRealmsDescripTable()[getMAGICAL_DOMAIN().get(i)];
			sbDomain.append(magicRealm).append(" ");
		}
	
		
		String modifActividad = getActivity() == null ? "" : " ("+ getActivity().getActivityModif()+" Modif. Activity)";
		String activityInfo = getActivity() == null ? "" : "\nActivity Modif:\t\t"+
		getActivity().getActivityModif() + "\t\tType: "+CombatStatus.activityType(getActivity().getType());
		
		String assaultsActivity = "";
		if(getActivity() != null){
			if(getActivity().getAssaultsLeft() > 0){
				assaultsActivity = "\t\tAssaults Left: "+ getActivity().getAssaultsLeft();
			}
		}
		
		StringBuffer knockedOutInfo = getKnockedOut() != null ? 
				new StringBuffer("\n").append(this.name).append(" can't fight: ").append(CombatStatus.knockedOutType(getKnockedOut().getType())).append(".")
				: new StringBuffer("");
				
		if(getKnockedOut() != null && getKnockedOut().getType() == CombatStatus.KNOCKED_OUT_ASSAULTS){
			knockedOutInfo.append(" ").append(getKnockedOut().getAssaultsLeft()).append(" assaults left.");
		}
		
		StringBuffer stunInfo = null;
		if(getStunned() != null){
			stunInfo = new StringBuffer("\n").append(this.name).append(" is STUNNED (can't attack and 50% parriyng):")
			.append("\t").append(getStunned().getAssaultsLeft()).append(" assaults left.");
		}
		
		String deadInfo = getDead() != null && getDead().getAssaultsLeft() == 0 ? "\nATTENTION: DEAD CHARACTER" : "";
		String assaultsToDieInfo = "";
		if(getDead() != null && getDead().getAssaultsLeft() > 0){
			assaultsToDieInfo = "\nATTENTION!! Assaults to die: "+getDead().getAssaultsLeft();
		}
		
		sb.append("\nMagic Realm: \t\t").append(sbDomain.toString())
		
		.append("\n\nLevel: \t\t\t").append(getLevel())
		.append("\nPX: \t\t\t").append(getPX())
		.append("\nPP: \t\t\t").append(getPP())
		
		.append("\n\n..............COMBAT..............")
		.append("\nLife:\t\t\t").append(life.getCurrentLife()).append("/").append(life.getTotalLife())
		.append(knockedOutInfo)
		.append(stunInfo)
		.append(deadInfo).append(assaultsToDieInfo)
		.append(activityInfo).append(assaultsActivity)
		.append("\nBD:\t\t\t").append(getTotalBD()).append("\t\tBD no Shield:\t").append(getTotalNoShield())
		.append("\nMovement:\t\t").append(skill.getModifTotal() + (getActivity() != null? getActivity().getActivityModif() : 0)).append(modifActividad)
		
		.append("\n\n..............GEAR..............")
		.append("\nWeapon: ").append(weaponName).append(" ").append("\tBO: ")
		.append(weapon == null ? "" : weapon.getBO() + (getActivity() != null? getActivity().getActivityModif() : 0)).append(modifActividad)
		.append("\nArmour: ").append(armour == null ? "NO" : armour.getType())
		.append("\nShield(10-25 BD): ").append(shield == null ? "NO" : shield.getType())
		.append("\nHelmet(-5 Perc): ").append(helmet == null ? "NO" : helmet.getType())
		.append("\nBracers(-5 BO): ").append(bracers == null ? "NO" : bracers.getType())
		.append("\nGreaves(-5 MM): ").append(greaves == null ? "NO" : greaves.getType())
		
		.append("\n\n.............ATTR............")
		.append("\n\t\t\tBase\tAttrib.\tRacial\t Total")
		.append("\nStrength: \t\t").append(str.getValue()).append("\t")
		.append(str.getModifAtt()).append("\t ").append(getRace().getModStrength()).append("\t ").append(str.getModifTotal())
		.append("\nAgility: \t\t").append(agi.getValue()).append("\t")
		.append(agi.getModifAtt()).append("\t ").append(getRace().getModAgility()).append("\t ").append(agi.getModifTotal())
		.append("\nConstitution: \t\t").append(cons.getValue()).append("\t")
		.append(cons.getModifAtt()).append("\t ").append(getRace().getModConstitution()).append("\t ").append(cons.getModifTotal())
		.append("\nIntelligence: \t\t").append(inte.getValue()).append("\t")
		.append(inte.getModifAtt()).append("\t ").append(getRace().getModIntelligence()).append("\t ").append(inte.getModifTotal())
		.append("\nIntuition: \t\t").append(intui.getValue()).append("\t")
		.append(intui.getModifAtt()).append("\t ").append(getRace().getModIntuition()).append("\t ").append(intui.getModifTotal());
		
		if(!Attribute.isCharismaBeneficiedByAppearance()){
			/*Por defecto*/
			sb.append("\nCharisma: \t\t").append(charis.getValue()).append("\t")
			.append(charis.getModifAtt()).append("\t ").append(getRace().getModCharisma()).append("\t ").append(charis.getModifTotal())
			.append("\n\t\t\tNormal\tCharis\t Total")
			.append("\nAppearance: \t\t").append(appea.getValue()).append("\t")
			.append(charis.getModifTotal()).append("\t ")
			.append(appea.getValue() + charis.getModifTotal());
		}else{
			/*Nueva*/
			sb.append("\nAppearance: \t\t").append(appea.getValue()).append("\t")
			.append(appea.getModifAtt()).append("\t ").append(" ").append("\t ").append(appea.getModifTotal())
			.append("\n\t\t\tBase\tAtt+App\tRacial\t Total")
			.append("\nCharisma: \t\t").append(charis.getValue()).append("\t")
			.append(charis.getModifAtt()).append("\t ").append(getRace().getModCharisma()).append("\t ").append(charis.getModifTotal());
		}
		
		sb.append("\n\n......................TR............................")
		.append("\n\t\t\tAttrib.\tObjects\tSpecial\t Total")
		.append("\nTR Essence: \t\t").append(essence.getBonusAttribute()).append("\t")
		.append(essence.getBonusObjects()).append("\t ").append(essence.getBonusSpecial()).append("\t ").append(essence.getBonusTotal())
		.append("\nRR Channeling: \t\t").append(channel.getBonusAttribute()).append("\t")
		.append(channel.getBonusObjects()).append("\t ").append(channel.getBonusSpecial()).append("\t ").append(channel.getBonusTotal())
		.append("\nRR Poison: \t\t").append(poison.getBonusAttribute()).append("\t")
		.append(poison.getBonusObjects()).append("\t ").append(poison.getBonusSpecial()).append("\t ").append(poison.getBonusTotal())
		.append("\nRR Disease: \t\t").append(disease.getBonusAttribute()).append("\t")
		.append(disease.getBonusObjects()).append("\t ").append(disease.getBonusSpecial()).append("\t ").append(disease.getBonusTotal())
		.append("\nRR Cold: \t\t").append(cold.getBonusAttribute()).append("\t")
		.append(cold.getBonusObjects()).append("\t ").append(cold.getBonusSpecial()).append("\t ").append(cold.getBonusTotal())
		.append("\nRR Fire: \t\t").append(fire.getBonusAttribute()).append("\t")
		.append(fire.getBonusObjects()).append("\t ").append(fire.getBonusSpecial()).append("\t ").append(fire.getBonusTotal());
		
		sb.append("\n\n/******************************************************************************************************"
				+ "\n*****************************************************************************************************/\n");
		
		System.out.println(sb.toString());
	}

	/*Decrementar en uno los contadores de asalto. Si llegan a cero despenalizar*/
	public void assaultDecrement(){
		
		if(getStunned() != null){
			getStunned().setAssaultsLeft(getStunned().getAssaultsLeft() - 1);
			System.out.println(name+" is Stunned for "+getStunned().getAssaultsLeft()+ " assaults.");
			if(getStunned().getAssaultsLeft()==0){
				System.out.println(name+" is not Stunned anymore.");
				setStunned(null);
			}
		}
		
		if(getKnockedOut() != null){
			if(getKnockedOut().getType() == 1){
				getKnockedOut().setAssaultsLeft(getKnockedOut().getAssaultsLeft() - 1);
				System.out.println(name+" is Knocked Out for "+getKnockedOut().getAssaultsLeft()+ " assaults.");
				if(getKnockedOut().getAssaultsLeft()==0){
					System.out.println(name+" is able to fight again.");
					setKnockedOut(null);
				}
			}
		}
		
		if(getActivity()!=null){
			if(getActivity().getType() == 1){
				getActivity().setAssaultsLeft(getActivity().getAssaultsLeft() - 1);
				System.out.println(name+"'s Activity Modificator lasts for "+getActivity().getAssaultsLeft()+ " assaults.");
				
				if(getActivity().getAssaultsLeft() == 0){
					System.out.println(name+ "'s Activity Modificator stops having an effect.");
					setActivity(null);
				}
			}
		}
		if(getDead() != null && getDead().getAssaultsLeft() > 0){
			getDead().setAssaultsLeft(getDead().getAssaultsLeft() - 1);

			if(getDead().getAssaultsLeft() == 0){
				System.out.println(
						"\n..............................................................................."
						+ "\n: ATTENTION: "+this.name + " has dead as consequence of assaults to dead got to zero :"
						+ "\n···············································································");
				death();
			}
		}
		
	}


	public void lifePointsLost(int lifePointsCaused) {
		
		if(life.getCurrentLife()>=0 && (life.getCurrentLife() - lifePointsCaused)<0){
			//Entra en inconsciencia y quedan 6 asaltos para muerte
			fallUnconscious(CombatStatus.KNOCKED_OUT_LIFE_BELOW_ZERO);
		}
			
		life.setCurrentLife(life.getCurrentLife() - lifePointsCaused);
		System.out.println("Vida actual: "+life.getCurrentLife());
		
	}


	public void fallUnconscious(int knockedOutType) {
		
		if(knockedOutType == CombatStatus.KNOCKED_OUT_LIFE_BELOW_ZERO){
			CombatStatus knocked = new CombatStatus("KnockedOut Life-below-zero",CombatStatus.KNOCKED_OUT_LIFE_BELOW_ZERO); 
			knocked.setType(CombatStatus.KNOCKED_OUT_LIFE_BELOW_ZERO);
			setKnockedOut(knocked);
			
			CombatStatus dead = new CombatStatus("Dead", 0);
			dead.setAssaultsLeft(CombatStatus.ASSAULTS_TO_DIE);
			setDead(dead);
			System.out.println(getName()+" ha caido inconsciente debido a la acumulación "
					+ "de heridas sufridas.");
		}
		
	}




	public void death() {
		if(getLife().getCurrentLife() >=0){
			getLife().setCurrentLife(-1);
		}
		
		//if(getDead() != null && getDead().getAssaultsLeft() > 0)
		//	getDead().setAssaultsLeft(0);
		
		if(getKnockedOut() != null){
			setKnockedOut(null);
		}
		
		
		dead = new CombatStatus("Dead", 0);
	}



	
	
	/*Recorre el equipo en uso y obtiene y suman los bonos a habilidades de los objetos equipados*/
	/*public Map<Integer, Integer> calculSkillObjectMods(Map<String, Item> inUseGear){
		
		Map<Integer, Integer> totalGearSkillMods = new HashMap<Integer, Integer>();
		int mm = 0;
		
		int[] sumSkillMods = new int[Skill.SKILLS_TOTAL_NUMBER];
		
		for (Map.Entry<String, Item> entry : inUseGear.entrySet()) {
			//for itera over skill table
			//String key = entry.getKey();
			Item item = entry.getValue();
			
			for(int skill = 0; skill < Skill.SKILLS_TOTAL_NUMBER; skill++){
				sumSkillMods[skill] = sumSkillMods[skill] + item.getSkillMods()[skill];
			}
			
		}
		
		for(int skill = 0 ; skill < Skill.SKILLS_TOTAL_NUMBER ; skill++){
			totalGearSkillMods.put(skill, sumSkillMods[skill]);
		}
		
		
		return totalGearSkillMods;

	}*/
	
	
}
