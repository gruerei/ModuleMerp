package test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import beans.Character;
import beans.CombatStatus;
import beans.combat.Attack;
import beans.combat.AttackMelee;
import beans.combat.AttackOutcome;
import utils.Utils;
import utils.Tables.Tables;
import utils.Tables.Tables_AT;
import utils.Tables.Tables_Crit;

public class CritTest {

	static boolean inititatedConfigs = false;
	static Character Galadhil = null;
	static Character OrcALvL1 = null;
	
	@BeforeClass 
    public static void setUpBeforeClass() {
			Utils.initConfigurations();
			Galadhil = Utils.readCharSheet(1);
			OrcALvL1 = Utils.readCharSheet(2);
			inititatedConfigs = true;
    }
	
	@Test
	public void testStunned() {
	
		Galadhil.setStunned(new CombatStatus(CombatStatus.STUNNED, 0));;
		Galadhil.getStunned().setAssaultsLeft(2);
		Galadhil.showCombatStatus();
		
		Galadhil.assaultDecrement();
		Galadhil.assaultDecrement();
		Galadhil.showCombatStatus();
	}
	
	@Test
	public void testUnconscious() {

		Galadhil.setKnockedOut(new CombatStatus(CombatStatus.KNOCKED_OUT, CombatStatus.KNOCKED_OUT_ASSAULTS));;
		Galadhil.getKnockedOut().setAssaultsLeft(2);
		Galadhil.showCombatStatus();
		
		Galadhil.assaultDecrement();
		Galadhil.assaultDecrement();
		Galadhil.showCombatStatus();
	}
	
	@Test
	public void testUnconsciousAndDeadByAssaults() {
		Galadhil.lifePointsLost(51);
		Galadhil.getDead().setAssaultsLeft(1);
		Galadhil.showCombatStatus();
		Galadhil.assaultDecrement();
		Galadhil.showCombatStatus();
	}
	
	@Test
	public void testActivityAssaults() {
		
		CombatStatus activ = new CombatStatus(CombatStatus.ACTIVITY,CombatStatus.ACTIVITY_ASSAULTS);
		OrcALvL1.setActivity(activ);
		OrcALvL1.getActivity().setActivityModif(-10);
		OrcALvL1.getActivity().setAssaultsLeft(2);
				
		OrcALvL1.showCombatStatus();
		OrcALvL1.assaultDecrement();
		OrcALvL1.assaultDecrement();
		OrcALvL1.showCombatStatus();
	}
	
	@Test
	public void showCombatStatus() {

		//OrcALvL1.showCombatStatus();
		//OrcALvL1.showCombatStatus();
		
		//Galadhil.show();
		//OrcALvL1.show();
		assertTrue(true);
	}
	
	@Test
	public void testLifePointsProtection() {
		String critLifePoints = "NP8-5";
		String[] split = critLifePoints.split("-");
		String lifePointsNoProtection = split[0].replace("NP", "");
		assertEquals(lifePointsNoProtection, "8");
	}
	
	@Test
	public void testCrit1() {
		int diceRoll = 78;
		int parryBonus = 10;OrcALvL1.setParryBonusInUse(10);
		int otherBonus = 0;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		assertEquals("14-C", attack.getOutcome().getTableAttackRoll());
		assertEquals("Herida leve en el pecho. -3 PV. 1 PV por asalto. -5 a la actividad.",
				attack.getOutcome().getMainCriticalOutcome().getCritDescription());
		//assertEquals();
	}
	
	
	@Test
	public void testCrit2()  {
			int diceRoll = 78;
			int parryBonus = 10;OrcALvL1.setParryBonusInUse(10);
			int otherBonus = 0;
			String otherBonusDescription = "";
			int attackCategory = Attack.EDGED;
			Galadhil.getActivity().setActivityModif(-10);
			
			Attack attack = new AttackMelee(Galadhil , diceRoll, OrcALvL1 , parryBonus, otherBonus, otherBonusDescription, attackCategory);
			assertEquals("12-B", attack.getOutcome().getTableAttackRoll());
			assertEquals("Herida leve en el pecho. -3 PV. 1 PV por asalto. -5 a la actividad.",
					attack.getOutcome().getMainCriticalOutcome().getCritDescription());
			
			//Galadhil BD:25 BO: 47
			//Orc BD:10 BO:27
			//110+17-25-15 = 87
		
	
	}
	
	@Test
	public void testCrit3() {
		int diceRoll = 110;
		int parryBonus = 15;Galadhil.setParryBonusInUse(15);
		int otherBonus = 0;
		String otherBonusDescription = "";
		int attackCategory = Attack.CONCUSSION;
		
		Attack attack = new AttackMelee(OrcALvL1, diceRoll, Galadhil , parryBonus, otherBonus, otherBonusDescription, attackCategory);
		assertEquals("7-A", attack.getOutcome().getTableAttackRoll());
		assertEquals("Golpe en un costado. -4 PV, -40 a la actividad durante 1 asalto.",
				attack.getOutcome().getMainCriticalOutcome().getCritDescription());
		//Galadhil BD:25 BO: 47
		//Orc BD:10 BO:27
		//110+17-25-15 = 87
	}
	
	@Test
	public void testCrit4() {
		int diceRoll = 110;
		int parryBonus = 15;Galadhil.setParryBonusInUse(15);
		int otherBonus = 0;
		String otherBonusDescription = "";
		int attackCategory = Attack.CONCUSSION;
		OrcALvL1.getActivity().setActivityModif(-10);
		
		Attack attack = new AttackMelee(OrcALvL1, diceRoll, Galadhil , parryBonus, otherBonus, otherBonusDescription, attackCategory);
		assertEquals("4", attack.getOutcome().getTableAttackRoll());

	}
	
	
	
	
	@Test
	public void testArrayReflection() {
		Method method;
		String tableMethod = "";
		String critType = "SLASH";
		int critRoll = 68;
		
		try {
			
			if(critType.equals("SLASH")){
				tableMethod = "getCT2";
			}else if(critType.equals("PUNCTURE")){
				
			}else if(critType.equals("CRUNCH")){
				tableMethod = "getCT1";
			}else if(critType.equals("GRAPPLE")){
				
			}else if(critType.equals("UNBALANCING")){
				
			}
			method = Tables_Crit.class.getDeclaredMethod(tableMethod);
			String[][] table = (String[][]) method.invoke(null);
			String[] crit_row = table[Tables_Crit.checkCritRow(critRoll)];
			System.out.println("");
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
		}
	}

}
