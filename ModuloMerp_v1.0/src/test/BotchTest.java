package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import beans.Character;
import beans.CombatStatus;
import beans.CriticalOutcome;
import beans.Item;
import beans.combat.Attack;
import beans.combat.AttackMelee;
import beans.combat.BotchOutcome;
import beans.combat.Combat;
import cache.Cache;
import utils.Utils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


import org.junit.Test;

public class BotchTest {
	
	static boolean inititatedConfigs = false;
	static Character Galadhil = null;
	static Character OrcALvL1 = null;
	static Attack attack = null;
	static int orcLife = 0;
	
	static int diceRoll = 0;
	static int parryBonus = 0;
	static int otherBonus = 0;
	static String otherBonusDescription = "";
	static int attackCategory = Attack.EDGED;

	@BeforeClass 
    public static void setUpBeforeClass() {
			Utils.initConfigurations();
			Galadhil = Utils.readCharSheet(1);
			OrcALvL1 = Utils.readCharSheet(2);
			
			Cache.pjsCombatList.add(Galadhil.getName());
			Cache.pnjsCombatList.add(OrcALvL1.getName());
			
			Combat.pjs.put(Galadhil.getName(), Galadhil);
			Combat.pnjs.put(OrcALvL1.getName(), OrcALvL1);
			
			inititatedConfigs = true;
			
			CriticalOutcome.critRollTest = 50;
			diceRoll = 3;
			parryBonus = 0;
			otherBonus = 0;
			otherBonusDescription = "";
			attackCategory = Attack.EDGED;
			orcLife = OrcALvL1.getLife().getTotalLife();

    }
	
	@Test
	public void a1BotchMINUS49_05() {
		BotchOutcome.botchRollTest = 16;
		Galadhil.setMounted(false);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void a2BotchTest() {
		a1BotchMINUS49_05();
		Galadhil.showCombatStatus();
	}
	
	@Test
	public void b1Botch06_20() {
		BotchOutcome.botchRollTest = 31;
		Galadhil.setMounted(false);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void b2BotchTest() {
		b1Botch06_20();
		Galadhil.showCombatStatus();
	}
	
	@Test
	public void c1Botch21_35() {
		BotchOutcome.botchRollTest = 46;
		Galadhil.setMounted(false);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void c2BotchTest() {
		c1Botch21_35();
		Galadhil.showCombatStatus();
	}
	
	@Test
	public void d1Botch36_50() {
		BotchOutcome.botchRollTest = 46;
		Galadhil.setMounted(false);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void d2BotchTest() {
		d1Botch36_50();
		Galadhil.showCombatStatus();
	}
	
	@Test
	public void e1Botch51_65() {
		BotchOutcome.botchRollTest = 61;
		Galadhil.setMounted(false);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void e2BotchTest() {
		e1Botch51_65();
		Galadhil.showCombatStatus();
		Galadhil.assaultDecrement();
		Galadhil.assaultDecrement();
		Galadhil.showCombatStatus();
	}
	
	@Test
	public void f1Botch66_79() {
		BotchOutcome.botchRollTest = 76;
		Galadhil.setMounted(false);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void f2BotchTest() {
		f1Botch66_79();
		Galadhil.showCombatStatus();
		Galadhil.assaultDecrement();
		Galadhil.assaultDecrement();
		Galadhil.showCombatStatus();
	}
	
	@Test
	public void g1Botch80() {
		BotchOutcome.botchRollTest = 90;
		Galadhil.setMounted(false);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void g2BotchTest() {
		g1Botch80();
		Galadhil.showCombatStatus();
	}
	
	@Test
	public void h1Botch81_86() {
		BotchOutcome.botchRollTest = 91;
		Galadhil.setMounted(false);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void h2BotchTest() {
		h1Botch81_86();
		//Galadhil.showCombatStatus();
		Galadhil.show();
	}
	
	@Test
	public void i1Botch87_89() {
		BotchOutcome.botchRollTest = 97;
		Galadhil.setMounted(false);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void i2BotchTest() {
		i1Botch87_89();
		Galadhil.showCombatStatus();
		//Galadhil.show();
	}
	
	@Test
	public void j1Botch90() {
		BotchOutcome.botchRollTest = 100;
		Galadhil.setMounted(false);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void j2BotchTest() {
		j1Botch90();
		Galadhil.showCombatStatus();
		//Galadhil.show();
	}
	
	@Test
	public void k1Botch91_96() {
		BotchOutcome.botchRollTest = 101;
		Galadhil.setMounted(false);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void k2BotchTest() {
		k1Botch91_96();
		Galadhil.showCombatStatus();
		//Galadhil.show();
	}
	
	@Test
	public void l1Botch97_99() {
		BotchOutcome.botchRollTest = 107;
		Galadhil.setMounted(false);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void l2BotchTest() {
		l1Botch97_99();
		Galadhil.showCombatStatus();
		//Galadhil.show();
	}
	
	@Test
	public void m1Botch100() {
		BotchOutcome.botchRollTest = 90;
		Galadhil.setMounted(true);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void m2BotchTest() {
		m1Botch100();
		Galadhil.showCombatStatus();
		//Galadhil.show();
	}
	
	@Test
	public void n1Botch101_106() {
		BotchOutcome.botchRollTest = 91;
		Galadhil.setMounted(true);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void n2BotchTest() {
		n1Botch101_106();
		Galadhil.showCombatStatus();
		//Galadhil.show();
	}
	
	@Test
	public void ñ1Botch107_109() {
		BotchOutcome.botchRollTest = 97;
		Galadhil.setMounted(true);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void ñ2BotchTest() {
		ñ1Botch107_109();
		Galadhil.showCombatStatus();
		//Galadhil.show();
	}

	@Test
	public void o1Botch110() {
		BotchOutcome.botchRollTest = 100;
		Galadhil.setMounted(true);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void o2BotchTest() {
		o1Botch110();
		Galadhil.showCombatStatus();
		//Galadhil.show();
	}
	
	@Test
	public void o3Botch110() {
		BotchOutcome.botchRollTest = 120;
		Galadhil.setMounted(false);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void o4BotchTest() {
		o3Botch110();
		Galadhil.showCombatStatus();
		//Galadhil.show();
	}
	
	@Test
	public void p1Botch111_116() {
		BotchOutcome.botchRollTest = 101;
		Galadhil.setMounted(true);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void p2BotchTest() {
		p1Botch111_116();
		Galadhil.showCombatStatus();
		//Galadhil.show();
	}
	
	@Test
	public void q1Botch117_119() {
		BotchOutcome.botchRollTest = 107;
		Galadhil.setMounted(true);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void q2BotchTest() {
		q1Botch117_119();
		Galadhil.showCombatStatus();
		//Galadhil.show();
	}
	
	
	@Test
	public void r1Botch120() {
		BotchOutcome.botchRollTest = 110;
		Galadhil.setMounted(true);
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
	}
	
	@Test
	public void r2BotchTest() {
		r1Botch120();
		Galadhil.showCombatStatus();
		//Galadhil.show();
	}
	

}
