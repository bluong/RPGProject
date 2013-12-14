package com.nyte.battle.cli.commander;

import java.util.Scanner;

import com.nyte.battle.Action;
import com.nyte.battle.Battle;
import com.nyte.battle.BattlingUnit;
import com.nyte.battle.commander.ActionCommander;

public class CLIActionCommander extends ActionCommander {

	public CLIActionCommander(Battle b) {
	    super(b);
    }

	@Override
    public Action getAction() {
		System.out.println("Choose an action");
		Scanner scanner = new Scanner(System.in);
		while (true){
			switch (scanner.next()) {
			case Action.Type.ATTACK_STRING:
				BattlingUnit attackTarget = (BattlingUnit) new CLIAttackTargetCommander(getBattle()).getTarget();
				if (attackTarget != null) {
					scanner.close();
					return Action.createAttackAction(attackTarget);
				}
			case Action.Type.DEFEND_STRING:
				scanner.close();
				return Action.createDefendAction();
			case Action.Type.ABILITY_STRING:
				Action abilityAction = new CLIAbilityCommander(getBattle()).getAction();
				if (abilityAction != null) {
					scanner.close();
					return abilityAction;
				}
			case Action.Type.WAIT_STRING:
				scanner.close();
				return Action.createWaitAction();
			}
		}
    }
}
