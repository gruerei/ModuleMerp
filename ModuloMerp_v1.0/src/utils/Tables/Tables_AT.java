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
				AT1_ROWS_01_08,//0
				AT1_ROWS_09_45,//1
				AT1_ROWS_46_50,//2 
				AT1_ROWS_51_55,//3 
				AT1_ROWS_56_60,//4 
				AT1_ROWS_61_65,//5 
				AT1_ROWS_66_70,//6 
				AT1_ROWS_71_75,//7
				AT1_ROWS_76_80,//8 
				AT1_ROWS_81_85,//9 
				AT1_ROWS_86_90,//10 
				AT1_ROWS_91_95,//11 
				AT1_ROWS_96_100,//12 
				AT1_ROWS_101_105,//13
				AT1_ROWS_106_110,//14
				AT1_ROWS_111_115,//15
				AT1_ROWS_116_120,//16
				AT1_ROWS_121_125,//17
				AT1_ROWS_126_130,//18
				AT1_ROWS_131_135,//19
				AT1_ROWS_136_140,//20
				AT1_ROWS_141_145,//21
				AT1_ROWS_146_150//22
		};
	
	/*AT2 ROWS							     PLA  	CHA		RL  	SL	    NOAR*/
	private static String[] AT2_ROWS_01_08 = {"0",	"0",	"0",	"0",	"0"};
	private static String[] AT2_ROWS_09_35 = {"0",	"0",	"0",	"0",	"0"};
	private static String[] AT2_ROWS_36_40 = {"1",	"0",	"0",	"0",	"0"};
	private static String[] AT2_ROWS_41_45 = {"1",	"1",	"0",	"0",	"0"};
	private static String[] AT2_ROWS_46_50 = {"2",	"2",	"0",	"0",	"0"};
	private static String[] AT2_ROWS_51_55 = {"3",	"3",	"0",	"0",	"0"};
	private static String[] AT2_ROWS_56_60 = {"3",	"4",	"0",	"0",	"0"};
	private static String[] AT2_ROWS_61_65 = {"4",	"5",	"0",	"0",	"0"};
	private static String[] AT2_ROWS_66_70 = {"5",	"6",	"2",	"3",	"0"};
	private static String[] AT2_ROWS_71_75 = {"5",	"7",	"3",	"5",	"0"};
	private static String[] AT2_ROWS_76_80 = {"6",	"8",	"4",	"6",	"0"};
	private static String[] AT2_ROWS_81_85 = {"7",	"9",	"6",	"7-A",	"6"};
	private static String[] AT2_ROWS_86_90 = {"8",	"10",	"7-A",	"8-A",	"8"};
	private static String[] AT2_ROWS_91_95 = {"8",	"11",	"8-A",	"9-A",	"9-A"};
	private static String[] AT2_ROWS_96_100 = {"9",	"12-A",	"9-B",	"10-B",	"10-B"};
	private static String[] AT2_ROWS_101_105 = {"10","13-A","10-B",	"11-B",	"12-C"};
	private static String[] AT2_ROWS_106_110 = {"10-A","14-B","11-B","12-B","13-C"};
	private static String[] AT2_ROWS_111_115 = {"11-A","15-B","12-C","13-C","14-D"};
	private static String[] AT2_ROWS_116_120 = {"12-B","16-C","13-C","14-C","15-D"};
	private static String[] AT2_ROWS_121_125 = {"13-B","17-C","15-C","15-C","17-D"};
	private static String[] AT2_ROWS_126_130 = {"13-C","18-C","16-C","16-D","18-E"};
	private static String[] AT2_ROWS_131_135 = {"14-C","19-D","17-D","17-D","19-E"};
	private static String[] AT2_ROWS_136_140 = {"15-D","20-D","18-D","18-E","21-E"};
	private static String[] AT2_ROWS_141_145 = {"16-D","21-E","19-E","19-E","22-E"};
	private static String[] AT2_ROWS_146_150 = {"16-E","22-E","20-E","20-E","23-E"};
	//                                          PLA  	CHA		RL  	SL	  NOAR
	/*AT2 TABLE*/
	public static String[][] AT2 = 
		{      
				AT2_ROWS_01_08,//0
				AT2_ROWS_09_35,//1
				AT2_ROWS_36_40,//2
				AT2_ROWS_41_45,//3
				AT2_ROWS_46_50,//4 
				AT2_ROWS_51_55,//5 
				AT2_ROWS_56_60,//6 
				AT2_ROWS_61_65,//7 
				AT2_ROWS_66_70,//8 
				AT2_ROWS_71_75,//9
				AT2_ROWS_76_80,//10 
				AT2_ROWS_81_85,//11 
				AT2_ROWS_86_90,//12 
				AT2_ROWS_91_95,//13 
				AT2_ROWS_96_100,//14 
				AT2_ROWS_101_105,//15
				AT2_ROWS_106_110,//16
				AT2_ROWS_111_115,//17
				AT2_ROWS_116_120,//18
				AT2_ROWS_121_125,//19
				AT2_ROWS_126_130,//20
				AT2_ROWS_131_135,//21
				AT2_ROWS_136_140,//22
				AT2_ROWS_141_145,//23
				AT2_ROWS_146_150//24
		};
}
