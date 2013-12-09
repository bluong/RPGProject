package com.nyte.core;

/**
 * Created by Brandon on 12/2/13.
 */
public class Ability {
	
	private Target target;
	private Attributes.Stat costStat;
	private int cost;
	private Attributes.Stat affectingStat;
	private int value;
	
	public Target getTarget() {
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
}
