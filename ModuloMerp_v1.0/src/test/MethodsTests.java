package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import beans.WeaponItem;
import beans.combat.AttackOutcome;
import cache.Cache;
import utils.ReadProperties;
import utils.Tables.Tables;
import utils.Tables.Tables_AT;

public class MethodsTests {
	
	@Before
    public void setUp() {
    }

	@Test
	public void testAT1() {
		
		String tableRoll = "B";
		String weaponCritMaxGravity = "C";
		
		String maxGrav = maxGravity(tableRoll, weaponCritMaxGravity);
		
		assertEquals(maxGrav,"B");
	}
	
	@Test
	public void testAT2() {
		
		String tableRoll = "D";
		String weaponCritMaxGravity = "C";
		
		String maxGrav = maxGravity(tableRoll, weaponCritMaxGravity);
		
		assertEquals(maxGrav,"C");
	}
	
	
	@Test
	public void testAT3() {
		
		String tableRoll = "A";
		String weaponCritMaxGravity = "E";
		
		String maxGrav = maxGravity(tableRoll, weaponCritMaxGravity);
		
		assertEquals(maxGrav,"A");
	}

	@Test
	public void testAT4() {
		
		String tableRoll = "E";
		String weaponCritMaxGravity = "E";
		
		String maxGrav = maxGravity(tableRoll, weaponCritMaxGravity);
		
		assertEquals(maxGrav,"E");
	}

	
	private String maxGravity(String tableRoll, String weaponCritMaxGravity) {
		
		if(tableRoll.toUpperCase().compareTo(weaponCritMaxGravity.toUpperCase()) <= 0){
			return tableRoll;
		}else{
			return weaponCritMaxGravity;
		}
	}

}
