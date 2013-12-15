package com.nyte.battle.cli;

import java.util.ArrayList;

import com.nyte.battle.Battle;
import com.nyte.battle.cli.commander.CLIAbilityCommander;
import com.nyte.core.Attributes;
import com.nyte.core.Attributes.Stat;
import com.nyte.core.Party;
import com.nyte.core.Unit;
import com.nyte.core.ability.Ability;

public class CLIBattle extends Battle {

	public CLIBattle(Party p1, Party p2) {
		super(p1, p2);
		actionCommander = new CLIAbilityCommander(this);
	}

	public static void main(String[] args) {
		Party p1 = new Party();

		Attributes attrs1 = new Attributes();
		attrs1.setStat(Stat.HEALTH, 10);
		attrs1.setStat(Stat.MANA, 10);
		attrs1.setStat(Stat.STRENGTH, 10);
		attrs1.setStat(Stat.DEFENSE, 10);
		attrs1.setStat(Stat.INTELLIGENCE, 10);
		attrs1.setStat(Stat.DEXTERITY, 10);

		Unit u1 = new Unit("Alice", attrs1, new ArrayList<Ability>());
		p1.addUnit(u1);

		Party p2 = new Party();

		Attributes attrs2 = new Attributes();
		attrs2.setStat(Stat.HEALTH, 10);
		attrs2.setStat(Stat.MANA, 10);
		attrs2.setStat(Stat.STRENGTH, 10);
		attrs2.setStat(Stat.DEFENSE, 10);
		attrs2.setStat(Stat.INTELLIGENCE, 10);
		attrs2.setStat(Stat.DEXTERITY, 10);

		Unit u2 = new Unit("Bob", attrs2, new ArrayList<Ability>());
		p2.addUnit(u2);
	}

}
