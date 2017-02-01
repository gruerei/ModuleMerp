package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import beans.Character;
import beans.CriticalOutcome;
import beans.combat.Attack;
import beans.combat.AttackMelee;
import utils.Utils;

public class WeaponTypesTest {
	static boolean inititatedConfigs = false;
	static Character Galadhil = null;
	static Character OrcALvL1 = null;
	static int diceRoll = 0;
	static int parryBonus = 0;
	static int otherBonus = 0;
	
	
	@BeforeClass 
    public static void setUpBeforeClass() {
			Utils.initConfigurations();
			Galadhil = Utils.readCharSheet(1);
			OrcALvL1 = Utils.readCharSheet(2);
			inititatedConfigs = true;
    }
	
	@Test
	public void a1test1() {
		diceRoll = 50;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
		//assertEquals("14-C", attack.getOutcome().getTableAttackRoll());
		
	}
	
	@Test
	public void a2testShow() {
		
		//OrcALvL1.showCombatStatus();
		Galadhil.show();
	}
}
