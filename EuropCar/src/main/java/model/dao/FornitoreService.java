package main.java.model.dao;

import main.java.model.session.Fornitore;

public class FornitoreService extends AbstractService<FornitoreDAO, Fornitore> {
	
	@Override
	public FornitoreDAO createDAO() {
		return new FornitoreDAO();
	}

	/*
	 * Metodo per la gestione della ricerca
	 * di Fornitori in base alla partita iva
	 * scelta dall'utente.
	 */
 	public Fornitore findFornitorePerPartitaIva(String partitaIva) throws Exception {
        Fornitore result =null;
        if(this.executeParamizedHQLQuery("FROM model.session.Fornitore o WHERE o.partitaiva= '"+partitaIva+"'", Fornitore.class)!=null) {
            if((this.executeParamizedHQLQuery("FROM model.session.Fornitore o WHERE o.partitaiva='"+partitaIva+"'", Fornitore.class).size()==1)) {
                result = this.executeParamizedHQLQuery("FROM model.session.Fornitore o WHERE o.partitaiva='"+partitaIva+"'", Fornitore.class).get(0);
            }
            else if
            (this.executeParamizedHQLQuery("FROM model.session.Fornitore o WHERE o.partitaiva="+partitaIva, Fornitore.class).size()>1) {
                throw new Exception("ATTENZIONE presenti più di un Fornitore per la PartitaIva:"+partitaIva);
            }
        }
        return result;
    }
}