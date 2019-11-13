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
@Table(name="HB_OrdineAcquisto")
public class OrdineAcquisto {
	
	//Costanti
	public static final String PROPERTY_chiave = "chiave";
	public static final String PROPERTY_importo = "importo";
	public static final String PROPERTY_ordineAcquisto = "ordineAcquisto";
	public static final String PROPERTY_data = "data";
	public static final String PROPERTY_ofornitore = "ofornitore";
	
	//Attributi
	@Column(name="IDOrdineAcquisto")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int chiave;

	@Column(name="Importo")
	private int importo;
	
	@Column(name="OrdineAcquisto")
	private String ordineAcquisto;
	
	@Column(name="Data")
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="IDFornitore")
	private Fornitore ofornitore;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	List<OrdineAcquistoDettaglio> listaDettagli = new ArrayList<OrdineAcquistoDettaglio>();
	
	//Gestters & Setters
	public int getChiave() {
		return chiave;
	}
	public void setChiave(int chiave) {
		this.chiave = chiave;
	}
	public int getImporto() {
		return importo;
	}
	public void setImporto(int importo) {
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
	public Fornitore getOfornitore() {
		return ofornitore;
	}
	public void setOfornitore(Fornitore ofornitore) {
		this.ofornitore = ofornitore;
	}
	public List<OrdineAcquistoDettaglio> getListaDettagli() {
		return listaDettagli;
	}
	public void setListaDettagli(List<OrdineAcquistoDettaglio> listaDettagli) {
		this.listaDettagli = listaDettagli;
	}

	//Sezione Costruttori
	public OrdineAcquisto() {
		this.inizializza();
	}
	
	public void inizializza() {
		this.chiave=0;
		this.data=null;
		this.importo=0;
		this.ofornitore=null;
	}
}