package main.java.model.dao;

import main.java.model.session.SpesaInvestimento;

public class SpesaInvestimentoDAO extends AbstractDAO<SpesaInvestimento> {

	@Override
	public Class<SpesaInvestimento> getPersistentClass() {
		return SpesaInvestimento.class;
	}
}