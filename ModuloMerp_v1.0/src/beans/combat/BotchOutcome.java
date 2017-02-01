package beans.combat;

import beans.Botch;
import beans.Character;
import beans.CombatStatus;
import beans.Critical;
import beans.CriticalOutcome;
import beans.Item;
import beans.WeaponItem;
import cache.Cache;
import utils.Utils;
import utils.Tables.Tables;
import utils.Tables.Tables_Botch;
import utils.Tables.Tables_Crit;

public class BotchOutcome {

	private int botchLifePoints;
	private int botchLifePointsPerAssault;
	private int[] botchMalusActivity;
	private String botchAssaultsStunned;
	private String botchTearItem;
	private int botchCauseBodyDisability;
	private String botchCauseAddCrit;
	private int botchCauseUnconsc;
	private int botchItemProtection;
	private Critical critical;
	private CriticalOutcome criticalOutcome;
	private CriticalOutcome botchWeaponCriticalOutcome;
	private Action action;
	private String botchDescription;
	private int botchRoll;
	private int botchRollModified;

	public static int botchRollTest = 0;

	public BotchOutcome(Attack attack) {
		this.action = attack;
	}

	public BotchOutcome() {
	}

	
	
	public CriticalOutcome getCriticalOutcome() {
		return criticalOutcome;
	}

	public void setCriticalOutcome(CriticalOutcome criticalOutcome) {
		this.criticalOutcome = criticalOutcome;
	}

	public CriticalOutcome getBotchWeaponCriticalOutcome() {
		return botchWeaponCriticalOutcome;
	}

	public void setBotchWeaponCriticalOutcome(CriticalOutcome botchWeaponCriticalOutcome) {
		this.botchWeaponCriticalOutcome = botchWeaponCriticalOutcome;
	}

	public int getBotchLifePoints() {
		return botchLifePoints;
	}

	public void setBotchLifePoints(int botchLifePoints) {
		this.botchLifePoints = botchLifePoints;
	}

	public int getBotchLifePointsPerAssault() {
		return botchLifePointsPerAssault;
	}

	public void setBotchLifePointsPerAssault(int botchLifePointsPerAssault) {
		this.botchLifePointsPerAssault = botchLifePointsPerAssault;
	}

	public String getBotchAssaultsStunned() {
		return botchAssaultsStunned;
	}

	public void setBotchAssaultsStunned(String botchAssaultsStunned) {
		this.botchAssaultsStunned = botchAssaultsStunned;
	}

	public int[] getBotchMalusActivity() {
		return botchMalusActivity;
	}

	public void setBotchMalusActivity(int[] botchMalusActivity) {
		this.botchMalusActivity = botchMalusActivity;
	}

	public String getBotchTearItem() {
		return botchTearItem;
	}

	public void setBotchTearItem(String botchTearItem) {
		this.botchTearItem = botchTearItem;
	}

	public String getBotchDescription() {
		return botchDescription;
	}

	public void setBotchDescription(String botchDescription) {
		this.botchDescription = botchDescription;
	}

	public int getBotchCauseBodyDisability() {
		return botchCauseBodyDisability;
	}

	public void setBotchCauseBodyDisability(int botchCauseBodyDisability) {
		this.botchCauseBodyDisability = botchCauseBodyDisability;
	}

	public String getBotchCauseAddCrit() {
		return botchCauseAddCrit;
	}

	public void setBotchCauseAddCrit(String botchCauseAddCrit) {
		this.botchCauseAddCrit = botchCauseAddCrit;
	}

	public int getBotchCauseUnconsc() {
		return botchCauseUnconsc;
	}

	public void setBotchCauseUnconsc(int botchCauseUnconsc) {
		this.botchCauseUnconsc = botchCauseUnconsc;
	}

	public int getBotchRoll() {
		return botchRoll;
	}

	public void setBotchRoll(int botchRoll) {
		this.botchRoll = botchRoll;
	}

	public int getBotchRollModified() {
		return botchRollModified;
	}

