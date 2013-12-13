package com.nyte.core.ability;

import com.nyte.battle.BattlingParty;
import com.nyte.battle.BattlingUnit;
import com.nyte.core.Target;

public abstract class MultiTargetAbility extends Ability {
	
	@Override
	public void performAbility(BattlingUnit user, Target target) {
		performMultiTargetAbility(user, (BattlingParty) target);
	}
	
	public abstract void performMultiTargetAbility(BattlingUnit user, BattlingParty receiver);

}
