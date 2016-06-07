package beans;

import java.util.Map;

public class Skill {
	
	//CATEGORIAS DE HABILIDADES
	public static final int MOVEMENT_MANEUVERS = 0;//Movimiento y maniobras
	public static final int WEAPON = 1;//ARMAS
	public static final int GENERAL = 2;//GENERALES
	public static final int SUBTERFUGE = 3;//SUBTERFUGIO
	public static final int MAGIC = 4;//MAGICA
	public static final int OTHERS = 5;//OTHER
	public static final int SECONDARY = 6;//SECUNDARIAS
	public static final int SECONDARY_ART = 7;//SECUNDARIAS ARTE
	public static final int SECONDARY_ATL = 8;//SECUNDARIAS ATLETICAS
	public static final int SECONDARY_WRK = 9;//SECUNDARIAS TRABAJO
	public static final int SECONDARY_INFL = 10;//SECUNDARIAS INFLUENCIA
	public static final int SECONDARY_KNOW = 11;//SECUNDARIAS CONOCIMIENTO
	public static final int SECONDARY_MART_ART = 12;//SECUNDARIAS ARTES MARCIALES
	
	//MM SKILLS
	public static final int NO_ARMOR = 0;//Sin armadura
	public static final int SOFT_LEATHER = 1;//Cuero
	public static final int RIGID_LEATHER = 2;//Cuero Endurecido
	public static final int CHAIN = 3;//Cota de Malla
	public static final int PLATE = 4;//Coraza
	
	//WEAPON SKILLS
	public static final int EDGED = 5;//Filo
	public static final int CONCUSSION = 6;//Contundentes
	public static final int TWO_HANDED = 7;//A dos manos
	public static final int THROWN = 8;//Arrojadizas
	public static final int PROJECTILE = 9;//Proyectil (Arcos)
	public static final int POLEARM = 10;//De asta
	
	//GENERAL SKILLS
	public static final int CLIMB = 11;//Trepar
	public static final int RIDE = 12;//Montar
	public static final int SWIM = 13;//Nadar
	public static final int TRACK = 14;//Rastrear
	
	//SUBTERFUGE SKILLS
	public static final int AMBUSH = 15;//Emboscar
	public static final int STALK_HIDE = 16;//Acechar/Esconder
	public static final int PICK_LOCK = 17;//Abrir Cerraduras
	public static final int DISARM_TRAP = 18;//Desactivar Trampas
	
	//MAGICAL SKILLS
	public static final int READ_RUNES = 19;//Leer Runas
	public static final int USE_MAG_ITEM = 20;//Usar Objeto Magicos
	public static final int DIRECTED_SPELLS = 21;//Usar Objeto Magicos
	public static final int BASE_SPELL = 22;//BO Base de Sortilegios
	
	//OTHER SKILLS
	public static final int BODY_DEVELOPMENT = 23;//Desarrollo Fisico
	public static final int PERCEPTION = 24;//Percepcion
	public static final int BD = 25;//Bonificacion Defensiva
	
	//SECONDARY SKILLS
	public static final int INFLUENCE_LEADERSHIP = 26;//Percepcion
	public static final int ACROBACIES = 27;//Acrobacias
	public static final int IMPERSONATE = 28;//Suplantar identidad
	public static final int ANIMAL_HANDLING = 29;//Trato con Animales
	public static final int APPRAISE  = 30;//Evaluar/Tasar
	public static final int NAVIGATION = 31;//Navegacion
	public static final int CAVE_KNOWL = 32;//Conocimiento de las Cuevas
	public static final int SKY_KNOWL = 33;//Conocimiento de los Cielos
	public static final int ESS_KNOWL = 34;//Conocimiento de la Esencia
	public static final int CHAN_KNOWL = 35;//Conocimiento de la Canalizacion
	public static final int CONTORT = 36;//Conotorsionismo
	public static final int COOK = 37;//Cocinar
	public static final int FIRST_AID = 38;//Primeros Auxilios
	public static final int SURVIVAL = 39;//Supervivencia, Forrajear
	public static final int GAMBLING = 40;//Apostar, Juegos de Azar
	public static final int MEDITATION = 41;//Meditación
	public static final int ROPES = 42;//Cordeleria, Nudos
	public static final int SIGNS = 43;//Señales, Lenguaje de Signos
	public static final int TRICK = 44;//Maña, Trucos, Embaucar, Juegos de Manos
	public static final int SHAPE_SHIFT = 45;//Cambio de Forma (no va con ninguna atributo)

