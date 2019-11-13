package main.java.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import main.java.model.session.Area;
import main.java.model.session.SottoCategoria;

public class AreaService extends AbstractService<AreaDAO, Area> {

	@Override
	public AreaDAO createDAO() {
		return new AreaDAO();
	}

	/*
	 * Metodo per la gestione della ricerca
	 * di aree in base alla sottoCategoria scelta
	 * dall'utente.
	 */
	public List<SottoCategoria> elencoAreePerSottoCategoria(int chiaveArea) {
		AreaDAO dao = this.createDAO();
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