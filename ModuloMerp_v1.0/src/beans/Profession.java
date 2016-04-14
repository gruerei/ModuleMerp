package beans;

public class Profession {
	
	/*BASICAS*/
	public static final String ANIMIST = "ANIMIST";//CLERIGO, SANADOR
	public static final String BARD = "BARD";
	public static final String MAGICIAN = "MAGICIAN";
	public static final String RANGER = "RANGER";//MONTARAZ
	public static final String SCOUT = "SCOUT";//EXPLORADOR/ESPIA (ARQUERO)
	public static final String WARRIOR = "WARRIOR";
	
	/*NUEVAS*/
	public static final String BARBARIAN = "BARBARIAN";
	public static final String ROGUE = "ROGUE";//BRIBON
	public static final String CONJURER = "CONJURER";
	public static final String SCHOLAR = "SCHOLAR";//ERUDITO
	public static final String WIZARD = "WIZARD";//HECHICERO
	public static final String BURGLAR = "BURGLAR";//LADRON/CAZATESOROS
	public static final String MONK = "MONK";
	public static final String WARRIORMONK = "WARRIORMONK";
	public static final String SHAPESHIFTER = "SHAPESHIFTER";//CAMBIAFORMAS
	public static final String TRACKER = "TRACKER";//RASTREADOR (MONTARAZ NO MAGICO)
	/*Equivalent to Rangers and have Stamina as a Prime Stat. They do not have access to Ranger
	spell lists, possessing only the magic-using abilities of Warriors. Like Rangers, they excel in outdoors skills.*/
	public static final String SHAMAN = "SHAMAN";//BRUJA (ANIMISTAS PRIMITIVOS)
	/* Primitive Animists and should be taken by primitive or barbarian cultures/races as a substitution for
	Animists. For evil cultures or races such as Orcs and Half Trolls, Shaman represents the only spell-casting
	profession. In this case, they may learn the base spell lists of Evil Mage, Evil Cleric or Sorcerer spell lists */
	
	public static final int MOVEMENT_MANEUVERS = 1;//Movimiento y maniobras
	public static final int WEAPONS = 2;//ARMAS
	public static final int GENERALS = 3;//GENERALES
	public static final int SUBTERFUGE = 4;//SUBTERFUGIO
	public static final int MAGICS = 5;//MAGICA
	public static final int SECONDARIES = 6;//SECUNDARIAS
	public static final int BODY_DEVELOPMENT = 7;//SECUNDARIAS
	


	private String name;
	/**Si se desea, se puede reemplazar la principal por 90 (si las tiradas no fueron buenas)*/
	private String mainAttribute;
	
	/*RULES*/
	private static boolean LimitMagicalClasses = false;
	private static boolean changeRuleScholarClass = false;
	@SuppressWarnings("unused")
	private static boolean changeRuleBardClass = false;
	
	
	public Profession(String profession, Character charac, String magicalDomainChoosen){
		createProfession(profession, charac, magicalDomainChoosen);
	}
	
