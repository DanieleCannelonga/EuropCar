package main.java.controller.Preventivo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

import main.java.model.dao.FornitoreService;
import main.java.model.dao.PreventivoService;
import main.java.model.session.Fornitore;
import main.java.model.session.Preventivo;

@SuppressWarnings("serial")
public class GestionePreventivo extends ActionSupport implements SessionAware {

	//Attributi
	public static final String KEY_LIST = "listaPreventivi";
	public static final String KEY_OBJ = "oggettoPreventivo";
	public static final String KEY_LISTAFORNITORI = "listaFornitori";
	private String chiave;
	private String codice;
	private String preventivo;
	private String chiaveFornitore;
	private SessionMap<String, Object> sessionMap;
	private List<Fornitore> elencoFornitori;
	PreventivoService oPreventivoService = new PreventivoService();
	FornitoreService oFornitoreService = new FornitoreService();
	
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
	public String getPreventivo() {
		return preventivo;
	}
	public void setPreventivo(String preventivo) {
		this.preventivo = preventivo;
	}
	public String getChiaveFornitore() {
		return chiaveFornitore;
	}
	public void setChiaveFornitore(String chiaveFornitore) {
		this.chiaveFornitore = chiaveFornitore;
	}
	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	public List<Fornitore> getElencoFornitori() {
		return elencoFornitori;
	}
	public void setElencoFornitori(List<Fornitore> elencoFornitori) {
		this.elencoFornitori = elencoFornitori;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}
	
	//Gestione Preventivo
	public String execute() {
		sessionMap.put(KEY_LIST, oPreventivoService.findAll());
		HashMap<String, String> mapFornitore = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un Fornitore");
				elencoFornitori = oFornitoreService.findAll();
				for(int i=0;i<elencoFornitori.size();i++) {
					put(String.valueOf(elencoFornitori.get(i).getChiave()),
							elencoFornitori.get(i).getRagioneSociale());
				}
			}
		};
		sessionMap.put(KEY_LISTAFORNITORI, mapFornitore);
		return "search";
	}
	
	public String cerca() {
		sessionMap.put(KEY_LIST, (oPreventivoService.elencoPreventiviPerFornitore(Integer.parseInt(this.chiaveFornitore.replace("\'", "")))));
		return "RicercaPreventivi";
	}
	
	public String nuovoPreventivo() {
		sessionMap.put(KEY_OBJ, new Preventivo());
		return "nuovoModifica";
	}
	
	public String modificaPreventivo() {
		sessionMap.put(KEY_OBJ, oPreventivoService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
		return "nuovoModifica";
	}
	
	public String eliminaPreventivo() {
		oPreventivoService.delete(Integer.parseInt(this.chiave.replace("\'", "")));
		return execute();
	}
	
	public String annulla() {
		return execute();
	}
	
	public String registra() {
		Preventivo oPreventivo = (Preventivo) sessionMap.get(KEY_OBJ);
		oPreventivo.setCodice(Integer.parseInt(this.codice));
		oPreventivo.setPreventivo(this.preventivo);
		oPreventivo.setOfornitore(oFornitoreService.findById(Integer.parseInt(this.chiaveFornitore)));
		oPreventivoService.persistOrUpdate(oPreventivo);
		return execute();
	}
}