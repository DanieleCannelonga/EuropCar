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
@Table(name="HB_FatturaPassivaDettaglio")
public class FatturaPassivaDettaglio {

	//Attributi
	@Column(name="IDDettaglioFattura")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int chiaveDettaglio;

	@ManyToOne
	@JoinColumn(name="IDAliquotaIva")
	private AliquotaIva oaliquotaiva;

	@ManyToOne
	@JoinColumn(name="IDPreventivo")
	private Preventivo opreventivo;

	@ManyToOne
	@JoinColumn(name="IDFatturaPassiva")
	private FatturaPassiva ofatturapassiva;

	@ManyToOne
	@JoinColumn(name="IDSpesaInvestimento")
	private SpesaInvestimento ospesainvestimento;

	@Column(name="DettaglioFattura")
	private String dettaglioFatturaDettaglio;

	@Column(name="Importo")
	private float importoDettaglio;

	//Getters & Setters
	public int getChiaveDettaglio() {
		return chiaveDettaglio;
	}
	public void setChiaveDettaglio(int chiaveDettaglio) {
		this.chiaveDettaglio = chiaveDettaglio;
	}
	public AliquotaIva getOaliquotaiva() {
		return oaliquotaiva;
	}
	public void setOaliquotaiva(AliquotaIva oaliquotaiva) {
		this.oaliquotaiva = oaliquotaiva;
	}
	public Preventivo getOpreventivo() {
		return opreventivo;
	}
	public void setOpreventivo(Preventivo preventivo) {
		this.opreventivo = preventivo;
	}
	public FatturaPassiva getOfatturapassiva() {
		return ofatturapassiva;
	}
	public void setOfatturapassiva(FatturaPassiva ofatturapassiva) {
		this.ofatturapassiva = ofatturapassiva;
	}
	public SpesaInvestimento getOspesainvestimento() {
		return ospesainvestimento;
	}
	public void setOspesainvestimento(SpesaInvestimento spesaInvestimento) {
		this.ospesainvestimento = spesaInvestimento;
	}
	public String getDettaglioFatturaDettaglio() {
		return dettaglioFatturaDettaglio;
	}
	public void setDettaglioFatturaDettaglio(String dettaglioFatturaDettaglio) {
		this.dettaglioFatturaDettaglio = dettaglioFatturaDettaglio;
	}
	public float getImportoDettaglio() {
		return importoDettaglio;
	}
	public void setImportoDettaglio(float f) {
		this.importoDettaglio = f;
	}

	//Costruttori
	public FatturaPassivaDettaglio() {
		this.inizializza();
	}

	public void inizializza() {
		this.chiaveDettaglio=0;
		this.importoDettaglio=0;
		this.dettaglioFatturaDettaglio="";
		this.oaliquotaiva=null;
		this.opreventivo=null;
		this.ospesainvestimento=null;
		this.ofatturapassiva=null;
	}
}