	private void createProfession(String profession, Character cha, String magicalDomainChoosen){
		/*1º Determine magic realm by Profession/Class
		 *2º Determine Puntos de Poder
		 *3º Determine Main Attrib */

		this.name = profession;
		
		int intel = cha.getAttributes().get(Attribute.INTELLIGENCE).getValue();
		int intui = cha.getAttributes().get(Attribute.INTUITION).getValue();
		
		/** Con mis Reglas, para acceder a la lista de hechizos de Canalización hay que coger
		 * Conocimiento de la Canalización (bloqueada por defecto).
		 * Para acceder a la lista de hechizos de Esencia hay que coger
		 * Conocimiento de la Esencia (bloqueada por defecto).
		 **/
		
		/*BASICAS*/
		if(profession.equalsIgnoreCase(ANIMIST)){
			/** Con mis Reglas, para acceder a la lista de hechizos del Animista
			 *  tener Primeros Auxilios y Conocimiento de la Canalización (bloqueada por defecto)
			 **/
			cha.getMAGICAL_DOMAIN().add(SpellList.ANIMIST);
			cha.getMAGICAL_DOMAIN().add(SpellList.CHANNELING);
			cha.setPP(Utils.getPPbyAttrib(intui) * cha.getLevel());
			mainAttribute = Attribute.INTUITION;
			
			
		}else if(profession.equalsIgnoreCase(BARD)){
			/** Con mis Reglas, para acceder a la lista de hechizos del Bardo coger
			 * Cantar y Conocimiento de la Esencia (bloqueada por defecto)**/
			cha.getMAGICAL_DOMAIN().add(SpellList.BARD);
			cha.getMAGICAL_DOMAIN().add(SpellList.ESSENCE);
			cha.setPP(Utils.getPPbyAttrib(intel) * cha.getLevel());
			mainAttribute = Attribute.CHARISMA;
			
		}else if(profession.equalsIgnoreCase(MAGICIAN)){
			/** Con mis Reglas, para poder ser mago hay que ser antes Erudito y obtener
			 * Conocimiento de la Esencia (bloqueada por defecto). Para obtener conjuros
			 * de la lista de hechizos del mago te los tiene que enseñar un mago**/
			cha.getMAGICAL_DOMAIN().add(SpellList.MAGICIAN);
			cha.getMAGICAL_DOMAIN().add(SpellList.ESSENCE);
			cha.setPP(Utils.getPPbyAttrib(intel) * cha.getLevel());
			mainAttribute = Attribute.INTELLIGENCE;
			
		}else if(profession.equalsIgnoreCase(RANGER)){//MONTARAZ
			/** Con mis Reglas, para acceder a la lista de hechizos del Montaraz coger
			 * Forrajear y Conocimiento de la Canalización (bloqueada por defecto)**/
			cha.getMAGICAL_DOMAIN().add(SpellList.RANGER);
			cha.getMAGICAL_DOMAIN().add(SpellList.CHANNELING);
			cha.setPP(Utils.getPPbyAttrib(intui) * cha.getLevel());
			mainAttribute = Attribute.CONSTITUTION;
			
		}else if(profession.equalsIgnoreCase(SCOUT)){//EXPLORADOR/ESPIA/ARQUERO
			
			if(!LimitMagicalClasses)
			{
				if(magicalDomainChoosen.equalsIgnoreCase("CHANNELING")){
					cha.getMAGICAL_DOMAIN().add(SpellList.CHANNELING);
					cha.setPP(Utils.getPPbyAttrib(intui) * cha.getLevel());
				}else{
					cha.getMAGICAL_DOMAIN().add(SpellList.ESSENCE);
					cha.setPP(Utils.getPPbyAttrib(intel) * cha.getLevel());
				}
			}else
			{
				cha.setPP(0);
			}
			
			mainAttribute = Attribute.AGILITY;
			
		}else if(profession.equalsIgnoreCase(WARRIOR)){
			
			if(!LimitMagicalClasses)
			{
				if(magicalDomainChoosen.equalsIgnoreCase("CHANNELING"))
				{
					cha.getMAGICAL_DOMAIN().add(SpellList.CHANNELING);
					cha.setPP(Utils.getPPbyAttrib(intui) * cha.getLevel());
				}
				else{
					cha.getMAGICAL_DOMAIN().add(SpellList.ESSENCE);
					cha.setPP(Utils.getPPbyAttrib(intel) * cha.getLevel());
				}
			}else
			{
				cha.setPP(0);
			}
			mainAttribute = Attribute.STRENTGTH;
			
		/************NUEVAS***********/
			
		}else if(profession.equalsIgnoreCase(BARBARIAN)){
			
			//he is not able to learn any spell
			cha.setPP(0);
			mainAttribute = Attribute.STRENTGTH;
			
		}else if(profession.equalsIgnoreCase(ROGUE)){//BRIBON
			
			if(!LimitMagicalClasses)
			{
				if(magicalDomainChoosen.equalsIgnoreCase("CHANNELING")){
					cha.getMAGICAL_DOMAIN().add(SpellList.CHANNELING);
					cha.setPP(Utils.getPPbyAttrib(intui) * cha.getLevel());
				}else{
					cha.getMAGICAL_DOMAIN().add(SpellList.ESSENCE);
					cha.setPP(Utils.getPPbyAttrib(intel) * cha.getLevel());
				}
			}else
			{
				cha.setPP(0);
			}
			mainAttribute = Attribute.STRENTGTH;
			
		}else if(profession.equalsIgnoreCase(CONJURER)){
			/** Con mis Reglas, para poder ser conjurador hay que ser antes Erudito y obtener
			 * Conocimiento de la Esencia (bloqueada por defecto) y Conocimiento de la Canalización.**/
			//He learn spell for both Realms
			cha.getMAGICAL_DOMAIN().add(SpellList.CHANNELING);
			cha.getMAGICAL_DOMAIN().add(SpellList.ESSENCE);
			int avgPoints = Math.round((intel + intui) / 2);//Redondea hacia arriba
			cha.setPP(Utils.getPPbyAttrib(avgPoints) * cha.getLevel());
			mainAttribute = Attribute.INTELLIGENCE;
			/**TODO podria cambiarse a INTUICION*/
			
		}else if(profession.equalsIgnoreCase(SCHOLAR)){
			//By default, he is not able to learn any spell
			
			if(!changeRuleScholarClass)
				//Si la regla del Erudito no se cambia, no es clase magica
			{
				cha.setPP(0);
			}else{
				//Si la regla del Erudito se cambia, pasa a ser potencial clase magica
				//para ello la magia tiene que estar limitada
				if(LimitMagicalClasses){
					//if(magicalDomainChoosen.equalsIgnoreCase("ESSENCE")){
						cha.getMAGICAL_DOMAIN().add(SpellList.ESSENCE);
						cha.getMAGICAL_DOMAIN().add(SpellList.MAGICIAN);
						cha.setPP(Utils.getPPbyAttrib(intel) * cha.getLevel());
					//}
				}else{
					cha.setPP(0);
				}
			}
			mainAttribute = Attribute.INTELLIGENCE;

			
		}else if(profession.equalsIgnoreCase(WIZARD)){
			/** Con mis Reglas, para poder ser hechicero hay que ser antes Erudito y obtener
			 * Conocimiento de la Esencia (bloqueada por defecto) y Conocimiento de la Canalización.**/
			//He learnt spell for both Realms
			cha.getMAGICAL_DOMAIN().add(SpellList.CHANNELING);
			cha.getMAGICAL_DOMAIN().add(SpellList.ESSENCE);
			int avgPoints = Math.round((intel + intui) / 2);//Redondea hacia arriba
			cha.setPP(Utils.getPPbyAttrib(avgPoints) * cha.getLevel());
			mainAttribute = Attribute.INTELLIGENCE;
			/**TODO podria cambiarse a INTUICION*/
			
		}else if(profession.equalsIgnoreCase(BURGLAR)){ //CAZATESOROS
			
			if(!LimitMagicalClasses)
			{
				if(magicalDomainChoosen.equalsIgnoreCase("CHANNELING")){
					cha.getMAGICAL_DOMAIN().add(SpellList.CHANNELING);
					cha.setPP(Utils.getPPbyAttrib(intui) * cha.getLevel());
				}else{
					cha.getMAGICAL_DOMAIN().add(SpellList.ESSENCE);
					cha.setPP(Utils.getPPbyAttrib(intel) * cha.getLevel());
				}
			}else{
				cha.setPP(0);
			}
			mainAttribute = Attribute.AGILITY;
			
		}else if(profession.equalsIgnoreCase(MONK)){
			/** Con mis Reglas, para poder acceder a la Lista de hechizos hay que tener
			 * Conocimiento de la Esencia (bloqueada por defecto) y Conocimiento de la Canalización.**/
			
			//He learn spell for both Realms
			cha.getMAGICAL_DOMAIN().add(SpellList.CHANNELING);
			cha.getMAGICAL_DOMAIN().add(SpellList.ESSENCE);
			int avgPoints = Math.round((intel + intui) / 2);//Redondea hacia arriba
			cha.setPP(Utils.getPPbyAttrib(avgPoints) * cha.getLevel());
			mainAttribute = Attribute.AGILITY;
			
		}else if(profession.equalsIgnoreCase(WARRIORMONK)){
			
			if(!LimitMagicalClasses)
			{
				if(magicalDomainChoosen.equalsIgnoreCase("CHANNELING")){
					cha.getMAGICAL_DOMAIN().add(SpellList.CHANNELING);
					cha.setPP(Utils.getPPbyAttrib(intui) * cha.getLevel());
				}else{
					cha.getMAGICAL_DOMAIN().add(SpellList.ESSENCE);
					cha.setPP(Utils.getPPbyAttrib(intel) * cha.getLevel());
				}
			}else{
				cha.setPP(0);
			}
			mainAttribute = Attribute.STRENTGTH;
			
		} else if(profession.equalsIgnoreCase(SHAPESHIFTER)){ //CAMBIAFORMAS
			if(!LimitMagicalClasses)
			{
				if(magicalDomainChoosen.equalsIgnoreCase("CHANNELING")){
					cha.getMAGICAL_DOMAIN().add(SpellList.CHANNELING);
					cha.setPP(Utils.getPPbyAttrib(intui) * cha.getLevel());
				}else{
					cha.getMAGICAL_DOMAIN().add(SpellList.ESSENCE);
					cha.setPP(Utils.getPPbyAttrib(intel) * cha.getLevel());
				}
			}else{
				cha.setPP(0);
			}
			mainAttribute = Attribute.CHARISMA;
			
		} else if(profession.equalsIgnoreCase(TRACKER)){ //RASTREADOR
			
			if(!LimitMagicalClasses)
			{
				if(magicalDomainChoosen.equalsIgnoreCase("CHANNELING")){
					cha.getMAGICAL_DOMAIN().add(SpellList.CHANNELING);
					cha.setPP(Utils.getPPbyAttrib(intui) * cha.getLevel());
				}else{
					cha.getMAGICAL_DOMAIN().add(SpellList.ESSENCE);
					cha.setPP(Utils.getPPbyAttrib(intel) * cha.getLevel());
				}
			}else{
				cha.setPP(0);
			}
			mainAttribute = Attribute.CONSTITUTION;
			
		}else if(profession.equalsIgnoreCase(SHAMAN)){
			/** Con mis Reglas, para acceder a la lista de hechizos del Animista
			 *  tener Primeros Auxilios y Conocimiento de la Canalización (bloqueada por defecto)
			 **/
			cha.getMAGICAL_DOMAIN().add(SpellList.ANIMIST);
			cha.getMAGICAL_DOMAIN().add(SpellList.CHANNELING);
			cha.setPP(Utils.getPPbyAttrib(intui) * cha.getLevel());
			mainAttribute = Attribute.INTUITION;
			
		}
		
	}
	
