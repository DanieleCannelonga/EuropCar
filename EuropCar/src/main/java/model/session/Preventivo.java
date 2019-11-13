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
@Table(name="HB_Preventivo")
public class Preventivo {
	
	//Costanti
	public static final String PROPERTY_chiave = "chiave";
	public static final String PROPERTY_codice = "codice";
	public static final String PROPERTY_preventivo = "preventivo";
	public static final String PROPERTY_ofornitore = "ofornitore";
	
	//Attributi
	@Column(name="IDPreventivo")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int chiave;
	
	@Column(name="Codice")
	private int codice;
	
	@Column(name="Preventivo")
	private String preventivo;
	
	@ManyToOne
	@JoinColumn(name="IDFornitore")
	private Fornitore ofornitore;
	
	//Getters & Setters
	public int getChiave() {
		return chiave;
	}
	public void setChiave(int chiave) {
		this.chiave = chiave;
	}
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public String getPreventivo() {
		return preventivo;
	}
	public void setPreventivo(String preventivo) {
		this.preventivo = preventivo;
	}
	public Fornitore getOfornitore() {
		return ofornitore;
	}
	public void setOfornitore(Fornitore ofornitore) {
		this.ofornitore = ofornitore;
	}

	//Sezione Costruttori
	public Preventivo() {
		this.inizializza();
	}
	
	public void inizializza() {
		this.chiave=0;
		this.codice=0;
		this.preventivo="";
		this.ofornitore=null;
	}
}