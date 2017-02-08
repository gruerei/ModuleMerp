package beans.combat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import beans.ArmourItem;
import beans.Character;
import beans.Item;
import beans.Skill;
import cache.Cache;
import utils.Utils;

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
	 * 1º Preparar/Realizar hechizo
	 * 2º Ataques con proyectiles o Armas Arrojadizas
	 * 3º Maniobras de Movimiento
	 * 4º Ataques Cuerpo a Cuerpo
	 * 5º Movimiento
	 * 6º Maniobras Estaticas
	 */ 
	/*
	 * (0º La resolucion de la accion de oportunidad tiene prioridad sobre cualquier otra)
	 * (La anulacion de la accion de opotunidad puede cancelarse al final del asalto(sin consecuencias)
	 * o durante el asalto del curso penalizándose la actividad/ataque al 50%)
	 * 
	 * 1º Distancia
	 * 2º Cuerpo A Cuerpo o Maniobras
	 * 3º Movimiento
	 * 
	 * A igualdad de acciones, empieza el PJ con Movimiento y Maniobras mas elevado
	 */
	
	
	public static Map<String, Character> pjs = new HashMap<String, Character>();
	public static Map<String, Character> pnjs = new HashMap<String, Character>();
	
	
	List<Assault> assaults = new ArrayList<Assault>();
	
	/*Asaltos*/
	/*Historico del Combate*/

	public Combat(Map<String, Character> pjs, Map<String, Character> pnjs) {
		this.pjs = pjs;
		this.pnjs = pnjs;
	}

	public void start() {
		
		boolean combatFinished = false;
		
	
		/*Loop By Assault*/
		do{
			Assault asalto = new Assault();
			assaults.add(asalto);
			
			/*** 1º DECLARAR ACCIONES: DISTANCIA, MELEE, MOVIMIENTO/MANIOBRAS y OPORTUNIDAD, HUIDA***/
			stateActions(asalto);

			/*Mix of Pjs and Pnjs and Sortering by Actions and Movement*/
			Collections.sort(asalto.getActions());			
			
			System.out.println(asalto.getActions().toString());
			
			/*** 2º RESOLVER LAS ACCIONES: ***/
			resolveActions(asalto);
			

			String entradaTeclado = "";
			do{
				System.out.println("¿End Combat Y/N ?");
				entradaTeclado = Utils.readFromInputLine();
				if(entradaTeclado.equalsIgnoreCase("Y")){
					combatFinished = true;
				}
			}while(!entradaTeclado.equalsIgnoreCase("Y") && !entradaTeclado.equalsIgnoreCase("N"));
			
			/**SIGUIENTE ASALTO EN CASO DE QUE EL COMBATE NO ACABE*/
		}while(!combatFinished);
		
		/* TODO: Dar info del combate	*/
		this.assaults.size();
		/*descriptivo pnjs*/
		/*descriptivo pjs*/
	}

	private void resolveActions(Assault asalto) {

		int diceRoll = 0;
		
		System.out.println("\n"
				+ "***********************************************************************"
				+ "\n****************** FASE 2 : RESOLVE ACTION BY CHARACTER  **********************"
				+ "\n*********************************************************************");
		
		/*Loop By Character List Sortered*/
		
		for(int i = 0; i < asalto.getActions().size(); i++){
			Action action = asalto.getActions().get(i);
			if(action.getType() == Action.RANGED){
				
			}
			else if(action.getType() == Action.MELEEE){
				do{
					try{
						String weaponName = action.getActor().getEquippedGear().get(Item.WEAPON_1).getName() == null ? 
								action.getActor().getEquippedGear().get(Item.WEAPON_1).getType() :
									action.getActor().getEquippedGear().get(Item.WEAPON_1).getName();
								
						System.out.println("\n"+action.getActor().getName() +" ataca a "+action.getTarget().getName()+" con "+ weaponName);
						System.out.println("****TIRADA DE DADOS****** RESULTADO: ");
						diceRoll = Utils.castToInt(Utils.readFromInputLine());
					}catch(NumberFormatException e){
						diceRoll = 0;
					}
					
				}while(diceRoll == 0);
				
				/*TODO Formulario entrada interactiva combate : Seleccionable por jugador/Dm*/
				int parryBonus = 0;action.getTarget().setParryBonusInUse(0);
				int otherBonus = 0;
				String otherBonusDescription = "";
				int attackCategory = Attack.EDGED;
				
				Attack attack = new AttackMelee(action.getActor(), diceRoll, action.getTarget(), parryBonus, otherBonus, otherBonusDescription, attackCategory);
				attack.setIniciative(action.getIniciative());
				attack.setType(action.getType());
				attack.setDescription(action.getDescription());
				/*Reemplazar en asalto el action por el attack que contiene mas info*/
				asalto.getActions().set(i, attack);
				System.out.println("");
			
			}
			else if(action.getType() == Action.MOVE_MANE){
				
			}
			else if(action.getType() == Action.OPORTUNITY){
				
			}
			else if(action.getType() == Action.ESCAPE){
				
				String actorName = action.getActor().getName();
				String pj_pnj = "";
				
				if(this.pjs.containsKey(actorName)){
					pj_pnj = "PJ";
					
				}else if(this.pnjs.containsKey(actorName)){
					pj_pnj = "PNJ";
					
				}
				
				System.out.println(pj_pnj +": Is " + actorName +" able to Run Away? Y/N");
				
				String entradaTeclado = "";
				do{
					entradaTeclado = Utils.readFromInputLine();
				}while(!entradaTeclado.equalsIgnoreCase("Y") && !entradaTeclado.equalsIgnoreCase("N"));
				
				if(entradaTeclado.equalsIgnoreCase("Y")){
					if(pj_pnj.equals("PJ")){
						this.pjs.remove(actorName);
						Cache.removeFromCacheList("pj",actorName);
					}else if(pj_pnj.equals("PNJ")){
						this.pnjs.remove(actorName);
						Cache.removeFromCacheList("pnj",actorName);
					}
					System.out.println(pj_pnj +": "+ actorName +" has fled.");
				}else{
					System.out.println(pj_pnj +": "+ actorName +" couldn't escape.");
				}
				
			}
		}

	
		
	}

	private void stateActions(Assault asalto) {
		
		System.out.println("\n"
				+ "***********************************************************************"
				+ "\n****************** STEP 1 : STATE ACTIONS  **********************"
				+ "\n*********************************************************************");
		
		
		/*Loop By Character List*/
		for (Map.Entry<String, Character> entry : pjs.entrySet()) {
			//String key = entry.getKey();
			Character character = entry.getValue();
			System.out.println(character.getName() + "\nSTATE ACTION:\t1.RANGED\t2.MELEEE\t3.MOVE/MANE\t4. OPORTUNITY\t5.HUIDA EXITOSA");
			String entradaTeclado = Utils.readFromInputLine();
			Action action = actionSelected(character,entradaTeclado);
			/*Meter en la lista acciones pjs*/
			asalto.getActions().add(action);
		}
		
		/*Loop By PNJ List*/
		for (Map.Entry<String, Character> entry : pnjs.entrySet()) {
			//String key = entry.getKey();
			Character pnj = entry.getValue();
			System.out.println("\n"+ pnj.getName() + "\nSTATE ACTION:\t1.RANGED\t2.MELEEE\t3.MOVE/MANE\t4. OPORTUNITY\t5.HUIDA EXITOSA");
			String entradaTeclado = Utils.readFromInputLine();
			Action action = actionSelected(pnj,entradaTeclado);
			/*Meter en la lista acciones pnjs*/
			asalto.getActions().add(action);
		}
		
	}

	private Action actionSelected(Character character, String entradaTeclado) {
		

		Action action = new Action(character);
		ArmourItem armour = (ArmourItem)character.getEquippedGear().get(Item.ARMOUR);
		int movSkillId = ArmourItem.getMovementSkillByArmour(armour.getType());
		Skill mov = character.getSkills().get(movSkillId);
		
		switch (Utils.castToInt(entradaTeclado)) {
		case 1:
			action.setIniciative(Action.RANGED_INICIATIVE + mov.getModifTotal());
			action.setType(Action.RANGED);
			Character enemy = selectEnemy(character);
			action.setTarget(enemy);
			action.setDescription(character.getName() + " selected RANGED Attack/Spell against "+enemy.getName());
			break;
		case 2:
			action.setIniciative(Action.MELEE_INICIATIVE + mov.getModifTotal());
			action.setType(Action.MELEEE);
			Character enemy2 = selectEnemy(character);
			action.setTarget(enemy2);
			action.setDescription(character.getName() + " selected MELEE Attack against "+enemy2.getName());
			break;
		case 3:
			action.setIniciative(Action.MOVE_MANE_INICIATIVE + mov.getModifTotal());
			action.setType(Action.MOVE_MANE);
			action.setDescription(character.getName() + " is going to do a MOVEMENT or a MANEUVER");
			break;
		case 4:
			action.setIniciative(Action.OPORTUNITY_INICIATIVE + mov.getModifTotal());
			action.setType(Action.OPORTUNITY);
			action.setDescription(character.getName() + " is in Oportunity Action");
			break;
		case 5:
			action.setIniciative(Action.MOVE_MANE_INICIATIVE + mov.getModifTotal());
			action.setType(Action.ESCAPE);
			action.setDescription(character.getName() + " will Flee in the next Action");
			break;
		default:
			System.out.println(" NONE");
			break;
			
		}

		System.out.println(action.getDescription());
		return action;
	}

	public static Character selectEnemy(Character character) {
		
		String entradaTeclado = "";
		String figherVsGroup = "";
		String enemyName = "";
		
		do{
			System.out.println("1.PNJs\n2.PJs\n\n Select a Group:\n");
			entradaTeclado = Utils.readFromInputLine();
			
			figherVsGroup = entradaTeclado;
			
			boolean selfSelected = false;
			boolean wrongSelection = false;
			do{
				
				selfSelected = false;
				wrongSelection = false;
				if(figherVsGroup.equals("1")){
					System.out.println("PNJS: \tSelect Target: ");
					showFightersList(Cache.pnjsCombatList);
				}else if(figherVsGroup.equals("2")){
					System.out.println("PJS: \tSelect Target: ");
					showFightersList(Cache.pjsCombatList);
				}
				System.out.println("0. Back");
				
				entradaTeclado = Utils.readFromInputLine();
				int fighterVsIndex = Utils.castToInt(entradaTeclado);
				
				if(figherVsGroup.equals("1") && (fighterVsIndex > Cache.pnjsCombatList.size())){
					System.out.println("Error seleccionando en la Lista de PNJs. Seleccione de nuevo.");
					wrongSelection = true;
				}
				
				if(figherVsGroup.equals("2") && (fighterVsIndex > Cache.pjsCombatList.size())){
					System.out.println("Error seleccionando en la Lista de PJs. Seleccione de nuevo.");
					wrongSelection = true;
				}
	
				if(!entradaTeclado.equals("0") && !wrongSelection){
					
					if(figherVsGroup.equals("1")){
						enemyName = searchFighterName(Cache.pnjsCombatList,fighterVsIndex);
					}else if(figherVsGroup.equals("2")){
						enemyName = searchFighterName(Cache.pjsCombatList,fighterVsIndex);
					}
					
					if(character.getName().equals(enemyName)){
						System.out.println("You cannot select yourself as target of your own attack. Select other enemy!");
						selfSelected = true;
					}
				}
			}while((selfSelected || wrongSelection) && !entradaTeclado.equals("0"));
			
		}while(!entradaTeclado.equals("1") && !entradaTeclado.equals("2"));

		
		Character enemyFighted = null;
		if(figherVsGroup.equals("1")){
			enemyFighted = pnjs.get(enemyName);
		}else if(figherVsGroup.equals("2")){
			enemyFighted = pjs.get(enemyName);
		}
		return enemyFighted;
	}
	
