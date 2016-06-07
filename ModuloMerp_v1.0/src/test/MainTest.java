package test;

import beans.Race;
import beans.Skill;
import beans.WeaponItem;
import cache.Cache;
import utils.ReadProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.lang.String;

import beans.ArmourItem;
import beans.Attribute;
import beans.Character;
import beans.Combat;
import beans.Item;
import beans.Profession;

public class MainTest {

	public static void main(String[] args) {

		//Fixed configurations from property files
		initConfigurations();
		
		Map<String, Character> characters = new HashMap<String, Character>();
		
		Attribute.changeRuleCharismaBeneficiedByAppearance(false);
		
		Character Galadhil = readCharSheet(1);
		//Galadhil.getLife().lifePointsLost(10);
		characters.put(Galadhil.getName(), Galadhil);
		//Galadhil.show();
		
		Character OrcALvL1 =  readCharSheet(2);
		characters.put(OrcALvL1.getName(), OrcALvL1);
		//OrcALvL1.show();
		
		menu(characters);

	}

	private static void menu(Map<String, Character> characters) {
		String entradaTeclado = "";
		do{
			System.out.println("\n"
					+ "***********************************************"
					+ "\n****************** MENU  **********************"
					+ "\n***********************************************");
			
			System.out.println("Characters:\n");
			int i = 0;
			for (Map.Entry<String, Character> entry : characters.entrySet()) {
				//String key = entry.getKey();
				i++;
				Character character = entry.getValue();
				System.out.println("\t"+ i + ". "+character.getName());
			}
			
			System.out.println("\nChoose Option:  \n"
					+ "\n\t1. Show All\n\n\t0. Exit");
			
			Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
	        entradaTeclado = entradaEscaner.nextLine(); //Invocamos un método sobre un objeto Scanner
	        
	        if(entradaTeclado.trim().equals("1")){
	        	for (Map.Entry<String, Character> entry : characters.entrySet()) {
					//String key = entry.getKey();
					Character character = entry.getValue();
					character.show();
				}
	        }
	        
			
			
			//Combat combat = new Combat(characters);
		}
		while(!entradaTeclado.equals("0"));
		
		System.out.println("EXIT");
		
	}


	private static Character readCharSheet(int sheetNumber) {

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
			broadSworHighQuality.setName("Silver BroadSword");
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
			
			System.out.println(" Creado Personaje Galadhil ");
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
			
			System.out.println(" Creado PNJ Orco ");
		}
		
		return character;
		
	}

	private static void initConfigurations() {
		ReadProperties.readWeaponFile();
		ReadProperties.readArmourFile();
	}

	
}
