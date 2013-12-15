package com.nyte.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Brandon on 11/30/13.
 */
public class Party implements Iterable<Unit> {

	protected List<Unit> units;

	public Party() {
		units = new ArrayList<Unit>();
	}

	public void addUnit(Unit unit) {
		units.add(unit);
		unit.setParty(this);
	}

	public List<Unit> getUnits() {
		return units;
	}

	@Override
	public Iterator<Unit> iterator() {
		return units.iterator();
	}

	public int getUnitCount() {
		return units.size();
	}
}
