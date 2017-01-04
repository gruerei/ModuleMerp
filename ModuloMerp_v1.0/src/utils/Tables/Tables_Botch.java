package utils.Tables;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import beans.Critical;

public class Tables_Botch {
	
	public static int COL_LIFE_POINTS = 0;
	public static int COL_LIFE_POINTS_PER_ASSAULT = 1;
	public static int COL_MALUS_ACTIVITY = 2;
	public static int COL_STUNNED_ASSAULTS = 3;
	public static int COL_TEAR_ITEM= 4;
	public static int COL_CAUSE_BODY_DISABILITY= 5;
	public static int COL_CAUSE_CRIT= 6;
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
	private static String[] FT1_ROWS_MINUS49_05 = 	{"0",		"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Pierdes el control. No haces nada más este asalto."};
	private static String[] FT1_ROWS_06_20 =		{"0",		"0",	"0",	"0",	"1?",	"0",	"0",	"0",	"0",	"0",	"Resbalas. Si tu arma se maneja con una sola mano y no es mágica, se rompe."};
	private static String[] FT1_ROWS_21_35 = 		{"2",		"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Mala continuación, pierdes tu oportunidad y 2 puntos de vida."};
	private static String[] FT1_ROWS_36_50 = 		{"0",		"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Se te cae el arma. Tardarás 1 asalto en desenvainar otra o 2 asaltos en recuperar la que ha caido."};
	private static String[] FT1_ROWS_51_65 = 		{"0",		"0",	"40-2A","0",	"0",	"0",	"0",	"0",	"0",	"0",	"Pierdes el hilo y te das cuenta de que deberias relajarte. -40 a la actividad durante dos asaltos"};
	private static String[] FT1_ROWS_66_79 = 		{"0",		"0",	"0",	"2",	"0",	"0",	"0",	"0",	"0",	"0",	"Tropiezas. Semejante demostración de falta de estilo te deja aturdido durante dos asaltos. Con suerte, sobrevivirás."};
	private static String[] FT1_ROWS_80 = 			{"0",		"0",	"0",	"0",	"1?",	"0",	"B",	"0",	"0",	"0",	"Movimiento increiblemente inepto. Te haces a ti mismo un Crítico 'B'. (Tira en la tabla corresp.). Si el oponente está usando un arma de tajo, tu arma se rompe."};
	private static String[] FT1_ROWS_81_86 = 		{"0",		"0",	"0",	"2",	"0",	"0",	"0",	"0",	"0",	"0",	"Con los nervios te muerdes la lengua. Aturdido durante 2 asaltos."};
	private static String[] FT1_ROWS_87_89 = 		{"0",		"0",	"0",	"3",	"0",	"0",	"0",	"0",	"0",	"0",	"Pierdes el control del arma y de la realidad. Aturdido 3 asaltos."};
	private static String[] FT1_ROWS_90 = 			{"0",		"0",	"0",	"0",	"1",	"0",	"C",	"0",	"0",	"0",	"Mala maniobra. Intentas automutilarte al tiempo que tu arma se rompe. Te haces un critico de 'C' (tira en al tabla corresp.)"};
	private static String[] FT1_ROWS_91_96 =		{"0",		"0",	"0",	"0",	"0",	"0",	"CR-B*","0",	"0",	"0",	"Increible tu forma de esgrimir el arma. Cualquier combatiente de tu bando cercano, recibe un critico 'B' de aplastamiento."};
	private static String[] FT1_ROWS_97_99 = 		{"0",		"0",	"0",	"3",	"0",	"0",	"0",	"0",	"0",	"0",	"Tropiezas con una imaginaria, e invisible, tortuga fenecida. Quedas bastante confundido. Aturdido 3 asaltos."};
	private static String[] FT1_ROWS_100 = 			{"0",		"0",	"60-30A","0",	"0",	"0",	"0",	"0",	"0",	"0",	"El peor movimiento visto en años. -60 a la actividad por un tirón en la ingle. El enemigo queda aturdido 2 asaltos, muerto de risa."};
	private static String[] FT1_ROWS_101_106 = 		{"0",		"0",	"0",	"3",	"1?",	"0",	"0",	"0",	"0",	"0",	"Te tambaleas y te caes en un aparente intento de suicidio. Quedas aturdido 3 asaltos. Si usas un arma de asta, se rompe el mango."};
	private static String[] FT1_ROWS_107_109 = 		{"0",		"0",	"0",	"4",	"1",	"0",	"0",	"0",	"0",	"0",	"Rompes tu arma por inepto. Quedas aturdido 4 asaltos"};
	private static String[] FT1_ROWS_110 = 			{"0",		"0",	"0",	"5",	"0",	"0",	"CR-C?","0",	"0",	"0",	"Tropiezas y claves la punta de tu arma en el suelo. Aturdido 5 asaltos. Si estas montado, tu arma de asta te hace saltar 9 metros y Recibes un crítico 'C' de aplastamiento."};
	private static String[] FT1_ROWS_111_116 = 		{"0",		"0",	"0",	"3",	"0",	"0",	"0",	"0",	"0",	"0",	"Tu montura se encabrita súbitamente. Aturdido 3 asaltos recuperándote."};
	private static String[] FT1_ROWS_117_119 = 		{"0",		"0",	"90-3A","0",	"0",	"0",	"0",	"0",	"0",	"0",	"No coordinas tus movimientos con los de tu montura. -90 a la actividad los siguientes 3 asaltos mientras intentas seguir siendo el jinete."};
	private static String[] FT1_ROWS_120 = 			{"0",		"0",	"0",	"0",	"0",	"0",	"CD-D",	"0",	"0",	"0",	"Te caes de tu montura, te haces un crítico 'D' de aplastamiento."};

	
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
	
