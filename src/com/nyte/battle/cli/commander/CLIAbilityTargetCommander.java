package com.nyte.battle.cli.commander;

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
			return handleSingleTarget(false);
		default:
			throw new IllegalStateException();
		}
	}

	private Target handleSingleTarget(boolean b) {
		BattlingUnit currentUnit = getBattle().getCurrentUnit();
		BattlingParty targetParty;
		if (b) {
			targetParty = getBattle().getOpposingParty(currentUnit);
		} else {
			targetParty = currentUnit.getBattlingParty();
		}
		System.out.println("Choose from the following units: ");
		for (BattlingUnit unit : targetParty) {
			System.out.println(unit.getName());
		}
	    Scanner scanner = new Scanner(System.in);
	    String unitName = scanner.next();
	    for (BattlingUnit unit : targetParty) {
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