	public static final int SKILLS_TOTAL_NUMBER = 46;


	/*Modificadores especiales de una Skill(Indices de una tabla de dos columnas)*/
	public static final int SPECIAL1 = 0;
	public static final int SPECIAL2 = 1;
	
	private int id;
	private int name;
	private String description;
	private int category;
	private int grades;
	private int modifGrades;
	private int modifAttributes;
	private int modifClass;
	private int modifObjects;
	private int modifSpecial;
	private int modifSpecial2;
	private int modifTotal;
	
	/*RULES*/
	private static boolean ruleHideUsingAGI = false;
	private static boolean ruleTrackerImproved = true;
	
	public Skill(int name, int grades){
		this.name = name;
		this.description = Tables.getSkillCategoryTable()[name][0];
		this.category = Integer.parseInt(Tables.getSkillCategoryTable()[name][1]);
		this.grades = grades;

	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getGrades() {
		return grades;
	}
	public void setGrades(int grades) {
		this.grades = grades;
	}

	public int getModifGrades() {
		return modifGrades;
	}

	public void setModifGrades(int modifGrades) {
		this.modifGrades = modifGrades;
	}

	public int getModifAttributes() {
		return modifAttributes;
	}

	public void setModifAttributes(int modifAttributes) {
		this.modifAttributes = modifAttributes;
	}

	public int getModifClass() {
		return modifClass;
	}

	public void setModifClass(int modifClass) {
		this.modifClass = modifClass;
	}

	public int getModifObjects() {
		return modifObjects;
	}

	public void setModifObjects(int modifObjects) {
		this.modifObjects = modifObjects;
	}

	public int getModifSpecial() {
		return modifSpecial;
	}

	public void setModifSpecial(int modifSpecial) {
		this.modifSpecial = modifSpecial;
	}

	public int getModifSpecial2() {
		return modifSpecial2;
	}

	public void setModifSpecial2(int modifSpecial2) {
		this.modifSpecial2 = modifSpecial2;
	}

	public int getModifTotal() {
		return modifTotal;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	/** Calcula el Modificador por Grados en base a los grados invertidos*/
	public void calculProfessionModifier(String profession,int nivel){

		/*BASICAS*/
		if(profession.equalsIgnoreCase(Profession.ANIMIST)){
			if(this.name == READ_RUNES || this.name == USE_MAG_ITEM || this.category == GENERAL
					|| this.name == PERCEPTION){
				this.modifClass = 1 * nivel;
			}else if(this.name == DIRECTED_SPELLS || this.name == BASE_SPELL){
				this.modifClass = 2 * nivel;
			}
		}else if(profession.equalsIgnoreCase(Profession.BARD)){
			if(this.category == WEAPON || this.category == GENERAL || this.category == SUBTERFUGE 
					|| this.category == MAGIC || this.name == BASE_SPELL || this.name == PERCEPTION){
				this.modifClass = 1 * nivel;
			}
		}else if(profession.equalsIgnoreCase(Profession.MAGICIAN)){
			if(this.name == READ_RUNES || this.name == USE_MAG_ITEM  || this.name == BASE_SPELL){
				this.modifClass = 2 * nivel;
			}else if(this.name == DIRECTED_SPELLS){
				this.modifClass = 3 * nivel;
			}
		}else if(profession.equalsIgnoreCase(Profession.RANGER)){//MONTARAZ
			if(this.category == WEAPON  || this.name == PERCEPTION || this.name == STALK_HIDE){
				this.modifClass = 2 * nivel;
			}else if(this.category == GENERAL){
				this.modifClass = 3 * nivel;
			}
		}else if(profession.equalsIgnoreCase(Profession.SCOUT)){//EXPLORADOR/ESPIA/ARQUERO
			if(this.category == WEAPON || this.category == GENERAL){
				this.modifClass = 1 * nivel;
			}else if(this.category == SUBTERFUGE){
				this.modifClass = 2 * nivel;
			}else if(this.name == PERCEPTION){
				this.modifClass = 3 * nivel;
			}
		}else if(profession.equalsIgnoreCase(Profession.WARRIOR)){
			if(this.category == GENERAL){
				this.modifClass = 1 * nivel;
			}else if(this.name == BODY_DEVELOPMENT){
				this.modifClass = 2 * nivel;
			}else if(this.category == WEAPON){
				this.modifClass = 3 * nivel;
			}
			
		/************NUEVAS***********/
			
		}else if(profession.equalsIgnoreCase(Profession.BARBARIAN)){
			if(this.name == BODY_DEVELOPMENT || this.category == WEAPON){
				this.modifClass = 2 * nivel;
			}else if(this.category == GENERAL){
				this.modifClass = 3 * nivel;
			}
		}else if(profession.equalsIgnoreCase(Profession.ROGUE)){//BRIBON
			if(this.category == WEAPON || this.category == GENERAL || this.category == SUBTERFUGE){
				this.modifClass = 2 * nivel;
			}
		}else if(profession.equalsIgnoreCase(Profession.CONJURER)){
			if(this.category == MAGIC || this.category == SUBTERFUGE || this.name == BASE_SPELL
					|| this.name == PERCEPTION){
				this.modifClass = 1 * nivel;
			}
		}else if(profession.equalsIgnoreCase(Profession.SCHOLAR)){
			if(this.category == SECONDARY || this.category == SECONDARY_ART
					|| this.category == SECONDARY_ATL || this.category == SECONDARY_INFL
					|| this.category == SECONDARY_WRK){
				this.modifClass = 1 * nivel;
			}
			if(this.name == PERCEPTION){
				this.modifClass = 2 * nivel;
			}
			if(this.category == SECONDARY_KNOW){
				this.modifClass = 4 * nivel;
			}
		}else if(profession.equalsIgnoreCase(Profession.WIZARD)){
			if(this.category == MAGIC || this.name == BASE_SPELL){
				this.modifClass = 2 * nivel;
			}
		}else if(profession.equalsIgnoreCase(Profession.BURGLAR)){ //CAZATESOROS
			if(this.category == GENERAL){
				this.modifClass = 1 * nivel;
			}
			if(this.category == SUBTERFUGE || this.name == PERCEPTION){
				this.modifClass = 3 * nivel;
			}
		}else if(profession.equalsIgnoreCase(Profession.MONK)){
			if(this.category == GENERAL || this.category == SUBTERFUGE
					|| this.category == MAGIC || this.name == PERCEPTION){
				this.modifClass = 1 * nivel;
			}else if(this.category == SECONDARY_MART_ART){
				this.modifClass = 2 * nivel;
			}
		}else if(profession.equalsIgnoreCase(Profession.WARRIORMONK)){
			if(this.category == GENERAL){
				this.modifClass = 1 * nivel;
			}else if(this.name == BODY_DEVELOPMENT){
				this.modifClass = 2 * nivel;
			}else if(this.category == SECONDARY_MART_ART){
				this.modifClass = 3 * nivel;
			}
		} else if(profession.equalsIgnoreCase(Profession.SHAPESHIFTER)){ //CAMBIAFORMAS
			if(this.category == MOVEMENT_MANEUVERS){
				this.modifClass = 1 * nivel;
			}else if(this.category == SECONDARY_MART_ART || this.name == BODY_DEVELOPMENT){
				this.modifClass = 2 * nivel;
			}else if(this.name == SHAPE_SHIFT){
				this.modifClass = 5 * nivel;
			}
		} else if(profession.equalsIgnoreCase(Profession.TRACKER)){ //RASTREADOR
			/*Segun la version, se mejora el Tracker*/
		
			if(!ruleTrackerImproved){
				if(this.category == SUBTERFUGE || this.name == PERCEPTION){
					this.modifClass = 2 * nivel;
				}
			}else{
				if(this.category == WEAPON){
					this.modifClass = 1 * nivel;
				}
				if(this.category == SUBTERFUGE || this.name == PERCEPTION){
					this.modifClass = 1 * nivel;
				}
				if(this.name == BODY_DEVELOPMENT){
					this.modifClass = 1 * nivel;
				}
			}
			
			if(this.category == GENERAL){
				this.modifClass = 3 * nivel;
			}
			
		}else if(profession.equalsIgnoreCase(Profession.SHAMAN)){
			if(this.category == GENERAL || this.category == SUBTERFUGE || this.name == PERCEPTION){
				this.modifClass = 1 * nivel;
			}else if(this.category == MAGIC){
				this.modifClass = 3 * nivel;
			}
		}
	}
	
	/** Calcula el Modificador por Grados en base a los grados invertidos*/
	public void calculGradesModifier(int gradesLife){

		if(this.name == BODY_DEVELOPMENT){
			this.modifGrades = gradesLife;
		}else{
		
			if(this.name != INFLUENCE_LEADERSHIP
					&& this.name != BASE_SPELL && this.name != BD){
				if(this.grades == 0){
					this.modifGrades = -25;
				}
				if(this.name == AMBUSH && this.grades > 0){
					this.modifGrades = this.grades;
				}else{
					if(this.grades > 0 && this.grades <= 10){
						this.modifGrades = this.grades * 5;
					}else if(this.grades > 10){
						int ten_grades = 10;
						this.modifGrades = this.modifGrades + (ten_grades * 5);
						this.modifGrades = this.modifGrades + (grades - ten_grades) * 2;
					}
				}
			}
		}
	}
	
	/** Calcula el Modificador por Atributo segun que habilidad seas*/
	public void calculAttribModifier(Map<String, Attribute> attributes, Race race){
		
		/*STRENGTH SKILLS*/
		if(this.name == CHAIN || this.name == PLATE || this.name == EDGED
				|| this.name == CONCUSSION || this.name == TWO_HANDED || this.name == POLEARM){
			this.modifAttributes = attributes.get(Attribute.STRENTGTH).getModifAtt() + race.getModStrength();
		}
		
		/*AGILIY SKILLS*/
		if(this.name == NO_ARMOR || this.name == SOFT_LEATHER || this.name == RIGID_LEATHER
				|| this.name == THROWN || this.name == PROJECTILE || this.name == CLIMB
				|| this.name == SWIM || this.name == DIRECTED_SPELLS || this.name == ACROBACIES
				|| this.name == CONTORT || this.name == BD
				|| this.category == SECONDARY_ATL || this.category == SECONDARY_WRK){
			this.modifAttributes = attributes.get(Attribute.AGILITY).getModifAtt() + race.getModAgility();
		}
		
		/*CONSTITUTION SKILLS*/
		if(this.name == BODY_DEVELOPMENT){
			this.modifAttributes = attributes.get(Attribute.CONSTITUTION).getModifAtt() + race.getModConstitution();
		}
		
		/*INTELLIGENCE SKILLS*/
		if(this.name == TRACK || this.name == PICK_LOCK || this.name == READ_RUNES
				|| this.name == APPRAISE || this.name == CAVE_KNOWL ||  this.name == ESS_KNOWL 
				|| this.name == CHAN_KNOWL || this.name == ROPES || this.name == SIGNS
				|| this.name == FIRST_AID
				|| this.category == SECONDARY_KNOW){
			this.modifAttributes = attributes.get(Attribute.INTELLIGENCE).getModifAtt() + race.getModIntelligence();
		}
		
		/*INTUITION SKILLS*/
		if(this.name == RIDE || this.name == DISARM_TRAP || this.name == USE_MAG_ITEM
				|| this.name == PERCEPTION || this.name == NAVIGATION || this.name == COOK
				|| this.name == SURVIVAL || this.name == GAMBLING || this.name == SKY_KNOWL
				|| this.category == SECONDARY_ART){
			this.modifAttributes = attributes.get(Attribute.INTUITION).getModifAtt() + race.getModIntuition();
		}
		
		/*CHARISMA SKILLS*/
		if(this.name == INFLUENCE_LEADERSHIP || this.name == IMPERSONATE || this.name == ANIMAL_HANDLING
				|| this.name == MEDITATION || this.name == TRICK ||
				this.category == SECONDARY_INFL){
			this.modifAttributes = attributes.get(Attribute.CHARISMA).getModifAtt() + race.getModCharisma();
		}

		if(ruleHideUsingAGI && this.name == STALK_HIDE){
			this.modifAttributes = attributes.get(Attribute.AGILITY).getModifAtt() + race.getModAgility();
		}else if(!ruleHideUsingAGI && this.name == STALK_HIDE){
			this.modifAttributes = attributes.get(Attribute.CHARISMA).getModifAtt() + race.getModCharisma();
		}

	}
	
	
	/*Recorre el equipo en uso y obtiene y suman los bonos a habilidades de los objetos equipados*/
	public void calculSkillObjectMods(Map<Integer, Item> inUseGear){

		int sumModifObjects = 0;
		
		//iterate over In Use Gear
		for (Map.Entry<Integer, Item> entry : inUseGear.entrySet()) {
			//String key = entry.getKey();
			Item item = entry.getValue();
			
			//Si el item es un Arma , Aumentamos Sus Bonos al bono por objetos
			if(item instanceof WeaponItem){
				WeaponItem wi = (WeaponItem)item;
				//Si la categoria del arma coincide con la Skill evaluada en curso
				/**No está terminado, hay que darle una vuelta más a esto*/
				if(wi.getCategory() == this.name){
					if(wi.getTypeMod1()!=0 && wi.getTypeMod1AppliedTo() == null){
						//Here, it's added any weapon type modifier to the particular Skill
						
						//AppliedtoNull means to any  race, armor, situation, ... in particular, so it's for ALL Situations
						//it is calculated here because it's the default situation (otherwise it'd be in the Combat Class)
						sumModifObjects = sumModifObjects + wi.getTypeMod1();
					}
					if(wi.getTypeMod2()!=0 && wi.getTypeMod2AppliedTo() == null){
						sumModifObjects = sumModifObjects + wi.getTypeMod2();
					}
					
					/**TODO  Calculate the TypeWeaponModifier in the Combat
					//because here you don't have any information related to the enemy armor*/
					
					/**TODO En Caso de algun modificador magico/especial de un arma aplicado
					 * a una raza o armadura especifica, de momento no esta hecho*/
				}
			}

			
			
			/*Si el item es un casco reducimos la PERCEPCION en 5*/
			/*if(this.name == PERCEPTION &&  item instanceof ArmourItem){
				ArmourItem ai = (ArmourItem)item;
				if(ai.getCategory() == Item.HELMET){
					sumModifObjects = sumModifObjects - 5;
				}
			}*/
			
			/*Si el item son grebas reducimos las MM en 5*/
			/*if(this.category == MOVEMENT_MANEUVERS &&  item instanceof ArmourItem){
				ArmourItem ai = (ArmourItem)item;
				if(ai.getCategory() == Item.GREAVES){
					sumModifObjects = sumModifObjects - 5;
				}
			}*/
			
			/*Si el item son brazales reducimos las Habilidades de Armas en 5*/
			/*if(this.category == WEAPON &&  item instanceof ArmourItem){
				ArmourItem ai = (ArmourItem)item;
				if(ai.getCategory() == Item.BRACERS){
					sumModifObjects = sumModifObjects - 5;
				}
			}*/
			
			/*Si el item es un escudo aumentamos la BD en 25*/
			/*if(this.category == BD &&  item instanceof ArmourItem){
				ArmourItem ai = (ArmourItem)item;
				if(ai.getCategory() == Item.SHIELD){
					sumModifObjects = sumModifObjects + ai.getSkillMods()[Skill.BD];
					
					if(ai.getBonusMagic1()> 0 && ai.getBonusMagic1AppliedTo() == null){
						sumModifObjects = sumModifObjects + ai.getBonusMagic1();
					}
					
					if(ai.getBonusMagic2()> 0 && ai.getBonusMagic2AppliedTo() == null){
						sumModifObjects = sumModifObjects + ai.getBonusMagic2();
					}
				}
			}*/
			
			if(item.getSkillMods()[this.name] != 0){
				sumModifObjects = sumModifObjects + item.getSkillMods()[this.name];
			}
			/*Bonificacion especial armaduras*/
			
		}
		
		this.modifObjects = sumModifObjects;

	}
	
	/*Recorre las skills y suma los bonos especiales (1 y 2)*/
	/* Desarrollo Fisico empieza con un Special de +5
	 * MM tiene bonos especiales segun que tipo de ARMADURA
	 * Otros motivos: Puntos de historial, hechizos activos, bonos de circustancia, bonus/malus de critico
	 * */
	public void calculSpecialModifiers(int[][] specialSkillModif){

		if(this.category == MOVEMENT_MANEUVERS){
			if(this.name == SOFT_LEATHER){
				modifSpecial2 = -15;
			}else if(this.name == RIGID_LEATHER){
				modifSpecial2 = -30;
			}else if(this.name == CHAIN){
				modifSpecial2 = -45;
			}else if(this.name == PLATE){
				modifSpecial2 = -60;
			}
		}else if(this.name == BODY_DEVELOPMENT){
			this.modifSpecial2 = 5;
		}
		
		this.modifSpecial = this.modifSpecial + specialSkillModif[this.name][SPECIAL1];
		this.modifSpecial2 = this.modifSpecial2 + specialSkillModif[this.name][SPECIAL2];
		

	}
	
	
	public static void changeRuleImproveTracker(boolean value){
		ruleTrackerImproved = value;
	}
	
	public static void changeRuleHideUsingAGI(){
		ruleHideUsingAGI = true;
	}


	
	/*Sum of every of the modifiers of this skill*/
	public void calculTotalModifiers() {
		modifTotal = modifGrades + modifAttributes + modifClass + modifObjects + modifSpecial + modifSpecial2;
		
	}
	
	
}
