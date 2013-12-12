package com.nyte.battle.commander;

import com.nyte.battle.Battle;
import com.nyte.core.Target;
import com.nyte.core.TargetType;

public abstract class TargetCommander {
	
	private Battle battle;
	private TargetType targetType;
	
	public TargetCommander(Battle b, TargetType t) {
		this.battle = b;
		this.targetType = t;
	}
	
	public abstract Target getTarget();
	
	public Battle getBattle() {
		return battle;
	}
	
	public TargetType getTargetType() {
		return targetType;
	}

}
