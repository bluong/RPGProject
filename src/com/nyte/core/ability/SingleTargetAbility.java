package com.nyte.core.ability;

import com.nyte.battle.BattlingUnit;
import com.nyte.core.Target;

public abstract class SingleTargetAbility extends Ability {
	
	@Override
	public void performAbility(BattlingUnit user, Target target) {
		performSingleTargetAbility(user, (BattlingUnit) target);
	}
	
	public abstract void performSingleTargetAbility(BattlingUnit user, BattlingUnit receiver);

}
