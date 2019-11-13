package main.java.model.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="HB_OrdineAcquistoDettaglio")
public class OrdineAcquistoDettaglio {

	//Attributi
	@Column(name="IDOrdineAcquistoDettaglio")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int chiaveDettaglio;
	
	@Column(name="Importo")
	private float importoDettaglio;

	@Column(name="Quantità")
	private int quantitaDettaglio;

	@ManyToOne
	@JoinColumn(name="IDOrdineAcquisto")
	private OrdineAcquisto oordineacquisto;

	@ManyToOne
	@JoinColumn(name="IDSpesaInvestimento")
	private SpesaInvestimento ospesainvestimento;

	@ManyToOne
	@JoinColumn(name="IDProgetto")
	private Progetto oprogetto;

	//Getters & Setters
	public int getChiaveDettaglio() {
		return chiaveDettaglio;
	}
	public void setChiaveDettaglio(int chiaveDettaglio) {
		this.chiaveDettaglio = chiaveDettaglio;
	}
	public OrdineAcquisto getOordineacquisto() {
		return oordineacquisto;
	}
	public void setOordineacquisto(OrdineAcquisto oordineacquisto) {
		this.oordineacquisto = oordineacquisto;
	}
	public SpesaInvestimento getOspesainvestimento() {
		return ospesainvestimento;
	}
	public void setOspesainvestimento(SpesaInvestimento ospesainvestimento) {
		this.ospesainvestimento = ospesainvestimento;
	}
	public Progetto getOprogetto() {
		return oprogetto;
	}
	public void setOprogetto(Progetto oprogetto) {
		this.oprogetto = oprogetto;
	}
	public float getImportoDettaglio() {
		return importoDettaglio;
	}
	public void setImportoDettaglio(float f) {
		this.importoDettaglio = f;
	}
	public int getQuantitaDettaglio() {
		return quantitaDettaglio;
	}
	public void setQuantitaDettaglio(int quantita) {
		this.quantitaDettaglio = quantita;
	}

	//Sezione Costruttori
	
	public OrdineAcquistoDettaglio() {
		this.inizializza();
	}
	
	public OrdineAcquistoDettaglio(OrdineAcquisto oOrdineAcquisto) {
		this.oordineacquisto=getOordineacquisto();
	}

	public void inizializza() {
		this.chiaveDettaglio=0;
		this.oprogetto=null;
		this.ospesainvestimento=null;
		this.oordineacquisto=null;
		this.importoDettaglio=0.0f;
		this.quantitaDettaglio=0;
	}
}