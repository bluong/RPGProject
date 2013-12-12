package com.nyte.battle.commander;

import com.nyte.battle.Battle;
import com.nyte.core.TargetType;

public abstract class AttackTargetCommander extends TargetCommander{

	public AttackTargetCommander(Battle b) {
	    super(b, TargetType.SINGLE_ENEMY);
    }

}
