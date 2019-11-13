package main.java.controller.Archivio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

import main.java.model.dao.AreaService;
import main.java.model.dao.SottoCategoriaService;
import main.java.model.session.Area;
import main.java.model.session.SottoCategoria;

@SuppressWarnings("serial")
public class GestioneSottoCategoria extends ActionSupport implements SessionAware {

	// Attributi
	public static final String KEY_LIST = "listaSottoCategorie";
	public static final String KEY_OBJ = "oggettoSottoCategoria";
	public static final String KEY_LISTAAREE = "listaAree";
	private String chiave;
	private String codice;
	private String sottoCategoria;
	private String budget;
	private String budgetSpeso;
	private String chiaveArea;
	private SessionMap<String, Object> sessionMap;
	private List<Area> elencoAree;

	SottoCategoriaService oSottoCategoriaService = new SottoCategoriaService();
	AreaService oAreaService = new AreaService();

	//Getters & Setters
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
	public String getSottoCategoria() {
		return sottoCategoria;
	}
	public void setSottoCategoria(String sottoCategoria) {
		this.sottoCategoria = sottoCategoria;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getBudgetSpeso() {
		return budgetSpeso;
	}
	public void setBudgetSpeso(String budgetSpeso) {
		this.budgetSpeso = budgetSpeso;
	}
	public String getChiaveArea() {
		return chiaveArea;
	}
	public void setChiaveArea(String chiaveArea) {
		this.chiaveArea = chiaveArea;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}

	//Metodi
	public String execute() {
		HashMap<String, String> mapArea = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un'Area");
				elencoAree = oAreaService.findAll();
				for (int i = 0; i < elencoAree.size(); i++) {
					put(String.valueOf(elencoAree.get(i).getChiave()),
							elencoAree.get(i).getArea());
				}
			}
		};
		sessionMap.put(KEY_LISTAAREE, mapArea);
		sessionMap.put(KEY_LIST, oSottoCategoriaService.findAll());
		return "search";
	}

	public String nuovaSottoCategoria() {
		sessionMap.put(KEY_OBJ, new SottoCategoria());
		return "nuovoModifica";
	}

	public String modificaSottoCategoria() {
		sessionMap.put(KEY_OBJ, oSottoCategoriaService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
		return "nuovoModifica";
	}

	public String eliminaSottoCategoria() {
		oSottoCategoriaService.delete(Integer.parseInt(this.chiave.replace("\'", "")));
		return execute();
	}

	public String annulla() {
		return execute();
	}

	public String registra() throws Exception {
		SottoCategoria oSottoCategoria = (SottoCategoria) sessionMap.get(KEY_OBJ);
		oSottoCategoria.setBudget(Float.parseFloat(this.budget));
		oSottoCategoria.setBudgetSpeso(Float.parseFloat(this.budgetSpeso));
		oSottoCategoria.setCodice(Integer.parseInt(codice));
		oSottoCategoria.setOarea(oAreaService.findById(Integer.parseInt(this.chiaveArea)));
		oSottoCategoria.setSottoCategoria(sottoCategoria);
		oSottoCategoriaService.persistOrUpdate(oSottoCategoria);
		return execute();
	}
}