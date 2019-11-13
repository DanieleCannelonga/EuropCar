package main.java.controller.OrdineAcquisto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import main.java.model.dao.OrdineAcquistoService;
import main.java.model.dao.ProgettoService;
import main.java.model.session.Progetto;

@SuppressWarnings("serial")
public class RicercaPerProgetto extends ActionSupport implements SessionAware {

	//Attributi
	public static final String KEY_LISTAORDINIACQUISTO = "listaOrdiniAcquisto";
	public static final String KEY_LISTAPROGETTI = "listaProgetti";
	private String chiaveProgetto;
	private SessionMap<String, Object> sessionMap;
	private List<Progetto> elencoProgetti;
	ProgettoService oProgettoService = new ProgettoService();
	OrdineAcquistoService oOrdineAcquistoService = new OrdineAcquistoService();
	
	//Getters & Setters
	public String getChiaveProgetto() {
		return chiaveProgetto;
	}
	public void setChiaveProgetto(String chiaveProgetto) {
		this.chiaveProgetto = chiaveProgetto;
	}
	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	public List<Progetto> getElencoProgetti() {
		return elencoProgetti;
	}
	public void setElencoProgetti(List<Progetto> elencoProgetti) {
		this.elencoProgetti = elencoProgetti;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}
	
	//Gestione Ricerca Per Progetto
	public String execute() {
		HashMap<String, String> mapProgetto = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un Progetto");
				elencoProgetti = oProgettoService.findAll();
				for(int i=0;i<elencoProgetti.size();i++) {
					put(String.valueOf(elencoProgetti.get(i).getChiave()),
							elencoProgetti.get(i).getProgetto());
				}
			}
		};
		sessionMap.put(KEY_LISTAPROGETTI, mapProgetto);
		return "search";
	}

	public String cerca() {
		HashMap<String, String> mapProgetto = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un Progetto");
				elencoProgetti = oProgettoService.findAll();
				for(int i=0;i<elencoProgetti.size();i++) {
					put(String.valueOf(elencoProgetti.get(i).getChiave()),
							elencoProgetti.get(i).getProgetto());
				}
			}
		};
		sessionMap.put(KEY_LISTAPROGETTI, mapProgetto);
		sessionMap.put(KEY_LISTAORDINIACQUISTO, (oOrdineAcquistoService.elencoOrdiniAcquistoTramiteDettaglioPerProgetto(Integer.parseInt(this.chiaveProgetto.replace("\'", "")))));
		return "RicercaPerProgetto";
	}
}