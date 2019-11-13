package main.java.model.dao;

import main.java.model.session.AliquotaIva;

public class AliquotaIvaService extends AbstractService<AliquotaIvaDAO, AliquotaIva> {

	@Override
	public AliquotaIvaDAO createDAO() {
		return new AliquotaIvaDAO();
	}

	/*
	 * Metodo per la gestione della ricerca
	 * di aliquote in base all'aliquota scelta
	 * dall'utente.
	 */
	public AliquotaIva findAliquotaPerAliquota(float aliquota) throws Exception {
		AliquotaIva result =null;
		if(this.executeParamizedHQLQuery("FROM model.session.AliquotaIva o WHERE o.aliquota="+aliquota, AliquotaIva.class)!=null) {
			if((this.executeParamizedHQLQuery("FROM model.session.AliquotaIva o WHERE o.aliquota="+aliquota, AliquotaIva.class).size()==1)) {
				result = this.executeParamizedHQLQuery("FROM model.session.AliquotaIva o WHERE o.aliquota="+aliquota, AliquotaIva.class).get(0);
			}
			else if(this.executeParamizedHQLQuery("FROM model.session.AliquotaIva o WHERE o.aliquota="+aliquota, AliquotaIva.class).size()>1) {
				throw new Exception("ATTENZIONE presenti più di un aliquota per la le aliquote:"+aliquota);

			}
		}
		return result;
	}
}