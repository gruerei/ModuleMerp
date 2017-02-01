package beans;

import beans.combat.Attack;
import beans.combat.AttackMelee;
import beans.combat.AttackProjectile;
import beans.combat.AttackSpell;

public class Botch {
	private int min;
	private int max;
	private Critical criticalTaken; 
	
	
	public Botch(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	
	public Botch(int min, int max, Critical criticalTaken) {
		this.min = min;
		this.max = max;
		this.criticalTaken = criticalTaken;
	}

	public Botch() {
	}


	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}


	public Critical getCriticalTaken() {
		return criticalTaken;
	}


	public void setCriticalTaken(Critical criticalTaken) {
		this.criticalTaken = criticalTaken;
	}


	public static int modifyRollByBotchType(String botchType, Attack attackMelee, boolean mounted) {
		int ret = 0;
		
		if(botchType.equals("WEAPON")){
			
			WeaponItem weapon = (WeaponItem)attackMelee.getActor().getEquippedGear().get(WeaponItem.WEAPON_1);
			
			if(weapon.getCategory() == WeaponItem.CONCUSSION){
				System.out.println("MODIFICADOR PIFIA: MELEE: CONCUSSION WEAPON : -20");
				ret = -20;
			}else if(weapon.getCategory() == WeaponItem.EDGED){
				System.out.println("MODIFICADOR PIFIA: MELEE: EDGED WEAPON : -10");
				ret = -10;
			}else if(weapon.getCategory() == WeaponItem.TWO_HANDED){
				System.out.println("MODIFICADOR PIFIA: MELEE: TWO_HANDED WEAPON : +0");
				ret = 0;
			}else if(weapon.getCategory() == WeaponItem.POLEARM){
				System.out.println("MODIFICADOR PIFIA: MELEE: POLEARM WEAPON : +10");
				ret = +10;
			}

			if(mounted){
				System.out.println("MODIFICADOR PIFIA: MELEE: MOUNTED : +20");
				ret = ret +20;
			}
			
			
		}else if(botchType.equals("PROJECTILE")){
			
			WeaponItem weapon = (WeaponItem)attackMelee.getActor().getEquippedGear().get(WeaponItem.WEAPON_1);
			
			if(weapon.getType().equals(WeaponItem.SLING)){
				System.out.println("PROJECTILE: SLING WEAPON : -20");
				ret = -20;
			}else if(weapon.getType().equals(WeaponItem.SHORTBOW)){
				System.out.println("PROJECTILE: SHORTBOW WEAPON : -10");
				ret = -10;
			}else if(weapon.getType().equals(WeaponItem.COMPOSITEBOW)){
				System.out.println("PROJECTILE: COMPOSITEBOW WEAPON : +0");
				ret = 0;
			}else if(weapon.getType().equals(WeaponItem.LONGBOW)){
				System.out.println("PROJECTILE: LONGBOW WEAPON : +10");
				ret = +10;
			}else if(weapon.getType().equals(WeaponItem.CROSSBOW)){
				System.out.println("PROJECTILE: CROSSBOW WEAPON : +20");
				ret = +20;
			}

			
		}else if(botchType.equals("SPELL")){
			
		}
		
		
		return ret;
		
	}

	
	
}
