package main.java.model.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HB_Fornitore")
public class Fornitore {
	
	//Costanti
	public static final String PROPERTY_chiave = "chiave";
	public static final String PROPERTY_ragioneSociale = "ragioneSociale";
	public static final String PROPERTY_indirizzo = "indirizzo";
	public static final String PROPERTY_citta = "citta";
	public static final String PROPERTY_cap = "cap";
	public static final String PROPERTY_provincia = "provincia";
	public static final String PROPERTY_partitaIva = "partitaIva";
	
	//Attributi
	@Column(name="IDFornitore")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int chiave;
	
	@Column(name="RagioneSociale")
	private String ragioneSociale;
	
	@Column(name="Indirizzo")
	private String indirizzo;
	
	@Column(name="Citta")
	private String citta;
	
	@Column(name="Cap")
	private String cap;
	
	@Column(name="Provincia")
	private String provincia;
	
	@Column(name="PartitaIva")
	private String partitaIva;

	//Getters & Setters
	public int getChiave() {
		return chiave;
	}
	public void setChiave(int chiave) {
		this.chiave = chiave;
	}
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	
	//Sezione Costruttori
	public Fornitore() {
		this.inizializza();
	}
	
	public void inizializza() {
		this.chiave=0;
		this.cap="";
		this.citta="";
		this.indirizzo="";
		this.partitaIva="";
		this.provincia="";
		this.ragioneSociale="";
	}
}