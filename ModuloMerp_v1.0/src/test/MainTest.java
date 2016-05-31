package test;

import beans.Race;
import beans.Skill;
import beans.WeaponItem;
import cache.Cache;
import utils.ReadProperties;

import java.util.HashMap;
import java.util.Map;

import beans.ArmourItem;
import beans.Attribute;
import beans.Character;
import beans.Item;
import beans.Profession;

public class MainTest {

	public static void main(String[] args) {

		//Fixed configurations from property files
		initConfigurations();
		
		Attribute.changeRuleCharismaBeneficiedByAppearance(false);
		
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
		int life = 24;
		
		//Lectura Equipo en uso
		Map<Integer, Item> equippedGear = new HashMap<Integer, Item>();
		
		//Lectura de equipamiento en el Excel
		//Identificada arma de uso, extraer la de la plantilla y clonarla
		WeaponItem scimitarHighQuality = (WeaponItem)Cache.weaponItems.get(WeaponItem.SCIMITAR).clone();
		//Aplicar modificaciones adicionales respecto de la plantilla
		/*Dos formas de hacer lo mismo (¿Quitar la primera o dejarla para cosas especiales(ver)?)*/
		//scimitarHighQuality.setSpecialMod1(10);
		scimitarHighQuality.getSkillMods()[Skill.EDGED] = 10;
		scimitarHighQuality.setName("Silver Scimitar");
		equippedGear.put(Item.WEAPON_1, scimitarHighQuality);
		
		equippedGear.put(Item.ARMOUR, Cache.armourItems.get(ArmourItem.RIGID_LEATHER).clone());
		equippedGear.put(Item.SHIELD, Cache.armourItems.get(ArmourItem.MEDIUM_SHIELD).clone());
		//equippedGear.put(Item.BRACERS, Cache.armourItems.get(ArmourItem.METAL_BRACERS).clone());
		//equippedGear.put(Item.GREAVES, Cache.armourItems.get(ArmourItem.METAL_GREAVERS).clone());
		//equippedGear.put(Item.HELMET, Cache.armourItems.get(ArmourItem.METAL_HELMET).clone());
	
		/**TODO Los casos donde un arma puede usarse de dos formas:
		 * Por defecto se usará lo que viene en el .properties en su categoria
		 * Bastard Sword and Double Axe : Por defecto (EDGED - 1 HAND)
		 * DAGGER, AXE : Por defecto (EDGED - 1 HAND) 
		 * 
		 * Modificable en el Combate
		 * */

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
		
		Character Galadhil = new Character(name, player, lvl, PX, raceIn, cultureIn, professionIn, equippedGear
				,str, agi, con, inte, i, car, ap, life, magicalDomainChoosen, skillGrades ,specialSkillModi);
		
		Galadhil.show();

	}

	private static void initConfigurations() {
		ReadProperties.readWeaponFile();
		ReadProperties.readArmourFile();
	}

	
}
