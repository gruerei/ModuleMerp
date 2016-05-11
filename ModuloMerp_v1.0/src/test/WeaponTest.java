package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import beans.WeaponItem;
import cache.Cache;
import utils.ReadProperties;

public class WeaponTest {
	private WeaponItem scimitarHighQuality;
	private WeaponItem scimitar2;
	
	@Before
    public void setUp() {
		ReadProperties.readWeaponFile();
		scimitarHighQuality = Cache.weaponItems.get(WeaponItem.SCIMITAR);
		scimitar2 = Cache.weaponItems.get(WeaponItem.SCIMITAR).clone();
		scimitarHighQuality.setSpecialMod1(10);
    }

	@Test
	public void testWellRecoveredFromCache() {
		Assert.assertEquals(scimitarHighQuality.getType(), "Scimitar");
	}
	
	@Test
	public void testHighQuality() {
		Assert.assertEquals(scimitarHighQuality.getSpecialMod1(), 10);
	}

	@Test
	public void testWeaponClone() {
		Assert.assertEquals(scimitarHighQuality.getSpecialMod1(),  scimitar2.getSpecialMod1());
	}


}
