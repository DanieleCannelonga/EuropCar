package main.java.controller.FatturaPassiva;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import main.java.model.dao.FatturaPassivaService;
import main.java.model.dao.SottoCategoriaService;
import main.java.model.dao.SpesaInvestimentoService;
import main.java.model.session.SottoCategoria;
import main.java.model.session.SpesaInvestimento;

@SuppressWarnings("serial")
public class GestioneStatistica extends ActionSupport implements SessionAware {

	//Attributi
	public static final String KEY_OBJ = "oggettoOrdineAcquisto";
	public static final String KEY_LISTAFATTUREPASSIVE = "listaFatturePassive";
	public static final String KEY_LISTASOTTOCATEGORIE = "listaSottoCategorie";
	public static final String KEY_LISTASPESEINVESTIMENTO = "listaSpeseInvestimento";
	private String chiave;
	private String chiaveSottoCategoria;
	private String chiaveSpesaInvestimento;
	private Date dataInizio;
	private Date dataFine;
	private SessionMap<String, Object> sessionMap;
	private List<SottoCategoria> elencoSottoCategorie;
	private List<SpesaInvestimento> elencoSpeseInvestimento;
	SottoCategoriaService oSottoCategoriaService = new SottoCategoriaService();
	SpesaInvestimentoService oSpesaInvestimentoService = new SpesaInvestimentoService();
	FatturaPassivaService oFatturaPassivaService = new FatturaPassivaService();
	
	//Getters & Setters
	public String getChiave() {
		return chiave;
	}
	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	public String getChiaveSottoCategoria() {
		return chiaveSottoCategoria;
	}
	public void setChiaveSottoCategoria(String chiaveSottoCategoria) {
		this.chiaveSottoCategoria = chiaveSottoCategoria;
	}
	public String getChiaveSpesaInvestimento() {
		return chiaveSpesaInvestimento;
	}
	public void setChiaveSpesaInvestimento(String chiaveSpesaInvestimento) {
		this.chiaveSpesaInvestimento = chiaveSpesaInvestimento;
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
	public List<SpesaInvestimento> getElencoSpeseInvestimento() {
		return elencoSpeseInvestimento;
	}
	public void setElencoSpeseInvestimento(List<SpesaInvestimento> elencoSpeseInvestimento) {
		this.elencoSpeseInvestimento = elencoSpeseInvestimento;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	//Gestione Statistica
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
		HashMap<String, String> mapSpesaInvestimento = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona una SpesaInvestimento");
				elencoSpeseInvestimento = oSpesaInvestimentoService.findAll();
				for(int i=0;i<elencoSpeseInvestimento.size();i++) {
					put(String.valueOf(elencoSpeseInvestimento.get(i).getChiave()),
							elencoSpeseInvestimento.get(i).getSpesaInvestimento());
				}
			}
		};
		sessionMap.put(KEY_LISTASPESEINVESTIMENTO, mapSpesaInvestimento);
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
		HashMap<String, String> mapSpesaInvestimento = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona una SpesaInvestimento");
				elencoSpeseInvestimento = oSpesaInvestimentoService.findAll();
				for(int i=0;i<elencoSpeseInvestimento.size();i++) {
					put(String.valueOf(elencoSpeseInvestimento.get(i).getChiave()),
							elencoSpeseInvestimento.get(i).getSpesaInvestimento());
				}
			}
		};
		sessionMap.put(KEY_LISTASPESEINVESTIMENTO, mapSpesaInvestimento);
		sessionMap.put(KEY_LISTASOTTOCATEGORIE, mapSottoCategoria);
		// SottoCategoria!=0 SpesaInvestimento!=0 Data!=null
		if(Integer.parseInt(this.chiaveSottoCategoria)!=0 && Integer.parseInt(this.chiaveSpesaInvestimento)!=0 && this.dataInizio!=null && this.dataFine!=null) {
			sessionMap.put(KEY_LISTAFATTUREPASSIVE, oFatturaPassivaService.elencoFatturePassivePerSottoCategoriaESpesaInvestimentoConData(Integer.parseInt(this.chiaveSottoCategoria.replace("\'", "")), Integer.parseInt(this.chiaveSpesaInvestimento.replace("\'", "")), dataInizio, dataFine));
		// SottoCategoria==0 SpesaInvestimento!=0 Data!=null
		} else if(Integer.parseInt(this.chiaveSottoCategoria)==0 && Integer.parseInt(this.chiaveSpesaInvestimento)!=0 && this.dataInizio!=null && this.dataFine!=null) {
			sessionMap.put(KEY_LISTAFATTUREPASSIVE, oFatturaPassivaService.elencoFatturePassivePerSpesaInvestimentoConData(Integer.parseInt(this.chiaveSpesaInvestimento.replace("\'", "")), dataInizio, dataFine));
		// SottoCategoria!=0 SpesaInvestimento==0 Data!=null
		} else if(Integer.parseInt(this.chiaveSottoCategoria)!=0 && Integer.parseInt(this.chiaveSpesaInvestimento)==0 && this.dataInizio!=null && this.dataFine!=null) {
			sessionMap.put(KEY_LISTAFATTUREPASSIVE, oFatturaPassivaService.elencoFatturePassivePerSottoCategoriaConData(Integer.parseInt(this.chiaveSottoCategoria.replace("\'", "")), dataInizio, dataFine));
		// SottoCategoria!=0 SpesaInvestimento!=0 Data==null
		} else if(Integer.parseInt(this.chiaveSottoCategoria)!=0 && Integer.parseInt(this.chiaveSpesaInvestimento)!=0 && (this.dataInizio==null || this.dataFine==null)) {
			sessionMap.put(KEY_LISTAFATTUREPASSIVE, oFatturaPassivaService.elencoFatturePassivePerSottoCategoriaESpesaInvestimento(Integer.parseInt(this.chiaveSottoCategoria.replace("\'", "")), Integer.parseInt(this.chiaveSpesaInvestimento.replace("\'", ""))));
		// SottoCategoria==0 SpesaInvestimento==0 Data!=null
		} else if(Integer.parseInt(this.chiaveSottoCategoria)==0 && Integer.parseInt(this.chiaveSpesaInvestimento)==0 && this.dataInizio!=null && this.dataFine!=null) {
			sessionMap.put(KEY_LISTAFATTUREPASSIVE, oFatturaPassivaService.elencoFatturePassivePerData(dataInizio, dataFine));
		// SottoCategoria!=0 SpesaInvestimento==0 Data==null
		} else if(Integer.parseInt(this.chiaveSottoCategoria)!=0 && Integer.parseInt(this.chiaveSpesaInvestimento)==0 && (this.dataInizio==null || this.dataFine==null)) {
			sessionMap.put(KEY_LISTAFATTUREPASSIVE, oFatturaPassivaService.elencoFatturePassivePerSottoCategoria(Integer.parseInt(this.chiaveSottoCategoria.replace("\'", ""))));
		// SottoCategoria==0 SpesaInvestimento!=0 Data==null
		} else if(Integer.parseInt(this.chiaveSottoCategoria)==0 && Integer.parseInt(this.chiaveSpesaInvestimento)!=0 && (this.dataInizio==null || this.dataFine==null)) {
			sessionMap.put(KEY_LISTAFATTUREPASSIVE, oFatturaPassivaService.elencoFatturePassivePerSpesaInvestimento(Integer.parseInt(this.chiaveSpesaInvestimento.replace("\'", ""))));
		}
		return "RicercaStatistica";
	}
}