	public void setBotchRollModified(int botchRollModified) {
		this.botchRollModified = botchRollModified;
	}

	public int getBotchItemProtection() {
		return botchItemProtection;
	}

	public void setBotchItemProtection(int botchItemProtection) {
		this.botchItemProtection = botchItemProtection;
	}

	public void botchAssess(Character actor, AttackMelee attackMelee) {
		int botchRoll = 0;
		boolean inputOk;

		do {
			try {
				System.out.print("Introduzca el valor de la tirada de pifia: ");
				botchRoll = botchRollTest;
				/** TODO: Descomentar botchRoll */
				// botchRoll = Utils.castToInt(Utils.readFromInputLine());
				setBotchRoll(botchRoll);
				System.out.println("\nTirada de Pifia: " + botchRoll);
				inputOk = true;
			} catch (NumberFormatException e) {
				System.out.println("Valor introducido incorrecto. Debe introducir un valor numerico.");
				inputOk = false;
			}
		} while (inputOk == false);

		boolean montado = actor.isMounted();
		/*
		 * String montadoIn = ""; do{ try{ System.out.print(
		 * "Combatiente Montado?: Y/N "); //montadoIn =
		 * Utils.readFromInputLine(); montadoIn = mountedTest;
		 * if(montadoIn.equalsIgnoreCase("Y")){ System.out.println(
		 * "\nCombatiente montado asignado."); montado = true; }else{
		 * System.out.println(""); }
		 * 
		 * 
		 * }catch(NumberFormatException e){ System.out.println(
		 * "Valor introducido incorrecto."); inputOk = false; } }while(inputOk
		 * == false);
		 */

		String botchType = "";

		if (action instanceof AttackMelee) {

			botchType = "WEAPON";

		} else if (action instanceof AttackProjectile) {
			botchType = "PROJECTILE";
		} else if (action instanceof AttackSpell) {
			botchType = "SPELL";
		} else {

			botchType = "MANEUVER";
		}

		botchRoll = botchRoll + Botch.modifyRollByBotchType(botchType, attackMelee, montado);
		System.out.println("Pifia Modificada : " + botchRoll);
		setBotchRollModified(botchRoll);

		if (botchRoll > 120) {
			botchRoll = 120;
			System.out.println("Maximo de Pifia superado. Establecido al valor máximo : 120");
		}

		String[] botchOutcome = Tables_Botch.getTableValue(botchType, botchRoll);

		fillOutcome(botchOutcome, actor, botchRoll);
		

	}

	private void fillOutcome(String[] botchOutcome, Character actor, int botchRoll) {

		setBotchItemProtection(Utils.castToInt(botchOutcome[Tables_Botch.COL_ITEM_PROTECTION]));

		botchDescription = botchOutcome[Tables_Botch.COL_DESCRIPTION];
		System.out.println(actor.getName() + " : " + botchDescription);

		String botchLifePoints = botchOutcome[Tables_Botch.COL_LIFE_POINTS];
		int calculLP = Utils.castToInt(botchLifePoints);
		setBotchLifePoints(calculLP);

		String botchLifePointsPerAssault = botchOutcome[Tables_Botch.COL_LIFE_POINTS_PER_ASSAULT];
		int calculLifePointsPerAssault = Utils.castToInt(botchLifePointsPerAssault);
		setBotchLifePointsPerAssault(calculLifePointsPerAssault);

		String botchMalusActivity = botchOutcome[Tables_Botch.COL_MALUS_ACTIVITY];
		int[] calculMalusActivity = calculActivity(botchMalusActivity);
		setBotchMalusActivity(calculMalusActivity);

		String botchAssaultsStunned = botchOutcome[Tables_Botch.COL_STUNNED_ASSAULTS];
		setBotchAssaultsStunned(botchAssaultsStunned);

		String botchTearItem = botchOutcome[Tables_Botch.COL_TEAR_ITEM];
		setBotchTearItem(botchTearItem);

		String botchCauseBodyDisability = botchOutcome[Tables_Botch.COL_CAUSE_BODY_DISABILITY];
		if (botchCauseBodyDisability.contains("?")) {
			boolean applyEffect = Utils.askConfirmation(botchCauseBodyDisability);
			if (applyEffect) {
				int bodyPart = Utils.castToInt(botchCauseBodyDisability.replace("?", ""));
				setBotchCauseBodyDisability(bodyPart);
			}
		} else {
			setBotchCauseBodyDisability(Utils.castToInt(botchCauseBodyDisability));
		}

		String botchCauseCrit = botchOutcome[Tables_Botch.COL_CAUSE_CRIT];
		if (botchRoll == 110) {
			if (!actor.isMounted())
				botchCauseCrit = "0";
		}
		setBotchCauseAddCrit(botchCauseCrit);

		String botchCauseUnconsc = botchOutcome[Tables_Botch.COL_CAUSE_UNCONSCIOUSSNESS];
		int calculCauseUnconsc = Utils.calculOutcomeByProtection(botchCauseUnconsc, actor,
				Tables_Crit.COL_CAUSE_UNCONSCIOUSSNESS, getBotchItemProtection());
		setBotchCauseUnconsc(calculCauseUnconsc);

		// String critAssaultsToDeath =
		// botchOutcome[Tables_Botch.COL_ASSAULTS_TO_DEATH];

	}

