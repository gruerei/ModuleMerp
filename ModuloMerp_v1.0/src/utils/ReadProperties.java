package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import beans.Botch;
import beans.Price;
import beans.WeaponItem;

public class ReadProperties {

	public static void main(String arg[]) {

		ReadProperties.readConfigurationFiles();
	}

	/**
	 * Lee un archivo de propiedades desde una ruta especifica y se imprime en
	 * pantalla.
	 */
	public static void readConfigurationFiles() {
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
				
				
				String main_critical = weaponProperties.getProperty("weapon." + weapon + ".maincritical");
				String second_critical = weaponProperties.getProperty("weapon." + weapon + ".secondcritical");
				
				String botch_ = weaponProperties.getProperty("weapon." + weapon + ".botch");
				String botchCriticaltaken = weaponProperties.getProperty("weapon." + weapon + ".botch.criticaltaken");
	
				Botch botch = new Botch();
				
				if(botch_.contains(Utils.PROPERTIES_SECONDARY_SEPARATOR)){
					String [] botch_numbers = botch_.split(Utils.PROPERTIES_SECONDARY_SEPARATOR);
					botch.setMin(Integer.parseInt(botch_numbers[0]));
					botch.setMax(Integer.parseInt(botch_numbers[1]));
					
					if(!botchCriticaltaken.isEmpty()){
						
						botch.setCriticalTakenGravity(botchCriticaltaken);
						
						if(botchCriticaltaken.equals("SL"))
							botch.setCriticalTakenType(WeaponItem.CRITICAL_SLASH);
						else if(botchCriticaltaken.equals("PU")){
							botch.setCriticalTakenType(WeaponItem.CRITICAL_PUNCTURE);
						}else if(botchCriticaltaken.equals("CR")){
							botch.setCriticalTakenType(WeaponItem.CRITICAL_CRUNCH);
						}
					}
				}
				
				int range = Utils.castToInt(weaponProperties.getProperty("weapon." + weapon + ".range"));
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
				 
				WeaponItem wi = new WeaponItem(type,category,main_critical,second_critical,botch,range
						,weight,typeMod1,typeMod1AppliedTo,typeMod2,typeMod2AppliedTo,
						specialMod1,specialMod1AppliedTo,specialMod2,specialMod2AppliedTo
						,reloadAssaults,malusNoReload,price_obj);
				
				System.out.println(wi.toString());
				
				

			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error, The file does not exist");
		} catch (IOException e) {
			System.out.println("Error, Reading the file has not been possible");
		}
	}
}
