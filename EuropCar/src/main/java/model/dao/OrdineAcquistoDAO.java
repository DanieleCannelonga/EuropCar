package main.java.model.dao;

import main.java.model.session.OrdineAcquisto;

public class OrdineAcquistoDAO extends AbstractDAO<OrdineAcquisto> {

	@Override
	public Class<OrdineAcquisto> getPersistentClass() {
		return OrdineAcquisto.class;
	}
}