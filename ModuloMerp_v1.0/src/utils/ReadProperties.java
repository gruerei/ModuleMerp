package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Map;

import beans.ArmourItem;
import beans.Botch;
import beans.Critical;
import beans.Item;
import beans.Price;
import beans.Skill;
import beans.WeaponItem;
import cache.Cache;

public class ReadProperties {

	public static void main(String arg[]) {

		
		//ReadProperties.readWeaponFile();
		ReadProperties.readArmourFile();
		
		//resetDefaults();
		
		//print(Cache.weaponItems);
		print(Cache.armourItems);
		
		
	} 



	public static void readArmourFile() {
		
		try {
			/** Creamos un Objeto de tipo Properties */
			Properties armourProperties = new Properties();
	
			/** Cargamos el archivo desde la ruta especificada */
			armourProperties.load(new FileInputStream(
				"src/properties/armour.properties"));
			
			String armoursFile =  armourProperties.getProperty("armour.types");
			String [] armours = armoursFile.split(Utils.PROPERTIES_MAIN_SEPARATOR);

			for(String armour : armours){
				
				int [] skillMods = new int[Skill.SKILLS_TOTAL_NUMBER];
				
				String name = armourProperties.getProperty("armour." + armour + ".name");
				String type = armourProperties.getProperty("armour." + armour + ".type");
				String category_ = armourProperties.getProperty("armour." + armour + ".category");
				int category = Item.ARMOUR;
				
				float weight = Utils.castToFloat(armourProperties.getProperty("armour." + armour + ".weight"));
				String material = armourProperties.getProperty("armour." + armour + ".material");
				
				String price = armourProperties.getProperty("armour." + armour + ".price");
				Price price_obj = new Price(price);
				
				ArmourItem ai = new ArmourItem(type, weight,price_obj,category, material, skillMods, 0);
				
				Cache.armourItems.put(getKey(armour), ai);
		
			}

			String shieldsFile =  armourProperties.getProperty("shield.types");
			String [] shields = shieldsFile.split(Utils.PROPERTIES_MAIN_SEPARATOR);
			
			
			for(String shield : shields){
				
				int [] skillMods = new int[Skill.SKILLS_TOTAL_NUMBER];
				
				int category = Item.SHIELD;
				String type = armourProperties.getProperty("shield." + shield + ".type");
				float weight = Utils.castToFloat(armourProperties.getProperty("shield." + shield + ".weight"));
				String material = armourProperties.getProperty("shield." + shield + ".material");
				String price = armourProperties.getProperty("shield." + shield + ".price");
				Price price_obj = new Price(price);
				
				int BD = Utils.castToInt(armourProperties.getProperty("shield." + shield + ".BD"));
				int BO = Utils.castToInt(armourProperties.getProperty("shield." + shield + ".BO"));
						
				skillMods[Skill.BD] = skillMods[Skill.BD] + BD;
				skillMods[Skill.EDGED] = skillMods[Skill.EDGED] + BO;
				skillMods[Skill.CONCUSSION] = skillMods[Skill.CONCUSSION] + BO;
				skillMods[Skill.TWO_HANDED] = skillMods[Skill.TWO_HANDED] + BO;
				skillMods[Skill.THROWN] = skillMods[Skill.THROWN] + BO;
				skillMods[Skill.PROJECTILE] = skillMods[Skill.PROJECTILE] + BO;
				skillMods[Skill.POLEARM] = skillMods[Skill.POLEARM] + BO;
				
				ArmourItem ai = new ArmourItem(type, weight,price_obj,category, material, skillMods, BO);
				
				Cache.armourItems.put(getKey(shield+"_shield"), ai);
			}
			
			
			String [] gear = {"helmet","bracers","greaves"};
			String [] materials = {"leather","metal"};
			
			for(String item : gear){
				for(String material : materials){
					
					int [] skillMods = new int[Skill.SKILLS_TOTAL_NUMBER];
					int bonusBo = 0;
					int category = 0;
					if(item.equals("helmet")){
						category = Item.HELMET;
						skillMods[Skill.PERCEPTION] = skillMods[Skill.PERCEPTION] - 5;
					}else if(item.equals("bracers")){
						category = Item.BRACERS;
						skillMods[Skill.EDGED] = skillMods[Skill.EDGED] - 5;
						skillMods[Skill.CONCUSSION] = skillMods[Skill.CONCUSSION] - 5;
						skillMods[Skill.TWO_HANDED] = skillMods[Skill.TWO_HANDED] - 5;
						skillMods[Skill.THROWN] = skillMods[Skill.THROWN] - 5;
						skillMods[Skill.PROJECTILE] = skillMods[Skill.PROJECTILE] - 5;
						skillMods[Skill.POLEARM] = skillMods[Skill.POLEARM] - 5;
						bonusBo = -5;
					}else if(item.equals("greaves")){
						category = Item.GREAVES;
						skillMods[Skill.NO_ARMOR] = skillMods[Skill.NO_ARMOR] - 5;
						skillMods[Skill.SOFT_LEATHER] = skillMods[Skill.SOFT_LEATHER] - 5;
						skillMods[Skill.RIGID_LEATHER] = skillMods[Skill.RIGID_LEATHER] - 5;
						skillMods[Skill.CHAIN] = skillMods[Skill.CHAIN] - 5;
						skillMods[Skill.PLATE] = skillMods[Skill.PLATE] - 5;
					}
						
					String type = armourProperties.getProperty(item + "." + material + ".type");
					float weight = Utils.castToFloat(armourProperties.getProperty(item + "." + material + ".weight"));
					String price = armourProperties.getProperty(item + "." + material + ".price");
					Price price_obj = new Price(price);
					
					ArmourItem ai = new ArmourItem(type, weight,price_obj,category, material,skillMods,bonusBo);
					Cache.armourItems.put(getKey(material + "_" + item), ai);
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error, The file does not exist");
		} catch (IOException e) {
			System.out.println("Error, Reading the file has not been possible");
		}
	}

	/**
	 * Lee un archivo de propiedades desde una ruta especifica y se imprime en
	 * pantalla.
	 */
	public static void readWeaponFile() {
		try {

			/** Creamos un Objeto de tipo Properties */
			Properties weaponProperties = new Properties();

			/** Cargamos el archivo desde la ruta especificada */
			weaponProperties.load(new FileInputStream(
					"src/properties/weapon.properties"));

			String weaponsFile =  weaponProperties.getProperty("weapon.types");
			String [] weapons = weaponsFile.split(Utils.PROPERTIES_MAIN_SEPARATOR);
			

			for(String weapon : weapons){
				
				int [] skillMods = new int[Skill.SKILLS_TOTAL_NUMBER];
				String name = weaponProperties.getProperty("weapon." + weapon + ".name");
				
				/** Obtenemos los parametros definidos en el archivo */
				String type = weaponProperties.getProperty("weapon." + weapon + ".type");
	
				String category_ = weaponProperties.getProperty("weapon." + weapon + ".category");
				int category = 0;
				if(category_.equalsIgnoreCase("EDGED")){
					category = WeaponItem.EDGED;
				}else if(category_.equalsIgnoreCase("CONCUSSION")){
					category = WeaponItem.CONCUSSION;
				}else if(category_.equalsIgnoreCase("TWO_HANDED")){
					category = WeaponItem.TWO_HANDED;
				}else if(category_.equalsIgnoreCase("THROWN")){
					category = WeaponItem.THROWN;
				}else if(category_.equalsIgnoreCase("PROJECTILE")){
					category = WeaponItem.PROJECTILE;
				}else if(category_.equalsIgnoreCase("POLEARM")){
					category = WeaponItem.POLEARM;
				}
				
				
				String main_critical_ = weaponProperties.getProperty("weapon." + weapon + ".maincritical");
				Critical main_critical = createCritical(main_critical_);
			
				String second_critical_ = weaponProperties.getProperty("weapon." + weapon + ".secondcritical");
				Critical second_critical = createCritical(second_critical_);
	
				String botch_ = weaponProperties.getProperty("weapon." + weapon + ".botch");
				String botchCriticaltaken_ = weaponProperties.getProperty("weapon." + weapon + ".botch.criticaltaken");
	
				Botch botch = createBotch(botch_,botchCriticaltaken_);
				
				/**INI-IF THIS WEAPON CAN BE 2H USED*/
				boolean usedTwoHanded = Utils.castToBoolean(weaponProperties.getProperty("weapon." + weapon + ".two_handed"));
				Botch botchTwoHanded = null;
				Critical botch_critical = null;
				int bonus2H = 0;
				
				if(usedTwoHanded){
					String botch2H = weaponProperties.getProperty("weapon." + weapon + ".two_handed.botch");
					botchTwoHanded = createBotch(botch2H,botchCriticaltaken_);
					String botch_critical_in = weaponProperties.getProperty("weapon." + weapon + ".two_handed.critical");
					botch_critical = createCritical(botch_critical_in);
					String bonus2H_ = weaponProperties.getProperty("weapon." + weapon + ".two_handed.mod");
					bonus2H = Utils.castToInt(bonus2H_);

				}
				/**END-IF THIS WEAPON CAN BE 2H USED*/
				
				float range = Utils.castToFloat(weaponProperties.getProperty("weapon." + weapon + ".range"));
				float weight = Utils.castToFloat(weaponProperties.getProperty("weapon." + weapon + ".weight"));
				int typeMod1 = Utils.castToInt(weaponProperties.getProperty("weapon." + weapon + ".weapontypemod1"));
				int typeMod2 = Utils.castToInt(weaponProperties.getProperty("weapon." + weapon + ".weapontypemod2"));
				
				/*----------*/
				String typeMod1AppliedTo_ = weaponProperties.getProperty("weapon." + weapon + ".weapontypemod1.appliedto");
				String [] typeMod1AppliedTo = typeMod1AppliedTo_.split(Utils.PROPERTIES_MAIN_SEPARATOR);
				String typeMod2AppliedTo_ = weaponProperties.getProperty("weapon." + weapon + ".weapontypemod2.appliedto");
				String [] typeMod2AppliedTo =  typeMod2AppliedTo_.split(Utils.PROPERTIES_MAIN_SEPARATOR);
				/*----------*/
				
				int specialMod1 = Utils.castToInt(weaponProperties.getProperty("weapon." + weapon + ".specialmod1"));
				int specialMod2 = Utils.castToInt(weaponProperties.getProperty("weapon." + weapon + ".specialmod2"));
				
				String[] specialMod1AppliedTo = weaponProperties.getProperty("weapon." + weapon + ".specialmod1.appliedto")
						.split(Utils.PROPERTIES_MAIN_SEPARATOR);
				String[] specialMod2AppliedTo = weaponProperties.getProperty("weapon." + weapon + ".specialmod2.appliedto")
						.split(Utils.PROPERTIES_MAIN_SEPARATOR);
				
				int reloadAssaults = Utils.castToInt(weaponProperties.getProperty("weapon." + weapon + ".reloadassaults"));
				int malusNoReload = Utils.castToInt(weaponProperties.getProperty("weapon." + weapon + ".malusnoreload"));
				
				String price = weaponProperties.getProperty("weapon." + weapon + ".price");
				Price price_obj = new Price(price);
				 
				/*----------------------------------*/
				WeaponItem wi = new WeaponItem(type,category,main_critical,second_critical,botch,range
						,weight,specialMod1,specialMod1AppliedTo,specialMod2,specialMod2AppliedTo
						,reloadAssaults,malusNoReload,price_obj,usedTwoHanded,botchTwoHanded,
						botch_critical,bonus2H,skillMods);
				
				wi.setTypeMod1(typeMod1);
				wi.conversionTypeMod(1,typeMod1AppliedTo);
				wi.setTypeMod2(typeMod2);
				wi.conversionTypeMod(2,typeMod2AppliedTo);
				/*--------------------------------------*/
				
				Cache.weaponItems.put(getKey(weapon), wi);


			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error, The file does not exist");
		} catch (IOException e) {
			System.out.println("Error, Reading the file has not been possible");
		}
	}
	
	private static Botch createBotch(String botch_in, String botchCriticaltaken_in ){
		Botch botch = new Botch();
		
		if(botch_in.contains(Utils.PROPERTIES_SECONDARY_SEPARATOR)){
			String [] botch_numbers = botch_in.split(Utils.PROPERTIES_SECONDARY_SEPARATOR);
			botch.setMin(Integer.parseInt(botch_numbers[0]));
			botch.setMax(Integer.parseInt(botch_numbers[1]));
			
			if(!botchCriticaltaken_in.isEmpty()){

				Critical botchCriticalTaken = new Critical();
				String[] botch_cri_array = botchCriticaltaken_in.split(Utils.PROPERTIES_SECONDARY_SEPARATOR);
				botchCriticalTaken.setCriticalMaxGravity(botch_cri_array[1]);
				botchCriticalTaken.setCriticalType(Critical.assesCriticalType(botch_cri_array[0]));
				botch.setCriticalTaken(botchCriticalTaken);
			}
		}
		return botch;
	}
	
	private static Critical createCritical(String critical_in){
		Critical critical = new Critical();
		
		if(!critical_in.isEmpty()){
			
			String[] cri_array = critical_in.split(Utils.PROPERTIES_SECONDARY_SEPARATOR);
			critical.setCriticalType(Critical.assesCriticalType(cri_array[0]));
			
			if(cri_array.length > 1){
				critical.setCriticalMaxGravity(cri_array[1]);
			}
		}
		return critical;
	}
	
	private static Integer getKey(String type){
		
		/*WEAPONS*/
		if(type.equalsIgnoreCase("BROADSWORD")){
			return WeaponItem.BROADSWORD;
		}else if(type.equalsIgnoreCase("DAGGER")){
			return WeaponItem.DAGGER;
		}else if(type.equalsIgnoreCase("AXE")){
			return WeaponItem.AXE;
		}else if(type.equalsIgnoreCase("SCIMITAR")){
			return WeaponItem.SCIMITAR;
		}else if(type.equalsIgnoreCase("SHORTSWORD")){
			return WeaponItem.SHORTSWORD;
		}else if(type.equalsIgnoreCase("CLUB")){
			return WeaponItem.CLUB;
		}else if(type.equalsIgnoreCase("MACE")){
			return WeaponItem.MACE;
		}else if(type.equalsIgnoreCase("MORNINGSTAR")){
			return WeaponItem.MORNINGSTAR;
		}else if(type.equalsIgnoreCase("NET")){
			return WeaponItem.NET;
		}else if(type.equalsIgnoreCase("WARHAMMER")){
			return WeaponItem.WARHAMMER;
		}else if(type.equalsIgnoreCase("WHIP")){
			return WeaponItem.WHIP;
		}else if(type.equalsIgnoreCase("JAVELIN")){
			return WeaponItem.JAVELIN;
		}else if(type.equalsIgnoreCase("SPEAR")){
			return WeaponItem.SPEAR;
		}else if(type.equalsIgnoreCase("LANCE")){
			return WeaponItem.LANCE;
		}else if(type.equalsIgnoreCase("HALBERD")){
			return WeaponItem.HALBERD;
		}else if(type.equalsIgnoreCase("BATTLEAXE")){
			return WeaponItem.BATTLEAXE;
		}else if(type.equalsIgnoreCase("FLAIL")){
			return WeaponItem.FLAIL;
		}else if(type.equalsIgnoreCase("STAFF")){
			return WeaponItem.STAFF;
		}else if(type.equalsIgnoreCase("GREATSWORD")){
			return WeaponItem.GREATSWORD;
		}else if(type.equalsIgnoreCase("BOLAS")){
			return WeaponItem.BOLAS;
		}else if(type.equalsIgnoreCase("COMPOSITEBOW")){
			return WeaponItem.COMPOSITEBOW;
		}else if(type.equalsIgnoreCase("SHORTBOW")){
			return WeaponItem.SHORTBOW;
		}else if(type.equalsIgnoreCase("LONGBOW")){
			return WeaponItem.LONGBOW;
		}else if(type.equalsIgnoreCase("CROSSBOW")){
			return WeaponItem.CROSSBOW;
		}else if(type.equalsIgnoreCase("SLING")){
			return WeaponItem.SLING;
		}else if(type.equalsIgnoreCase("BASTARDSWORD")){
			return WeaponItem.BASTARDSWORD;
		}else if(type.equalsIgnoreCase("DOUBLEAXE")){
			return WeaponItem.DOUBLEAXE;
		}
		/*ARMOURS*/
		else if(type.equalsIgnoreCase("SOFT_LEATHER")){
			return ArmourItem.SOFT_LEATHER;
		}else if(type.equalsIgnoreCase("RIGID_LEATHER")){
			return ArmourItem.RIGID_LEATHER;
		}else if(type.equalsIgnoreCase("CHAIN")){
			return ArmourItem.CHAIN;
		}else if(type.equalsIgnoreCase("PLATE")){
			return ArmourItem.PLATE;
		/*SHIELDS*/	
		}else if(type.equalsIgnoreCase("GREAT_SHIELD")){
			return ArmourItem.GREAT_SHIELD;
		}else if(type.equalsIgnoreCase("MEDIUM_SHIELD")){
			return ArmourItem.MEDIUM_SHIELD;
		}else if(type.equalsIgnoreCase("SMALL_SHIELD")){
			return ArmourItem.SMALL_SHIELD;
		}
		/*GEAR*/
		else if(type.equalsIgnoreCase("LEATHER_HELMET")){
			return ArmourItem.LEATHER_HELMET;
		}else if(type.equalsIgnoreCase("METAL_HELMET")){
			return ArmourItem.METAL_HELMET;
		}else if(type.equalsIgnoreCase("LEATHER_BRACERS")){
			return ArmourItem.LEATHER_BRACERS;
		}else if(type.equalsIgnoreCase("METAL_BRACERS")){
			return ArmourItem.METAL_BRACERS;
		}else if(type.equalsIgnoreCase("LEATHER_GREAVES")){
			return ArmourItem.LEATHER_GREAVERS;
		}else if(type.equalsIgnoreCase("METAL_GREAVES")){
			return ArmourItem.METAL_GREAVERS;
		}
		

		return null;

	}
	
	private static void resetDefaults() {
		/*ESCUDOS*/
		
		try{
			Cache.armourItems.remove(ArmourItem.GREAT_SHIELD);
			Cache.armourItems.remove(ArmourItem.MEDIUM_SHIELD);
			Cache.armourItems.remove(ArmourItem.SMALL_SHIELD);
			
			/** Creamos un Objeto de tipo Properties */
			Properties resetProperties = new Properties();
	
			/** Cargamos el archivo desde la ruta especificada */
			resetProperties.load(new FileInputStream(
					"src/properties/armour.properties"));
			
			String [] shields = {"great"};
			for(String shield : shields){
				
				int [] skillMods = new int[Skill.SKILLS_TOTAL_NUMBER];
				int category = Item.SHIELD;
				String type = resetProperties.getProperty("shield." + shield + ".type");
				float weight = Utils.castToFloat(resetProperties.getProperty("shield." + shield + ".weight"));
				String material = resetProperties.getProperty("shield." + shield + ".material");
				String price = resetProperties.getProperty("shield." + shield + ".price.default");
				Price price_obj = new Price(price);

				int BD = Utils.castToInt(resetProperties.getProperty("shield." + shield + ".BD.default"));
				int BO = Utils.castToInt(resetProperties.getProperty("shield." + shield + ".BO.default"));
					
				skillMods[Skill.BD] = skillMods[Skill.BD] + BD;
				skillMods[Skill.EDGED] = skillMods[Skill.EDGED] + BO;
				skillMods[Skill.CONCUSSION] = skillMods[Skill.CONCUSSION] + BO;
				skillMods[Skill.TWO_HANDED] = skillMods[Skill.TWO_HANDED] + BO;
				skillMods[Skill.THROWN] = skillMods[Skill.THROWN] + BO;
				skillMods[Skill.PROJECTILE] = skillMods[Skill.PROJECTILE] + BO;
				skillMods[Skill.POLEARM] = skillMods[Skill.POLEARM] + BO;
				
				ArmourItem ai = new ArmourItem(type, weight,price_obj,category, material, skillMods, BO );
	
				
				Cache.armourItems.put(getKey(shield+"_shield"), ai);
			}
	
		} catch (FileNotFoundException e) {
			System.out.println("Error, The file does not exist");
		} catch (IOException e) {
			System.out.println("Error, Reading the file has not been possible");
		}
		
		
	}

	private static void print(Map<Integer, Item> items) {
		
		for(Map.Entry<Integer, Item> entry: items.entrySet()){
			Item item = entry.getValue();
			System.out.println(item.toString());
		}
	}

}