	private int[] calculActivity(String valueIn) {
		int[] valueRetourned = new int[2];

		if (valueIn.contains("_")) {
			String[] split = valueIn.split("_");
			valueRetourned[0] = Utils.castToInt(split[0]);

			/* El tipo de Malus a la Actividad(H - Heridas / A - Asaltos) */
			if (split[1].equals("H")) {
				valueRetourned[1] = 999;
			} else if (split[1].contains("A")) {
				valueRetourned[1] = Utils.castToInt(split[1].replace("A", ""));
			} else {
				valueRetourned[0] = 0;
				valueRetourned[1] = 0;
			}

		} else {
			valueRetourned[0] = 0;
			valueRetourned[1] = 0;
		}

		return valueRetourned;
	}

	public void applyOutcome(Character actor, Character enemy) {
		CombatStatus cs = null;

		// LIFE POINTS
		if (getBotchLifePoints() > 0)
			actor.lifePointsLost(getBotchLifePoints());

		// LIFE POINTS PER ASSAULT
		if (getBotchLifePointsPerAssault() > 0) {
			cs = actor.addBleeding(getBotchLifePointsPerAssault(), CombatStatus.BLEEDING_WOUND, 0);
			cs.setDescription(getBotchDescription());
		}

		// ACTIVITY MALUS
		if (botchMalusActivity[0] != 0) {
			if (botchMalusActivity[1] == 999) {
				cs = new CombatStatus(CombatStatus.ACTIVITY, CombatStatus.ACTIVITY_WOUND);
			} else {
				cs = new CombatStatus(CombatStatus.ACTIVITY, CombatStatus.ACTIVITY_ASSAULTS);
				cs.setAssaultsLeft(botchMalusActivity[1]);
			}
			cs.setActivityModif(botchMalusActivity[0]);
			cs.setDescription(getBotchDescription());
			actor.getActivityList().put(actor.getActivityList().size() + 1, cs);
			actor.setModifTotalActivity(actor.getModifTotalActivity() + cs.getActivityModif());
		}

		// ASSAULTS STUNNED
		if (!getBotchAssaultsStunned().equals("0")) {
			cs = new CombatStatus(CombatStatus.STUNNED, 0);
			cs.setDescription(this.getBotchDescription());

			if (getBotchAssaultsStunned().contains("*")) {
				int assaults = Utils.castToInt(getBotchAssaultsStunned().replace("*", ""));
				cs.setAssaultsLeft(assaults);

				if (enemy.getStunned() == null || enemy.getStunned().getAssaultsLeft() <= assaults) {
					enemy.setStunned(cs);
					System.out.println(enemy.getName() + " STUNNED for " + getBotchAssaultsStunned().replace("*", "")
							+ " assaults.");
				} else {
					System.out.println(
							enemy.getName() + " already was STUNNED for longer assaults. This STUN won't be applied.");
				}
			} else {
				int assaults = Utils.castToInt(getBotchAssaultsStunned());
				cs.setAssaultsLeft(assaults);

				if (actor.getStunned() == null || actor.getStunned().getAssaultsLeft() <= assaults) {
					actor.setStunned(cs);
					System.out.println(actor.getName() + " STUNNED for " + getBotchAssaultsStunned() + " assaults.");
				} else {
					System.out.println(
							actor.getName() + " already was STUNNED for longer assaults. This STUN won't be applied.");
				}
			}
		}

		// CAUSE DISABILITY,CRIT, UNCOUN IN ACTOR
		if (getBotchCauseBodyDisability() > 0 || !getBotchCauseAddCrit().equals("0") || getBotchCauseUnconsc() > 0) {

			if (getBotchCauseUnconsc() > 0) {
				actor.fallUnconscious(CombatStatus.KNOCKED_OUT_WOUND, 0);
			}

			if (getBotchCauseBodyDisability() > 0) {

				int disIdx = getBotchCauseBodyDisability();
				if (disIdx == Character.DISABILITY_BOTH_LEGS) {
					actor.getBodyPartDisabled()[Character.DISABILITY_RIGHT_LEG] = true;
					actor.getBodyPartDisabled()[Character.DISABILITY_LEFT_LEG] = true;
					System.out.println(actor.getName() + "s' Both Legs have been critically injured and are disabled.");
				} else {

					if (actor.getBodyPartDisabled()[disIdx] == true) {
						disIdx = disIdx + 1;
						setBotchCauseBodyDisability(disIdx);
					}

					String disStr = Character.disabilityToString(disIdx);
					actor.getBodyPartDisabled()[disIdx] = true;
					System.out.println(
							actor.getName() + "'s " + disStr + " has been critically injured and is disabled.");
				}
			}

			if (!getBotchCauseAddCrit().equals("0")) {
				// Seleccionar un pj o un pnj a quien se dirige el crítico
				if (getBotchCauseAddCrit().contains("*")) {
					Character target = Combat.selectEnemy();
					if (target == null) {
						System.out.println("No fighter selected. Critical Strike in Botch ignored.");
					} else {
						criticalOutcome = botchCriticalReceivedAssess(getBotchCauseAddCrit().replace("*", ""), target, actor);
					}
				} else {
					criticalOutcome = botchCriticalReceivedAssess(getBotchCauseAddCrit().replace("*", ""), actor, actor);
				}

			}

		}

		// BREAK/UNEQUIP ITEM
		if (getBotchTearItem() != null && !getBotchTearItem().equals("0")) {

			Utils.unequipItem(actor, getBotchTearItem());
		}

	}

	public CriticalOutcome botchCriticalReceivedAssess(String crit, Character target, Character actor) {

		String[] crit_ = crit.split("-");
		int critIndx;
		WeaponItem weapon = (WeaponItem) actor.getEquippedGear().get(Item.WEAPON_1);

		// Si aparece el simbolo de interrogacion, hay que poner el Critico del
		// Arma.
		if (crit_[0].equals("?")) {
			critIndx = weapon.getMainCritical().getCriticalType();
			crit = crit.replace("?", Tables.getCritical_typeAbb()[critIndx]);

		} else {
			critIndx = Critical.assesCriticalType(crit_[0]);
		}

		String critMaxGravity = crit_[1];
		Critical critical = new Critical(critIndx, critMaxGravity);
		CriticalOutcome criticalOutcome = new CriticalOutcome();

		criticalOutcome.criticalAssess(crit_[1], target, actor, critical);
		criticalOutcome.applyOutcome(target);
		
		return criticalOutcome;

	}

}
