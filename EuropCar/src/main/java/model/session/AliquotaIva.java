package main.java.model.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HB_AliquotaIva")
public class AliquotaIva {
	
	//Costanti
	public static final String PROPERTY_chiave = "chiave";
	public static final String PROPERTY_aliquota = "aliquota";
	public static final String PROPERTY_descrizione = "descrizione";
	
	//Attributi
	@Column(name="IDAliquotaIva")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int chiave;
	
	@Column(name="Aliquota")
	private int aliquota;
	
	@Column(name="Descrizione")
	private String descrizione;

	//Getters & Setters
	public int getChiave() {
		return chiave;
	}
	public void setChiave(int chiave) {
		this.chiave = chiave;
	}
	public int getAliquota() {
		return aliquota;
	}
	public void setAliquota(int aliquota) {
		this.aliquota = aliquota;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	//Costruttori
	public AliquotaIva() {
		this.inizializza();
	}
	
	public void inizializza() {
		this.chiave=0;
		this.aliquota=0;
		this.descrizione="";
	}
}