package main.java.model.dao;

import main.java.model.session.FatturaPassiva;

public class FatturaPassivaDAO extends AbstractDAO<FatturaPassiva> {

	@Override
	public Class<FatturaPassiva> getPersistentClass() {
		return FatturaPassiva.class;
	}
}