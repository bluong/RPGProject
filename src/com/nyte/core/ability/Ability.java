package com.nyte.core.ability;

import com.nyte.battle.BattlingParty;
import com.nyte.battle.BattlingUnit;
import com.nyte.core.Attributes;
import com.nyte.core.Target;
import com.nyte.core.TargetType;

/**
 * Created by Brandon on 12/2/13.
 */
public abstract class Ability {
	
	private TargetType target;
	private Attributes.Stat costStat;
	private int cost;
	private Attributes.Stat affectingStat;
	private int value;
	
	public TargetType getTarget() {
		return target;
	}
	
	public Attributes.Stat getCostingStat() {
		return costStat;
	}
	
	public int getCost() {
		return cost;
	}
	
	public Attributes.Stat getAffectingStat() {
		return affectingStat;
	}
	
	public int getValue() {
		return value;
	}
	
	public abstract void performAbility(BattlingUnit user, Target target);
}
