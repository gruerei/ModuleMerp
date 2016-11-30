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
public class BleedingTest {
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
	public void a1testApplyBleed1() {
			
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		orcLife = orcLife - 17;
		
		CombatStatus cs = OrcALvL1.getBleedingList().get(1);
		assertEquals("Herida leve en el pecho. -3 PV. 1 PV por asalto. -5 a la actividad.",
				cs.getDescription());
		orcLife = orcLife - 3; 
		assertEquals(cs.getName(), "BLEEDING");
		assertEquals(cs.getType(), CombatStatus.BLEEDING_WOUND);
		
	}
	
	@Test
	public void a2testBleeds1() {
		OrcALvL1.bleeds();
		assertEquals(OrcALvL1.getLife().getCurrentLife(), orcLife - 1);
	}
	
	@Test
	public void a3testHealBleeding1() {
		OrcALvL1.applyBandageToBleeding(1, CombatStatus.BANDAGE_EFFECT_LOW);
		assertEquals(OrcALvL1.getBleedingList().size(), 0);
	}
	
	@Test
	public void b1testMultipleBleeding() {
		orcLife = OrcALvL1.getLife().getTotalLife();
		OrcALvL1.getLife().setCurrentLife(OrcALvL1.getLife().getTotalLife());
		
		diceRoll = 78;
		parryBonus = 0;
		otherBonus = 0;
		otherBonusDescription = "";
		attackCategory = Attack.EDGED;
		
		/*----------ATAQUE 1 / BLEEDING 1---------*/
		CriticalOutcome.critRollTest = 61;
		System.out.println("\n"+Galadhil.getName() +" ataca a "+OrcALvL1.getName());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		
		Attack attack = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		orcLife = orcLife - 17;
				
		CombatStatus cs = OrcALvL1.getBleedingList().get(1);
		assertEquals("Herida leve en el antebrazo -4 PV. 2 PV por asalto. Aturdido durante 1 asalto.",
				cs.getDescription());
		orcLife = orcLife - 4; 
		
		/*----------ATAQUE 2 / BLEEDING 2---------*/
		CriticalOutcome.critRollTest = 76;
		diceRoll = 77;
		System.out.println("\n"+Galadhil.getName() +" ataca a "+OrcALvL1.getName());
		System.out.println("****TIRADA DE DADOS****** RESULTADO: "+diceRoll);
		
		Attack attack2 = new AttackMelee(Galadhil, diceRoll, OrcALvL1, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		orcLife = orcLife - 17;
		CombatStatus cs2 = OrcALvL1.getBleedingList().get(2);
		assertEquals("Herida menos grave en el muslo. -6 PV. 1 PV por asalto. - 10 a la actividad. Aturdido durante 2 asaltos.",
				cs2.getDescription());
		orcLife = orcLife - 6; 
		
		assertEquals(OrcALvL1.getLife().getCurrentLife(), orcLife);
		OrcALvL1.bleeds();
		assertEquals(OrcALvL1.getLife().getCurrentLife(), orcLife - 3);
	}
	
	@Test
	public void b2testBleedingUnconsc() {
		b1testMultipleBleeding();
		OrcALvL1.bleeds();
		assertEquals(OrcALvL1.getKnockedOut().getType(), CombatStatus.KNOCKED_OUT_LIFE_BELOW_ZERO);
		OrcALvL1.bleeds();

	}
	
	@Test
	public void b3testBleedingApplyBandage() {
		b1testMultipleBleeding();
		OrcALvL1.applyBandageToBleeding(1, CombatStatus.BANDAGE_EFFECT_MEDIUM);
		OrcALvL1.bleeds();
		OrcALvL1.applyBandageToBleeding(2, CombatStatus.BANDAGE_EFFECT_LOW);
		OrcALvL1.bleeds();
		assertEquals(OrcALvL1.getBleedingList().size(), 0);

	}
	
	
}
