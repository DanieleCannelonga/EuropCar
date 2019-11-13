package main.java.controller.Archivio;

import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import main.java.model.dao.AliquotaIvaService;
import main.java.model.session.AliquotaIva;

@SuppressWarnings("serial")
public class GestioneAliquotaIva extends ActionSupport implements SessionAware {
	
	//Attributi
    public static final String KEY_LIST = "listaAliquoteIva";
    public static final String KEY_OBJ = "oggettoAliquotaIva";
    private SessionMap<String, Object> sessionMap;
    private String chiave;
    private String aliquota;
    private String descrizione;
	AliquotaIvaService oAliquotaIvaService = new AliquotaIvaService();
	
	//Getters & Setters
	public String getChiave() {
		return chiave;
	}
	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	public String getAliquota() {
		return aliquota;
	}
	public void setAliquota(String aliquota) {
		this.aliquota = aliquota;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	@Override
	public void setSession(Map<String, Object> arg0)
    {
    	this.sessionMap = (SessionMap<String, Object>) arg0;
    }

	//Metodi
	public String execute() {
		sessionMap.put(KEY_LIST, oAliquotaIvaService.findAll());
		return "search";
	}
	
	public String nuovaAliquotaIva() {
		sessionMap.put(KEY_OBJ, new AliquotaIva());
		return "nuovoModifica";
	}
	
	public String modificaAliquotaIva() {
		sessionMap.put(KEY_OBJ, oAliquotaIvaService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
		return "nuovoModifica";
	}
	
	public String eliminaAliquotaIva() {
		oAliquotaIvaService.delete(Integer.parseInt(this.chiave.replace("\'", "")));
		return execute();
	}
	
	public String annulla() {
		return execute();
	}
	
	public String registra() throws Exception {
		 AliquotaIva oAliquotaIva = (AliquotaIva) sessionMap.get(KEY_OBJ);
		 oAliquotaIva.setAliquota(Integer.parseInt(aliquota));
		 oAliquotaIva.setDescrizione(descrizione);
		 oAliquotaIvaService.persistOrUpdate(oAliquotaIva);
		 return execute();
	 }
}