package com.nyte.battle.cli;

import com.nyte.battle.Battle;
import com.nyte.battle.cli.commander.CLIAbilityCommander;
import com.nyte.core.Party;

public class CLIBattle extends Battle {

	public CLIBattle(Party p1, Party p2) {
	    super(p1, p2);
	    actionCommander = new CLIAbilityCommander(this);
    }

}
