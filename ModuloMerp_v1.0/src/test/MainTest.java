package test;

import beans.Race;
import beans.Skill;
import beans.WeaponItem;
import cache.Cache;
import utils.ReadProperties;
import utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.lang.String;

import beans.ArmourItem;
import beans.Attribute;
import beans.Character;
import beans.Item;
import beans.Profession;

public class MainTest {

	public static void main(String[] args) {

		//Fixed configurations from property files
		Utils.initConfigurations();
		
		Map<String, Character> pjs = new HashMap<String, Character>();
		Map<String, Character> pnjs = new HashMap<String, Character>();
		
		Attribute.changeRuleCharismaBeneficiedByAppearance(false);
		
		Character Galadhil = Utils.readCharSheet(1);
		//Galadhil.getLife().lifePointsLost(10);
		pjs.put(Galadhil.getName(), Galadhil);
		//Galadhil.show();
		
		Character OrcALvL1 =  Utils.readCharSheet(2);
		pnjs.put(OrcALvL1.getName(), OrcALvL1);
		//OrcALvL1.show();
		
		menu(pjs,pnjs);

	}

	private static void menu(Map<String, Character> pjs, Map<String, Character> pnjs ) {
		String entradaTeclado = "";
		do{
			System.out.println("\n"
					+ "***********************************************"
					+ "\n****************** MENU  **********************"
					+ "\n***********************************************");
			
			System.out.println("PJs:\n");
			int i = 0;
			for (Map.Entry<String, Character> entry : pjs.entrySet()) {
				//String key = entry.getKey();
				i++;
				Character character = entry.getValue();
				System.out.println("\t"+ i + ". "+character.getName());
			}
			i=0;
			System.out.println("PNJs:\n");
			for (Map.Entry<String, Character> entry : pnjs.entrySet()) {
				//String key = entry.getKey();
				i++;
				Character character = entry.getValue();
				System.out.println("\t"+ i + ". "+character.getName());
			}
			
			System.out.println("\nChoose Option:  \n"
					+ "\n\t1. Combat"
					+ "\n\t2. Show All\n\n\t0. Exit");
			

	        entradaTeclado = Utils.readFromInputLine();
	        
	        if(entradaTeclado.trim().equals("1")){
	        
	        }else if(entradaTeclado.trim().equals("2")){
	        	for (Map.Entry<String, Character> entry : pjs.entrySet()) {
					//String key = entry.getKey();
					Character character = entry.getValue();
					character.show();
				}
	        	for (Map.Entry<String, Character> entry : pnjs.entrySet()) {
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

	
}
