package test;

import beans.Race;
import beans.Skill;

import java.util.HashMap;
import java.util.Map;

import beans.Attribute;
import beans.Character;
import beans.Item;
import beans.Profession;

public class MainTest {

	public static void main(String[] args) {
		/*int grades = 13;
		int modifGrades = 0;
		
		int ten_grades = 10;
		modifGrades = modifGrades + (ten_grades * 5);
		modifGrades = modifGrades + (grades - ten_grades) * 2;
		
		/*modifGrades = 50 + 6 = 56*/
		/*System.out.println("modifGrades: "+modifGrades);*/
		
		String name = "Galadhil";
		String player = "PlayerTest";
		int PX = 10000;
		int lvl = 1;
		
		int str = 98, agi = 91, con = 90; 
		int inte = 44, i = 85, car = 63;
		int ap =77;
		
		String raceIn = "Dunedain";
		String cultureIn = "";
		String professionIn = "Ranger";
		Map<String, Item> equippedGear = new HashMap<String, Item>();
		String magicalDomainChoosen = "";
		int[] skillGrades = new int[Skill.SKILLS_TOTAL_NUMBER];
		int[][] specialSkillModi = new int[Skill.SKILLS_TOTAL_NUMBER][2];
		
		Character Galadhil = new Character(name, player, lvl, PX, raceIn, cultureIn, professionIn, equippedGear
				,str, agi, con, inte, i, car, ap, magicalDomainChoosen, skillGrades ,specialSkillModi);
		
		Galadhil.show();
	}

}
