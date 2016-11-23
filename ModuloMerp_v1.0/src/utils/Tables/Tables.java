package utils.Tables;

public class Tables {

	/*BT3 - ROWS*/
	public static final int HOBBIT_BT3 = 0;
	public static final int UMLI_BT3 = 1;
	public static final int DWARF_BT3 = 2;
	public static final int WOSE_BT3 = 3;
	public static final int HUMAN_BT3 = 4;
	public static final int DUNEDAIN_BT3 = 5;
	public static final int HALF_ELF_BT3 = 6;
	public static final int SILVAN_ELF_BT3 = 7;
	public static final int SINDARIN_ELF_BT3 = 8;
	public static final int NOLDOR_ELF_BT3 = 9;
	public static final int HALF_ORC_BT3 = 10;
	public static final int ORC_BT3 = 11;
	public static final int URUK_HAI_BT3 = 12;
	public static final int HALF_TROLL_BT3 = 13;
	public static final int TROLL_BT3 = 14;
	public static final int OLOG_HAI_BT3 = 15;
	
	/*BT3 - COLUMNS*/
	public static final int STR_BT3 = 0;
	public static final int AGI_BT3 = 1;
	public static final int CON_BT3 = 2;
	public static final int INT_BT3 = 3;
	public static final int I_BT3   = 4;
	public static final int CHAR_BT3 = 5;
	public static final int ESE_BT3 = 6;
	public static final int CHAN_BT3 = 7;
	public static final int POI_BT3 = 8;
	public static final int ILL_BT3 = 9;
	public static final int COLD_BT3 = 10;
	public static final int FIRE_BT3 = 11;
	
	/**BT3 : TABLE : Attribute Modifications by Race */
	private static final int[][] BT3 =
		{       //STR AGI CON INT I CHAR  ESE CHAN POI ILL COL FIR
				{-20 ,15 ,15 ,0 ,-5 ,-5   ,50 ,20 ,30 ,15,  0,  0}, /*HOBBIT [0]*/
				{  5 , 0 ,10 ,0 ,-5 ,-5   ,20 , 0 , 5 , 5,  0,  0}, /*UMLI [1]*/
				{  5 ,-5 ,15 ,0 ,-5 ,-5   ,40 , 0 ,10 ,10,  0,  0}, /*DWARF [2]*/
				
				{  0 , 0 , 5 ,0 , 0 , 0   ,20 , 0 , 0 , 0,  0,  0}, /*WOSE [3]*/
				{  5 , 0 , 0 ,0 , 0 , 0   , 0 , 0 , 0 , 0,  0,  0}, /*HUMAN [4]*/
				{  5 , 0 ,10 ,0 , 0 , 5   , 0 , 0 , 5 , 5,  0,  0}, /*DUNEDAIN [5]*/
				
				{  5 , 5 , 5 ,0 , 0 , 5   , 0 , 0 , 5 ,50,  0,  0}, /*HALF-ELF [6]*/
				{  0 ,10 , 0 ,0 , 5 , 5   , 0 , 0 ,10 ,100,  0,  0}, /*SILVAN-ELF [7]*/
				{  0 ,10 , 5 ,0 , 5 ,10   , 0 , 0 ,10 ,100,  0,  0}, /*SINDARIN-ELF [8]*/
				{  0 ,15 ,10 ,5 , 5 ,15   , 0 , 0 ,10 ,100,  0,  0}, /*NOLDOR-ELF [9]*/
				
				{  5 , 0 , 5 ,0 , 0 ,-5   , 0 , 0 ,10 , 0,  0,  0}, /*HALF-ORC [10]*/
				{  5 ,-5 ,15,-10,-10,-10  , 0 , 0 ,20 , 5,  0, 30}, /*ORC [11]*/
				{ 10 , 0 ,20, 0 ,-5 ,-10  , 0 , 0 ,20 , 5,  0,  0}, /*URUK-HAI [12]*/
				{ 10 ,-5 ,10,-5 ,-5 ,-5   , 0 , 0 ,15 , 5,  0,  0}, /*HALF-TROLL [13]*/
				{ 15,-10 ,15,-15,-15,-10  , 0 , 0 ,30 , 10,  0,  0}, /*TROLL [14]*/
				{ 20 ,-5 ,15,-5 ,-10,-10  , 0 , 0 ,20 , 10,  0,  0}, /*OLOG-HAI [15]*/
				
		}		
	; 
	
	
	/*COLUMNS CGT4*/
	public static final int	WAR_CGT4 = 0;
	public static final int	MAG_CGT4 = 1;
	public static final int	ANI_CGT4 = 2;
	public static final int	SCO_CGT4 = 3;
	public static final int	RAN_CGT4 = 4;
	public static final int	BRD_CGT4 = 5;
	public static final int	BAR_CGT4 = 6;
	public static final int	ROG_CGT4 = 7;
	public static final int	CIV_CGT4 = 8;
	public static final int	CON_CGT4 = 9;
	public static final int	WIZ_CGT4 = 10;
	public static final int	SCH_CGT4 = 11;
	public static final int	BUR_CGT4 = 12;
	public static final int	MNK_CGT4 = 13;
	public static final int	WMNK_CGT4 = 14;
	public static final int	SS_CGT4 = 15;
	public static final int	TRA_CGT4 = 16;
	public static final int	SHA_CGT4 = 17;
	
