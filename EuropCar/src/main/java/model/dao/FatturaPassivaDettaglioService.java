package main.java.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import main.java.model.session.FatturaPassivaDettaglio;
import main.java.model.session.Fornitore;

public class FatturaPassivaDettaglioService extends AbstractService<FatturaPassivaDettaglioDAO, FatturaPassivaDettaglio> {

	@Override
	public FatturaPassivaDettaglioDAO createDAO() {
		return new FatturaPassivaDettaglioDAO();
	}

	/*
	 * Metodo per la gestione della ricerca
	 * di fatture passive in base all'id scelto
	 * dall'utente.
	 */
	public List<FatturaPassivaDettaglio> findFatturaPassivaDettaglioPerId(int chiave) {
		FatturaPassivaDettaglioDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(FatturaPassivaDettaglio.class)
				.createAlias("ofatturapassiva", "o")
				.add(Restrictions.eq("o.chiave", chiave));
		@SuppressWarnings("unchecked")
		List<FatturaPassivaDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di fatture passive dettaglio in base 
	 * al fornitore scelto dall'utente.
	 */
	public List<FatturaPassivaDettaglio> elencoFatturePassiveDettaglioPerFornitore(Fornitore oFornitore) {
		FatturaPassivaDettaglioDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(FatturaPassivaDettaglio.class)
				.createAlias("ofatturapassiva", "o")
				.createAlias("o.ofornitore", "a")
				.add(Restrictions.eq("a.chiave", oFornitore.getChiave()));
		@SuppressWarnings("unchecked")
		List<FatturaPassivaDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	/*
	 * Metodo per la gestione della ricerca
	 * di fatture passive in base al fornitore 
	 * scelto dall'utente.
	 */
	public List<FatturaPassivaDettaglio> findFatturaPerFornitore(String chiave) {
		FatturaPassivaDettaglioDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(FatturaPassivaDettaglio.class)
				.createAlias("ofatturapassiva", "o")
				.createAlias("o.ofornitore", "a")
				.add(Restrictions.eq("a.chiave", Integer.parseInt(chiave)));
		@SuppressWarnings("unchecked")
		List<FatturaPassivaDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
}