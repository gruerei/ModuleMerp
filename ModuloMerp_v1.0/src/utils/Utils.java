package utils;

public class Utils {

	public static final String PROPERTIES_MAIN_SEPARATOR = ",";
	public static final String PROPERTIES_SECONDARY_SEPARATOR = "-";
	
	/*Devuelve numero de PP segun el attributo de entrada*/
	public static int getPPbyAttrib(int value){
		int pp = 0;
		
		if(value >= 75 & value < 90 ){
			pp = 1;
		}else if(value >= 90 & value < 95 ){
			pp = 1;
		}else if(value >= 95 & value < 98 ){
			pp = 2;
		}else if(value >= 98 & value < 100 ){
			pp = 2;
		}else if(value == 100 ){
			pp = 3;
		}if(value == 101 ){
			pp = 3;
		}if(value >= 102 ){
			pp = 4;
		}
		return pp;
	}
	
	public static String padRight(String s, int n) {
	     return String.format("%1$-" + n + "s", s);  
	}
	
	public static String padLeft(String s, int n) {
	     return String.format("%1$" + n + "s", s);  
	}
	
	
	public static String blankIfNull(String chain){
		if(chain == null){
			return "";
		}else {
			return chain;
		}
	}
	
	public static int castToInt(String chain){
		if(chain != null && !chain.isEmpty()){
			return Integer.parseInt(chain);
		}else
			return 0;
	}
	
	public static float castToFloat(String chain){
		if(chain != null && !chain.isEmpty()){
			return Float.parseFloat(chain);
		}else
			return 0;
	}
	
}
