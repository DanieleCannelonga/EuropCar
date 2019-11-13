package main.java.controller.Budget;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import main.java.model.dao.SottoCategoriaService;
import main.java.model.dao.SpesaInvestimentoService;
import main.java.model.session.SottoCategoria;
import main.java.model.session.SpesaInvestimento;

@SuppressWarnings("serial")
public class GestioneSpesaInvestimento extends ActionSupport implements SessionAware {

	//Attributi
	public static final String KEY_LIST = "listaSpeseInvestimento";
	public static final String KEY_OBJ = "oggettoSpesaInvestimento";
	public static final String KEY_LISTASOTTOCATEGORIE = "listaSottoCategorie";
	private String chiave;
	private String spesaInvestimento;
	private String chiaveSottoCategoria;
	private SessionMap<String, Object> sessionMap;
	private List<SottoCategoria> elencoSottoCategorie;
	SpesaInvestimentoService oSpesaInvestimentoService = new SpesaInvestimentoService();
	SottoCategoriaService oSottoCategoriaService = new SottoCategoriaService();
	
	//Getters & Setters
	public String getChiave() {
		return chiave;
	}
	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	public String getSpesaInvestimento() {
		return spesaInvestimento;
	}
	public void setSpesaInvestimento(String spesaInvestimento) {
		this.spesaInvestimento = spesaInvestimento;
	}
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
	
	//Gestione Spesa d'Investimento
	public String execute() {
		sessionMap.put(KEY_LIST, oSpesaInvestimentoService.findAll());
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
		sessionMap.put(KEY_LIST, (oSpesaInvestimentoService.elencoSpeseInvestimentoPerSottoCategoria(Integer.parseInt(this.chiaveSottoCategoria.replace("\'", "")))));
		return "RicercaSpeseInvestimento";
	}
	
	public String nuovaSpesaInvestimento() {
		sessionMap.put(KEY_LIST, oSpesaInvestimentoService.findAll());
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
		sessionMap.put(KEY_OBJ, new SpesaInvestimento());
		return "nuovoModifica";
	}
	
	public String modificaSpesaInvestimento() {
		sessionMap.put(KEY_OBJ, oSpesaInvestimentoService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
		return "nuovoModifica";
	}
	
	public String eliminaSpesaInvestimento() {
		oSpesaInvestimentoService.delete(Integer.parseInt(this.chiave.replace("\'", "")));
		return execute();
	}
	
	public String annulla() {
		return execute();
	}
	
	public String registra() throws ParseException {
		SpesaInvestimento oSpesaInvestimento = (SpesaInvestimento) sessionMap.get(KEY_OBJ);
		oSpesaInvestimento.setSpesaInvestimento(spesaInvestimento);
		oSpesaInvestimento.setOsottocategoria(oSottoCategoriaService.findById(Integer.parseInt(this.chiaveSottoCategoria)));
		oSpesaInvestimentoService.persistOrUpdate(oSpesaInvestimento);
		return execute();
	}
}