package com.nyte.battle.cli.commander;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.nyte.battle.Battle;
import com.nyte.battle.BattlingParty;
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
		Map<String, BattlingUnit> unitNameMap = new HashMap<String, BattlingUnit>();
		BattlingParty targetParty = getBattle().getOpposingParty(currentUnit);
		System.out.println("Choose from the following units: ");
		for (BattlingUnit unit : targetParty) {
			System.out.println(unit.getName());
			unitNameMap.put(unit.getName(), unit);
		}
	    Scanner scanner = new Scanner(System.in);
		while (true) {
			String unitName = scanner.next();
			if (unitNameMap.containsKey(unitName)) {
				scanner.close();
				return unitNameMap.get(unitName);
			} else if (unitName.equals("Back")) {
				scanner.close();
				return null;
			}
		}
	}

}
