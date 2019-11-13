package main.java.controller.OrdineAcquisto;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import main.java.model.dao.FornitoreService;
import main.java.model.dao.OrdineAcquistoDettaglioService;
import main.java.model.dao.OrdineAcquistoService;
import main.java.model.dao.ProgettoService;
import main.java.model.dao.SpesaInvestimentoService;
import main.java.model.session.Fornitore;
import main.java.model.session.OrdineAcquisto;
import main.java.model.session.OrdineAcquistoDettaglio;
import main.java.model.session.Progetto;
import main.java.model.session.SpesaInvestimento;

@SuppressWarnings("serial")
public class GestioneOrdineAcquisto extends ActionSupport implements SessionAware {

	//Attributi
	public static final String KEY_LIST = "listaOrdiniAcquisto";
	public static final String KEY_OBJ = "oggettoOrdineAcquisto";
	public static final String KEY_LISTAFORNITORI = "listaFornitori";
	private String chiave;
	private String importo;
	private String ordineAcquisto;
	private Date data;
	private String chiaveFornitore;
	private String chiaveOrdineAcquisto;
	private SessionMap<String, Object> sessionMap;
	private List<Fornitore> elencoFornitori;
	OrdineAcquistoService oOrdineAcquistoService = new OrdineAcquistoService();
	FornitoreService oFornitoreService = new FornitoreService();
	
	//Attributi Dettaglio
	public static final String KEY_LISTDETTAGLIO = "listaOrdiniAcquistoDettaglio";
	public static final String KEY_OBJDETTAGLIO = "oggettoOrdineAcquistoDettaglio";
	public static final String KEY_LISTASPESEINVESTIMENTO = "listaSpeseInvestimento";
	public static final String KEY_LISTAPROGETTI= "listaProgetti";
	private String chiaveDettaglio;
	private String importoDettaglio;
	private String quantitaDettaglio;
	private String chiaveSpesaInvestimento;
	private String chiaveProgetto;
	OrdineAcquistoDettaglioService oOrdineAcquistoDettaglioService = new OrdineAcquistoDettaglioService();
	SpesaInvestimentoService oSpesaInvestimentoService = new SpesaInvestimentoService();
	ProgettoService oProgettoService = new ProgettoService();
	private List<SpesaInvestimento> elencoSpeseInvestimento;
	private List<Progetto> elencoProgetti;
	
