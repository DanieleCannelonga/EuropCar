package main.java.controller.Applicazione;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GestioneFatturaPassiva extends ActionSupport {
	
	private String scelta;

	/* 			--> HashMap <--
	 * HashMap Per la gestione della Fattura Passiva.
	 * utilizzato nella jsp corrispondente con
	 * il metodo radio.
	 */
	
	private HashMap<String, String> map = new HashMap<String, String>() {
		{
			put("GestioneFatturaPassivaRedirect", "Gestione");
			put("RicercaRedirect", "Ricerca");
			put("StatisticaRedirect", "Statistica");
		}
	};
	
	public String execute() throws Exception {
		String result=INPUT;
		
		if(StringUtils.isNotBlank(scelta)) {
			result = scelta;
			scelta = null;
		}
		return result;
	}

	//Getters & Setters
	public HashMap<String, String> getMap() {
		return map;
	}

	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}

	public String getScelta() {
		return scelta;
	}

	public void setScelta(String scelta) {
		this.scelta = scelta;
	}
}