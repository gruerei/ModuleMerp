package utils.Tables;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tables_Botch {
	
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

	public static String[] BOTCH_EFFECTS = 
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
	
	/*FT1 WEAPONS  - ROWS							LIFE		ASSAUL	ACTIV	ASSAUL	ITEM	CAUSE	CAUSE	CAUSE	ASSAUL	ITEM	ADDITIONAL*/
	/*       							     		POINTS		LIFEPT	MALUS	STUNN	TEAR	BDYDIS	CRIT	UNCON	DEATH	PROTEC	DESCRIPTION*/
	private static String[] FT1_ROWS_MINUS49_05 = 	{"0",		"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Pierdes el control. No haces nada m�s este asalto."};
	private static String[] FT1_ROWS_06_20 =/*TODO*/{"0",		"0",	"0",	"0",	"1?",	"0",	"0",	"0",	"0",	"0",	"Resbalas. Si tu arma se maneja con una sola mano y no es m�gica, se rompe."};
	private static String[] FT1_ROWS_21_35 = 		{"2",		"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Mala continuaci�n, pierdes tu oportunidad y 2 puntos de vida."};
	private static String[] FT1_ROWS_36_50 = 		{"0",		"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Se te cae el arma. Tardar�s 1 asalto en desenvainar otra o 2 asaltos en recuperar la que ha caido."};
	private static String[] FT1_ROWS_51_65 = 		{"0",		"0",	"40-2A","0",	"0",	"0",	"0",	"0",	"0",	"0",	"Pierdes el hilo y te das cuenta de que deberias relajarte. -40 a la actividad durante dos asaltos"};
	private static String[] FT1_ROWS_66_79 = 		{"0",		"0",	"0",	"2",	"0",	"0",	"0",	"0",	"0",	"0",	"Tropiezas. Semejante demostraci�n de falta de estilo te deja aturdido durante dos asaltos. Con suerte, sobrevivir�s."};
	private static String[] FT1_ROWS_80 = 	/*TODO*/{"0",		"0",	"0",	"0",	"1?",	"0",	"0",	"0",	"0",	"0",	"Movimiento increiblemente inepto. Te haces a ti mismo un Cr�tico 'B'. (Tira en la tabla corresp.). Si el oponente est� usando un arma de tajo, tu arma se rompe."};
	private static String[] FT1_ROWS_81_86 = 		{"0",		"0",	"0",	"2",	"0",	"0",	"0",	"0",	"0",	"0",	"Con los nervios te muerdes la lengua. Aturdido durante 2 asaltos."};
	private static String[] FT1_ROWS_87_89 = 		{"0",		"0",	"0",	"3",	"0",	"0",	"0",	"0",	"0",	"0",	"Pierdes el control del arma y de la realidad. Aturdido 3 asaltos."};
	private static String[] FT1_ROWS_90 = 	/*TODO*/{"0",		"0",	"0",	"0",	"1",	"0",	"0",	"0",	"0",	"0",	"Mala maniobra. Intentas automutilarte al tiempo que tu arma se rompe. Te haces un critico de 'C' (tira en al tabla corresp.)"};
	private static String[] FT1_ROWS_91_96 =/*TODO*/{"0",		"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Increible tu forma de esgrimir el arma. Cualquier combatiente de tu bando cercano, recibe un critico 'B' de aplastamiento."};
	private static String[] FT1_ROWS_97_99 = 		{"0",		"0",	"0",	"3",	"0",	"0",	"0",	"0",	"0",	"0",	"Tropiezas con una imaginaria, e invisible, tortuga fenecida. Quedas bastante confundido. Aturdido 3 asaltos."};
	private static String[] FT1_ROWS_100 = 	/*TODO*/{"0",		"0",	"60-30A","0",	"0",	"0",	"0",	"0",	"0",	"0",	"El peor movimiento visto en a�os. -60 a la actividad por un tir�n en la ingle. El enemigo queda aturdido 2 asaltos, muerto de risa."};
	private static String[] FT1_ROWS_101_106 = 		{"0",		"0",	"0",	"3",	"1?",	"0",	"0",	"0",	"0",	"0",	"Te tambaleas y te caes en un aparente intento de suicidio. Quedas aturdido 3 asaltos. Si usas un arma de asta, se rompe el mango."};
	private static String[] FT1_ROWS_107_109 = 		{"0",		"0",	"0",	"4",	"1",	"0",	"0",	"0",	"0",	"0",	"Rompes tu arma por inepto. Quedas aturdido 4 asaltos"};
	private static String[] FT1_ROWS_110 = /*TODO*/	{"0",		"0",	"0",	"5",	"0",	"0",	"0",	"0",	"0",	"0",	"Tropiezas y claves la punta de tu arma en el suelo. Aturdido 5 asaltos. Si estas montado, tu arma de asta te hace saltar 9 metros y Recibes un cr�tico 'C' de aplastamiento."};
	private static String[] FT1_ROWS_111_116 = 		{"0",		"0",	"0",	"3",	"0",	"0",	"0",	"0",	"0",	"0",	"Tu montura se encabrita s�bitamente. Aturdido 3 asaltos recuper�ndote."};
	private static String[] FT1_ROWS_117_119 = 		{"0",		"0",	"90-3A","0",	"0",	"0",	"0",	"0",	"0",	"0",	"No coordinas tus movimientos con los de tu montura. -90 a la actividad los siguientes 3 asaltos mientras intentas seguir siendo el jinete."};
	private static String[] FT1_ROWS_120 = /*TODO*/	{"0",		"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Te caes de tu montura, te haces un cr�tico 'D' de aplastamiento."};

	
	/*FT1 WEAPONS TABLE*/
	public static String[][] FT1 = 
		{      
			FT1_ROWS_MINUS49_05,
			FT1_ROWS_06_20,
			FT1_ROWS_21_35, 
			FT1_ROWS_36_50, 
			FT1_ROWS_51_65, 
			FT1_ROWS_66_79, 
			FT1_ROWS_80, 
			FT1_ROWS_81_86,
			FT1_ROWS_87_89, 
			FT1_ROWS_90, 
			FT1_ROWS_91_96, 
			FT1_ROWS_97_99, 
			FT1_ROWS_97_99,
			FT1_ROWS_100,
			FT1_ROWS_101_106,
			FT1_ROWS_107_109,
			FT1_ROWS_110,
			FT1_ROWS_111_116,
			FT1_ROWS_117_119,
			FT1_ROWS_120
		};
	
	/*FT2 - PROJECTILE ROWS							LIFE		ASSAUL	ACTIV	ASSAUL	ITEM	CAUSE	CAUSE	CAUSE	ASSAUL	ITEM	ADDLP	ASSLP	DEAD	ADDITIONAL*/
	/*       							     		POINTS		LIFEPT	MALUS	STUNN	TEAR	BDYDIS	DEAD	UNCON	DEATH	PROTEC	NOPROT	NOPROT	NOPROT	DESCRIPTION*/
	private static String[] FT2_ROWS_MINUS49_05 = 	{"0",		"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Un golpe debil que no produce da�o extra. +0."};
	private static String[] FT2_ROWS_06_20 = 		{"0",		"1",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Herida leve en la pantorilla. 1 Punto de vida por asalto."};
	private static String[] FT2_ROWS_21_35 = 		{"NP8-5",	"NP2",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"7",	"Golpe en la parte superior de la pierna. -5 PV. Si no se llevan grebas 3PV y +2PV por asalto."};
	private static String[] FT2_ROWS_36_50 = 		{"3",		"1",	"5-H",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Herida leve en el pecho. -3 PV. 1 PV por asalto. -5 a la actividad."};
	private static String[] FT2_ROWS_51_65 = 		{"4",		"2",	"0",	"1",	"0",	"0",	"0",	"0",	"0",	"0",	"Herida leve en el antebrazo -4 PV. 2 PV por asalto. Aturdido durante 1 asalto."};
	private static String[] FT2_ROWS_66_79 = 		{"6",		"1",	"10-H",	"2",	"0",	"0",	"0",	"0",	"0",	"0",	"Herida menos grave en el muslo. -6 PV. 1 PV por asalto. - 10 a la actividad. Aturdido durante 2 asaltos."};
	private static String[] FT2_ROWS_80 = 			{"0",		"0",	"0",	"0",	"0",	"0",	"1",	"1",	"1",	"0",	"Un golpe en el cuello secciona la arteria car�tida. Cuello roto. Muerte tras 1 asalto de intensa agonia."};
	private static String[] FT2_ROWS_81_86 = 		{"10",		"1",	"0",	"0",	"0",	"1",	"0",	"0",	"0",	"0",	"Tajo en los m�sculos y tendones del brazo que esgrime el arma. El brazo queda inutilizado -10PV y 1 PV m�s cada asalto."};
	private static String[] FT2_ROWS_87_89 = 		{"10",		"0",	"0",	"30",	"0",	"0",	"0",	"0",	"0",	"0",	"Un ojo destruido. - 10 PV y aturdido 30 asaltos."};
	private static String[] FT2_ROWS_90 = 			{"0",		"0",	"0",	"0",	"0",	"0",	"1",	"0",	"0",	"0",	"Destripado, muere instantaneamente. 25% de que tu arma se quede atrancada en el contrincante durante 2 asaltos."};
	private static String[] FT2_ROWS_91_96 = 		{"15",		"0",	"0",	"0",	"0",	"0",	"NP1",	"1",	"0",	"5",	"Inconsciente 6 horas debido a un tajo al lado de la cabeza. -15 PV. Si no se lleva yelmo muerte instant�nea."};
	private static String[] FT2_ROWS_97_99 = 		{"0",		"20",	"0",	"0",	"0",	"3",	"0",	"1",	"0",	"0",	"Extremo inferior de la pierna seccionado. -20 PV por asalto. Cae y se desmaya."};
	private static String[] FT2_ROWS_100 = 			{"0",		"0",	"0",	"0",	"0",	"0",	"0",	"1",	"3",	"0",	"Tajo abierto en el costado. Cae inconsciente y muere en 3 asaltos debido a da�os masivos en �rganos internos."};
	private static String[] FT2_ROWS_101_106 = 		{"10",		"8",	"10-H",	"4",	"0",	"0",	"0",	"0",	"0",	"0",	"Grave herida en el abdomen- -10 PV. Pierde 8 PV m�s cada asalto. -10 a la actividad. Aturdido durante 4 asaltos."};
	private static String[] FT2_ROWS_107_109 = 		{"0",		"15",	"0",	"0",	"0",	"1",	"0",	"1",	"0",	"0",	"El brazo que esgrim�a el arma queda cercenado. -15 PV por asalto. Cae inconsciente inmediatemente."};
	private static String[] FT2_ROWS_110 = 			{"0",		"0",	"0",	"0",	"0",	"0",	"1",	"0",	"0",	"0",	"Coraz�n empalado. Muere instant�neamente, el coraz�n destrozado. 25% de que el arma se quede atascada en el enemigo durante 3 asaltos."};
	private static String[] FT2_ROWS_111_116 = 		{"0",		"12",	"0",	"6",	"0",	"1",	"0",	"0",	"0",	"0",	"Mano cercenada. 12 PV por asalto. Cae al suelo y queda aturdido 6 asaltos."};
	private static String[] FT2_ROWS_117_119 = 		{"20",		"0",	"0",	"0",	"0",	"0",	"0",	"1",	"0",	"0",	"Tajo en la espina dorsal. Colapso inmediato. Paralizado desde el cuello para abajo, permanentemente. -20 PV."};
	private static String[] FT2_ROWS_120 = 			{"0",		"0",	"0",	"0",	"0",	"0",	"1",	"0",	"0",	"0",	"Un tajo en la cabeza destruye el cerebro, lo que hace dificil que el pobre infeliz siga con vida . Cae fulminado."};
	
	
	/*FT2 PROJECTILE TABLE*/
	public static String[][] FT2 = 
		{      
			FT2_ROWS_MINUS49_05,
			FT2_ROWS_06_20,
			FT2_ROWS_21_35, 
			FT2_ROWS_36_50, 
			FT2_ROWS_51_65, 
			FT2_ROWS_66_79, 
			FT2_ROWS_80, 
			FT2_ROWS_81_86,
			FT2_ROWS_87_89, 
			FT2_ROWS_90, 
			FT2_ROWS_91_96, 
			FT2_ROWS_97_99, 
			FT2_ROWS_100,
			FT2_ROWS_101_106,
			FT2_ROWS_107_109,
			FT2_ROWS_110,
			FT2_ROWS_111_116,
			FT2_ROWS_117_119,
			FT2_ROWS_120
		};
	
	
	
	public static String[][] getFT1() {
		return FT1;
	}


	public static String[][] getFT2() {
		return FT2;
	}


	public static String[] getTableValue(String botchType, int botchRoll) {
		Method method;
		String tableMethod = "";
		String[] botch_row = null;
		String botchTable = "";
		try {
			
			if(botchType.equals("PROJECTILE")){
				tableMethod = "getFT2";
				botchTable = "FT2";
			}else if(botchType.equals("SPELL")){
				
			}else if(botchType.equals("WEAPON")){
				tableMethod = "getFT1";
				botchTable = "FT1";
			}else if(botchType.equals("MANEUVER")){
				
			}
			

			System.out.println("Consultando Tabla de Pifia "+botchType+" : "+botchTable);
			method = Tables_Botch.class.getDeclaredMethod(tableMethod);
			String[][] table = (String[][]) method.invoke(null);
			botch_row = table[checkCritRow(botchRoll)];
			
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
		
		return botch_row;
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
