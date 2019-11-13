package main.java.controller.FatturaPassiva;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import main.java.model.dao.FatturaPassivaService;
import main.java.model.dao.PreventivoService;
import main.java.model.session.Preventivo;

@SuppressWarnings("serial")
public class RicercaPerPreventivo extends ActionSupport implements SessionAware {

	//Attributi
	public static final String KEY_LISTAFATTUREPASSIVE = "listaFatturePassive";
	public static final String KEY_LISTAPREVENTIVI = "listaPreventivi";
	private String chiavePreventivo;
	private SessionMap<String, Object> sessionMap;
	private List<Preventivo> elencoPreventivi;
	PreventivoService oPreventivoService = new PreventivoService();
	FatturaPassivaService oFatturaPassivaService = new FatturaPassivaService();
	
	//Getters & Setters
	public String getChiavePreventivo() {
		return chiavePreventivo;
	}
	public void setChiavePreventivo(String chiavePreventivo) {
		this.chiavePreventivo = chiavePreventivo;
	}
	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	public List<Preventivo> getElencoPreventivi() {
		return elencoPreventivi;
	}
	public void setElencoPreventivi(List<Preventivo> elencoPreventivi) {
		this.elencoPreventivi = elencoPreventivi;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}
	
	//Gestione Ricerca Per Preventivo
	public String execute() {
		HashMap<String, String> mapPreventivo = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un Preventivo");
				elencoPreventivi = oPreventivoService.findAll();
				for(int i=0;i<elencoPreventivi.size();i++) {
					put(String.valueOf(elencoPreventivi.get(i).getChiave()),
							elencoPreventivi.get(i).getPreventivo());
				}
			}
		};
		sessionMap.put(KEY_LISTAPREVENTIVI, mapPreventivo);
		return "search";
	}
	public String cerca() {
		HashMap<String, String> mapPreventivo = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un Preventivo");
				elencoPreventivi = oPreventivoService.findAll();
				for(int i=0;i<elencoPreventivi.size();i++) {
					put(String.valueOf(elencoPreventivi.get(i).getChiave()),
							elencoPreventivi.get(i).getPreventivo());
				}
			}
		};
		sessionMap.put(KEY_LISTAPREVENTIVI, mapPreventivo);
		sessionMap.put(KEY_LISTAFATTUREPASSIVE, (oFatturaPassivaService.elencoFatturePassiveTramiteDettaglioPerPreventivo(Integer.parseInt(this.chiavePreventivo.replace("\'", "")))));
		return "RicercaPerPreventivo";
	}
}