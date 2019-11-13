package main.java.model.dao;

import main.java.model.session.Fornitore;

public class FornitoreDAO extends AbstractDAO<Fornitore> {

	@Override
	public Class<Fornitore> getPersistentClass() {
		return Fornitore.class;
	}
}