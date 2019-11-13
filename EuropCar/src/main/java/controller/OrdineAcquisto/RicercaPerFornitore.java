package main.java.controller.OrdineAcquisto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import main.java.model.dao.FornitoreService;
import main.java.model.dao.OrdineAcquistoService;
import main.java.model.session.Fornitore;

@SuppressWarnings("serial")
public class RicercaPerFornitore extends ActionSupport implements SessionAware {

	//Attributi
	public static final String KEY_LISTAORDINIACQUISTO = "listaOrdiniAcquisto";
	public static final String KEY_LISTAFORNITORI = "listaFornitori";
	private String chiaveFornitore;
	private SessionMap<String, Object> sessionMap;
	private List<Fornitore> elencoFornitori;
	FornitoreService oFornitoreService = new FornitoreService();
	OrdineAcquistoService oOrdineAcquistoService = new OrdineAcquistoService();
	
	//Getters & Setters
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
	
	//Gestione Ricerca Per Fornitore
	public String execute() {
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
		sessionMap.put(KEY_LISTAORDINIACQUISTO, (oOrdineAcquistoService.elencoOrdiniAcquistoPerFornitore(Integer.parseInt(this.chiaveFornitore.replace("\'", "")))));
		return "RicercaPerFornitore";
	}
}