	/*FT2 - PROJECTILE ROWS							LIFE		ASSAUL	ACTIV	ASSAUL	ITEM	CAUSE	CAUSE	CAUSE	ASSAUL	ITEM	ADDITIONAL*/
	/*       							     		POINTS		LIFEPT	MALUS	STUNN	TEAR	BDYDIS	CRIT	UNCON	DEATH	PROTEC	DESCRIPTION*/
	private static String[] FT2_ROWS_MINUS49_05 = 	{"0",		"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Pierdes el control. No haces nada más este asalto."};
	private static String[] FT2_ROWS_06_20 = 		{"0",		"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Eres tan manazas que no aciertas a recargar. Pierdes este asalto."};
	private static String[] FT2_ROWS_21_35 = 		{"0",		"0",	"50-1A","0",	"0",	"0",	"0",	"0",	"0",	"0",	"Pifia con la munición. Pierdes este asalto y -50 a la actividad en el siguiente."};
	private static String[] FT2_ROWS_36_50 = 		{"0",		"0",	"30-3A","0",	"0",	"0",	"0",	"0",	"0",	"0",	"Se te rompe la munición y pierdes la serenidad. Te encuentras con -30 a la actividad durante 3 asaltos."};
	private static String[] FT2_ROWS_51_65 = 		{"0",		"0",	"0",	"1",	"0",	"0",	"0",	"0",	"0",	"0",	"Se te cae la munición. Aturdido este asalto y el siguiente intentando decidir si la recuperas."};
	private static String[] FT2_ROWS_66_79 = 		{"0",		"0",	"0",	"2",	"0",	"0",	"0",	"0",	"0",	"0",	"Realmente te estás haciendo un lío con el arma. Aturdido durante 2 asaltos."};
	private static String[] FT2_ROWS_80 = 			{"5",		"2?",	"0",	"0",	"0",	"7?",	"0",	"0",	"0",	"0",	"Falta de criterio. Pierdes 5 PV. Si no estás usando una ballesta, se te escapa una flecha, te arrancas una oreja y pierdes 2 PV por asalto."};
	private static String[] FT2_ROWS_81_86 = 		{"0",		"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Se te rompe la cuerda de tu arma. Tardarás 2 asaltos en sacar una nueva."};
	private static String[] FT2_ROWS_87_89 = 		{"0",		"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Pifia con la munición cuando recargabas. Esparces tu munición en una superficie de 3 metros de radio."};
	private static String[] FT2_ROWS_90 = 			{"0",		"0",	"0",	"4",	"1",	"0",	"0",	"0",	"0",	"0",	"Tu arma se hace añicos. Quedas aturdido durante 4 asaltos de combate. Que tengas suerte chaval."};
	private static String[] FT2_ROWS_91_96 = 		{"0",		"0",	"30-3A","0",	"0",	"0",	"0",	"0",	"0",	"0",	"Disparas tu flecha demasiado pronto. Se queda 6 mts corta en su trayectoria. Estás a -30 de actividad los siguientes tres asaltos por la falta de confianza."};
	private static String[] FT2_ROWS_97_99 = 		{"0",		"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Pareces pensar que tu arco es una batuta. Se te resbala y al intentar recogerlo, va a parar a un metro y medio delante de ti."};
	private static String[] FT2_ROWS_100 = 			{"5",		"0",	"0",	"0",	"0",	"1",	"0",	"0",	"0",	"0",	"Se te resbala la munición al ir a disparar. El proyectil te atraviesa la mano. La mano queda inutilizada. Pierdes 5 PV."};
	private static String[] FT2_ROWS_101_106 = 		{"0",		"0",	"0",	"5",	"0",	"0",	"0",	"0",	"0",	"0",	"Resbalas y caes al suelo. Tu disparo se pierde. Aturdido 5 asaltos."};
	private static String[] FT2_ROWS_107_109 = 		{"5",		"0",	"20-H",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Las plumas del proyectil te arañan el ojo al disparar. Pierdes 5 puntos de vida. - 20 a la actividad."};
	private static String[] FT2_ROWS_110 = 			{"0",		"0",	"0",	"0",	"1",	"0",	"PU-A*","0",	"0",	"0",	"La punta del arma se engancha en el objeto más proximo y se rompe. Si es aplicable, el objeto recibe un crítico A de perforación."};
	private static String[] FT2_ROWS_111_116 = 		{"0",		"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"0",	"Se dispara el seguro cuando estás alzando tu arma. Haz un ataque sin modificadores sobre el combatiente más próximo."};
	private static String[] FT2_ROWS_117_119 = 		{"20",		"0",	"0",	"0",	"0",	"0",	"0",	"1",	"0",	"0",	"Mientras soñabas despierto, pusiste la mano delante del virote en el momento del disparo. Pierdes un dedo y 4 PV. Luego sigues perdiendo 2 PV por asalto."};
	private static String[] FT2_ROWS_120 = 			{"0",		"0",	"0",	"0",	"0",	"0",	"1",	"0",	"0",	"0",	"Resbalas y te clavas un pie al suelo con un virote. Pierdes 10 PV. Luego 2 PV más por asalto. -30 a la actividad y aturdido dos asaltos."};
	
	
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
