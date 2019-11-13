package main.java.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import main.java.model.session.OrdineAcquistoDettaglio;

public class OrdineAcquistoDettaglioService extends AbstractService<OrdineAcquistoDettaglioDAO, OrdineAcquistoDettaglio> {

	@Override
	public OrdineAcquistoDettaglioDAO createDAO() {
		return new OrdineAcquistoDettaglioDAO();
	}

	/*
	 * Metodo per la gestione della ricerca
	 * di ordini d'acquisto dettaglio 
	 * in base all'id scelta
	 * dall'utente.
	 */
	public List<OrdineAcquistoDettaglio> findOrdiniAcquistoDettaglioPerId(int chiave) {
		OrdineAcquistoDettaglioDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(OrdineAcquistoDettaglio.class)
				.createAlias("oordineacquisto", "o")
				.add(Restrictions.eq("o.chiave", chiave));
		@SuppressWarnings("unchecked")
		List<OrdineAcquistoDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
}