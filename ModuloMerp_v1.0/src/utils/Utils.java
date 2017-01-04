package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.annotation.Generated;

import beans.ArmourItem;
import beans.Character;
import beans.Item;
import beans.Skill;
import beans.WeaponItem;
import cache.Cache;
import utils.Tables.Tables; 

public class Utils {

	
	public static final String PROPERTIES_MAIN_SEPARATOR = ",";
	public static final String PROPERTIES_SECONDARY_SEPARATOR = "-";
	private static Scanner scanner = null;
	
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
	
	public static boolean castToBoolean(String chain){
		boolean ret = false;
		
		if(chain != null && !chain.isEmpty())
			if(chain.equals("1"))
				ret = true;
		
		return ret;
	}
	
	public static String printTable(Object[] objs){
		
		StringBuffer ret = new StringBuffer("");
		
		if(objs != null){
		
			for(int i = 0; i < objs.length ; ret.append(" "), i++){
				
				if(objs instanceof Integer[]){
					ret.append(Tables.getSkillCategoryTable()[(Integer)objs[i]][0]);
				}else if(objs instanceof String[]){
					ret.append(objs[i]);
				}
				
			}
			
		}
		
		return ret.toString();
		
	}
	
	public static String readFromInputLine(){
		if(scanner == null){
			scanner = new Scanner (System.in); //Creación de un objeto Scanner
		}
        return scanner.nextLine(); //Invocamos un método sobre un objeto Scanner
	}
	
