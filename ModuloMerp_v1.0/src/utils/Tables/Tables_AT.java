package utils.Tables;

public class Tables_AT {
	/*COLUMNS AT1,AT2,AT3,AT4,AT5,AT6*/
	public static final int AT_PLATE = 0;
	public static final int AT_CHAIN = 1;
	public static final int AT_RIGLEA = 2;
	public static final int AT_SOFLEA = 3;
	public static final int AT_NOAR = 4;
	
	/*AT1 ROWS							     PLA  	CHA		RL  	SL	    NOAR*/
	private static String[] AT1_ROWS_01_08 = {"0",	"0",	"0",	"0",	"0"};
	private static String[] AT1_ROWS_09_45 = {"0",	"0",	"0",	"0",	"0"};
	private static String[] AT1_ROWS_46_50 = {"1",	"0",	"0",	"0",	"0"};
	private static String[] AT1_ROWS_51_55 = {"1",	"1",	"0",	"0",	"0"};
	private static String[] AT1_ROWS_56_60 = {"2",	"1",	"0",	"0",	"0"};
	private static String[] AT1_ROWS_61_65 = {"2",	"2",	"0",	"0",	"0"};
	private static String[] AT1_ROWS_66_70 = {"3",	"3",	"2",	"3",	"0"};
	private static String[] AT1_ROWS_71_75 = {"3",	"4",	"3",	"5",	"0"};
	private static String[] AT1_ROWS_76_80 = {"4",	"5",	"5",	"7-A",	"7"};
	private static String[] AT1_ROWS_81_85 = {"5",	"6",	"6",	"9-A",	"9-A"};
	private static String[] AT1_ROWS_86_90 = {"5",	"7",	"7-A",	"10-B",	"10-A"};
	private static String[] AT1_ROWS_91_95 = {"6",	"8",	"9-A",	"12-B",	"11-B"};
	private static String[] AT1_ROWS_96_100 = {"6",	"9",	"10-B",	"13-B",	"13-C"};
	private static String[] AT1_ROWS_101_105 = {"7","10-A",	"11-B",	"14-C",	"15-C"};
	private static String[] AT1_ROWS_106_110 = {"8","11-A",	"12-B",	"15-C",	"17-D"};
	private static String[] AT1_ROWS_111_115 = {"8-A","12-B","13-C","17-C",	"19-D"};
	private static String[] AT1_ROWS_116_120 = {"9-A","13-B","15-C","18-D",	"20-D"};
	private static String[] AT1_ROWS_121_125 = {"9-A","13-C","16-C","19-D",	"21-E"};
	private static String[] AT1_ROWS_126_130 = {"10-B","14-C","17-D","20-D","23-E"};
	private static String[] AT1_ROWS_131_135 = {"10-B","15-C","18-D","22-D","25-E"};
	private static String[] AT1_ROWS_136_140 = {"11-C","16-D","20-D","23-E","27-E"};
	private static String[] AT1_ROWS_141_145 = {"12-D","17-D","21-E","24-E","28-E"};
	private static String[] AT1_ROWS_146_150 = {"12-E","18-E","22-E","25-E","30-E"};
	//                                          PLA  	CHA		RL  	SL	  NOAR
	/*AT1 TABLE*/
	public static String[][] AT1 = 
		{      
				AT1_ROWS_01_08,
				AT1_ROWS_09_45,
				AT1_ROWS_46_50, 
				AT1_ROWS_51_55, 
				AT1_ROWS_56_60, 
				AT1_ROWS_61_65, 
				AT1_ROWS_66_70, 
				AT1_ROWS_71_75,
				AT1_ROWS_76_80, 
				AT1_ROWS_81_85, 
				AT1_ROWS_86_90, 
				AT1_ROWS_91_95, 
				AT1_ROWS_96_100, 
				AT1_ROWS_101_105,
				AT1_ROWS_106_110,
				AT1_ROWS_111_115,
				AT1_ROWS_116_120,
				AT1_ROWS_121_125,
				AT1_ROWS_126_130,
				AT1_ROWS_131_135,
				AT1_ROWS_136_140,
				AT1_ROWS_141_145,
				AT1_ROWS_146_150
		};
}