	/*ROWS CGT4*/
	public static final int MM_CGT4 = 0;
	public static final int WEA_CGT4 = 1;
	public static final int GEN_CGT4 = 2;
	public static final int SUB_CGT4 = 3;
	public static final int MGC_CGT4 = 4;
	public static final int BOD_CGT4 = 5;
	public static final int IDI_CGT4 = 6;
	public static final int SPE_CGT4 = 7;
	public static final int MARC_CGT4 = 8;
	public static final int ADR_CGT4 = 9;
	public static final int SEC_CGT4 = 10;
	
	
	/**CGT4_TABLE : Development Points by Profession(Lvl Up Points) */
	private static int[][] CGT4 =
		{      
				// 0   1   2   3   4   5     6    7   8   9  10  11  12  13  14   15  16 17
				//WAR MAG ANI SCO RAN BRD   BAR ROG CIV CON SCH WIZ BUR MNK WMNK SS TRA SHA
				{  3 , 0 , 1 , 1 , 2 , 0    , 1 , 2 , 0 , 0 , 1 , 0 , 2 , 0 , 0 , 1 , 2 , 1 }, /*MM  [0]*/
				{  5 , 0 , 1 , 3 , 3 , 2    , 5 , 4 , 1 , 1 , 1 , 0 , 1 , 1 , 1 , 1 , 2 , 2 }, /*WEA [1]*/
				{  2 , 2 , 2 , 3 , 4 , 2    , 5 , 3 , 2 , 1 , 3 , 2 , 2 , 2 , 1 , 1 , 5 , 1 }, /*GEN [2]*/
				{  2 , 0 , 1 , 5 , 2 , 2    , 1 , 3 , 0 , 4 , 0 , 0 , 8 , 2 , 2 , 1 , 4 , 3 }, /*SUB [3]*/
				{  0 , 5 , 2 , 0 , 0 , 3    , 0 , 1 , 0 , 3 , 0 , 5 , 0 , 1 , 0 , 0 , 0 , 5 }, /*MGC [4]*/
				{  3 , 1 , 1 , 2 , 2 , 1    , 3 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 3 , 3 , 1 , 1 }, /*BOD [5]*/
				{  0 , 2 , 2 , 1 , 1 , 3    , 0 , 0 , 0 , 1 , 4 , 2 , 1 , 1 , 0 , 1 , 1 , 0 }, /*IDI [6]*/
				{  0 , 5 , 5 , 0 , 1 , 2    , 0 , 0 , 0 , 4 , 0 , 5 , 0 , 2 , 0 , 0 , 0 , 2 }, /*SPE [7]*/
				
				{  0 , 0 , 0 , 0 , 0 , 0    , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 3 , 5 , 3 , 0 , 0 }, /*MARC [8]*/
				{  0 , 0 , 0 , 0 , 0 , 0    , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 2 , 3 , 3 , 0 , 0 }, /*ADR [9]*/
				{  0 , 0 , 0 , 0 , 0 , 0    , 0 , 0 ,11 , 0 , 5 , 0 , 0 , 0 , 0 , 0 , 0 , 0 }, /*SEC [10]*/						
		}; 
	
