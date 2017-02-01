package beans.combat;

import beans.ArmourItem;
import beans.Character;
import beans.Item;
import beans.WeaponItem;

public abstract class Attack extends Action{
	
	public static final int EDGED = 1;
	public static final int CONCUSSION = 2;
	public static final int PROJECTILE = 3;
	public static final int TWO_HANDED = 4;
	public static final int GRIP_UNBALANCE = 5;
	public static final int UNBALANCE = 6;
	public static final int CLAWS_BITE = 7;
	public static final int SPELL_BEAM= 8;
	public static final int SPELL_AREA= 9;
	public static final int SPELL_BASE= 10;
	
	protected int category;
	
	protected int diceRoll;
	protected int rollCalculation;
	protected Character enemy;
	protected int parryBonus;
	protected int otherBonus;
	protected String otherBonusDescription;
	protected AttackOutcome outcome;
	protected WeaponItem weapon;
	protected ArmourItem enemyArmour;
	protected BotchOutcome botchOutcome;
	
	public Attack(){
		super();
	};
	
	public Attack(Character actor, int diceRoll, Character enemy, int parryBonus,
			int otherBonus, String otherBonusDescription, int attackCategory) {
		
		super(actor);
		this.diceRoll = diceRoll;
		this.enemy = enemy;
		this.otherBonus = otherBonus;
		this.otherBonusDescription = otherBonusDescription;
		this.parryBonus = parryBonus;
		this.weapon = (WeaponItem) actor.getEquippedGear().get(Item.WEAPON_1);
		this.enemyArmour = (ArmourItem) enemy.getEquippedGear().get(Item.ARMOUR);
		this.category = attackCategory;
	}
	
	
	
	
	public int getCategory() {
		return category;
	}


	public void setCategory(int category) {
		this.category = category;
	}

	public int getDiceRoll() {
		return diceRoll;
	}

	public void setDiceRoll(int diceRoll) {
		this.diceRoll = diceRoll;
	}

	public int getRollCalculation() {
		return rollCalculation;
	}

	public void setRollCalculation(int rollCalculation) {
		this.rollCalculation = rollCalculation;
	}


	public Character getEnemy() {
		return enemy;
	}


	public void setEnemy(Character enemy) {
		this.enemy = enemy;
	}

	public int getParryBonus() {
		return parryBonus;
	}


	public void setParryBonus(int parryBonus) {
		this.parryBonus = parryBonus;
	}

	public int getOtherBonus() {
		return otherBonus;
	}

	public void setOtherBonus(int otherBonus) {
		this.otherBonus = otherBonus;
	}

	public String getOtherBonusDescription() {
		return otherBonusDescription;
	}

	public void setOtherBonusDescription(String otherBonusDescription) {
		this.otherBonusDescription = otherBonusDescription;
	}

	public AttackOutcome getOutcome() {
		return outcome;
	}


	public void setOutcome(AttackOutcome outcome) {
		this.outcome = outcome;
	}

	public WeaponItem getWeapon() {
		return weapon;
	}
	public void setWeapon(WeaponItem weapon) {
		this.weapon = weapon;
	}


	public ArmourItem getEnemyArmour() {
		return enemyArmour;
	}


	public void setEnemyArmour(ArmourItem enemyArmour) {
		this.enemyArmour = enemyArmour;
	}
	
	
	public BotchOutcome getBotchOutcome() {
		return botchOutcome;
	}

	public void setBotchOutcome(BotchOutcome botchOutcome) {
		this.botchOutcome = botchOutcome;
	}

	protected abstract void resolveAttack();
	 
}
