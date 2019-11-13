package main.java.model.dao;

import main.java.model.session.AliquotaIva;

public class AliquotaIvaDAO extends AbstractDAO<AliquotaIva> {

	@Override
	public Class<AliquotaIva> getPersistentClass() {
		return AliquotaIva.class;
	}
}