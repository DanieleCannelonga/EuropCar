package main.java.controller.Budget;

import java.util.Date;
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
public class GestioneRiconciliazione extends ActionSupport implements SessionAware {

	//Attributi
	public static final String KEY_OBJ = "oggettoOrdineAcquisto";
	public static final String KEY_LISTAORDINIACQUISTO = "listaOrdiniAcquisto";
	public static final String KEY_LISTASOTTOCATEGORIE = "listaSottoCategorie";
	private String chiave;
	private String chiaveSottoCategoria;
	private Date dataInizio;
	private Date dataFine;
	private int totale;
	private SessionMap<String, Object> sessionMap;
	private List<SottoCategoria> elencoSottoCategorie;
	private List<String> elenco;
	SottoCategoriaService oSottoCategoriaService = new SottoCategoriaService();
	OrdineAcquistoService oOrdineAcquistoService = new OrdineAcquistoService();
	
	//Getters & Setters
	public String getChiave() {
		return chiave;
	}
	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public String getChiaveSottoCategoria() {
		return chiaveSottoCategoria;
	}
	public void setChiaveSottoCategoria(String chiaveSottoCategoria) {
		this.chiaveSottoCategoria = chiaveSottoCategoria;
	}
	public List<SottoCategoria> getElencoSottoCategorie() {
		return elencoSottoCategorie;
	}
	public void setElencoSottoCategorie(List<SottoCategoria> elencoSottoCategorie) {
		this.elencoSottoCategorie = elencoSottoCategorie;
	}
	public int getTotale() {
		return totale;
	}
	public void setTotale(int totale) {
		this.totale = totale;
	}
	public List<String> getElenco() {
		return elenco;
	}
	public void setElenco(List<String> elenco) {
		this.elenco = elenco;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}
	
	//Gestione Riconciliazione
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
	
	public String riconcilia() {
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
		if(Integer.parseInt(this.chiaveSottoCategoria)!=0 && this.dataInizio!=null && this.dataFine!=null) {
			sessionMap.put(KEY_LISTAORDINIACQUISTO, oOrdineAcquistoService.elencoOrdiniAcquistoPerSottoCategoriaConData(Integer.parseInt(this.chiaveSottoCategoria.replace("\'", "")), dataInizio, dataFine));
		} else if(Integer.parseInt(this.chiaveSottoCategoria)==0 && this.dataInizio!=null && this.dataFine!=null) {
			sessionMap.put(KEY_LISTAORDINIACQUISTO, oOrdineAcquistoService.elencoOrdiniAcquistoPerData(dataInizio, dataFine));
		} else if(Integer.parseInt(this.chiaveSottoCategoria)!=0 && this.dataInizio==null && this.dataFine==null) {
			sessionMap.put(KEY_LISTAORDINIACQUISTO, oOrdineAcquistoService.elencoOrdiniAcquistoPerSottoCategoria(Integer.parseInt(this.chiaveSottoCategoria.replace("\'", ""))));
		}
		return "RicercaRiconciliazione";
	}
}