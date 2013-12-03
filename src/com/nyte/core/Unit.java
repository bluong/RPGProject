package com.nyte.core;

/**
 * Created by Brandon on 11/30/13.
 */
public class Unit {

    private Attributes savedAttributes;
    private Attributes currentAttributes;

    public Unit(Unit original) {
        //TODO: Copy the stats
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
}
