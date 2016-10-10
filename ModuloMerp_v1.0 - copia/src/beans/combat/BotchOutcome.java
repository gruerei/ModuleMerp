package beans.combat;

import beans.Botch;
import beans.Critical;

public class BotchOutcome {

	private int lifePointsCaused;
	private Botch botch;
	private Critical critical;
	private int resistanceRollModificators;
	private Attack attack;
	
	public BotchOutcome(Attack attack) {
		this.attack = attack;
	}

}
