package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Map;

import beans.Botch;
import beans.Critical;
import beans.Price;
import beans.WeaponItem;
import cache.Cache;

public class ReadProperties {

	public static void main(String arg[]) {

		ReadProperties.readWeaponFile();
		

		for(Map.Entry<Integer, WeaponItem> entry: Cache.weaponItems.entrySet()){
			WeaponItem weapon = entry.getValue();
			System.out.println(weapon.toString());
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
						botch_critical,bonus2H);
				
				wi.setTypeMod1(typeMod1);
				wi.conversionTypeMod(1,typeMod1AppliedTo);
				wi.setTypeMod2(typeMod2);
				wi.conversionTypeMod(2,typeMod2AppliedTo);
				/*--------------------------------------*/
				
				Cache.weaponItems.put(getWeaponKey(weapon), wi);


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
	
	private static Integer getWeaponKey(String weaponType){
		
		if(weaponType.equalsIgnoreCase("BROADSWORD")){
			return WeaponItem.BROADSWORD;
		}else if(weaponType.equalsIgnoreCase("DAGGER")){
			return WeaponItem.DAGGER;
		}else if(weaponType.equalsIgnoreCase("AXE")){
			return WeaponItem.AXE;
		}else if(weaponType.equalsIgnoreCase("SCIMITAR")){
			return WeaponItem.SCIMITAR;
		}else if(weaponType.equalsIgnoreCase("SHORTSWORD")){
			return WeaponItem.SHORTSWORD;
		}else if(weaponType.equalsIgnoreCase("CLUB")){
			return WeaponItem.CLUB;
		}else if(weaponType.equalsIgnoreCase("MACE")){
			return WeaponItem.MACE;
		}else if(weaponType.equalsIgnoreCase("MORNINGSTAR")){
			return WeaponItem.MORNINGSTAR;
		}else if(weaponType.equalsIgnoreCase("NET")){
			return WeaponItem.NET;
		}else if(weaponType.equalsIgnoreCase("WARHAMMER")){
			return WeaponItem.WARHAMMER;
		}else if(weaponType.equalsIgnoreCase("WHIP")){
			return WeaponItem.WHIP;
		}else if(weaponType.equalsIgnoreCase("JAVELIN")){
			return WeaponItem.JAVELIN;
		}else if(weaponType.equalsIgnoreCase("SPEAR")){
			return WeaponItem.SPEAR;
		}else if(weaponType.equalsIgnoreCase("LANCE")){
			return WeaponItem.LANCE;
		}else if(weaponType.equalsIgnoreCase("HALBERD")){
			return WeaponItem.HALBERD;
		}else if(weaponType.equalsIgnoreCase("BATTLEAXE")){
			return WeaponItem.BATTLEAXE;
		}else if(weaponType.equalsIgnoreCase("FLAIL")){
			return WeaponItem.FLAIL;
		}else if(weaponType.equalsIgnoreCase("STAFF")){
			return WeaponItem.STAFF;
		}else if(weaponType.equalsIgnoreCase("GREATSWORD")){
			return WeaponItem.GREATSWORD;
		}else if(weaponType.equalsIgnoreCase("BOLAS")){
			return WeaponItem.BOLAS;
		}else if(weaponType.equalsIgnoreCase("COMPOSITEBOW")){
			return WeaponItem.COMPOSITEBOW;
		}else if(weaponType.equalsIgnoreCase("SHORTBOW")){
			return WeaponItem.SHORTBOW;
		}else if(weaponType.equalsIgnoreCase("LONGBOW")){
			return WeaponItem.LONGBOW;
		}else if(weaponType.equalsIgnoreCase("CROSSBOW")){
			return WeaponItem.CROSSBOW;
		}else if(weaponType.equalsIgnoreCase("SLING")){
			return WeaponItem.SLING;
		}else if(weaponType.equalsIgnoreCase("BASTARDSWORD")){
			return WeaponItem.BASTARDSWORD;
		}else if(weaponType.equalsIgnoreCase("DOUBLEAXE")){
			return WeaponItem.DOUBLEAXE;
		}
		return null;

	}
	

}
