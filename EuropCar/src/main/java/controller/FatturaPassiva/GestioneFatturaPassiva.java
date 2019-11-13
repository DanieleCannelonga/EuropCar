package main.java.controller.FatturaPassiva;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import main.java.model.dao.AliquotaIvaService;
import main.java.model.dao.FatturaPassivaDettaglioService;
import main.java.model.dao.FatturaPassivaService;
import main.java.model.dao.FornitoreService;
import main.java.model.dao.PreventivoService;
import main.java.model.dao.SpesaInvestimentoService;
import main.java.model.session.AliquotaIva;
import main.java.model.session.FatturaPassiva;
import main.java.model.session.FatturaPassivaDettaglio;
import main.java.model.session.Fornitore;
import main.java.model.session.Preventivo;
import main.java.model.session.SpesaInvestimento;

@SuppressWarnings("serial")
public class GestioneFatturaPassiva extends ActionSupport implements SessionAware {

	//Attributi
	public static final String KEY_LIST = "listaFatturePassive";
	public static final String KEY_OBJ = "oggettoFatturaPassiva";
	public static final String KEY_LISTAFORNITORI = "listaFornitori";
	private String chiave;
	private Date data;
	private String descrizione;
	private String numero;
	private String chiaveFornitore;
	public String chiaveFatturaPassiva;
	private SessionMap<String, Object> sessionMap;
	private List<Fornitore> elencoFornitori;
	FatturaPassivaService oFatturaPassivaService = new FatturaPassivaService();
	FornitoreService oFornitoreService = new FornitoreService();
	
	//Attributi Dettaglio
	public static final String KEY_LISTDETTAGLIO = "listaFatturePassiveDettaglio";
	public static final String KEY_OBJDETTAGLIO = "oggettoFatturaPassivaDettaglio";
	public static final String KEY_LISTAALIQUOTEIVA = "listaAliquoteIva";
	public static final String KEY_LISTAPREVENTIVI = "listaPreventivi";
	public static final String KEY_LISTASPESEINVESTIMENTO = "listaSpeseInvestimento";
	private String chiaveDettaglio;
	private String dettaglioFattura;
	private String importo;
	private String chiaveAliquotaIva;
	private String chiavePreventivo;
	private String chiaveSpesaInvestimento;