	/** CGT5: TABLE : Adolescence Points by Race */
	private static int[][] CGT5 =
		{      
				// 0   1   2   3   4   5   6   7   8   9  10  11  12  13  14   15  16  17  18  19 20  21 22  23   24   25  26  27
				//EN  UM ENL ESIN ESIL HE HOB BEO NN COR DOR DUN  DUL EM  ERI GON HAR LOS ROH VAR WM WOS ORC URU HORC TRO OLO HTRO
				{  1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 }, /*N_ARM [0]*/
				{  0 , 3 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 1 , 1 , 3 , 0 , 1 , 1 , 3 , 1 , 1 , 1 , 0 , 0 , 1 }, /*S_LEA [1]*/
				{  1 , 3 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 2 , 1 , 1 , 1 , 0 , 1 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 3 , 3 , 3 , 0 , 0 , 2 }, /*R_LEA [2]*/
				{  3 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 2 , 0 , 0 , 2 , 0 , 0 , 1 , 0 , 0 , 0 , 2 , 0 , 0 , 0 , 2 , 3 , 1 , 0 , 0 , 3 }, /*CHA   [3]*/
				
				{  0 , 0 , 1 , 1 , 1 , 1 , 0 , 0 , 1 , 2 , 0 , 2 , 0 , 1 , 1 , 1 , 1 , 0 , 2 , 2 , 1 , 2 , 1 , 4 , 0 , 0 , 0 , 0 }, /*EDG   [4]*/
				{  4 , 3 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 3 , 1 , 3 , 0 , 0 , 0 }, /*CON   [5]*/
				{  0 , 1 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 3 , 5 , 4 }, /*T_H   [6]*/
				{  1 , 1 , 0 , 0 , 0 , 0 , 2 , 1 , 1 , 1 , 1 , 0 , 2 , 1 , 1 , 0 , 1 , 3 , 0 , 1 , 1 , 4 , 1 , 1 , 1 , 1 , 2 , 2 }, /*THR   [7]*/
				{  0 , 0 , 1 , 2 , 3 , 2 , 2 , 0 , 1 , 1 , 1 , 1 , 1 , 2 , 1 , 1 , 0 , 0 , 1 , 1 , 1 , 0 , 0 , 1 , 1 , 0 , 0 , 0 }, /*PRO   [8]*/
				{  0 , 0 , 0 , 0 , 0 , 0 , 0 , 2 , 0 , 0 , 1 , 1 , 2 , 2 , 1 , 0 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 0 , 0 , 0 , 0 }, /*POL   [9]*/
				
				{  1 , 0 , 0 , 1 , 2 , 1 , 2 , 2 , 0 , 0 , 0 , 0 , 5 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 3 , 3 , 1 , 1 , 1 , 1 , 1 , 1 }, /*CLI   [10]*/
				{  0 , 0 , 1 , 1 , 1 , 1 , 0 , 0 , 1 , 0 , 2 , 1 , 0 , 5 , 1 , 0 , 7 , 0 , 8 , 4 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 }, /*RID   [11]*/
				{  0 , 1 , 2 , 2 , 3 , 1 , 0 , 2 , 3 , 5 , 1 , 1 , 1 , 0 , 1 , 1 , 0 , 2 , 1 , 0 , 1 , 2 , 0 , 0 , 0 , 0 , 0 , 0 }, /*SWI   [12]*/
				
				{  0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 2 , 1 , 1 , 1 , 0 , 0 , 0 }, /*AMB   [13]*/
				{  0 , 1 , 2 , 3 , 4 , 2 , 5 , 4 , 0 , 0 , 0 , 0 , 2 , 0 , 1 , 0 , 0 , 4 , 0 , 1 , 4 , 4 , 0 , 0 , 0 , 0 , 0 , 0 }, /*HID   [14]*/
				{  1 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 }, /*LOK   [15]*/
				{  1 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 }, /*MEC   [16]*/
				
				{  0 , 0 , 2 , 1 , 1 , 1 , 0 , 0 , 1 , 0 , 0 , 1 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 }, /*RUN   [17]*/
				{  0 , 0 , 1 , 1 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 1 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 }, /*UOB   [18]*/
				
				{  3 , 2 , 1 , 1 , 1 , 1 , 2 , 3 , 2 , 2 , 1 , 3 , 3 , 2 , 2 , 1 , 2 , 3 , 2 , 2 , 2 , 3 , 2 , 3 , 2 , 5 , 5 , 4 }, /*BDE   [19]*/
				{  2 , 1 , 3 , 3 , 3 , 1 , 4 , 1 , 0 , 0 , 0 , 0 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 0 , 1 , 0 , 0 , 1 , 0 }, /*PER   [20]*/
				
				{  3 , 5 ,40 ,30 ,20 ,10 , 0 , 3 ,10 , 5 ,10 ,10 , 2 , 2 , 3 ,15 , 2 , 5 , 3 , 5 , 3 , 5 , 0 , 0 , 0 , 0 , 0 , 0 }, /*SPE   [21]*/
				{  4 , 3 ,10 , 8 , 6 , 4 , 3 , 3 , 6 , 5 , 5 , 6 , 2 , 2 , 4 , 5 , 3 , 1 , 4 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 }, /*LAN   [22]*/
				{  4 , 4 , 2 , 3 , 4 , 3 , 5 , 5 , 3 , 5 , 5 , 3 , 4 , 4 , 5 , 5 , 5 , 4 , 5 , 4 , 5 , 5 , 2 , 2 , 3 , 1 , 1 , 2 }, /*HIST  [23]*/
		};
	
