package beans;

public class Tables {

	/**BT3 : TABLE : Attribute Modifications by Race */
	private static final int[][] BT3 =
		{       //STR AGI CON INT I CHAR  ESE CHAN POI ILL
				{-20 ,15 ,15 ,0 ,-5 ,-5   ,50 ,20 ,30 ,15}, /*HOBBIT [0]*/
				{  5 , 0 ,10 ,0 ,-5 ,-5   ,20 , 0 , 5 , 5}, /*UMLI [1]*/
				{  5 ,-5 ,15 ,0 ,-5 ,-5   ,40 , 0 ,10 ,10}, /*DWARF [2]*/
				
				{  0 , 0 , 5 ,0 , 0 , 0   ,20 , 0 , 0 , 0}, /*WOSE [3]*/
				{  5 , 0 , 0 ,0 , 0 , 0   , 0 , 0 , 0 , 0}, /*HUMAN [4]*/
				{  5 , 0 ,10 ,0 , 0 , 5   , 0 , 0 , 5 , 5}, /*DUNEDAIN [5]*/
				
				{  5 , 5 , 5 ,0 , 0 , 5   , 0 , 0 , 5 ,50}, /*HALF-ELF [6]*/
				{  0 ,10 , 0 ,0 , 5 , 5   , 0 , 0 ,10 ,100}, /*SILVAN-ELF [7]*/
				{  0 ,10 , 5 ,0 , 5 ,10   , 0 , 0 ,10 ,100}, /*SINDARIN-ELF [8]*/
				{  0 ,15 ,10 ,5 , 5 ,15   , 0 , 0 ,10 ,100}, /*NOLDOR-ELF [9]*/
				
				{  5 , 0 , 5 ,0 , 0 ,-5   , 0 , 0 ,10 , 0}, /*HALF-ORC [10]*/
				{  5 ,-5 ,15,-10,-10,-10  , 0 , 0 ,20 , 5}, /*ORC [11]*/
				{ 10 , 0 ,20, 0 ,-5 ,-10  , 0 , 0 ,20 , 5}, /*URUK-HAI [12]*/
				{ 10 ,-5 ,10,-5 ,-5 ,-5   , 0 , 0 ,15 , 5}, /*HALF-TROLL [13]*/
				{ 15,-10 ,15,-15,-15,-10  , 0 , 0 ,30 , 10}, /*TROLL [14]*/
				{ 20 ,-5 ,15,-5 ,-10,-10  , 0 , 0 ,20 , 10}, /*OLOG-HAI [15]*/
				
		}		
	; 
	
	
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
	
	private static String[] skill_descrip_table = {"NO_ARMOR","SOFT_LEATHER","RIGID_LEATHER","CHAIN","PLATE",
			"EDGED","CONCUSSION","TWO_HANDED","THROWN","PROJECTILE","POLEARM",
			"CLIMB","RIDE","SWIM","TRACK",
			"AMBUSH","STALK_HIDE","PICK_LOCK","DISARM_TRAP",
			"READ_RUNES","USE_MAG_ITEM","DIRECTED_SPELLS","BASE_SPELL",
			"BODY_DEVELOPMENT","PERCEPTION","INFLUENCE_LEADERSHIP",
			"ACROBACIES","ACT","ANIMAL_HANDLING","APPRAISE","NAVIGATION",
			"CAVE_KNOWL","SKY_KNOWL","ESS_KNOWL","CHAN_KNOWL","CONTORT",
			"COOK","FIRST_AID","SURVIVAL","GAMBLING","MEDITATION",
			"ROPES","SIGNS","TRICK","SHAPE_SHIFT"};
	
	private static String[] magic_realms_descrip_table = {"ESSENCE","CHANNELING","MAGICIAN","BARD","ANIMIST","RANGER"};

	
	
	public static String[] getSkillDescripTable() {
		return skill_descrip_table;
	}

	public static String[] getMagicRealmsDescripTable() {
		return magic_realms_descrip_table;
	}


	public static int getTableValue(String table_name, int rowIdx, int colIdx){
		int ret = 0;
		
		if(table_name.equals("CGT5")){
			ret = CGT5[rowIdx][colIdx];
		}else if(table_name.equals("BT3")){
			ret = BT3[rowIdx][colIdx];
		}
		
		return ret;
	}
}
