package main.java.model.dao;

import main.java.model.session.Area;

public class AreaDAO extends AbstractDAO<Area> {

	@Override
	public Class<Area> getPersistentClass() {
		return Area.class;
	}
}