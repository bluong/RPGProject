package com.nyte.battle.cli.commander;

import java.util.Scanner;

import com.nyte.battle.Action;
import com.nyte.battle.Battle;
import com.nyte.battle.BattlingUnit;
import com.nyte.battle.commander.AbilityCommander;
import com.nyte.core.Target;
import com.nyte.core.ability.Ability;

public class CLIAbilityCommander extends AbilityCommander{

	public CLIAbilityCommander(Battle b) {
	    super(b);
    }

	@Override
    public Action getAction() {
		BattlingUnit currentUnit = getBattle().getCurrentUnit();
		System.out.println("Choose from the following abilities: ");
		for (Ability a : currentUnit.getAbilities()) {
			System.out.println(a.getName());
		}
	    Scanner scanner = new Scanner(System.in);
	    String abilityName = scanner.next();
	    for (Ability a : currentUnit.getAbilities()) {
			if (abilityName.equals(a.getName())) {
				Target target = new CLIAbilityTargetCommander(getBattle(), a).getTarget();
				if (target != null) {
					scanner.close();
					return Action.createAbilityAction((BattlingUnit) target, a);
				}
			} else if (abilityName.equals("BACK")) {
				scanner.close();
				return null;
			}
		}
	    scanner.close();
	    return null;
    }

}
