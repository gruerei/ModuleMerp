package utils.Tables;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tables_Crit {
	
	public static int COL_LIFE_POINTS = 0;
	public static int COL_LIFE_POINTS_PER_ASSAULT = 1;
	public static int COL_MALUS_ACTIVITY = 2;
	public static int COL_STUNNED_ASSAULTS = 3;
	public static int COL_TEAR_ITEM= 4;
	public static int COL_CAUSE_BODY_DISABILITY= 5;
	public static int COL_CAUSE_DEATH= 6;
	public static int COL_CAUSE_UNCONSCIOUSSNESS= 7;
	public static int COL_ASSAULTS_TO_DEATH= 8;
	public static int COL_ITEM_PROTECTION= 9;
	public static int COL_DESCRIPTION= 10;

	public static String[] CRIT_EFFECTS = 
		{
				"ADDITIONAL LIFE POINTS LOST",
				"LIFE POINTS LOST PER ASSAULT",
				"ACTIVITY BONUS",
				"ASSAULTS STUNNED",
				"TEAR ITEM",
				"BODY DISABILITY",
				"CAUSE DEATH",
				"CAUSA UNCONSCIOUSSNESS",
				"ASSAULTS TO DEATH",
				"ITEM PROTECTION",
				"DESCRIPTION",
		};
	
	/*CT1 CONCUSSION - ROWS 						LIFE		ASSAUL	ACTIV	ASSAUL	ITEM	CAUSE	CAUSE	CAUSE	ASSAUL	ITEM	ADDITIONAL*/
	/*       							     		POINTS		LIFEPT	MALUS	STUNN	TEAR	BDYDIS	DEATH	UNCON	DEATH	PROTEC	DESCRIPTION*/
	private static String[] CT1_ROWS_MINUS49_05 = 	{"0",		"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Poco dominio. No hay daño extra. +0."};
	private static String[] CT1_ROWS_06_20 = 		{"5",		"0",	"-5_H",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Fractura leve en las costillas. -5 PV. -5 a la actividad."};
	private static String[] CT1_ROWS_21_35 = 		{"4",		"0",	"-40_1A","0",	"0",	"0",	"0",	"0",	"0",	"0",	"Golpe en un costado. -4 PV, -40 a la actividad durante 1 asalto."};
	private static String[] CT1_ROWS_36_50 = 		{"5",		"0",	"0",	"1",	"0",	"0",	"0",	"0",	"0",	"0",	"Golpe en el antebrazo. -5 PV. Aturdido durante un asalto."};
	private static String[] CT1_ROWS_51_65 = 		{"0",		"0",	"0",	"0",	"4",	"NP2",	"0",	"0",	"0",	"4",	"Un golpe al hombro del lado del escudo, rompe el escudo. Si no hay, el hombro se rompe y el brazo queda inutilizado."};
	private static String[] CT1_ROWS_66_79 = 		{"12",		"0",	"-40_H","2",	"0",	"3",	"0",	"0",	"0",	"0",	"El golpe rompe un hueso de la pierna. -12 PV. -40 a la actividad. Aturdido durante 2 asaltos."};
	private static String[] CT1_ROWS_80 = 			{"30",		"0",	"0",	"24",	"0",	"0",	"0",	"NP1",	"0",	"5",	"Golpe en la frente. -30 PV. Un ojo destruido. Aturdido 24 asaltos. Si no se lleva yelmo puesto, en coma 1 mes."};
	private static String[] CT1_ROWS_81_86 = 		{"8",		"0",	"0",	"2",	"0",	"1",	"0",	"0",	"0",	"0",	"El golpe rompe el brazo del arma. El brazo inutilizado. Daño en los tendones. -8PV. Aturdido durante 2 asaltos."};
	private static String[] CT1_ROWS_87_89 = 		{"9",		"0",	"-60_H","3",	"0",	"0",	"0",	"0",	"0",	"0",	"Rodilla hecha trizas.-9 PV.-60 a la actividad. Derribado y aturdido durante 3 asaltos."};
	private static String[] CT1_ROWS_90 = 			{"25",		"0",	"0",	"0",	"0",	"0",	"0",	"1",	"0",	"0",	"Un golpe en la base del cuello deja paralizado de los hombros hacia abajo. -25 PV. El enemigo queda desconcertado."};
	private static String[] CT1_ROWS_91_96 = 		{"20",		"0",	"0",	"0",	"0",	"0",	"NP1",	"1",	"0",	"5",	"Inconsciente 4 horas por un golpe en un lado de la cabeza. Si no se lleva yelmo el craneo queda aplastado. -20 PV."};
	private static String[] CT1_ROWS_97_99 = 		{"0",		"0",	"0",	"0",	"0",	"0",	"1",	"1",	"6",	"0",	"Un golpe tremendo en el pecho hace que las costillas perforen los pulmones. Cae y muere en 6 asaltos. Salvaje."};
	private static String[] CT1_ROWS_100 = 			{"0",		"0",	"0",	"0",	"0",	"0",	"1",	"0",	"0",	"0",	"Golpe en la mandibula, hace que el hueso penetre en el cerebro. Muerte instantánea."};
	private static String[] CT1_ROWS_101_106 = 		{"15",		"0",	"-75_H","3",	"0",	"0",	"0",	"0",	"0",	"0",	"Un golpe rompe la cadera. -15 PV y -75 a la actividad. Cae al suelo y queda aturdido 3 asaltos."};
	private static String[] CT1_ROWS_107_109 = 		{"0",		"0",	"0",	"12",	"0",	"0",	"1",	"0",	"12",	"0",	"Un golpe en el cuello aplasta la garganta. No puede respirar y queda aturdido 12 asaltos. Después, el pobre infeliz muere."};
	private static String[] CT1_ROWS_110 = 			{"35",		"0",	"0",	"2",	"0",	"0",	"1",	"0",	"4",	"0",	"Cadera aplastada. -35 PV. Aturdido durante 2 asaltos. Activo los siguientes 4 asaltos, pero luego muere debido a un fallo nervioso."};
	private static String[] CT1_ROWS_111_116 = 		{"0",		"0",	"0",	"5",	"0",	"1",	"0",	"0",	"0",	"0",	"Destrozado el codo del brazo que sostenía el arma. El brazo queda inutilizado. Aturdido 5 asaltos."};
	private static String[] CT1_ROWS_117_119 = 		{"0",		"0",	"0",	"0",	"0",	"0",	"1",	"1",	"3",	"0",	"Un golpe en el costado aplasta la cavidad torácica. Cae y muere en 3 asaltos."};
	private static String[] CT1_ROWS_120 = 			{"0",		"0",	"0",	"0",	"0",	"0",	"1",	"0",	"0",	"0",	"Golpe tremendo en la zona del pecho. El corazón queda destruido y el sujeto muere instantáneamente. Un buen trabajo."};


	/*CT1 CONCUSSION/CRUSH/APLASTAMIENTO TABLE*/
	public static String[][] CT1 = 
		{      
			CT1_ROWS_MINUS49_05,
			CT1_ROWS_06_20,
			CT1_ROWS_21_35, 
			CT1_ROWS_36_50, 
			CT1_ROWS_51_65, 
			CT1_ROWS_66_79, 
			CT1_ROWS_80, 
			CT1_ROWS_81_86,
			CT1_ROWS_87_89, 
			CT1_ROWS_90, 
			CT1_ROWS_91_96, 
			CT1_ROWS_97_99,
			CT1_ROWS_100,
			CT1_ROWS_101_106,
			CT1_ROWS_107_109,
			CT1_ROWS_110,
			CT1_ROWS_111_116,
			CT1_ROWS_117_119,
			CT1_ROWS_120
		};
	
	/*CT2 SLASH - ROWS							    LIFE		ASSAUL	ACTIV	ASSAUL	ITEM	CAUSE	CAUSE	CAUSE	ASSAUL	ITEM	ADDITIONAL*/
	/*       							     		POINTS		LIFEPT	MALUS	STUNN	TEAR	BDYDIS	DEAD	UNCON	DEATH	PROTEC	DESCRIPTION*/
	private static String[] CT2_ROWS_MINUS49_05 = 	{"0",		"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Un golpe debil que no produce daño extra. +0."};
	private static String[] CT2_ROWS_06_20 = 		{"0",		"1",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Herida leve en la pantorilla. 1 Punto de vida por asalto."};
	private static String[] CT2_ROWS_21_35 = 		{"NP8-5",	"NP2",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"7",	"Golpe en la parte superior de la pierna. -5 PV. Si no se llevan grebas 3PV y +2 PV por asalto."};
	private static String[] CT2_ROWS_36_50 = 		{"3",		"1",	"-5_H",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Herida leve en el pecho. -3 PV. 1 PV por asalto. -5 a la actividad."};
	private static String[] CT2_ROWS_51_65 = 		{"4",		"2",	"0",	"1",	"0",	"0",	"0",	"0",	"0",	"0",	"Herida leve en el antebrazo -4 PV. 2 PV por asalto. Aturdido durante 1 asalto."};
	private static String[] CT2_ROWS_66_79 = 		{"6",		"1",	"-10_H","2",	"0",	"0",	"0",	"0",	"0",	"0",	"Herida menos grave en el muslo. -6 PV. 1 PV por asalto. - 10 a la actividad. Aturdido durante 2 asaltos."};
	private static String[] CT2_ROWS_80 = 			{"0",		"0",	"0",	"0",	"0",	"0",	"1",	"1",	"1",	"0",	"Un golpe en el cuello secciona la arteria carótida. Cuello roto. Muerte tras 1 asalto de intensa agonia."};
	private static String[] CT2_ROWS_81_86 = 		{"10",		"1",	"0",	"0",	"0",	"1",	"0",	"0",	"0",	"0",	"Tajo en los músculos y tendones del brazo que esgrime el arma. El brazo queda inutilizado -10PV y 1 PV más cada asalto."};
	private static String[] CT2_ROWS_87_89 = 		{"10",		"0",	"0",	"30",	"0",	"0",	"0",	"0",	"0",	"0",	"Un ojo destruido. - 10 PV y aturdido 30 asaltos."};
	private static String[] CT2_ROWS_90 = 			{"0",		"0",	"0",	"0",	"0",	"0",	"1",	"0",	"0",	"0",	"Destripado, muere instantaneamente. 25% de que tu arma se quede atrancada en el contrincante durante 2 asaltos."};
	private static String[] CT2_ROWS_91_96 = 		{"15",		"0",	"0",	"0",	"0",	"0",	"NP1",	"1",	"0",	"5",	"Inconsciente 6 horas debido a un tajo al lado de la cabeza. -15 PV. Si no se lleva yelmo muerte instantánea."};
	private static String[] CT2_ROWS_97_99 = 		{"0",		"20",	"0",	"0",	"0",	"3",	"0",	"1",	"0",	"0",	"Extremo inferior de la pierna seccionado. -20 PV por asalto. Cae y se desmaya."};
	private static String[] CT2_ROWS_100 = 			{"0",		"0",	"0",	"0",	"0",	"0",	"0",	"1",	"3",	"0",	"Tajo abierto en el costado. Cae inconsciente y muere en 3 asaltos debido a daños masivos en órganos internos."};
	private static String[] CT2_ROWS_101_106 = 		{"10",		"8",	"-10_H","4",	"0",	"0",	"0",	"0",	"0",	"0",	"Grave herida en el abdomen- -10 PV. Pierde 8 PV más cada asalto. -10 a la actividad. Aturdido durante 4 asaltos."};
	private static String[] CT2_ROWS_107_109 = 		{"0",		"15",	"0",	"0",	"0",	"1",	"0",	"1",	"0",	"0",	"El brazo que esgrimía el arma queda cercenado. -15 PV por asalto. Cae inconsciente inmediatemente."};
	private static String[] CT2_ROWS_110 = 			{"0",		"0",	"0",	"0",	"0",	"0",	"1",	"0",	"0",	"0",	"Corazón empalado. Muere instantáneamente, el corazón destrozado. 25% de que el arma se quede atascada en el enemigo durante 3 asaltos."};
	private static String[] CT2_ROWS_111_116 = 		{"0",		"12",	"0",	"6",	"0",	"1",	"0",	"0",	"0",	"0",	"Mano cercenada. 12 PV por asalto. Cae al suelo y queda aturdido 6 asaltos."};
	private static String[] CT2_ROWS_117_119 = 		{"20",		"0",	"0",	"0",	"0",	"0",	"0",	"1",	"0",	"0",	"Tajo en la espina dorsal. Colapso inmediato. Paralizado desde el cuello para abajo, permanentemente. -20 PV."};
	private static String[] CT2_ROWS_120 = 			{"0",		"0",	"0",	"0",	"0",	"0",	"1",	"0",	"0",	"0",	"Un tajo en la cabeza destruye el cerebro, lo que hace dificil que el pobre infeliz siga con vida . Cae fulminado."};
	
	
	/*CT2 EDGED/CORTANTE/FILO TABLE*/
	public static String[][] CT2 = 
		{      
			CT2_ROWS_MINUS49_05,
			CT2_ROWS_06_20,
			CT2_ROWS_21_35, 
			CT2_ROWS_36_50, 
			CT2_ROWS_51_65, 
			CT2_ROWS_66_79, 
			CT2_ROWS_80, 
			CT2_ROWS_81_86,
			CT2_ROWS_87_89, 
			CT2_ROWS_90, 
			CT2_ROWS_91_96, 
			CT2_ROWS_97_99, 
			CT2_ROWS_100,
			CT2_ROWS_101_106,
			CT2_ROWS_107_109,
			CT2_ROWS_110,
			CT2_ROWS_111_116,
			CT2_ROWS_117_119,
			CT2_ROWS_120
		};
	
	
	
	public static String[][] getCT1() {
		return CT1;
	}


	public static String[][] getCT2() {
		return CT2;
	}


	public static String[] getTableValue(String critType, int critRoll) {
		Method method;
		String tableMethod = "";
		String[] crit_row = null;
		String critTable = "";
		try {
			
			if(critType.equals("SLASH")){
				tableMethod = "getCT2";
				critTable = "CT2";
			}else if(critType.equals("PUNCTURE")){
				
			}else if(critType.equals("CRUNCH")){
				tableMethod = "getCT1";
				critTable = "CT1";
			}else if(critType.equals("GRAPPLE")){
				
			}else if(critType.equals("UNBALANCING")){
				
			}
			

			System.out.println("Consultando Tabla de Critico "+critType+" : "+critTable);
			method = Tables_Crit.class.getDeclaredMethod(tableMethod);
			String[][] table = (String[][]) method.invoke(null);
			crit_row = table[checkCritRow(critRoll)];
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return crit_row;
	}
	
	
	public static int checkCritRow(int rollCalculation) {
		int rowId = 0;


		if(rollCalculation <= 5){
			rowId = 0;
		}else if(rollCalculation >5 && rollCalculation <= 20){
			rowId = 1;
		}else if(rollCalculation >20 && rollCalculation <= 35){
			rowId = 2;
		}else if(rollCalculation >35 && rollCalculation <= 50){
			rowId = 3;
		}else if(rollCalculation >50 && rollCalculation <= 65){
			rowId = 4;
		}else if(rollCalculation >65 && rollCalculation <= 79){
			rowId = 5;
		}else if(rollCalculation == 80){
			rowId = 6;
		}else if(rollCalculation >80 && rollCalculation <= 86){
			rowId = 7;
		}else if(rollCalculation >86 && rollCalculation <= 89){
			rowId = 8;
		}else if(rollCalculation == 90){
			rowId = 9;
		}else if(rollCalculation >90 && rollCalculation <= 96){
			rowId = 10;
		}else if(rollCalculation >96 && rollCalculation <= 99){
			rowId = 11;
		}else if(rollCalculation == 100){
			rowId = 12;
		}else if(rollCalculation >100 && rollCalculation <= 106){
			rowId = 13;
		}else if(rollCalculation >106 && rollCalculation <= 109){
			rowId = 14;
		}else if(rollCalculation == 110){
			rowId = 15;
		}else if(rollCalculation >110 && rollCalculation <= 116){
			rowId = 16;
		}else if(rollCalculation >116 && rollCalculation <= 119){
			rowId = 17;
		}else if(rollCalculation >=120){
			rowId = 18;
		}
		
		
		return rowId;
		
	}

}
