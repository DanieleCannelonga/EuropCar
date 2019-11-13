package main.java.model.dao;

import main.java.model.session.OrdineAcquistoDettaglio;

public class OrdineAcquistoDettaglioDAO extends AbstractDAO<OrdineAcquistoDettaglio> {

	@Override
	public Class<OrdineAcquistoDettaglio> getPersistentClass() {
		return OrdineAcquistoDettaglio.class;
	}
}