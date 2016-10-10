package beans.combat;

import beans.Attribute;
import beans.Character;
import beans.Skill;
import beans.Spell;

public class AttackSpell extends Attack {

	private Spell spell;

	public AttackSpell(Character actor, int diceRoll, Character enemy, int parryBonus,
			int otherBonus, String otherBonusDescription, int attackCategory, Spell spell) {
		
		super(actor, diceRoll, enemy, parryBonus, otherBonus, otherBonusDescription, attackCategory);
		this.spell = spell;
		
	}

	@Override
	protected void resolveAttack() {
		
		int spellBO = 0;
		
		if(spell.getCategory() == Spell.SPELL_BEAM){
			spellBO = actor.getSkills().get(Skill.DIRECTED_SPELLS).getModifTotal();
			rollCalculation = diceRoll + spellBO - enemy.getAttributes().get(Attribute.AGILITY).getModifTotal() + otherBonus;
		}else if(spell.getCategory() == Spell.SPELL_AREA){
			spellBO = actor.getSkills().get(Skill.BASE_SPELL).getModifTotal();
			rollCalculation = diceRoll + spellBO - enemy.getAttributes().get(Attribute.AGILITY).getModifTotal() + otherBonus;
		}else if(spell.getCategory() == Spell.SPELL_BASE){
			spellBO = actor.getSkills().get(Skill.BASE_SPELL).getModifTotal() - spell.getLvl();
			rollCalculation = diceRoll + spellBO + otherBonus;
		}
		
		/*TODO : Pendiente calcular segun el tipo de hechizo cosas como la resistencia
		 * al calor/frio y la tirada de critico*/
		
		
		
		outcome = new AttackOutcome(rollCalculation, this);
		
	}
	
}
