package beans.combat;

import beans.ArmourItem;
import beans.Attribute;
import beans.Character;
import beans.Item;
import beans.Skill;
import beans.WeaponItem;
import cache.Cache;

public class AttackMelee extends Attack {

	protected int rollCalculation;
	
	public AttackMelee(Character actor, int diceRoll, Character enemy, int parryBonus,
			int otherBonus, String otherBonusDescription, int attackCategory) {
		super(actor, diceRoll, enemy, parryBonus, otherBonus, otherBonusDescription,attackCategory);
		String weaponName = actor.getEquippedGear().get(Item.WEAPON_1).getName() == null ? actor.getEquippedGear().get(Item.WEAPON_1).getType() : actor.getEquippedGear().get(Item.WEAPON_1).getName();
		System.out.println("\n"+actor.getName() +" ataca a "+enemy.getName()+" con "+ weaponName);
		resolveAttack();
	}

	@Override
	protected void resolveAttack() {
		
		
		//attackFromBehind: Enemigo no puede parar y no hay bono por escudo
		//stunned: Enemigo para como máximo con la mitad
		//offguarded : Enemigo no para y no puede usar BD escudo
		//flanked: Segun sitio del escudo, no se cuenta BD
		
		if(diceRoll <= weapon.getBotch().getMax()){
			//PIFIA
			new BotchOutcome(this);
		}else{
			
			int enemyTotalBD = enemy.getTotalBD();

			ArmourItem enemyShield = (ArmourItem)enemy.getEquippedGear().get(Item.SHIELD);
			if(!enemy.isAbleToBlock() && enemyShield!=null){
				enemyTotalBD = enemyTotalBD - enemyShield.getSkillMods()[Skill.BD];
			}
			
			if(enemy.getStunned() != null && enemy.isOffGuarded() && enemy.isAttackedFromBehind()){
				enemyTotalBD = enemyTotalBD - enemy.getAttributes().get(Attribute.AGILITY).getModifTotal();
				otherBonus = otherBonus + Cache.combatProperties.get(Combat.STUNNED_OFF_GUARDED_ATTACKED_FROM_BEHIND);
			}else if(enemy.isOffGuarded() && enemy.isFlanked()){
				enemyTotalBD = enemyTotalBD - enemy.getAttributes().get(Attribute.AGILITY).getModifTotal();
				otherBonus = otherBonus + Cache.combatProperties.get(Combat.OFF_GUARDED_FLANKED);
			}else if(enemy.isOffGuarded() && enemy.isAttackedFromBehind()){
				enemyTotalBD = enemyTotalBD - enemy.getAttributes().get(Attribute.AGILITY).getModifTotal();
				otherBonus = otherBonus + Cache.combatProperties.get(Combat.OFF_GUARDED_ATTACKED_FROM_BEHIND);
			}else if(enemy.getStunned() != null && enemy.isFlanked()){
				otherBonus = otherBonus + Cache.combatProperties.get(Combat.STUNNED_FLANKED);
			}else if(enemy.getStunned() != null && enemy.isAttackedFromBehind()){
				otherBonus = otherBonus + Cache.combatProperties.get(Combat.STUNNED_ATTACKED_FROM_BEHIND);
			}else if(enemy.getStunned() != null && enemy.isOffGuarded()){
				enemyTotalBD = enemyTotalBD - enemy.getAttributes().get(Attribute.AGILITY).getModifTotal();
				otherBonus = otherBonus + Cache.combatProperties.get(Combat.STUNNED_OFF_GUARDED);
			}
			
			else if(enemy.isFlanked()){
				otherBonus = otherBonus + Cache.combatProperties.get(Combat.FLANKED);
			}else if(enemy.isAttackedFromBehind()){
				//El enemigo no puede parar(controlar con mensaje informativo en interfaz)
				otherBonus = otherBonus + Cache.combatProperties.get(Combat.ATTACKED_FROM_BEHIND);
			}else if(enemy.getStunned() != null){
				//El enemigo solo puede parar con la mitad de su BO(controlar con mensaje informativo en interfaz)
				otherBonus = otherBonus + Cache.combatProperties.get(Combat.STUNNED);
			}else if(enemy.isOffGuarded()){
				//El enemigo no puede parar(controlar con mensaje informativo en interfaz)
				enemyTotalBD = enemyTotalBD - enemy.getAttributes().get(Attribute.AGILITY).getModifTotal();
				otherBonus = otherBonus + Cache.combatProperties.get(Combat.OFF_GUARDED);
			}
			
			int bonusAct = 0;
			if(actor.getActivity() != null){
				bonusAct = actor.getActivity().getActivityModif();
			}
			
			rollCalculation = diceRoll + weapon.getBO() - actor.getParryBonusInUse() -  enemy.getTotalBD()
					- super.parryBonus + otherBonus + bonusAct;
			
			System.out.println(diceRoll + " Roll + "+ weapon.getBO() +" BO - " + actor.getParryBonusInUse() + " BO used to parry - " +
			enemyTotalBD + " BD " +enemy.getName() + " - " +super.parryBonus+ " Enemy Parry " 
					+ (bonusAct != 0 ? bonusAct + " Modif. Actividad "  : "" ) + "= " +rollCalculation);
			outcome = new AttackOutcome(rollCalculation, this);
		}
		
	}

}