	public static Character readCharSheet(int sheetNumber) {

		Character character = null;
		
		if(sheetNumber == 1){
			//Lectura Basicos
			String name = "Galadhil";
			String player = "PlayerTest";
			String raceIn = "Dunedain";
			String cultureIn = "";
			String professionIn = "Ranger";
			String magicalDomainChoosen = "";
			int PX = 10000;
			int lvl = 1;
			
			//Lectura de Atributos
			int str = 98, agi = 91, con = 90; 
			int inte = 44, i = 85, car = 63;
			int ap =77;
			int life = 25;
			//Adol: 3 | Prof: 2
			
			//Lectura Equipo en uso
			Map<Integer, Item> equippedGear = new HashMap<Integer, Item>();
			
			//Identificada arma de uso, extraer la de la plantilla y clonarla
			WeaponItem broadSworHighQuality = (WeaponItem)Cache.weaponItems.get(WeaponItem.BROADSWORD).clone();
			//Aplicar modificaciones adicionales respecto de la plantilla
			/*Dos formas de hacer lo mismo (¿Quitar la primera o dejarla para cosas especiales(ver)?)*/
			//scimitarHighQuality.setSpecialMod1(10);
			broadSworHighQuality.getSkillMods()[Skill.EDGED] = 10;
			broadSworHighQuality.setName("Silver Broadsword");
			equippedGear.put(Item.WEAPON_1, broadSworHighQuality);
			
			equippedGear.put(Item.ARMOUR, Cache.armourItems.get(ArmourItem.RIGID_LEATHER).clone());
			equippedGear.put(Item.SHIELD, Cache.armourItems.get(ArmourItem.MEDIUM_SHIELD).clone());
			//equippedGear.put(Item.BRACERS, Cache.armourItems.get(ArmourItem.METAL_BRACERS).clone());
			//equippedGear.put(Item.GREAVES, Cache.armourItems.get(ArmourItem.METAL_GREAVERS).clone());
			//equippedGear.put(Item.HELMET, Cache.armourItems.get(ArmourItem.METAL_HELMET).clone());

			//Lectura Habilidades
			int[] skillGrades = new int[Skill.SKILLS_TOTAL_NUMBER];
			int[][] specialSkillModi = new int[Skill.SKILLS_TOTAL_NUMBER][2];

			skillGrades[Skill.NO_ARMOR] = 1; skillGrades[Skill.RIGID_LEATHER] = 3; skillGrades[Skill.CHAIN] = 2;
			skillGrades[Skill.EDGED] = 4; skillGrades[Skill.TWO_HANDED] = 1; skillGrades[Skill.PROJECTILE] = 1; skillGrades[Skill.POLEARM] = 1;
			skillGrades[Skill.CLIMB] = 1; skillGrades[Skill.RIDE] = 1;skillGrades[Skill.SWIM] = 1;skillGrades[Skill.TRACK] = 1;
			skillGrades[Skill.STALK_HIDE] = 1;skillGrades[Skill.DISARM_TRAP] = 1;
			skillGrades[Skill.READ_RUNES] = 1;skillGrades[Skill.USE_MAG_ITEM] = 1;
			skillGrades[Skill.PERCEPTION] = 1;skillGrades[Skill.BODY_DEVELOPMENT] = 5;
			skillGrades[Skill.CAVE_KNOWL] = 5;
			
			specialSkillModi[Skill.TRACK][Skill.SPECIAL1] = 10; specialSkillModi[Skill.PERCEPTION][Skill.SPECIAL1] = 10;
			
			
			character = new Character(name, player, lvl, PX, raceIn, cultureIn, professionIn, equippedGear
					,str, agi, con, inte, i, car, ap, life, magicalDomainChoosen, skillGrades ,specialSkillModi);
			
			/*Aqui habria que leer y aplicar la actividad(y modifs de tipos parecidos que no son intrinsicos a la creacion
			 * del personaje)*/
			/*Si actividad es diferente de 0*/
			//character.setActivityModif(-10);
			//character.setActivityAssaultsLeft(2);
			
			System.out.println("Creado Personaje Galadhil ");
		}
		
		if(sheetNumber == 2){
			String name = "Arukh";
			String player = "PNJ";
			String raceIn = "Orc";
			String cultureIn = "";
			String professionIn = "Barbarian";
			String magicalDomainChoosen = "";
			int PX = 10000;
			int lvl = 1;
			
			//Lectura de Atributos
			int str = 90, agi = 78, con = 80; 
			int inte = 45, i = 50, car = 40;
			int ap =42;
			int life = 20;
			//Adol: 2 | Prof: 3
			
			//Lectura Equipo en uso
			Map<Integer, Item> equippedGear = new HashMap<Integer, Item>();
			
			//Identificada arma de uso, extraer la de la plantilla y clonarla
			WeaponItem mace = (WeaponItem)Cache.weaponItems.get(WeaponItem.MACE).clone();
			equippedGear.put(Item.WEAPON_1, mace);
			
			equippedGear.put(Item.ARMOUR, Cache.armourItems.get(ArmourItem.SOFT_LEATHER).clone());
			equippedGear.put(Item.SHIELD, Cache.armourItems.get(ArmourItem.SMALL_SHIELD).clone());
			//equippedGear.put(Item.BRACERS, Cache.armourItems.get(ArmourItem.LEATHER_BRACERS).clone());
			//equippedGear.put(Item.GREAVES, Cache.armourItems.get(ArmourItem.LEATHER_GREAVERS).clone());
			//equippedGear.put(Item.HELMET, Cache.armourItems.get(ArmourItem.LEATHER_HELMET).clone());
			
			int[] skillGrades = new int[Skill.SKILLS_TOTAL_NUMBER];
			int[][] specialSkillModi = new int[Skill.SKILLS_TOTAL_NUMBER][2];
			
			skillGrades[Skill.NO_ARMOR] = 1; skillGrades[Skill.SOFT_LEATHER] = 2;skillGrades[Skill.RIGID_LEATHER] = 3; skillGrades[Skill.CHAIN] = 2;
			skillGrades[Skill.CONCUSSION] = 3; skillGrades[Skill.EDGED] = 1; skillGrades[Skill.TWO_HANDED] = 1; skillGrades[Skill.THROWN] = 1; skillGrades[Skill.PROJECTILE] = 1; skillGrades[Skill.POLEARM] = 1;
			skillGrades[Skill.CLIMB] = 3;
			skillGrades[Skill.TRACK] = 2;
			skillGrades[Skill.AMBUSH] = 1;
			skillGrades[Skill.PERCEPTION] = 1;
			skillGrades[Skill.BODY_DEVELOPMENT] = 4;
			
			character = new Character(name, player, lvl, PX, raceIn, cultureIn, professionIn, equippedGear
					,str, agi, con, inte, i, car, ap, life, magicalDomainChoosen, skillGrades ,specialSkillModi);
			
			//character.setActivityModif(-5);
			
			System.out.println("Creado PNJ Orco ");
		}
		
		return character;
		
	}

	public static void initConfigurations() {
		ReadProperties.readWeaponFile();
		ReadProperties.readArmourFile();
		ReadProperties.readCombatFile();
	}

	
}
