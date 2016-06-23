package beans.combat;

import beans.Character;
import beans.Item;
import beans.WeaponItem;

public class AttackProjectile extends Attack {

	public AttackProjectile(Character actor, int diceRoll, Character enemy, int parryBonus
			,int otherBonus, String otherBonusDescription, int attackCategory) {
		super(actor, diceRoll, enemy, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void resolveAttack() {
		
		WeaponItem weapon = (WeaponItem) actor.getEquippedGear().get(Item.WEAPON_1);

		rollCalculation = diceRoll + weapon.getBO() - enemy.getTotalBD() + otherBonus;
		
		outcome = new AttackOutcome(rollCalculation, this);
		
	}

}
