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
@Table(name="HB_SpesaInvestimento")
public class SpesaInvestimento {
	
	//Costanti
	public static final String PROPERTY_chiave = "chiave";
	public static final String PROPERTY_spesaInvestimento = "spesaInvestimento";
	public static final String PROPERTY_osottocategoria = "osottocategoria";
	
	//Attributi
	@Column(name="IDSpesaInvestimento")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int chiave;
	
	@Column(name="SpesaInvestimento")
	private String spesaInvestimento;
	
	@ManyToOne
	@JoinColumn(name="IDSottoCategoria")
	private SottoCategoria osottocategoria;

	//Getters & Setters
	public int getChiave() {
		return chiave;
	}
	public void setChiave(int chiave) {
		this.chiave = chiave;
	}
	public String getSpesaInvestimento() {
		return spesaInvestimento;
	}
	public void setSpesaInvestimento(String spesaInvestimento) {
		this.spesaInvestimento = spesaInvestimento;
	}
	public SottoCategoria getOsottocategoria() {
		return osottocategoria;
	}
	public void setOsottocategoria(SottoCategoria osottocategoria) {
		this.osottocategoria = osottocategoria;
	}
	
	//Sezione Costruttori
	public SpesaInvestimento() {
		this.inizializza();
	}
	
	public void inizializza() {
		this.chiave=0;
		this.spesaInvestimento="";
		this.osottocategoria=null;
	}
}