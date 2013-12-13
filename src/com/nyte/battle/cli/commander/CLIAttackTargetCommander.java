package com.nyte.battle.cli.commander;

import java.util.Scanner;

import com.nyte.battle.Battle;
import com.nyte.battle.BattlingUnit;
import com.nyte.battle.commander.AttackTargetCommander;
import com.nyte.core.Target;

public class CLIAttackTargetCommander extends AttackTargetCommander {

	public CLIAttackTargetCommander(Battle b) {
	    super(b);
    }

	@Override
	public Target getTarget() {
		BattlingUnit currentUnit = getBattle().getCurrentUnit();
		System.out.println("Choose from the following units: ");
		for (BattlingUnit unit : getBattle().getOpposingParty(currentUnit)) {
			System.out.println(unit.getName());
		}
	    Scanner scanner = new Scanner(System.in);
	    String unitName = scanner.next();
	    for (BattlingUnit unit : getBattle().getOpposingParty(currentUnit)) {
			if (unitName.equals(unit.getName())) {
				scanner.close();
				return unit;
			} else if (unitName.equals("BACK")) {
				scanner.close();
				return null;
			}
		}
	    scanner.close();
	    return null;
	}

}
