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
public class OtherCritEffectsTest {
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

    }
	

	/*Tests de Critico de Muerte por Asalto y Muerte Directa completos*/
	@Test
	public void a1testCauseDeath6Assaults() {

		CriticalOutcome.critRollTest = 97;
		diceRoll = 111;
		WeaponItem wi = (WeaponItem)OrcALvL1.getEquippedGear().get(Item.WEAPON_1);
		System.out.println("\n"+OrcALvL1.getName() +" ataca a "+Galadhil.getName() + " con "+wi.getType());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		Attack attack = new AttackMelee(OrcALvL1 , diceRoll, Galadhil , parryBonus, otherBonus, otherBonusDescription, attackCategory);
		assertEquals(Galadhil.getDead().getName(),CombatStatus.DEAD);
		assertEquals(Galadhil.getDead().getType(),CombatStatus.DEAD_ASSAULTS);
		assertEquals(Galadhil.getDead().getAssaultsLeft(),6);
	}
	
	@Test
	public void a2testCauseDeathDirect(){
		a1testCauseDeath6Assaults();
		Galadhil.getDead().setAssaultsLeft(1);
		Galadhil.assaultDecrement();
		assertEquals(Galadhil.getDead().getName(),CombatStatus.DEAD);
		assertEquals(Galadhil.getDead().getType(),CombatStatus.DEAD_FINAL);
	}
	
	@Test
	public void a3testCauseDeathDirect() {

		CriticalOutcome.critRollTest = 100;
		diceRoll = 111;
		WeaponItem wi = (WeaponItem)OrcALvL1.getEquippedGear().get(Item.WEAPON_1);
		System.out.println("\n"+OrcALvL1.getName() +" ataca a "+Galadhil.getName() + " con "+wi.getType());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		Attack attack = new AttackMelee(OrcALvL1 , diceRoll, Galadhil , parryBonus, otherBonus, otherBonusDescription, attackCategory);
		assertEquals(Galadhil.getDead().getName(),CombatStatus.DEAD);
		assertEquals(Galadhil.getDead().getType(),CombatStatus.DEAD_FINAL);
		assertEquals(Galadhil.getDead().getAssaultsLeft(),0);
	}
	
	/*Tests Body Disability Completos*/
	@Test
	public void b1testCauseRightLegDis() {

		CriticalOutcome.critRollTest = 86;
		WeaponItem wi = (WeaponItem)OrcALvL1.getEquippedGear().get(Item.WEAPON_1);
		System.out.println("\n"+OrcALvL1.getName() +" ataca a "+Galadhil.getName() + " con "+wi.getType());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		Attack attack = new AttackMelee(OrcALvL1 , diceRoll, Galadhil , parryBonus, otherBonus, otherBonusDescription, attackCategory);
	
	}
	
	@Test
	public void b2testCauseRightEyeDis() {

		CriticalOutcome.critRollTest = 100;
		WeaponItem wi = (WeaponItem)OrcALvL1.getEquippedGear().get(Item.WEAPON_1);
		System.out.println("\n"+OrcALvL1.getName() +" ataca a "+Galadhil.getName() + " con "+wi.getType());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		Attack attack = new AttackMelee(OrcALvL1 , diceRoll, Galadhil , parryBonus, otherBonus, otherBonusDescription, attackCategory);
	
	}
	
	@Test
	public void b2testCauseMainArmDis() {

		CriticalOutcome.critRollTest = 101;
		WeaponItem wi = (WeaponItem)OrcALvL1.getEquippedGear().get(Item.WEAPON_1);
		System.out.println("\n"+OrcALvL1.getName() +" ataca a "+Galadhil.getName() + " con "+wi.getType());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		Attack attack = new AttackMelee(OrcALvL1 , diceRoll, Galadhil , parryBonus, otherBonus, otherBonusDescription, attackCategory);
	
	}
	
	@Test
	public void b3testCauseWeakArmDis() {
		b2testCauseMainArmDis();
		CriticalOutcome.critRollTest = 91;
		WeaponItem wi = (WeaponItem)OrcALvL1.getEquippedGear().get(Item.WEAPON_1);
		System.out.println("\n"+OrcALvL1.getName() +" ataca a "+Galadhil.getName() + " con "+wi.getType());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		Attack attack = new AttackMelee(OrcALvL1 , diceRoll, Galadhil , parryBonus, otherBonus, otherBonusDescription, attackCategory);
	
	}
	
	/*Tests Body Disability y Rotura de item Completos*/
	@Test
	public void c1testBodyDisAndTearItem() {

		CriticalOutcome.critRollTest = 71;
		WeaponItem wi = (WeaponItem)OrcALvL1.getEquippedGear().get(Item.WEAPON_1);
		System.out.println("\n"+OrcALvL1.getName() +" ataca a "+Galadhil.getName() + " con "+wi.getType());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		Attack attack = new AttackMelee(OrcALvL1 , diceRoll, Galadhil , parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	@Test
	public void c2testBodyDisAndTearItem() {
		c1testBodyDisAndTearItem();
		CriticalOutcome.critRollTest = 71;
		WeaponItem wi = (WeaponItem)OrcALvL1.getEquippedGear().get(Item.WEAPON_1);
		System.out.println("\n"+OrcALvL1.getName() +" ataca a "+Galadhil.getName() + " con "+wi.getType());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		Attack attack = new AttackMelee(OrcALvL1 , diceRoll, Galadhil , parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	/* Test de Unconciousness*/
	@Test
	public void d1testUncounciousness() {
		CriticalOutcome.critRollTest = 90;
		diceRoll = 108;
		WeaponItem wi = (WeaponItem)OrcALvL1.getEquippedGear().get(Item.WEAPON_1);
		System.out.println("\n"+OrcALvL1.getName() +" ataca a "+Galadhil.getName() + " con "+wi.getType());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		Attack attack = new AttackMelee(OrcALvL1 , diceRoll, Galadhil , parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
}
