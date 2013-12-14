package com.nyte.battle.cli.commander;

import java.util.HashMap;
import java.util.Map;
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
	    Map<String, Ability> abilityNameMap = new HashMap<String,Ability> ();
		System.out.println("Choose from the following abilities: ");
		for (Ability a : currentUnit.getAbilities()) {
			System.out.println(a.getName());
			abilityNameMap.put(a.getName(), a);
		}
	    Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Please input an ability");
			String abilityName = scanner.next();
			if (abilityName.equals("Back")) {
				scanner.close();
				return null;
			} else if (abilityNameMap.containsKey(abilityName)) {
				Ability ability = abilityNameMap.get(abilityName);
				Target target = new CLIAbilityTargetCommander(getBattle(), ability).getTarget();
				if (target != null) {
					scanner.close();
					return Action.createAbilityAction((BattlingUnit) target, ability);
				} else {
					continue;
				}
			}
			System.out.println("Invalid ability name selected.");
		}
    }

}
