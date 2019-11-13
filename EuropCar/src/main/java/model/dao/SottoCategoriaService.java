package main.java.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import main.java.model.session.SottoCategoria;

public class SottoCategoriaService extends AbstractService<SottoCategoriaDAO, SottoCategoria> {

	@Override
	public SottoCategoriaDAO createDAO() {
		return new SottoCategoriaDAO();
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di sottoCategorie in base all'area
	 * inserita dall'utente.
	 */
	public List<SottoCategoria> elencoSottoCategoriePerArea(int chiaveArea) {
		SottoCategoriaDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(SottoCategoria.class)
				.createAlias("oarea", "a")
				.add(Restrictions.eq("a.chiave", chiaveArea));
		@SuppressWarnings("unchecked")
		List<SottoCategoria> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
}