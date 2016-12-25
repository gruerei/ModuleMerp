package test;


import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import beans.Character;
import beans.CombatStatus;
import beans.CriticalOutcome;
import beans.combat.Attack;
import beans.combat.AttackMelee;
import utils.Utils;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ActivityTest {
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
			
			CriticalOutcome.critRollTest = 50;
			diceRoll = 78;
			parryBonus = 0;
			otherBonus = 0;
			otherBonusDescription = "";
			attackCategory = Attack.EDGED;
			orcLife = OrcALvL1.getLife().getTotalLife();

    }
	
	
	@Test
	public void a1testApplyActivity1() {
		System.out.println("\n"+Galadhil.getName() +" ataca a "+OrcALvL1.getName());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
		CombatStatus cs = OrcALvL1.getActivityList().get(1);
		assertEquals("Herida leve en el pecho. -3 PV. 1 PV por asalto. -5 a la actividad.",
				cs.getDescription());

		assertEquals(cs.getName(), "ACTIVITY");
		assertEquals(cs.getType(), CombatStatus.ACTIVITY_WOUND);
		
	}
	
	@Test
	public void a1testApplyActivity2() {

		CriticalOutcome.critRollTest = 70;
		System.out.println("\n"+Galadhil.getName() +" ataca a "+OrcALvL1.getName());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
		CombatStatus cs = OrcALvL1.getActivityList().get(1);
		assertEquals("Herida menos grave en el muslo. -6 PV. 1 PV por asalto. - 10 a la actividad. Aturdido durante 2 asaltos.",
				cs.getDescription());

		assertEquals(cs.getName(), "ACTIVITY");
		assertEquals(cs.getType(), CombatStatus.ACTIVITY_WOUND);
		assertEquals(cs.getActivityModif(), 10);
		
	}
	
	@Test
	public void a1testApplyActivity3() {
		diceRoll = 88;
		CriticalOutcome.critRollTest = 50;
		attackCategory = Attack.CONCUSSION;
		System.out.println("\n"+ OrcALvL1.getName() +" ataca a "+Galadhil.getName());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		Attack attack = new AttackMelee(OrcALvL1, diceRoll,Galadhil, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		CombatStatus cs = Galadhil.getActivityList().get(1);
		assertEquals("Golpe en un costado. -4 PV, -40 a la actividad durante 1 asalto.",
				cs.getDescription());

		assertEquals(cs.getName(), "ACTIVITY");
		assertEquals(cs.getType(), CombatStatus.ACTIVITY_ASSAULTS);
		assertEquals(cs.getActivityModif(), -40);
		assertEquals(cs.getAssaultsLeft(), 1);
	}
	
	@Test
	public void b1testActivityEffect() {
		a1testApplyActivity3();
		diceRoll = 69;
		CriticalOutcome.critRollTest = 50;
		attackCategory = Attack.CONCUSSION;
		System.out.println("\n"+Galadhil.getName() +" ataca a "+OrcALvL1.getName());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1 , parryBonus, otherBonus, otherBonusDescription, attackCategory);
		assertEquals(OrcALvL1.getLife().getCurrentLife(), OrcALvL1.getLife().getTotalLife() - 3);
		Galadhil.assaultDecrement();
		assertEquals(Galadhil.getActivityList().size(),0);
		System.out.println("\n"+Galadhil.getName() +" ataca a "+OrcALvL1.getName());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1 , parryBonus, otherBonus, otherBonusDescription, attackCategory);
		assertEquals(OrcALvL1.getLife().getCurrentLife(), OrcALvL1.getLife().getTotalLife() - 3 - 12 - 3);
	}
	
	@Test
	public void b2testMultipleActivity() {
		
		a1testApplyActivity3();
		diceRoll = 84;
		CriticalOutcome.critRollTest = 40;
		

		/*----------ATAQUE 1 / BLEEDING 1---------*/
		System.out.println("\n"+ OrcALvL1.getName() +" ataca a "+Galadhil.getName());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		Attack attack = new AttackMelee(OrcALvL1, diceRoll,Galadhil, parryBonus, otherBonus, otherBonusDescription, attackCategory);
				
		CombatStatus cs = Galadhil.getActivityList().get(2);
		assertEquals("Fractura leve en las costillas. -5 PV. -5 a la actividad.",
				cs.getDescription());
		
		
		System.out.println("\n"+Galadhil.getName() +" ataca a "+OrcALvL1.getName());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1 , parryBonus, otherBonus, otherBonusDescription, attackCategory);
		assertEquals(Galadhil.getModifTotalActivity(),-45);

	}
	
	@Test
	public void b3testMultipleActivityDeath() {
		b2testMultipleActivity();
		
		assertEquals(Galadhil.getActivityList().size(),2);
		assertEquals(Galadhil.getModifTotalActivity(),-45);
		Galadhil.death();
		assertEquals(Galadhil.getActivityList().size(),0);
		assertEquals(Galadhil.getModifTotalActivity(),0);
	}

	
	@Test
	public void b4testMultipleActivityAssaultDecrement() {
		b2testMultipleActivity();
		
		Galadhil.assaultDecrement();
		assertEquals(Galadhil.getActivityList().size(),1);
		assertEquals(Galadhil.getModifTotalActivity(),-5);
	}
	
	@Test
	public void b5testMultipleActivityRestoreModifByKey() {
		b2testMultipleActivity();
		
		Galadhil.restoreActivityModif(2);
		assertEquals(Galadhil.getActivityList().size(),1);
		assertEquals(Galadhil.getModifTotalActivity(),-40);
		
		Galadhil.restoreActivityModif(1);
		assertEquals(Galadhil.getActivityList().size(),0);
		assertEquals(Galadhil.getModifTotalActivity(),0);
	}
	
	@Test
	public void c1testMultipleActivityShowCombatStatus() {
		b2testMultipleActivity();
		Galadhil.showCombatStatus();
	}
	
	@Test
	public void c2testMultipleActivityShow() {
		b2testMultipleActivity();
		Galadhil.show();
	}

	
}