	public static void changeRuleBardClass(){
		Tables.getCGT4()[Tables.MM_CGT4][Tables.BRD_CGT4] = Tables.getCGT4()[Tables.MM_CGT4][Tables.BRD_CGT4] + 1;
		Tables.getCGT4()[Tables.MGC_CGT4][Tables.BRD_CGT4] = Tables.getCGT4()[Tables.MGC_CGT4][Tables.BRD_CGT4] + 1;
		changeRuleBardClass = true;
		/** Regla de la casa para BARDOS, dejarles repartir 15 puntos como quieran
		 * poniendo como limite : WEA (4), BOD(3), IDI(3), SPE(2) */
	}
	
	public static void changeRuleScholarClass(){
		Tables.getCGT4()[Tables.MGC_CGT4][Tables.SCH_CGT4] = Tables.getCGT4()[Tables.MGC_CGT4][Tables.SCH_CGT4] + 2;
		Tables.getCGT4()[Tables.SPE_CGT4][Tables.SCH_CGT4] = Tables.getCGT4()[Tables.SPE_CGT4][Tables.SCH_CGT4] + 2;
		Tables.getCGT4()[Tables.IDI_CGT4][Tables.SCH_CGT4] = Tables.getCGT4()[Tables.IDI_CGT4][Tables.SCH_CGT4] - 2;	
		Tables.getCGT4()[Tables.SEC_CGT4][Tables.SCH_CGT4] = Tables.getCGT4()[Tables.SEC_CGT4][Tables.SCH_CGT4] - 2;
		changeRuleScholarClass = true;
	}
	
	public static void changeRuleLimitMagicalClasses(){
		LimitMagicalClasses = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMainAttribute() {
		return mainAttribute;
	}

	public void setMainAttribute(String mainAttribute) {
		this.mainAttribute = mainAttribute;
	}

	
	
}
