package beans.combat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import beans.Character;

public class Combat {
	
		public static final String FLANKED = "flanked";
		public static final String ATTACKED_FROM_BEHIND = "attackedFromBehind";
		public static final String OFF_GUARDED = "offguarded";
		public static final String STUNNED = "stunned";
		
		public static final String OFF_GUARDED_FLANKED = "offguarded_flanked";
		public static final String OFF_GUARDED_ATTACKED_FROM_BEHIND = "offguarded_attackedFromBehind";
		public static final String STUNNED_FLANKED = "stunned_flanked";
		public static final String STUNNED_ATTACKED_FROM_BEHIND = "stunned_attackedFromBehind";
		public static final String STUNNED_OFF_GUARDED = "stunned_offguarded";
		public static final String STUNNED_OFF_GUARDED_ATTACKED_FROM_BEHIND = "stunned_offguarded_attackedFromBehind";
		
	/*
	 * 1� Preparar/Realizar hechizo
	 * 2� Ataques con proyectiles o Armas Arrojadizas
	 * 3� Maniobras de Movimiento
	 * 4� Ataques Cuerpo a Cuerpo
	 * 5� Movimiento
	 * 6� Maniobras Estaticas
	 */ 
	/*
	 * (0� La resolucion de la accion de oportunidad tiene prioridad sobre cualquier otra)
	 * (La anulacion de la accion de opotunidad puede cancelarse al final del asalto(sin consecuencias)
	 * o durante el asalto del curso penaliz�ndose la actividad/ataque al 50%)
	 * 
	 * 1� Distancia
	 * 2� Cuerpo A Cuerpo o Maniobras
	 * 3� Movimiento
	 * 
	 * A igualdad de acciones, empieza el PJ con Movimiento y Maniobras mas elevado
	 */
	
	
	
	Map<String, Character> pjs;
	Map<String, Character> pnjs;
	
	
	List<Action> actions = new ArrayList<Action>();
	
	/*Asaltos*/
	/*Historico del Combate*/

	public Combat(Map<String, Character> pjs, Map<String, Character> pnjs) {
		this.pjs = pjs;
		this.pnjs = pnjs;
	}

}
