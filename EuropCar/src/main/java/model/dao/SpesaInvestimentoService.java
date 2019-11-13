package main.java.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import main.java.model.session.SpesaInvestimento;

public class SpesaInvestimentoService extends AbstractService<SpesaInvestimentoDAO, SpesaInvestimento> {

	@Override
	public SpesaInvestimentoDAO createDAO() {
		return new SpesaInvestimentoDAO();
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di spese d'investimento in base alla
	 * sottoCategoria inserita dall'utente.
	 */
	public List<SpesaInvestimento> elencoSpeseInvestimentoPerSottoCategoria(int chiaveSottoCategoria) {
		SpesaInvestimentoDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(SpesaInvestimento.class)
				.createAlias("osottocategoria", "a")
				.add(Restrictions.eq("a.chiave", chiaveSottoCategoria));
				
		@SuppressWarnings("unchecked")
		List<SpesaInvestimento> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
}