package main.java.controller.Archivio;

import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import main.java.model.dao.AreaService;
import main.java.model.session.Area;

@SuppressWarnings("serial")
public class GestioneArea extends ActionSupport implements SessionAware {
	
	//Attributi
    public static final String KEY_LIST = "listaAree";
    public static final String KEY_OBJ = "oggettoArea";
    private SessionMap<String, Object> sessionMap;
    private String chiave;
    private String codice;
    private String area;
	AreaService oAreaService = new AreaService();
	
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
    public void setSession(Map<String, Object> arg0)
    {
    	this.sessionMap = (SessionMap<String, Object>) arg0;
    }

	//Metodi
	public String execute() {
		sessionMap.put(KEY_LIST, oAreaService.findAll());
		return "search";
	}
    
    public String nuovaArea() {
    	sessionMap.put(KEY_OBJ, new Area());
    	return "nuovoModifica";
    }
	
	public String modificaArea() {
    	sessionMap.put(KEY_OBJ, oAreaService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
		return "nuovoModifica";
    }
    
    public String eliminaArea() {
    	oAreaService.delete(Integer.parseInt(this.chiave.replace("\'", "")));
		return execute();
    }
    
    public String annulla() {
    	return execute();
    }
    
    public String registra() throws Exception {
    	Area oArea = (Area) sessionMap.get(KEY_OBJ);
    	oArea.setCodice(Integer.parseInt(codice));
    	oArea.setArea(area);
    	oAreaService.persistOrUpdate(oArea);
    	return execute();
    }
}