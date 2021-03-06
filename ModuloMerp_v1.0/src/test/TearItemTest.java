package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import beans.ArmourItem;
import beans.Character;
import beans.CombatStatus;
import beans.CriticalOutcome;
import beans.Item;
import beans.Skill;
import beans.WeaponItem;
import beans.combat.Attack;
import beans.combat.AttackMelee;
import utils.Utils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TearItemTest {
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
			diceRoll = 88;
			parryBonus = 0;
			otherBonus = 0;
			otherBonusDescription = "";
			attackCategory = Attack.CONCUSSION;
			orcLife = OrcALvL1.getLife().getTotalLife();

    }
	
	
	@Test
	public void a1testApplyTearItem() {

		CriticalOutcome.critRollTest = 71;
		System.out.println("\n"+OrcALvL1.getName() +" ataca a "+Galadhil.getName());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		Attack attack = new AttackMelee(OrcALvL1 , diceRoll, Galadhil , parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	
	
	
	
	@Test
	public void a2ApplyTearItemShow() {
		//a1testApplyTearItem();
		Galadhil.show();
	}

	@Test
	public void a3ApplyTearItemShow() {
		a1testApplyTearItem();
		Galadhil.showCombatStatus();
	}

	
	@Test
	public void a3ApplyTearItemNull() {
		Galadhil.unequipItem(Item.HELMET);
		Galadhil.showCombatStatus();
		//Galadhil.show();
	}
	
	@Test
	public void a4ApplyTearItemBracers() {
		
		WeaponItem wi = (WeaponItem) Galadhil.getEquippedGear().get(Item.WEAPON_1);
		int boBracers = Galadhil.getSkills().get(wi.getCategory()).getModifTotal();
		int boBracersWeapon = wi.getBO();
		Galadhil.unequipItem(Item.BRACERS);
		int boSinBracers = Galadhil.getSkills().get(wi.getCategory()).getModifTotal();
		int boSinBracersWeapon = wi.getBO();
		assertEquals(boSinBracers, boBracers + 5);
		assertEquals(boSinBracersWeapon, boBracersWeapon + 5);
		//Galadhil.showCombatStatus();
		//Galadhil.show();
	}
	
	@Test
	public void a5ApplyTearItemGreaves() {
		
		ArmourItem wi = (ArmourItem) Galadhil.getEquippedGear().get(Item.ARMOUR);
		int mmGreaves = Galadhil.getSkills().get(wi.getCategory()).getModifTotal();
		Galadhil.unequipItem(Item.GREAVES);
		int mmSinGreaves = Galadhil.getSkills().get(wi.getCategory()).getModifTotal();
		
		assertEquals(mmSinGreaves , mmGreaves + 5);
		//Galadhil.showCombatStatus();
		//Galadhil.show();
	}
	
	@Test
	public void a5ApplyTearItemHelmet() {
		
		ArmourItem wi = (ArmourItem) Galadhil.getEquippedGear().get(Item.HELMET);
		int percHelmet= Galadhil.getSkills().get(Skill.PERCEPTION).getModifTotal();
		Galadhil.unequipItem(Item.HELMET);
		int percSinHelmet = Galadhil.getSkills().get(Skill.PERCEPTION).getModifTotal();
		
		assertEquals(percSinHelmet , percHelmet + 5);
		//Galadhil.showCombatStatus();
		//Galadhil.show();
	}
}
