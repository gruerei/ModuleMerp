package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import beans.ArmourItem;
import beans.Character;
import beans.CriticalOutcome;
import beans.Item;
import beans.combat.Attack;
import beans.combat.AttackMelee;
import cache.Cache;
import utils.Utils;

public class AdditionalCombatInfoTest {
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
	public void a1testParryShieldDodge_MISSED() {
		/*Precondicion: Subir la agilidad del Orco a 90, para que tengo un bono de 10 -5 = +5 , o sino no 
		 * se puede testear el DODGE */
		
		diceRoll = 18;
		parryBonus = 5;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	@Test
	public void a2testParryShieldDodge_DODGED() {
		/*Precondicion: Subir la agilidad del Orco a 90, para que tengo un bono de 10 -5 = +5 , o sino no 
		 * se puede testear el DODGE */
		
		diceRoll = 19;
		parryBonus = 5;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	@Test
	public void a3testParryShieldDodge_DEFLECTED() {
		/*Precondicion: Subir la agilidad del Orco a 90, para que tengo un bono de 10 -5 = +5 , o sino no 
		 * se puede testear el DODGE */
		
		diceRoll = 24;
		parryBonus = 5;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	@Test
	public void a4testParryShieldDodge_PARRIED() {
		/*Precondicion: Subir la agilidad del Orco a 90, para que tengo un bono de 10 -5 = +5 , o sino no 
		 * se puede testear el DODGE */
		
		diceRoll = 34;
		parryBonus = 5;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	@Test
	public void a5testParryShieldDodge_HIT() {
		/*Precondicion: Subir la agilidad del Orco a 90, para que tengo un bono de 10 -5 = +5 , o sino no 
		 * se puede testear el DODGE */
		
		diceRoll = 39;
		parryBonus = 5;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	
	@Test
	public void b1testParryDodge_MISSED() {
		/*Precondicion: Subir la agilidad del Orco a 90, para que tengo un bono de 10 -5 = +5 , o sino no 
		 * se puede testear el DODGE.
		 *Precondicion: desequipar escudo  */
		
		OrcALvL1.unequipItem(Item.SHIELD);
		
		diceRoll = 18;
		parryBonus = 5;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	@Test
	public void b2testParryDodge_DODGED() {
		/*Precondicion: Subir la agilidad del Orco a 90, para que tengo un bono de 10 -5 = +5 , o sino no 
		 * se puede testear el DODGE.
		 *Precondicion: desequipar escudo  */
		
		OrcALvL1.unequipItem(Item.SHIELD);
		
		diceRoll = 19;
		parryBonus = 5;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	@Test
	public void b3testParryDodge_PARRIED() {
		/*Precondicion: Subir la agilidad del Orco a 90, para que tengo un bono de 10 -5 = +5 , o sino no 
		 * se puede testear el DODGE.
		 *Precondicion: desequipar escudo  */
		
		OrcALvL1.unequipItem(Item.SHIELD);
		
		diceRoll = 24;
		parryBonus = 5;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	@Test
	public void b4testParryDodge_HIT() {
		/*Precondicion: Subir la agilidad del Orco a 90, para que tengo un bono de 10 -5 = +5 , o sino no 
		 * se puede testear el DODGE */
		
		OrcALvL1.unequipItem(Item.SHIELD);
		
		diceRoll = 29;
		parryBonus = 5;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	@Test
	public void c1testShieldDodge_MISSED() {
		/*Precondicion: Subir la agilidad del Orco a 90, para que tengo un bono de 10 -5 = +5 , o sino no 
		 * se puede testear el DODGE */

		diceRoll = 18;
		parryBonus = 0;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	
	@Test
	public void c2testShieldDodge_DODGED() {
		/*Precondicion: Subir la agilidad del Orco a 90, para que tengo un bono de 10 -5 = +5 , o sino no 
		 * se puede testear el DODGE */

		diceRoll = 19;
		parryBonus = 0;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	@Test
	public void c3testShieldDodge_DEFLECTED() {
		/*Precondicion: Subir la agilidad del Orco a 90, para que tengo un bono de 10 -5 = +5 , o sino no 
		 * se puede testear el DODGE */

		diceRoll = 24;
		parryBonus = 0;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	@Test
	public void c4testShieldDodge_HIT() {
		/*Precondicion: Subir la agilidad del Orco a 90, para que tengo un bono de 10 -5 = +5 , o sino no 
		 * se puede testear el DODGE */

		diceRoll = 34;
		parryBonus = 0;
		
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	@Test
	public void d1testDodge_MISSED() {
		/*Precondicion: Subir la agilidad del Orco a 90, para que tengo un bono de 10 -5 = +5 , o sino no 
		 * se puede testear el DODGE */

		OrcALvL1.unequipItem(Item.SHIELD);
		diceRoll = 18;
		parryBonus = 0;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	@Test
	public void d2testDodge_DODGED() {
		/*Precondicion: Subir la agilidad del Orco a 90, para que tengo un bono de 10 -5 = +5 , o sino no 
		 * se puede testear el DODGE */

		OrcALvL1.unequipItem(Item.SHIELD);
		diceRoll = 19;
		parryBonus = 0;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}

	@Test
	public void d3testDodge_HIT() {
		/*Precondicion: Subir la agilidad del Orco a 90, para que tengo un bono de 10 -5 = +5 , o sino no 
		 * se puede testear el DODGE */

		OrcALvL1.unequipItem(Item.SHIELD);
		diceRoll = 24;
		parryBonus = 0;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	@Test
	public void e1testNoBD_MISSED() {
		/*Precondicion: Volver a Poner la Agilidad del Orco a +0 */

		OrcALvL1.unequipItem(Item.SHIELD);
		diceRoll = 18;
		parryBonus = 0;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	@Test
	public void e2testNoBD_HIT() {
		/*Precondicion: Volver a Poner la Agilidad del Orco a +0 */

		OrcALvL1.unequipItem(Item.SHIELD);
		diceRoll = 19;
		parryBonus = 0;
		String otherBonusDescription = "";
		int attackCategory = Attack.EDGED;
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		
	}
	
	@Test
	public void f1testThreshold() {
		ArmourItem softLea = (ArmourItem)Cache.armourItems.get(ArmourItem.SOFT_LEATHER).clone();
		int thre = ArmourItem.calculThresold(softLea.getType());
		assertEquals(thre , 66);
		
		ArmourItem rigidLea = (ArmourItem)Cache.armourItems.get(ArmourItem.RIGID_LEATHER).clone();
		thre = ArmourItem.calculThresold(rigidLea.getType());
		assertEquals(thre , 66);
		
		ArmourItem chain = (ArmourItem)Cache.armourItems.get(ArmourItem.CHAIN).clone();
		thre = ArmourItem.calculThresold(chain.getType());
		assertEquals(thre , 51);
		
		ArmourItem plate = (ArmourItem)Cache.armourItems.get(ArmourItem.PLATE).clone();
		thre = ArmourItem.calculThresold(plate.getType());
		assertEquals(thre , 46);
		
		
		thre = ArmourItem.calculThresold(null);
		assertEquals(thre , 76);
		
	}
	
	@Test
	public void z1testShow() {
		
		//OrcALvL1.showCombatStatus();
		OrcALvL1.show();
		//Galadhil.show();
	}
}
