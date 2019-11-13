package main.java.controller.Applicazione;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class RicercaOrdineAcquisto extends ActionSupport {
	
	private String scelta;

	/* 			--> HashMap <--
	 * HashMap Per la ricerca dell'Ordine di Acquisto.
	 * utilizzato nella jsp corrispondente con
	 * il metodo radio.
	 */
	
	private HashMap<String, String> map = new HashMap<String, String>() {
		{
			put("RicercaFornitoreRedirect", "Fornitore");
			put("RicercaProgettoRedirect", "Progetto");
			put("RicercaSottoCategoriaRedirect", "SottoCategoria");
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