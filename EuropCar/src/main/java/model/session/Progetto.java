package main.java.model.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HB_Progetto")
public class Progetto {
	
	//Costanti
	public static final String PROPERTY_chiave = "chiave";
	public static final String PROPERTY_codice = "codice";
	public static final String PROPERTY_progetto = "progetto";
	
	//Attributi
	@Column(name="IDProgetto")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int chiave;
	
	@Column(name="Codice")
	private int codice;
	
	@Column(name="Progetto")
	private String progetto;

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
	public String getProgetto() {
		return progetto;
	}
	public void setProgetto(String progetto) {
		this.progetto = progetto;
	}
	
	//Sezione Costruttori
	public Progetto() {
		this.inizializza();
	}
	
	public void inizializza() {
		this.chiave=0;
		this.codice=0;
		this.progetto="";
	}
}