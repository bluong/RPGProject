package com.nyte.core;

/**
 * Created by Brandon on 12/1/13.
 */
public class Attributes {

    private int[] attributes = new int[6];

    public enum Stat {
        HEALTH, MANA, STRENGTH, DEFENSE, INTELLIGENCE, DEXTERITY
    }

    public int getStat(Stat stat) {
        return attributes[stat.ordinal()];
    }

    public void setStat(Stat stat, int newValue) {
        attributes[stat.ordinal()] = newValue;
    }
}
