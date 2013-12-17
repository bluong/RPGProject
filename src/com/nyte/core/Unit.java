package com.nyte.core;

import java.util.List;

import com.nyte.core.Attributes.Stat;
import com.nyte.core.ability.Ability;

/**
 * Created by Brandon on 11/30/13.
 */
public class Unit extends Target{

	private String name;
    private Attributes savedAttributes;
    private Attributes currentAttributes;
    private Party party;
    private List<Ability> abilities;
    
    public Unit(String name, Attributes attrs, List<Ability> abils) {
    	this.name = new String(name);
    	this.savedAttributes = attrs;
    	this.abilities = abils;
    }

    public Unit(Unit original) {
        //TODO: Copy the stats
    }
    
    void setParty(Party p) {
    	party = p;
    }
    
    public Party getParty() {
    	return party;
    }

    public boolean isUnable() {
        return currentAttributes.getStat(Attributes.Stat.HEALTH) == 0;
    }

    public Attributes getCurrentAttributes() {
        return currentAttributes;
    }

    public int getCurrentAttr(Attributes.Stat attr) {
        return currentAttributes.getStat(attr);
    }
    
    public Attributes getSavedAttributes() {
        return savedAttributes;
    }

    public int getSavedAttributes(Attributes.Stat attr) {
        return savedAttributes.getStat(attr);
    }
    
    public List<Ability> getAbilities() {
    	return abilities;
    }
    
    public String getName() {
    	return name;
    }
    
    public int getCurrentStat(Stat stat) {
        return currentAttributes.getStat(stat);
    }

    public void setCurrentStat(Stat stat, int newValue) {
        currentAttributes.setStat(stat, newValue);
    }
    
    public void incrementCurrentStat(Stat stat, int modifier) {
        currentAttributes.incrementStat(stat, modifier);
    }
    
    public void decrementCurrentStat(Stat stat, int modifier) {
    	currentAttributes.decrementStat(stat, modifier);
    }
}
