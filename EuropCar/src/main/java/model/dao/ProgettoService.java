package main.java.model.dao;

import main.java.model.session.Progetto;

public class ProgettoService extends AbstractService<ProgettoDAO, Progetto> {

	@Override
	public ProgettoDAO createDAO() {
		return new ProgettoDAO();
	}
}