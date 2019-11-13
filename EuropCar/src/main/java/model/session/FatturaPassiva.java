package main.java.model.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="HB_FatturaPassiva")
public class FatturaPassiva {
	
	//Costanti
	public static final String PROPERTY_chiave = "chiave";
	public static final String PROPERTY_data = "data";
	public static final String PROPERTY_numero = "numero";
	public static final String PROPERTY_descrizione = "descrizione";
	public static final String PROPERTY_ofornitore = "ofornitore";
	
	//Attributi
	@Column(name="IDFatturaPassiva")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int chiave;
	
	@Column(name="Data")
	private Date data;
	
	@Column(name="Numero")
	private String numero;
	
	@Column(name="Descrizione")
	private String descrizione;
	
	@ManyToOne
	@JoinColumn(name="IDFornitore")
	private Fornitore ofornitore;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	List<FatturaPassivaDettaglio> listaDettagli = new ArrayList<FatturaPassivaDettaglio>();

	//Getters & Setters
	public int getChiave() {
		return chiave;
	}
	public void setChiave(int chiave) {
		this.chiave = chiave;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Fornitore getOfornitore() {
		return ofornitore;
	}
	public void setOfornitore(Fornitore ofornitore) {
		this.ofornitore = ofornitore;
	}
	public List<FatturaPassivaDettaglio> getListaDettagli() {
		return listaDettagli;
	}
	public void setListaDettagli(List<FatturaPassivaDettaglio> listaDettagli) {
		this.listaDettagli = listaDettagli;
	}
	
	//Costruttori
	public FatturaPassiva() {
		this.inizializza();
	}
	
	public void inizializza() {
		this.chiave=0;
		this.data=null;
		this.descrizione="";
		this.numero="";
		this.ofornitore=null;
	}
}