package main.java.model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import main.java.model.session.FatturaPassiva;
import main.java.model.session.FatturaPassivaDettaglio;

public class FatturaPassivaService extends AbstractService<FatturaPassivaDAO, FatturaPassiva> {

	@Override
	public FatturaPassivaDAO createDAO() {
		return new FatturaPassivaDAO();
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di fatture passive in base alla sottoCategoria,
	 * alla spesa d'investimento e alla data inserite
	 * dall'utente.
	 */
	public List<FatturaPassivaDettaglio> elencoFatturePassivePerSottoCategoriaESpesaInvestimentoConData(int chiaveSottoCategoria, int chiaveSpesaInvestimento, Date dataInizio, Date dataFine) {
		FatturaPassivaDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(FatturaPassivaDettaglio.class)
				.createAlias("ospesainvestimento", "a")
				.createAlias("a.osottocategoria", "b")
				.createAlias("ofatturapassiva", "c")
				.add(Restrictions.eq("a.chiave", chiaveSpesaInvestimento))
				.add(Restrictions.eq("b.chiave", chiaveSottoCategoria))
				.add(Restrictions.ge("c.data", dataInizio))
				.add(Restrictions.lt("c.data", dataFine));
		@SuppressWarnings("unchecked")
		List<FatturaPassivaDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di fatture passive in base alla spesa 
	 * d'investimento e alla data inserite
	 * dall'utente.
	 */
	public List<FatturaPassivaDettaglio> elencoFatturePassivePerSpesaInvestimentoConData(int chiaveSpesaInvestimento, Date dataInizio, Date dataFine) {
		FatturaPassivaDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(FatturaPassivaDettaglio.class)
				.createAlias("ospesainvestimento", "a")
				.createAlias("ofatturapassiva", "b")
				.add(Restrictions.eq("a.chiave", chiaveSpesaInvestimento))
				.add(Restrictions.ge("b.data", dataInizio))
				.add(Restrictions.lt("b.data", dataFine));
		@SuppressWarnings("unchecked")
		List<FatturaPassivaDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di fatture passive in base alla sottoCategoria,
	 * e alla data inserite dall'utente.
	 */
	public List<FatturaPassivaDettaglio> elencoFatturePassivePerSottoCategoriaConData(int chiaveSottoCategoria, Date dataInizio, Date dataFine) {
		FatturaPassivaDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(FatturaPassivaDettaglio.class)
				.createAlias("ospesainvestimento", "a")
				.createAlias("a.osottocategoria", "b")
				.createAlias("ofatturapassiva", "c")
				.add(Restrictions.eq("b.chiave", chiaveSottoCategoria))
				.add(Restrictions.ge("c.data", dataInizio))
				.add(Restrictions.lt("c.data", dataFine));
		@SuppressWarnings("unchecked")
		List<FatturaPassivaDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di fatture passive in base alla sottoCategoria,
	 * alla spesa d'investimento inserite
	 * dall'utente.
	 */
	public List<FatturaPassivaDettaglio> elencoFatturePassivePerSottoCategoriaESpesaInvestimento(int chiaveSottoCategoria, int chiaveSpesaInvestimento) {
		FatturaPassivaDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(FatturaPassivaDettaglio.class)
				.createAlias("ospesainvestimento", "a")
				.createAlias("a.osottocategoria", "b")
				.add(Restrictions.eq("a.chiave", chiaveSpesaInvestimento))
				.add(Restrictions.eq("b.chiave", chiaveSottoCategoria));
		@SuppressWarnings("unchecked")
		List<FatturaPassivaDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di fatture passive in base  data inserite
	 * dall'utente.
	 */
	public List<FatturaPassivaDettaglio> elencoFatturePassivePerData(Date dataInizio, Date dataFine) {
		FatturaPassivaDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(FatturaPassivaDettaglio.class)
				.createAlias("ofatturapassiva", "a")
				.add(Restrictions.ge("a.data", dataInizio))
				.add(Restrictions.lt("a.data", dataFine));
		@SuppressWarnings("unchecked")
		List<FatturaPassivaDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di fatture passive in base alla spesa 
	 * d'investimento inserita dall'utente.
	 */
	public List<FatturaPassivaDettaglio> elencoFatturePassivePerSpesaInvestimento(int chiaveSpesaInvestimento) {
		FatturaPassivaDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(FatturaPassivaDettaglio.class)
				.createAlias("ospesainvestimento", "a")
				.add(Restrictions.eq("a.chiave", chiaveSpesaInvestimento));
		@SuppressWarnings("unchecked")
		List<FatturaPassivaDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di fatture passive in base alla SottoCategoria 
	 * inserita dall'utente.
	 */
	public List<FatturaPassivaDettaglio> elencoFatturePassivePerSottoCategoria(int chiaveSottoCategoria) {
		FatturaPassivaDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(FatturaPassivaDettaglio.class)
				.createAlias("ospesainvestimento", "a")
				.createAlias("a.osottocategoria", "b")
				.add(Restrictions.eq("b.chiave", chiaveSottoCategoria));
		@SuppressWarnings("unchecked")
		List<FatturaPassivaDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di fatture passive tramite il dettaglio
	 * in base alla sottoCategoria inserita dall'utente.
	 */
	public List<FatturaPassivaDettaglio> elencoFatturePassiveTramiteDettaglioPerSottoCategoria(int chiaveSottoCategoria) {
		FatturaPassivaDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(FatturaPassivaDettaglio.class)
				.createAlias("ospesainvestimento", "a")
				.createAlias("a.osottocategoria", "o")
				.add(Restrictions.eq("o.chiave", chiaveSottoCategoria));
		@SuppressWarnings("unchecked")
		List<FatturaPassivaDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di fatture passive in base al fornitore
	 * inserito dall'utente.
	 */
	public List<FatturaPassivaDettaglio> elencoFatturePassivePerFornitore(int chiaveFornitore) {
		FatturaPassivaDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(FatturaPassivaDettaglio.class)
				.createAlias("ofatturapassiva", "a")
				.createAlias("a.ofornitore", "b")
				.add(Restrictions.eq("b.chiave", chiaveFornitore));
		@SuppressWarnings("unchecked")
		List<FatturaPassivaDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	/*
	 * Metodo per generare un elenco filtrato
	 * di fatture passive tramite il dettaglio
	 * in base al preventivo inserito dall'utente.
	 */
	public List<FatturaPassivaDettaglio> elencoFatturePassiveTramiteDettaglioPerPreventivo(int chiavePreventivo) {
		FatturaPassivaDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getCurrentSession().createCriteria(FatturaPassivaDettaglio.class)
				.createAlias("opreventivo", "a")
				.add(Restrictions.eq("a.chiave", chiavePreventivo));
		@SuppressWarnings("unchecked")
		List<FatturaPassivaDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
}