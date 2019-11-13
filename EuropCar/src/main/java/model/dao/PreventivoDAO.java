package main.java.model.dao;

import main.java.model.session.Preventivo;

public class PreventivoDAO extends AbstractDAO<Preventivo> {

	@Override
	public Class<Preventivo> getPersistentClass() {
		return Preventivo.class;
	}
}