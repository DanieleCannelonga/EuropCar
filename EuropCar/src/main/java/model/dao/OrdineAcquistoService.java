package main.java.model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import main.java.model.session.OrdineAcquisto;
import main.java.model.session.OrdineAcquistoDettaglio;

public class OrdineAcquistoService extends AbstractService<OrdineAcquistoDAO, OrdineAcquisto> {

	@Override
	public OrdineAcquistoDAO createDAO() {
		return new OrdineAcquistoDAO();
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di ordini d'acquisto tramite dettaglio 
	 * in base al progetto inserito
	 * dall'utente.
	 */
	public List<OrdineAcquistoDettaglio> elencoOrdiniAcquistoTramiteDettaglioPerProgetto(int chiaveProgetto) {
		OrdineAcquistoDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(OrdineAcquistoDettaglio.class)
				.createAlias("oprogetto", "a")
				.add(Restrictions.eq("a.chiave", chiaveProgetto));
		@SuppressWarnings("unchecked")
		List<OrdineAcquistoDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di ordini d'acquisto tramite dettaglio 
	 * in base alla sottoCategoria inserita
	 * dall'utente.
	 */
	public List<OrdineAcquistoDettaglio> elencoOrdiniAcquistoTramiteDettaglioPerSottoCategoria(int chiaveSottoCategoria) {
		OrdineAcquistoDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(OrdineAcquistoDettaglio.class)
				.createAlias("ospesainvestimento", "a")
				.createAlias("a.osottocategoria", "o")
				.add(Restrictions.eq("o.chiave", chiaveSottoCategoria));
		@SuppressWarnings("unchecked")
		List<OrdineAcquistoDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di ordini d'acquisto in base al fornitore
	 * inserito dall'utente.
	 */
	public List<OrdineAcquisto> elencoOrdiniAcquistoPerFornitore(int chiaveFornitore) {
		OrdineAcquistoDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(OrdineAcquisto.class)
				.createAlias("ofornitore", "a")
				.add(Restrictions.eq("a.chiave", chiaveFornitore));
				
		@SuppressWarnings("unchecked")
		List<OrdineAcquisto> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di ordini d'acquisto in base alla
	 * sottoCategoria e alla data inserita
	 * dall'utente.
	 */
	public List<OrdineAcquistoDettaglio> elencoOrdiniAcquistoPerSottoCategoriaConData(int chiaveSottoCategoria, Date dataInizio, Date dataFine) {
		OrdineAcquistoDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(OrdineAcquistoDettaglio.class)
				.createAlias("ospesainvestimento", "a")
				.createAlias("a.osottocategoria", "b")
				.createAlias("oordineacquisto", "c")
				.add(Restrictions.eq("b.chiave", chiaveSottoCategoria))
				.add(Restrictions.ge("c.data", dataInizio))
				.add(Restrictions.lt("c.data", dataFine));
		@SuppressWarnings("unchecked")
		List<OrdineAcquistoDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di ordini d'acquisto in base alla data
	 * inserita dall'utente.
	 */
	public List<OrdineAcquistoDettaglio> elencoOrdiniAcquistoPerData(Date dataInizio, Date dataFine) {
		OrdineAcquistoDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(OrdineAcquistoDettaglio.class)
				.createAlias("oordineacquisto", "a")
				.add(Restrictions.ge("a.data", dataInizio))
				.add(Restrictions.lt("a.data", dataFine));
		@SuppressWarnings("unchecked")
		List<OrdineAcquistoDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di ordini d'acquisto in base alla sottoCategoria
	 * inserita dall'utente.
	 */
	public List<OrdineAcquistoDettaglio> elencoOrdiniAcquistoPerSottoCategoria(int chiaveSottoCategoria) {
		OrdineAcquistoDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(OrdineAcquistoDettaglio.class)
				.createAlias("ospesainvestimento", "a")
				.createAlias("a.osottocategoria", "b")
				.add(Restrictions.eq("b.chiave", chiaveSottoCategoria));
		@SuppressWarnings("unchecked")
		List<OrdineAcquistoDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di ordini d'acquisto in base al progetto
	 * inserito dall'utente.
	 */
	public List<OrdineAcquisto> elencoOrdiniAcquistoPerProgetto(int chiaveProgetto) {
		OrdineAcquistoDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(OrdineAcquisto.class)
				.createAlias("oprogetto", "a")
				.add(Restrictions.eq("a.chiave", chiaveProgetto));
		@SuppressWarnings("unchecked")
		List<OrdineAcquisto> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
}