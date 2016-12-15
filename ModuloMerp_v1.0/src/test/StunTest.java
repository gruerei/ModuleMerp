package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import beans.Character;
import beans.CombatStatus;
import beans.CriticalOutcome;
import beans.combat.Attack;
import beans.combat.AttackMelee;
import utils.Utils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StunTest {
	static boolean inititatedConfigs = false;
	static Character Galadhil = null;
	static Character OrcALvL1 = null;
	static Attack attack = null;
	static int orcLife = 0;
	
	static int diceRoll = 78;
	static int parryBonus = 0;
	static int otherBonus = 0;
	static String otherBonusDescription = "";
	static int attackCategory = Attack.EDGED;
	
	@BeforeClass 
    public static void setUpBeforeClass() {
			Utils.initConfigurations();
			Galadhil = Utils.readCharSheet(1);
			OrcALvL1 = Utils.readCharSheet(2);
			inititatedConfigs = true;
			diceRoll = 78;
			parryBonus = 0;
			otherBonus = 0;
			otherBonusDescription = "";
			attackCategory = Attack.EDGED;
			orcLife = OrcALvL1.getLife().getTotalLife();

    }
	
	
	@Test
	public void a1testApplyStun() {

		CriticalOutcome.critRollTest = 60;
		System.out.println("\n"+Galadhil.getName() +" ataca a "+OrcALvL1.getName());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
		CombatStatus cs = OrcALvL1.getStunned();
		assertEquals("Herida leve en el antebrazo -4 PV. 2 PV por asalto. Aturdido durante 1 asalto.",
				cs.getDescription());

		assertEquals(cs.getName(), "STUNNED");
		assertEquals(cs.getAssaultsLeft(), 1);
		
	}
	
	@Test
	public void a2testApplyStun() {
		a1testApplyStun();
		OrcALvL1.assaultDecrement();
		CombatStatus cs = OrcALvL1.getStunned();
		assertEquals(cs, null);
	}
	
	@Test
	public void a2testMultipleActivityShow() {
		a1testApplyStun();
		OrcALvL1.show();
	}

	@Test
	public void a2testMultipleActivityShowCombatStatus() {
		a1testApplyStun();
		OrcALvL1.showCombatStatus();
	}

	
}
