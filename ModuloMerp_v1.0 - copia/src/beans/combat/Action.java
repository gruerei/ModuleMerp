package beans.combat;

import beans.Character;

/*Acciones; Movimiento, Ataque (CC, Hechizos y Distancia), Maniobra (Estatica y de Movimiento), Preparar/Realizar Hechizos*/
public class Action implements Comparable<Action>{
	
	public static final int RANGED = 1;
	public static final int MELEEE = 2;
	public static final int MOVE_MANE = 3;
	public static final int OPORTUNITY = 4;
	
	
	public static final int RANGED_INICIATIVE = 900;
	public static final int MELEE_INICIATIVE = 700;
	public static final int MOVE_MANE_INICIATIVE = 500;
	public static final int OPORTUNITY_INICIATIVE = 0;
	
	protected Character actor;
	protected int type;
	protected int iniciative;
	protected String description;

	public Action(Character actor) {
		this.actor = actor;
	}


	public Character getActor() {
		return actor;
	}

	public void setActor(Character actor) {
		this.actor = actor;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getIniciative() {
		return iniciative;
	}

	public void setIniciative(int iniciative) {
		this.iniciative = iniciative;
	}
	

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public int compareTo(Action o) {
		
		int compareIniciative = ((Action) o).getIniciative();
		//descending order
		return compareIniciative - this.getIniciative();
	}


	@Override
	public String toString() {
		return "\n" +this.getDescription()+", iniciative=" + iniciative;
	}

	
	

	
}
