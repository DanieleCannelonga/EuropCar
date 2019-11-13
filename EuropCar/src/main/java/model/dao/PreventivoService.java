package main.java.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import main.java.model.session.Preventivo;

public class PreventivoService extends AbstractService<PreventivoDAO, Preventivo> {

	@Override
	public PreventivoDAO createDAO() {
		return new PreventivoDAO();
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di preventivi in base al fornitore
	 * inserito dall'utente.
	 */
	public List<Preventivo> elencoPreventiviPerFornitore(int chiaveFornitore) {
		PreventivoDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(Preventivo.class)
				.createAlias("ofornitore", "a")
				.add(Restrictions.eq("a.chiave", chiaveFornitore));
				
		@SuppressWarnings("unchecked")
		List<Preventivo> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
}