	private static String[][] skill_category_table = {
			{"NO_ARMOR","0"},
			{"SOFT_LEATHER","0"},
			{"RIGID_LEATHER","0"},
			{"CHAIN","0"},
			{"PLATE","0"},
			{"EDGED","1"},
			{"CONCUSSION","1"},
			{"TWO_HANDED","1"},
			{"THROWN","1"},
			{"PROJECTILE","1"},
			{"POLEARM","1"},
			{"CLIMB","2"},
			{"RIDE","2"},
			{"SWIM","2"},
			{"TRACK","2"},
			{"AMBUSH","3"},
			{"STALK_HIDE","3"},
			{"PICK_LOCK","3"},
			{"DISARM_TRAP","3"},
			{"READ_RUNES","4"},
			{"USE_MAG_ITEM","4"},
			{"DIRECTED_SPELLS","4"},
			{"BASE_SPELL","5"},
			{"BODY_DEVELOPMENT","5"},
			{"PERCEPTION","5"},
			{"BD","5"},
			{"INFLUENCE_LEADERSHIP","6"},
			{"ACROBACIES","8"},
			{"IMPERSONATE","10"},
			{"ANIMAL_HANDLING","10"},
			{"APPRAISE","6"},
			{"NAVIGATION","6"},
			{"CAVE_KNOWL","11"},
			{"SKY_KNOWL","6"},
			{"ESS_KNOWL","11"},
			{"CHAN_KNOWL","11"},
			{"CONTORT","6"},
			{"COOK","6"},
			{"FIRST_AID","6"},
			{"SURVIVAL","6"},
			{"GAMBLING","6"},
			{"MEDITATION","6"},
			{"ROPES","6"},
			{"SIGNS","6"},
			{"TRICK","6"},
			{"SHAPE_SHIFT","6"},
			};
	
	private static String[] magic_realms_descrip_table = {"ESSENCE","CHANNELING","MAGICIAN","BARD","ANIMIST","RANGER"};
	private static String[] skill_categories = {"MOVEMENT_MANEUVERS","WEAPONS","GENERAL","SUBTERFUGE","MAGIC",
			"OTHERS","SECONDARY","SECONDARY_ART", "SECONDARY_ATL", "SECONDARY_WRK", "SECONDARY_INFL", "SECONDARY_KNOW", "SECONDARY_MART_ART"};	
	private static String[] item_categories = {"","WEAPON_1","WEAPON_2","ARMOUR","SHIELD","HELMET","BRACERS","GREAVES","RING_1","RING_2","AMULET","OTHER1","OTHER2","OTHER3"};	

	private static String[] material_categories = {"LEATHER","METAL"};
	
	private static String[] critical_type = {"","SLASH","PUNCTURE","CRUNCH","GRAPPLE","UNBALANCING"};
	
	private static String[] botch_type = {"","SLASH","PUNCTURE","CRUNCH","GRAPPLE","UNBALANCING"};
	
	public static String[] getBotch_type() {
		return botch_type ;
	}
	
	public static String[] getCritical_type() {
		return critical_type ;
	}
	
	public static String[] getMaterial_categories() {
		return material_categories;
	}

	public static String[] getItem_categories(){
		return item_categories;
	}
	
	public static String[][] getSkillCategoryTable() {
		return skill_category_table;
	}

	public static String[] getMagicRealmsDescripTable() {
		return magic_realms_descrip_table;
	}

	public static int[][] getCGT4() {
		return CGT4;
	}


	public static String[] getSkillCategories() {
		return skill_categories;
	}

	public static String getTableValue(String table_name, int rowIdx, int colIdx){
		String ret = "";
		
		if(table_name.contains("AT"))
			System.out.println("Consultando Tabla de Ataque "+table_name);
		
		if(table_name.equals("CGT5")){
			ret = CGT5[rowIdx][colIdx] + "";
		}else if(table_name.equals("BT3")){
			ret = BT3[rowIdx][colIdx] + "";
		}else if(table_name.equals("AT1")){
			ret = Tables_AT.AT1[rowIdx][colIdx] + "";
		}else if(table_name.equals("AT2")){
			ret = Tables_AT.AT2[rowIdx][colIdx] + "";
		}
		
		return ret;
	}
}
