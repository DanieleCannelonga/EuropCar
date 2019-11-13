package main.java.model.dao;

import main.java.model.session.SottoCategoria;

public class SottoCategoriaDAO extends AbstractDAO<SottoCategoria> {

	@Override
	public Class<SottoCategoria> getPersistentClass() {
		return SottoCategoria.class;
	}
}