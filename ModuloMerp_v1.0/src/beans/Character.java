package beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Character {
	/*Prueba de comentario porque yo lo quiero*/
	public int id;
	
	/*Principales*/
	public String name;
	public String player;
	public Race race;
	public Profession profession;//Guerrero, Explorador, Montaraz, Bardo, etc
	public int level;
	public int PX = 10000;//Experiencia. Se empieza con 10.000 px de inicio
	public int PP;//Puntos de poder
	
	public List<Integer> MAGICAL_DOMAIN = new ArrayList<Integer>();//CANALIZACION o ESENCIA
	
	/*Descripcion Personaje*/
	public int gender;//Hombre/Mujer
	public int age;
	public int height;//centimetros
	public int weight;//kilos
	public String hair;
	public String eyes;
	public String physicalLook;
	public String personality;
	public String motivation;
	public String alignment;//bueno, neutral, malo
	public List<String> special;//para poner cualquier cosa adicional
	public String origin;//Procedencia
	public String family;//Clan,familia
	public String religion;
	public String gods;
	
	//ATRIBUTOS
	/** Para equilibrar se podia aceptar como regla de la casa que para crear 
	 * un personaje nuevo lo minimo sean dos 90s o su equivalente(bono total por attrib de +20)*/
	Map<String, Attribute> attributes = new HashMap<String, Attribute>();
	
	//LENGUAJES
	List<Language> languages = new ArrayList<Language>();
	
	//CARGA
	public float loadlimit;
	public float load;
	
	/*COMBATE*/
	public int life;//vida total
	public int wounds;//heridas sufridas
	public int offguardBD;//sin contar el bono por agilidad
	public int totalBD;//BD con escudo
	public int totalNoShield;//BD sin escudo
	public int movSpeed;//Movimiento
	public int loadPenal;//PenalizadorCarga
	public int woundPenal;//PenalizadorHeridas
	public int meleAttack;//Puntuacion Ataque Principal Melee
	public int rangedAttack;//Puntuacion Ataque Principal a Distancia
	

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
	
	
	/*INVENTARIO*/
	List<Item> inventory = new ArrayList<Item>();
	
	/*EQUIPO EN USO*/
	Map<String, Item> equippedGear = new HashMap<String, Item>();
	
	/*GEAR SKILL MODS*/
	Map<Integer, Integer> totalGearSkillMods  = new HashMap<Integer, Integer>();
	
	/*SKILLS */
	int[] skillGrades = new int[Skill.SKILLS_TOTAL_NUMBER];
	Map<Integer, Skill> skills  = new HashMap<Integer, Skill>();
	
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
	Map<String, ResistanceRoll> resistanceRolls = new HashMap<String, ResistanceRoll>();
	
	public Character(String name, String player) {
		this.name = name;
		this.player = player;
	}

	
	public Character(String name, String player, int lvl, int PX, String raceIn, String cultureIn, String professionIn, Map<String, Item> equippedGear , int sTR, int aGI, int cON, int iNT, int i,
			int cAR, int aP, String magicalDomainChoosen,int[] skillGrades ,int[][] specialSkillModif){

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
		charis.setModifAtt(charis.getModifAtt() + appear.getModifAtt());
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
		this.skills = calculSkills(this.skillGrades,this.profession,this.level,this.attributes
				,equippedGear,specialSkillModif);
		
		/*Calcula Resistance Rolls*/
		this.setResistanceRolls(calculResistanceRolls(equippedGear));
		

	}
	
	private Map<Integer, Skill> calculSkills(int[] skillGrades2, Profession profession2, int level2,
			Map<String, Attribute> attributes2, Map<String, Item> equippedGear2,int[][] specialSkillModif2) {
		
		Map<Integer, Skill> skills = new HashMap<Integer, Skill>();
		
		for(int skillidx = 0; skillidx < Skill.SKILLS_TOTAL_NUMBER ; skillidx++){
			Skill skill = new Skill(skillidx,skillGrades2[skillidx]);
			skill.calculGradesModifier();
			skill.calculAttribModifier(attributes2);
			skill.calculProfessionModifier(profession2.getName(), level2);
			skill.calculSpecialModifiers(specialSkillModif2);
			skill.calculTotalModifiers();
			skills.put(skillidx, skill);
		}
		
		return skills;
	}

	/*Calcula las Tiradas de Resistancia de un personaje*/
	private Map<String, ResistanceRoll> calculResistanceRolls(Map<String, Item> equippedGear2) {
		
		Map<String, ResistanceRoll> rRolls = new  HashMap<String, ResistanceRoll>();
		
		ResistanceRoll essenceRR = new ResistanceRoll(ResistanceRoll.ESSENCE, race, equippedGear, attributes);
		ResistanceRoll chanRR = new ResistanceRoll(ResistanceRoll.CHANNELLING, race, equippedGear, attributes);
		ResistanceRoll poisonRR = new ResistanceRoll(ResistanceRoll.POISON, race, equippedGear, attributes);
		ResistanceRoll diseaseRR = new ResistanceRoll(ResistanceRoll.DISEASE, race, equippedGear, attributes);
		
		Map<String, Integer> totalGearResistances  = calculTotalGearResistances(equippedGear);
		
		essenceRR.calculTotalBonus(totalGearResistances);
		chanRR.calculTotalBonus(totalGearResistances);
		poisonRR.calculTotalBonus(totalGearResistances);
		diseaseRR.calculTotalBonus(totalGearResistances);
		
		rRolls.put(ResistanceRoll.ESSENCE, essenceRR);
		rRolls.put(ResistanceRoll.CHANNELLING, chanRR);
		rRolls.put(ResistanceRoll.POISON,poisonRR);
		rRolls.put(ResistanceRoll.DISEASE, diseaseRR);
		
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
			System.out.println("ATENCION: Este personaje tiene un bono por Atributos menor de 20. Se aconseja rehacer tiradas.");
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

	public int getLife() {
		return life;
	}

	public int getWounds() {
		return wounds;
	}

	public int getOffguardBD() {
		return offguardBD;
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

	public int getMeleAttack() {
		return meleAttack;
	}

	public int getRangedAttack() {
		return rangedAttack;
	}

	public Map<String, Item> getEquippedGear() {
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

	public void setLife(int life) {
		this.life = life;
	}

	public void setWounds(int wounds) {
		this.wounds = wounds;
	}

	public void setOffguardBD(int offguardBD) {
		this.offguardBD = offguardBD;
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

	public void setMeleAttack(int meleAttack) {
		this.meleAttack = meleAttack;
	}

	public void setRangedAttack(int rangedAttack) {
		this.rangedAttack = rangedAttack;
	}

	public static void setWEAPON1_USED(String wEAPON1_USED) {
		WEAPON1_USED = wEAPON1_USED;
	}

	public static void setWEAPON2_USED(String wEAPON2_USED) {
		WEAPON2_USED = wEAPON2_USED;
	}

	public static void setSHIELD_USED(String sHIELD_USED) {
		SHIELD_USED = sHIELD_USED;
	}

	public static void setGREAVES_USED(String gREAVES_USED) {
		GREAVES_USED = gREAVES_USED;
	}

	public static void setGLOVES_USED(String gLOVES_USED) {
		GLOVES_USED = gLOVES_USED;
	}

	public static void setHELMET_USED(String hELMET_USED) {
		HELMET_USED = hELMET_USED;
	}

	public static void setRING1_USED(String rING1_USED) {
		RING1_USED = rING1_USED;
	}

	public static void setRING2_USED(String rING2_USED) {
		RING2_USED = rING2_USED;
	}

	public static void setARMOR_USED(String aRMOR_USED) {
		ARMOR_USED = aRMOR_USED;
	}

	public static void setTALISMAN_USED(String tALISMAN_USED) {
		TALISMAN_USED = tALISMAN_USED;
	}


	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}

	public void setEquippedGear(Map<String, Item> equippedGear) {
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


	/*Recorre el equipo en uso y obtiene y suma el total de las resistencias de todos estos objetos*/
	public Map<String, Integer> calculTotalGearResistances(Map<String, Item> inUseGear){
		
		Map<String, Integer> totalGearResistances = new HashMap<String, Integer>();
		int essenceRes = 0;
		int channelRes = 0;
		int poisonRes = 0;
		int diseaseRes = 0;
		

		for (Map.Entry<String, Item> entry : inUseGear.entrySet()) {
			//String key = entry.getKey();
			Item item = entry.getValue();
			essenceRes = essenceRes + item.getModEssence();
			channelRes = channelRes + item.getModChanneling();
			poisonRes = poisonRes + item.getModPoison();
			diseaseRes = diseaseRes + item.getModDisease();
		}
		
		totalGearResistances.put(ResistanceRoll.ESSENCE, essenceRes);
		totalGearResistances.put(ResistanceRoll.CHANNELLING, channelRes);
		totalGearResistances.put(ResistanceRoll.POISON, poisonRes);
		totalGearResistances.put(ResistanceRoll.DISEASE, diseaseRes);
		
		return totalGearResistances;

	}

	public Map<Integer, Integer> getTotalGearSkillMods() {
		return totalGearSkillMods;
	}

	public void setSkills(Map<Integer, Skill> skills) {
		this.skills = skills;
	}
	
	public void addPx(int px){
		this.PX = this.PX + px;
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
		
		StringBuffer ssb = new StringBuffer();
		for(int i=0 ; i<getMAGICAL_DOMAIN().size();i++){
			String magicRealm = Tables.getMagicRealmsDescripTable()[getMAGICAL_DOMAIN().get(i)];
			ssb.append(magicRealm).append(" ");
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("Name: \t\t\t").append(getName())
			.append("\nPlayer: \t\t").append(getPlayer())
			.append("\nRace/Culture: \t\t").append(getRace().getName()).append(" ").append(getRace().getCulture())
			.append("\nProfession: \t\t").append(getProfession().getName())
			.append("\nMagic Realm: \t\t").append(ssb.toString())
			
			.append("\n\nLevel: \t\t\t").append(getLevel())
			.append("\nPX: \t\t\t").append(getPX())
			.append("\nPP: \t\t\t").append(getPP())
			
			.append("\n\nAttributes\t\tValue\tNormal\tRacial\t Total")
			.append("\nStrength: \t\t").append(str.getValue()).append("\t")
			.append(str.getModifAtt()).append("\t ").append(getRace().getModStrength()).append("\t ").append(str.getModifTotal())
			.append("\nAgility: \t\t").append(agi.getValue()).append("\t")
			.append(agi.getModifAtt()).append("\t ").append(getRace().getModAgility()).append("\t ").append(agi.getModifTotal())
			.append("\nConstitution: \t\t").append(cons.getValue()).append("\t")
			.append(cons.getModifAtt()).append("\t ").append(getRace().getModConstitution()).append("\t ").append(cons.getModifTotal())
			.append("\nIntelligence: \t\t").append(inte.getValue()).append("\t")
			.append(inte.getModifAtt()).append("\t ").append(getRace().getModIntelligence()).append("\t ").append(inte.getModifTotal())
			.append("\nIntuition: \t\t").append(intui.getValue()).append("\t")
			.append(intui.getModifAtt()).append("\t ").append(getRace().getModIntuition()).append("\t ").append(intui.getModifTotal())
			.append("\nCharisma: \t\t").append(charis.getValue()).append("\t")
			.append(charis.getModifAtt()).append("\t ").append(getRace().getModCharisma()).append("\t ").append(charis.getModifTotal())
			.append("\nAppearance: \t\t").append(appea.getValue()).append("\t")
			.append(appea.getModifAtt())
			
			.append("\n\n\t\t\tAttrib.\tObjects\tSpecial\t Total")
			.append("\nTR Essence: \t\t").append(essence.getBonusAttribute()).append("\t")
			.append(essence.getBonusObjects()).append("\t ").append(essence.getBonusSpecial()).append("\t ").append(essence.getBonusTotal())
			.append("\nRR Channeling: \t\t").append(channel.getBonusAttribute()).append("\t")
			.append(channel.getBonusObjects()).append("\t ").append(channel.getBonusSpecial()).append("\t ").append(channel.getBonusTotal())
			.append("\nRR Poison: \t\t").append(poison.getBonusAttribute()).append("\t")
			.append(poison.getBonusObjects()).append("\t ").append(poison.getBonusSpecial()).append("\t ").append(poison.getBonusTotal())
			.append("\nRR Disease: \t\t").append(disease.getBonusAttribute()).append("\t")
			.append(disease.getBonusObjects()).append("\t ").append(disease.getBonusSpecial()).append("\t ").append(disease.getBonusTotal())
			;
		
		System.out.println(sb.toString());
		
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
