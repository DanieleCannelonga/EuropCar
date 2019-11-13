package main.java.controller.Archivio;

import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import main.java.model.dao.FornitoreService;
import main.java.model.session.Fornitore;

@SuppressWarnings("serial")
public class GestioneFornitore extends ActionSupport implements SessionAware {

	//Attributi
	public static final String KEY_LIST = "listaFornitori";
	public static final String KEY_OBJ = "oggettoFornitore";
	private SessionMap<String, Object> sessionMap;
	private String chiave;
	private String ragioneSociale;
	private String indirizzo;
	private String citta;
	private String cap;
	private String provincia;
	private String partitaIva;
	FornitoreService oFornitoreService = new FornitoreService();
	
	//Getters & Setters
	public String getChiave() {
		return chiave;
	}
	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	@Override
    public void setSession(Map<String, Object> arg0)
    {
    	this.sessionMap = (SessionMap<String, Object>) arg0;
    }

	//Metodi
	public String execute() {
		sessionMap.put(KEY_LIST, oFornitoreService.findAll());
		return "search";
	}

	public String nuovoFornitore() {
		sessionMap.put(KEY_OBJ, new Fornitore());
		return "nuovoModifica";
	}
	
	public String modificaFornitore() {
		sessionMap.put(KEY_OBJ, oFornitoreService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
		return "nuovoModifica";
	}
	
	public String eliminaFornitore() {
		oFornitoreService.delete(Integer.parseInt(this.chiave.replace("\'", "")));
		return execute();
	}
	
	public String annulla() {
		return execute();
	}
	
	public String registra() throws Exception {
		Fornitore oFornitore = (Fornitore) sessionMap.get(KEY_OBJ);
		oFornitore.setCap(cap);
		oFornitore.setCitta(citta);
		oFornitore.setIndirizzo(indirizzo);
		oFornitore.setPartitaIva(partitaIva);
		oFornitore.setProvincia(provincia);
		oFornitore.setRagioneSociale(ragioneSociale);
		oFornitoreService.persistOrUpdate(oFornitore);
		return execute();
	}
}