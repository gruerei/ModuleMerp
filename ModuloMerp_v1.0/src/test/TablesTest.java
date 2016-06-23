package test;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import beans.Character;
import beans.combat.Attack;
import beans.combat.AttackMelee;
import beans.combat.AttackOutcome;
import utils.ReadProperties;
import utils.Utils;
import utils.Tables.Tables;
import utils.Tables.Tables_AT;
import utils.Tables.Tables_Crit;

public class TablesTest {
	


	
	@Test
	public void testAT1() {
		int rollCalculation = 108;
		int enemyArmourType = Tables_AT.AT_SOFLEA;
		int id_row = AttackOutcome.checkRow("AT1",rollCalculation);
		String outcome = Tables.getTableValue("AT1", id_row, enemyArmourType);
		assertEquals(outcome, "15C");
	}
	

	

}
