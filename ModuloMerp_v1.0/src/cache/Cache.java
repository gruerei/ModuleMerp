package cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import beans.ArmourItem;
import beans.Item;
import beans.WeaponItem;

public class Cache {
	
	public static Map<Integer, Item>  weaponItems = new TreeMap<Integer, Item>();
	public static Map<Integer, Item>  armourItems = new TreeMap<Integer, Item>();
	public static Map<String, Integer>  combatProperties = new HashMap<String, Integer>();
	public static List<String> pjsCombatList = new ArrayList<String>();
	public static List<String> pnjsCombatList = new ArrayList<String>();
	
	public static void removeFromCacheList(String combatantList,String combatantName){
		if(combatantList.equals("pj")){
			pjsCombatList.remove(combatantName);
		}else if(combatantList.equals("pnj")){
			pnjsCombatList.remove(combatantName);
		}
	}
	
}