	FatturaPassivaDettaglioService oFatturaPassivaDettaglioService = new FatturaPassivaDettaglioService();
	SpesaInvestimentoService oSpesaInvestimentoService = new SpesaInvestimentoService();
	AliquotaIvaService oAliquotaIvaService = new AliquotaIvaService();
	PreventivoService oPreventivoService = new PreventivoService();
	private List<SpesaInvestimento> elencoSpeseInvestimento;
	private List<AliquotaIva> elencoAliquoteIva;
	private List<Preventivo> elencoPreventivi;
	
	
	//Getters & Setters
	public String getChiave() {
		return chiave;
	}
	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
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
	public String getDettaglioFattura() {
		return dettaglioFattura;
	}
	public void setDettaglioFattura(String dettaglioFattura) {
		this.dettaglioFattura = dettaglioFattura;
	}
	public String getImporto() {
		return importo;
	}
	public void setImporto(String importo) {
		this.importo = importo;
	}
	public String getChiaveAliquotaIva() {
		return chiaveAliquotaIva;
	}
	public void setChiaveAliquotaIva(String chiaveAliquotaIva) {
		this.chiaveAliquotaIva = chiaveAliquotaIva;
	}
	public String getChiavePreventivo() {
		return chiavePreventivo;
	}
	public void setChiavePreventivo(String chiavePreventivo) {
		this.chiavePreventivo = chiavePreventivo;
	}
	public String getChiaveSpesaInvestimento() {
		return chiaveSpesaInvestimento;
	}
	public void setChiaveSpesaInvestimento(String chiaveSpesaInvestimento) {
		this.chiaveSpesaInvestimento = chiaveSpesaInvestimento;
	}
	public List<SpesaInvestimento> getElencoSpeseInvestimento() {
		return elencoSpeseInvestimento;
	}
	public void setElencoSpeseInvestimento(List<SpesaInvestimento> elencoSpeseInvestimento) {
		this.elencoSpeseInvestimento = elencoSpeseInvestimento;
	}
	public List<AliquotaIva> getElencoAliquoteIva() {
		return elencoAliquoteIva;
	}
	public void setElencoAliquoteIva(List<AliquotaIva> elencoAliquoteIva) {
		this.elencoAliquoteIva = elencoAliquoteIva;
	}
	public List<Preventivo> getElencoPreventivi() {
		return elencoPreventivi;
	}
	public void setElencoPreventivi(List<Preventivo> elencoPreventivi) {
		this.elencoPreventivi = elencoPreventivi;
	}
	public String getChiaveDettaglio() {
		return chiaveDettaglio;
	}
	public void setChiaveDettaglio(String chiaveDettaglio) {
		this.chiaveDettaglio = chiaveDettaglio;
	}
	public String getChiaveFatturaPassiva() {
		return chiaveFatturaPassiva;
	}
	public void setChiaveFatturaPassiva(String chiaveFatturaPassiva) {
		this.chiaveFatturaPassiva = chiaveFatturaPassiva;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String, Object>) arg0;
	}
	
	//Gestione Fattura Passiva
	public String execute() {
		sessionMap.put(KEY_LIST, oFatturaPassivaService.findAll());
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
		sessionMap.put(KEY_LIST, (oFatturaPassivaService.elencoFatturePassivePerFornitore(Integer.parseInt(this.chiaveFornitore.replace("\'", "")))));
		return "search";
	}
	public String nuovaFatturaPassiva() {
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
		sessionMap.put(KEY_OBJ, new FatturaPassiva());
		return "nuovaFatturaPassiva";
	}
	
	public String modificaFatturaPassiva() {
		sessionMap.put(KEY_OBJ, oFatturaPassivaService.findById(Integer.parseInt(this.chiave.replace("\'", ""))));
		sessionMap.put(KEY_LISTDETTAGLIO, oFatturaPassivaDettaglioService.findFatturaPassivaDettaglioPerId(Integer.parseInt(this.chiave.replace("\'", ""))));
		return "modificaFatturaPassiva";
	}
	
	public String eliminaFatturaPassiva() {
		oFatturaPassivaService.delete(Integer.parseInt(this.chiave.replace("\'", "")));
		return execute();
	}
	
	public String annulla() {
		return execute();
	}
	
	public String registra() {
		FatturaPassiva oFatturaPassiva = ((FatturaPassiva) sessionMap.get(KEY_OBJ));
		oFatturaPassiva.setDescrizione(this.descrizione);
		oFatturaPassiva.setNumero(this.numero);
		oFatturaPassiva.setData(this.data);
		oFatturaPassiva.setOfornitore(oFornitoreService.findById(Integer.parseInt(this.chiaveFornitore.replace("\'", ""))));
		oFatturaPassivaService.persistOrUpdate(oFatturaPassiva);
		return execute();
	}
	
	//Gestione Dettaglio
	public String nuovoDettaglio() {
		sessionMap.put(KEY_LISTDETTAGLIO, new FatturaPassivaDettaglio());
		FatturaPassiva oFatturaPassiva = ((FatturaPassiva) sessionMap.get(KEY_OBJ));
			oFatturaPassiva.setData(data);
		oFatturaPassiva.setNumero(this.numero);
		oFatturaPassiva.setDescrizione(this.descrizione);
		oFatturaPassiva.setOfornitore(oFornitoreService.findById(Integer.parseInt(this.chiaveFornitore)));
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
		HashMap<String, String> mapPreventivo = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un Preventivo");
				elencoPreventivi = oPreventivoService.findAll();
				for(int i=0;i<elencoPreventivi.size();i++) {
					put(String.valueOf(elencoPreventivi.get(i).getChiave()),
							elencoPreventivi.get(i).getPreventivo());
				}
			}
		};
		sessionMap.put(KEY_LISTASPESEINVESTIMENTO, mapSpesaInvestimento);
		sessionMap.put(KEY_LISTAPREVENTIVI, mapPreventivo);
		sessionMap.put(KEY_OBJDETTAGLIO, new FatturaPassivaDettaglio());
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
		HashMap<String, String> mapPreventivo = new HashMap<String, String>() {
			{
				put(String.valueOf(0), "Seleziona un Preventivo");
				elencoPreventivi = oPreventivoService.findAll();
				for(int i=0;i<elencoPreventivi.size();i++) {
					put(String.valueOf(elencoPreventivi.get(i).getChiave()),
							elencoPreventivi.get(i).getPreventivo());
				}
			}
		};
		sessionMap.put(KEY_LISTASPESEINVESTIMENTO, mapSpesaInvestimento);
		sessionMap.put(KEY_LISTAPREVENTIVI, mapPreventivo);
		sessionMap.put(KEY_OBJDETTAGLIO, oFatturaPassivaDettaglioService.findById(Integer.parseInt(this.chiaveDettaglio.replace("\'", ""))));
		return "nuovoModificaDettaglio";
	}
	
	public String eliminaDettaglio() {
		oFatturaPassivaDettaglioService.delete(Integer.parseInt(this.chiaveDettaglio.replace("\'", "")));
		return "modificaFatturaPassiva";
	}
	
	public String registraDettaglio() {
		FatturaPassivaDettaglio oFatturaPassivaDettaglio = ((FatturaPassivaDettaglio) sessionMap.get(KEY_OBJDETTAGLIO));
		oFatturaPassivaDettaglio.setOfatturapassiva((FatturaPassiva) sessionMap.get(KEY_OBJ));
		oFatturaPassivaDettaglio.setDettaglioFatturaDettaglio(this.dettaglioFattura);
		oFatturaPassivaDettaglio.setImportoDettaglio(Integer.parseInt(this.importo));
		oFatturaPassivaDettaglio.setOpreventivo(oPreventivoService.findById(Integer.parseInt(this.chiavePreventivo.replace("\'", ""))));
		oFatturaPassivaDettaglio.setOspesainvestimento(oSpesaInvestimentoService.findById(Integer.parseInt(this.chiaveSpesaInvestimento.replace("\'", ""))));
		((FatturaPassiva) sessionMap.get(KEY_OBJ)).getListaDettagli().add(oFatturaPassivaDettaglio);
		sessionMap.put(KEY_LISTDETTAGLIO, ((FatturaPassiva) sessionMap.get(KEY_OBJ)).getListaDettagli());
		oFatturaPassivaDettaglioService.persistOrUpdate(oFatturaPassivaDettaglio);
		return execute();
	}
}