package main.java.controller.Budget;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import main.java.model.dao.AreaService;
import main.java.model.dao.SottoCategoriaService;
import main.java.model.session.Area;

@SuppressWarnings("serial")
public class GestioneAvanzamento extends ActionSupport implements SessionAware {

	//Attributi
	public static final String KEY_LISTAAREE = "listaAree";
	public static final String KEY_LISTASOTTOCATEGORIE = "listaSottoCategorie";
	private String chiave;
	private String chiaveArea;
	private SessionMap<String, Object> sessionMap;
	private List<Area> elencoAree;
	private float avanzamento;
	AreaService oAreaService = new AreaService();
	SottoCategoriaService oSottoCategoriaService = new SottoCategoriaService();
	
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
	public List<Area> getElencoAree() {
		return elencoAree;
	}
	public void setElencoAree(List<Area> elencoAree) {
		this.elencoAree = elencoAree;
	}
	public String getChiaveArea() {
		return chiaveArea;
	}
	public void setChiaveArea(String chiaveArea) {
		this.chiaveArea = chiaveArea;
	}
	public float getAvanzamento() {
		return avanzamento;
	}
	public void setAvanzamento(float avanzamento) {
		this.avanzamento = avanzamento;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}
	
	//Gestione Avanzamento
	public String execute() {
		HashMap<String, String> mapArea = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un' Area");
				elencoAree = oAreaService.findAll();
				for(int i=0;i<elencoAree.size();i++) {
					put(String.valueOf(elencoAree.get(i).getChiave()),
							elencoAree.get(i).getArea());
				}
			}
		};
		sessionMap.put(KEY_LISTAAREE, mapArea);
		return "search";
	}
	
	public String cerca() {
		sessionMap.put(KEY_LISTASOTTOCATEGORIE, (oSottoCategoriaService.elencoSottoCategoriePerArea(Integer.parseInt(this.chiaveArea.replace("\'", "")))));
		return "RicercaAvanzamento";
	}
}