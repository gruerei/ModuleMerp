package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import beans.Character;
import beans.CombatStatus;
import beans.CriticalOutcome;
import beans.Item;
import beans.WeaponItem;
import beans.combat.Attack;
import beans.combat.AttackMelee;
import beans.combat.BotchOutcome;
import beans.combat.Combat;
import cache.Cache;
import utils.Utils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


public class BotchCriticalTakenTest {

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
			diceRoll = 136;
			parryBonus = 0;
			otherBonus = 0;
			otherBonusDescription = "";
	}
	
	
	@Test
	public void a1TwoHandedDoubleCriticalTest() {
		CriticalOutcome.critRollTest = 50;
		diceRoll = 136;
		
		OrcALvL1.unequipItem(Item.WEAPON_1);
		WeaponItem battleaxe = (WeaponItem)Cache.weaponItems.get(WeaponItem.BATTLEAXE).clone();
		OrcALvL1.equipItem(Item.WEAPON_1, battleaxe);
		

		attackCategory = Attack.TWO_HANDED;
		Attack attack = new AttackMelee(OrcALvL1, diceRoll, Galadhil , parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
		//OrcALvL1.showCombatStatus();
		//OrcALvL1.show();
		assertEquals(attack.getOutcome().getMainCriticalOutcome().getCritGravity(), "E");
		assertEquals(attack.getOutcome().getSecondCriticalOutcome().getCritGravity(), "C");
		assertEquals(Galadhil.getLife().getCurrentLife(), Galadhil.getLife().getTotalLife()-32-6-5);
		assertEquals(Galadhil.getStunned().getAssaultsLeft(), 2);
		assertEquals(Galadhil.getBleedingList().get(1).getLifePointLostPerAssault(), 1);
		assertEquals(Galadhil.getTotalBleedingValue(), 1);
	}
	
	@Test
	public void b1BotchCriticalTakenTest() {
		diceRoll = 8;
		BotchOutcome.botchRollTest = 100;
		attackCategory = Attack.CONCUSSION;
		
		OrcALvL1.unequipItem(Item.WEAPON_1);
		WeaponItem morningStar = (WeaponItem)Cache.weaponItems.get(WeaponItem.MORNINGSTAR).clone();
		OrcALvL1.equipItem(Item.WEAPON_1, morningStar);
		
		Attack attack = new AttackMelee(OrcALvL1, diceRoll, Galadhil , parryBonus, otherBonus, otherBonusDescription, attackCategory);


	}
	
	
}
