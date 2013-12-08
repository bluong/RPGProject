package com.nyte.battle.cli;

import java.util.Scanner;

import com.nyte.battle.Action;
import com.nyte.battle.Battle;
import com.nyte.battle.BattlingUnit;
import com.nyte.battle.Commander;

public class CLICommander implements Commander {

	@Override
	public Action getAction(BattlingUnit unit, Battle battle) {
		Scanner scanner = new Scanner(System.in);
		while (true){
			switch (scanner.next()) {
			case Action.Type.ATTACK_STRING:
				processAttack(unit, battle, scanner);
			case Action.Type.DEFEND_STRING:
				scanner.close();
				return Action.createDefendAction();
			case Action.Type.ABILITY_STRING:
				// TODO: Get the ability, get the target, return ability action
			case Action.Type.WAIT_STRING:
				scanner.close();
				return Action.createWaitAction();
			}
		}
	}

	private void processAttack(BattlingUnit unit, Battle battle, Scanner scanner) {
		for (BattlingUnit opponent : battle.getOpposingParty(unit)) {
			System.out.println(opponent);
		}
		String target = scanner.next();
    }

}
