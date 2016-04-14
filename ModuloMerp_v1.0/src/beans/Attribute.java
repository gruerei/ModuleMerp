package beans;

public class Attribute {
	
	public static final String STRENTGTH  = "STRENTGTH";
	public static final String AGILITY = "AGILITY";
	public static final String CONSTITUTION = "CONSTITUTION";
	public static final String INTELLIGENCE = "INTELLIGENCE";
	public static final String INTUITION = "INTUITION";
	public static final String CHARISMA = "CHARISMA";
	public static final String APPEARANCE = "APPEARANCE";
	public static final String PRESENCE = "PRESENCE";
	
	private static boolean charismaBeneficiedByAppearance = false;

	private String name;
	private int value;
	private int modifAtt;
	private int modifTotal;
	
	public Attribute(String name,int value){
		
		this.name = name;
		this.value = value;
		
		if(value == 1 ){
			modifAtt = -25;
		}else if(value == 2 ){
			modifAtt = -20;
		}else if(value >= 3 & value < 5 ){
			modifAtt = -15;
		}else if(value >= 5 & value < 10 ){
			modifAtt = -10;
		}else if(value >= 10 & value < 25 ){
			modifAtt = -5;
		}else if(value >= 25 & value < 75 ){
			modifAtt = 0;
		}else if(value >= 75 & value < 90 ){
			modifAtt = 5;
		}else if(value >= 90 & value < 95 ){
			modifAtt = 10;
		}else if(value >= 95 & value < 98 ){
			modifAtt = 15;
		}else if(value >= 98 & value < 100 ){
			modifAtt = 20;
		}else if(value == 100 ){
			modifAtt = 25;
		}if(value == 101 ){
			modifAtt = 30;
		}if(value >= 102 ){
			modifAtt = 35;
		}
	}


	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}
	
	public int getModifAtt() {
		return modifAtt;
	}

	//Normalmente la Apariencia se beneficia del carisma,
	//aquí será al revés, La apariencia beneficia al carisma/presencia.
	public static void changeRuleCharismaBeneficiedByAppearance(){
		charismaBeneficiedByAppearance  = true;
	}


	public void setModifAtt(int modifAtt) {
		this.modifAtt = modifAtt;
	}
	
	
	public void calculModifTotal(int raceModif){
		this.modifTotal = this.modifAtt + raceModif;
	}


	public int getModifTotal() {
		return modifTotal;
	}


	public static boolean isCharismaBeneficiedByAppearance() {
		return charismaBeneficiedByAppearance;
	}


	
	
}
