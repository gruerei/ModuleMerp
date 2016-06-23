package cache;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import beans.ArmourItem;
import beans.Item;
import beans.WeaponItem;

public class Cache {
	
	public static Map<Integer, Item>  weaponItems = new TreeMap<Integer, Item>();
	public static Map<Integer, Item>  armourItems = new TreeMap<Integer, Item>();
	public static Map<String, Integer>  combatProperties = new HashMap<String, Integer>();
}
