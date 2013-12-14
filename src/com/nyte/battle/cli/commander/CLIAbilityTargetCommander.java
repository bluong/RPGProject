package com.nyte.battle.cli.commander;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.nyte.battle.Battle;
import com.nyte.battle.BattlingParty;
import com.nyte.battle.BattlingUnit;
import com.nyte.battle.commander.AbilityTargetCommander;
import com.nyte.core.Target;
import com.nyte.core.ability.Ability;

public class CLIAbilityTargetCommander extends AbilityTargetCommander {

	public CLIAbilityTargetCommander(Battle b, Ability a) {
	    super(b, a);
    }

	@Override
	public Target getTarget() {
		switch(getAbility().getTargetType()) {
		case ALL_ALLY:
			return getBattle().getCurrentUnit().getBattlingParty();
		case ALL_ENEMY:
			return getBattle().getOpposingParty(getBattle().getCurrentUnit());
		case SINGLE_ALLY:
			return handleSingleTarget(false);
		case SINGLE_ENEMY:
			return handleSingleTarget(true);
		default:
			throw new IllegalStateException();
		}
	}

	private Target handleSingleTarget(boolean isEnemy) {
		BattlingUnit currentUnit = getBattle().getCurrentUnit();
		Map<String, BattlingUnit> unitNameMap = new HashMap<String, BattlingUnit>();
		BattlingParty targetParty;
		if (isEnemy) {
			targetParty = getBattle().getOpposingParty(currentUnit);
		} else {
			targetParty = currentUnit.getBattlingParty();
		}
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
