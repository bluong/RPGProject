package com.nyte.battle.commander;

import com.nyte.battle.Battle;
import com.nyte.core.ability.Ability;

public abstract class AbilityTargetCommander extends TargetCommander{

	private Ability ability;
	
	public AbilityTargetCommander(Battle b, Ability a) {
	    super(b, a.getTarget());
    }

	public Ability getAbility() {
		return ability;
	}

}