	//Getters & Setters
	public String getChiave() {
		return chiave;
	}
	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	public String getImporto() {
		return importo;
	}
	public void setImporto(String importo) {
		this.importo = importo;
	}
	public String getOrdineAcquisto() {
		return ordineAcquisto;
	}
	public void setOrdineAcquisto(String ordineAcquisto) {
		this.ordineAcquisto = ordineAcquisto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getChiaveFornitore() {
		return chiaveFornitore;
	}
	public void setChiaveFornitore(String chiaveFornitore) {
		this.chiaveFornitore = chiaveFornitore;
	}
	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	public List<Fornitore> getElencoFornitori() {
		return elencoFornitori;
	}
	public void setElencoFornitori(List<Fornitore> elencoFornitori) {
		this.elencoFornitori = elencoFornitori;
	}
	public String getChiaveDettaglio() {
		return chiaveDettaglio;
	}
	public void setChiaveDettaglio(String chiaveDettaglio) {
		this.chiaveDettaglio = chiaveDettaglio;
	}
	public String getImportoDettaglio() {
		return importoDettaglio;
	}
	public void setImportoDettaglio(String importoDettaglio) {
		this.importoDettaglio = importoDettaglio;
	}
	public String getQuantitaDettaglio() {
		return quantitaDettaglio;
	}
	public void setQuantitaDettaglio(String quantitaDettaglio) {
		this.quantitaDettaglio = quantitaDettaglio;
	}
	public String getChiaveSpesaInvestimento() {
		return chiaveSpesaInvestimento;
	}
	public void setChiaveSpesaInvestimento(String chiaveSpesaInvestimento) {
		this.chiaveSpesaInvestimento = chiaveSpesaInvestimento;
	}
	public String getChiaveProgetto() {
		return chiaveProgetto;
	}
	public void setChiaveProgetto(String chiaveProgetto) {
		this.chiaveProgetto = chiaveProgetto;
	}
	public List<SpesaInvestimento> getElencoSpeseInvestimento() {
		return elencoSpeseInvestimento;
	}
	public void setElencoSpeseInvestimento(List<SpesaInvestimento> elencoSpeseInvestimento) {
		this.elencoSpeseInvestimento = elencoSpeseInvestimento;
	}
	public List<Progetto> getElencoProgetti() {
		return elencoProgetti;
	}
	public void setElencoProgetti(List<Progetto> elencoProgetti) {
		this.elencoProgetti = elencoProgetti;
	}
	public String getChiaveOrdineAcquisto() {
		return chiaveOrdineAcquisto;
	}
	public void setChiaveOrdineAcquisto(String chiaveOrdineAcquisto) {
		this.chiaveOrdineAcquisto = chiaveOrdineAcquisto;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}
	
	//Gestione Ordine Acquisto
	public String execute() {
		sessionMap.put(KEY_LIST, oOrdineAcquistoService.findAll());
		HashMap<String, String> mapFornitore = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un Fornitore");
				elencoFornitori = oFornitoreService.findAll();
				for(int i=0;i<elencoFornitori.size();i++) {
					put(String.valueOf(elencoFornitori.get(i).getChiave()),
							elencoFornitori.get(i).getRagioneSociale());
				}
			}
		};
		sessionMap.put(KEY_LISTAFORNITORI, mapFornitore);
		return "search";
	}
	
	public String cerca() {
		sessionMap.put(KEY_LIST, (oOrdineAcquistoService.elencoOrdiniAcquistoPerFornitore(Integer.parseInt(this.chiaveFornitore.replace("\'", "")))));
		return "search";
	}
	
	public String nuovoOrdineAcquisto() {
		HashMap<String, String> mapFornitore = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un Fornitore");
				elencoFornitori = oFornitoreService.findAll();
				for(int i=0;i<elencoFornitori.size();i++) {
					put(String.valueOf(elencoFornitori.get(i).getChiave()),
							elencoFornitori.get(i).getRagioneSociale());
				}
			}
		};
		sessionMap.put(KEY_LISTAFORNITORI, mapFornitore);
		sessionMap.put(KEY_OBJ, new OrdineAcquisto());
		return "nuovoOrdineAcquisto";
	}
	
	public String modificaOrdineAcquisto() {
		sessionMap.put(KEY_OBJ, oOrdineAcquistoService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
		sessionMap.put(KEY_LISTDETTAGLIO, oOrdineAcquistoDettaglioService.findOrdiniAcquistoDettaglioPerId(Integer.parseInt(this.chiave.replace("\'", ""))));
		return "modificaOrdineAcquisto";
	}
	
	public String eliminaOrdineAcquisto() {
		oOrdineAcquistoService.delete(Integer.parseInt(this.chiave.replace("\'", "")));
		return execute();
	}
	
	public String annulla() {
		return execute();
	}
	
	public String registra() {
		OrdineAcquisto oOrdineAcquisto = ((OrdineAcquisto) sessionMap.get(KEY_OBJ));
		oOrdineAcquisto.setOrdineAcquisto(this.ordineAcquisto);
		oOrdineAcquisto.setImporto(Integer.parseInt((this.importo)));
			oOrdineAcquisto.setData(this.data);
		oOrdineAcquisto.setOfornitore(oFornitoreService.findById(Integer.parseInt(this.chiaveFornitore)));
		oOrdineAcquistoService.persistOrUpdate(oOrdineAcquisto);
		return execute();
	}
	
	//Gestione Dettaglio
	public String nuovoDettaglio() {
		sessionMap.put(KEY_LISTDETTAGLIO, new OrdineAcquistoDettaglio());
		OrdineAcquisto oOrdineAcquisto = ((OrdineAcquisto) sessionMap.get(KEY_OBJ));
		oOrdineAcquisto.setOrdineAcquisto(this.ordineAcquisto);
			oOrdineAcquisto.setData(this.data);
		oOrdineAcquisto.setOfornitore(oFornitoreService.findById(Integer.parseInt(this.chiaveFornitore)));
		HashMap<String, String> mapSpesaInvestimento = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona una Spesa Investimento");
				elencoSpeseInvestimento = oSpesaInvestimentoService.findAll();
				for(int i=0;i<elencoSpeseInvestimento.size();i++) {
					put(String.valueOf(elencoSpeseInvestimento.get(i).getChiave()),
							elencoSpeseInvestimento.get(i).getSpesaInvestimento());
				}
			}
		};
		HashMap<String, String> mapProgetto = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un Progetto");
				elencoProgetti = oProgettoService.findAll();
				for(int i=0;i<elencoProgetti.size();i++) {
					put(String.valueOf(elencoProgetti.get(i).getChiave()),
							elencoProgetti.get(i).getProgetto());
				}
			}
		};
		sessionMap.put(KEY_LISTASPESEINVESTIMENTO, mapSpesaInvestimento);
		sessionMap.put(KEY_LISTAPROGETTI, mapProgetto);
		sessionMap.put(KEY_OBJDETTAGLIO, new OrdineAcquistoDettaglio());
		return "nuovoModificaDettaglio";
	}
	
	public String modificaDettaglio() {
		HashMap<String, String> mapSpesaInvestimento = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona una Spesa Investimento");
				elencoSpeseInvestimento = oSpesaInvestimentoService.findAll();
				for(int i=0;i<elencoSpeseInvestimento.size();i++) {
					put(String.valueOf(elencoSpeseInvestimento.get(i).getChiave()),
							elencoSpeseInvestimento.get(i).getSpesaInvestimento());
				}
			}
		};
		HashMap<String, String> mapProgetto = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un Progetto");
				elencoProgetti = oProgettoService.findAll();
				for(int i=0;i<elencoProgetti.size();i++) {
					put(String.valueOf(elencoProgetti.get(i).getChiave()),
							elencoProgetti.get(i).getProgetto());
				}
			}
		};
		sessionMap.put(KEY_LISTASPESEINVESTIMENTO, mapSpesaInvestimento);
		sessionMap.put(KEY_LISTAPROGETTI, mapProgetto);
		sessionMap.put(KEY_OBJDETTAGLIO, oOrdineAcquistoDettaglioService.findById(Integer.parseInt(this.chiaveDettaglio.replace("\'", ""))));
		return "nuovoModificaDettaglio";
	}
	
	public String eliminaDettaglio() {
		oOrdineAcquistoDettaglioService.delete(Integer.parseInt(chiaveDettaglio.replace("\'", "")));
		return "search";
	}

	public String registraDettaglio() {
		OrdineAcquistoDettaglio oOrdineAcquistoDettaglio = ((OrdineAcquistoDettaglio) sessionMap.get(KEY_OBJDETTAGLIO));
		oOrdineAcquistoDettaglio.setOordineacquisto((OrdineAcquisto) sessionMap.get(KEY_OBJ));
		oOrdineAcquistoDettaglio.setOspesainvestimento(oSpesaInvestimentoService.findById(Integer.parseInt(this.chiaveSpesaInvestimento.replace("\'", ""))));
		oOrdineAcquistoDettaglio.setOprogetto(oProgettoService.findById(Integer.parseInt(this.chiaveProgetto)));
		oOrdineAcquistoDettaglio.setImportoDettaglio(Float.parseFloat(this.importoDettaglio));
		oOrdineAcquistoDettaglio.setQuantitaDettaglio(Integer.parseInt(this.quantitaDettaglio));
		((OrdineAcquisto) sessionMap.get(KEY_OBJ)).getListaDettagli().add(oOrdineAcquistoDettaglio);
		sessionMap.put(KEY_LISTDETTAGLIO, ((OrdineAcquisto) sessionMap.get(KEY_OBJ)).getListaDettagli());
		oOrdineAcquistoDettaglioService.persistOrUpdate(oOrdineAcquistoDettaglio);
		return execute();
	}
}