public static Character selectEnemy() {
		
		String entradaTeclado = "";
		String figherVsGroup = "";
		String enemyName = "";
		
		do{
			System.out.println("1.PNJs\n2.PJs\n0.None\n");
			entradaTeclado = Utils.readFromInputLine();
			
			figherVsGroup = entradaTeclado;
			
			boolean wrongSelection = false;
			do{
				
				wrongSelection = false;
				if(figherVsGroup.equals("1")){
					System.out.println("PNJS: \tSelect Target: ");
					showFightersList(Cache.pnjsCombatList);
				}else if(figherVsGroup.equals("2")){
					System.out.println("PJS: \tSelect Target: ");
					showFightersList(Cache.pjsCombatList);
				}else if(figherVsGroup.equals("0")){
					return null;
				}
				System.out.println("0. Back");
				
				entradaTeclado = Utils.readFromInputLine();
				int fighterVsIndex = Utils.castToInt(entradaTeclado);
				
				if(figherVsGroup.equals("1") && (fighterVsIndex > Cache.pnjsCombatList.size())){
					System.out.println("Error seleccionando en la Lista de PNJs. Seleccione de nuevo.");
					wrongSelection = true;
				}
				
				if(figherVsGroup.equals("2") && (fighterVsIndex > Cache.pjsCombatList.size())){
					System.out.println("Error seleccionando en la Lista de PJs. Seleccione de nuevo.");
					wrongSelection = true;
				}
	
				if(!entradaTeclado.equals("0") && !wrongSelection){
					
					if(figherVsGroup.equals("1")){
						enemyName = searchFighterName(Cache.pnjsCombatList,fighterVsIndex);
					}else if(figherVsGroup.equals("2")){
						enemyName = searchFighterName(Cache.pjsCombatList,fighterVsIndex);
					}
					
				}
			}while((wrongSelection) && !entradaTeclado.equals("0"));
			
		}while(!entradaTeclado.equals("1") && !entradaTeclado.equals("2"));

		
		Character enemyFighted = null;
		if(figherVsGroup.equals("1")){
			enemyFighted = pnjs.get(enemyName);
		}else if(figherVsGroup.equals("2")){
			enemyFighted = pjs.get(enemyName);
		}
		return enemyFighted;
	}
	

	public static void showFightersList(List<String> pjs) {
		int i = 0;
		for (String name : pjs) {
			i++;
			System.out.println("\t"+ i + ". "+name);
		}
	}
	
	public static String searchFighterName(List<String> pjs, int index){
		return pjs.get(index-1);
	}

}
