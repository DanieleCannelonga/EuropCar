package main.java.controller.Archivio;

import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import main.java.model.dao.ProgettoService;
import main.java.model.session.Progetto;

@SuppressWarnings("serial")
public class GestioneProgetto extends ActionSupport implements SessionAware{

	//Attributi
	public static final String KEY_LIST = "listaProgetti";
	public static final String KEY_OBJ = "oggettoProgetto";
	private SessionMap<String, Object> sessionMap;
	private String chiave;
	private String codice;
	private String progetto;
	ProgettoService oProgettoService = new ProgettoService();
	
	//Getters & Setters
	public String getChiave() {
		return chiave;
	}
	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getProgetto() {
		return progetto;
	}
	public void setProgetto(String progetto) {
		this.progetto = progetto;
	}
	@Override
    public void setSession(Map<String, Object> arg0)
    {
    	this.sessionMap = (SessionMap<String, Object>) arg0;
    }

	//Metodi
	public String execute() {
		sessionMap.put(KEY_LIST, oProgettoService.findAll());
		return "search";
	}

	public String nuovoProgetto() {
		sessionMap.put(KEY_OBJ, new Progetto());
		return "nuovoModifica";
	}
	
	public String modificaProgetto () {
		sessionMap.put(KEY_OBJ, oProgettoService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
		return "nuovoModifica";
	}
	
	public String eliminaProgetto() {
		oProgettoService.delete(Integer.parseInt(this.chiave.replace("\'", "")));
		return execute();
	}
	
	public String annulla() {
		return execute();
	}
	
	public String registra() {
		Progetto oProgetto = (Progetto) sessionMap.get(KEY_OBJ);
		oProgetto.setCodice(Integer.parseInt(codice));
		oProgetto.setProgetto(progetto);
		oProgettoService.persistOrUpdate(oProgetto); 
		return execute();
	}
}