package main.java.model.dao;

import main.java.model.session.FatturaPassivaDettaglio;

public class FatturaPassivaDettaglioDAO extends AbstractDAO<FatturaPassivaDettaglio> {

	@Override
	public Class<FatturaPassivaDettaglio> getPersistentClass() {
		return FatturaPassivaDettaglio.class;
	}
}