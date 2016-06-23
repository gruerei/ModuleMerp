package test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import beans.Character;
import beans.combat.Attack;
import beans.combat.AttackMelee;
import beans.combat.AttackOutcome;
import utils.Utils;
import utils.Tables.Tables;
import utils.Tables.Tables_AT;
import utils.Tables.Tables_Crit;

public class CritTest {

	static boolean inititatedConfigs = false;
	Character Galadhil = null;
	Character OrcALvL1 = null;
	
	@Before
    public void setUp() {
		if(!inititatedConfigs){
			Utils.initConfigurations();
			Galadhil = Utils.readCharSheet(1);
			OrcALvL1 = Utils.readCharSheet(2);
			inititatedConfigs = true;
		}
		
    }
	
	@Test
	public void testLifePointsProtection() {
		String critLifePoints = "NP8-5";
		String[] split = critLifePoints.split("-");
		String lifePointsNoProtection = split[0].replace("NP", "");
		assertEquals(lifePointsNoProtection, "8");
	}
	
	@Test
	public void testCrit() {
		int diceRoll = 78;
		int parryBonus = 0;
		int otherBonus = 0;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		assertEquals("17-C", attack.getOutcome().getTableAttackRoll());
		assertEquals("Herida leve en el pecho. -3 PV. 1 PV por asalto. -5 a la actividad.",
				attack.getOutcome().getMainCriticalOutcome().getCritDescription());
		
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
