package main.java.controller.OrdineAcquisto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import main.java.model.dao.OrdineAcquistoService;
import main.java.model.dao.SottoCategoriaService;
import main.java.model.session.SottoCategoria;

@SuppressWarnings("serial")
public class RicercaPerSottoCategoria extends ActionSupport implements SessionAware {

	//Attributi
	public static final String KEY_LISTAORDINIACQUISTO = "listaOrdiniAcquisto";
	public static final String KEY_LISTASOTTOCATEGORIE = "listaSottoCategorie";
	private String chiaveSottoCategoria;
	private SessionMap<String, Object> sessionMap;
	private List<SottoCategoria> elencoSottoCategorie;
	SottoCategoriaService oSottoCategoriaService = new SottoCategoriaService();
	OrdineAcquistoService oOrdineAcquistoService = new OrdineAcquistoService();
	
	//Getters & Setters
	public String getChiaveSottoCategoria() {
		return chiaveSottoCategoria;
	}
	public void setChiaveSottoCategoria(String chiaveSottoCategoria) {
		this.chiaveSottoCategoria = chiaveSottoCategoria;
	}
	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	public List<SottoCategoria> getElencoSottoCategorie() {
		return elencoSottoCategorie;
	}
	public void setElencoSottoCategorie(List<SottoCategoria> elencoSottoCategorie) {
		this.elencoSottoCategorie = elencoSottoCategorie;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}
	
	//Gestione Ricerca Per SottoCategoria
	public String execute() {
		HashMap<String, String> mapSottoCategoria = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona una SottoCategoria");
				elencoSottoCategorie = oSottoCategoriaService.findAll();
				for(int i=0;i<elencoSottoCategorie.size();i++) {
					put(String.valueOf(elencoSottoCategorie.get(i).getChiave()),
							elencoSottoCategorie.get(i).getSottoCategoria());
				}
			}
		};
		sessionMap.put(KEY_LISTASOTTOCATEGORIE, mapSottoCategoria);
		return "search";
	}

	public String cerca() {
		HashMap<String, String> mapSottoCategoria = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona una SottoCategoria");
				elencoSottoCategorie = oSottoCategoriaService.findAll();
				for(int i=0;i<elencoSottoCategorie.size();i++) {
					put(String.valueOf(elencoSottoCategorie.get(i).getChiave()),
							elencoSottoCategorie.get(i).getSottoCategoria());
				}
			}
		};
		sessionMap.put(KEY_LISTASOTTOCATEGORIE, mapSottoCategoria);
		sessionMap.put(KEY_LISTAORDINIACQUISTO, (oOrdineAcquistoService.elencoOrdiniAcquistoTramiteDettaglioPerSottoCategoria(Integer.parseInt(this.chiaveSottoCategoria.replace("\'", "")))));
		return "RicercaPerSottoCategoria";
	}
}