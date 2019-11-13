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
@Table(name="HB_SottoCategoria")
public class SottoCategoria {
	
	//Costanti
	public static final String PROPERTY_ciave = "chiave";
	public static final String PROPERTY_codice = "codice";
	public static final String PROPERTY_sottoCategoria = "sottoCategoria";
	public static final String PROPERTY_budget = "budget";
	public static final String PROPERTY_budgetSpeso = "budgetSpeso";
	public static final String PROPERTY_oarea = "oarea";
	
	//Attributi
	@Column(name="IDSottoCategoria")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int chiave;
	
	@Column(name="Codice")
	private int codice;
	
	@Column(name="sottoCategoria")
	private String sottoCategoria;
	
	@Column(name="Budget")
	private float budget;
	
	@Column(name="BudgetSpeso")
	private float budgetSpeso;
	
	@ManyToOne
	@JoinColumn(name="IDArea")
	private Area oarea;

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
	public String getSottoCategoria() {
		return sottoCategoria;
	}
	public void setSottoCategoria(String sottoCategoria) {
		this.sottoCategoria = sottoCategoria;
	}
	public float getBudget() {
		return budget;
	}
	public void setBudget(float budget) {
		this.budget = budget;
	}
	public float getBudgetSpeso() {
		return budgetSpeso;
	}
	public void setBudgetSpeso(float budgetSpeso) {
		this.budgetSpeso = budgetSpeso;
	}
	public Area getOarea() {
		return oarea;
	}
	public void setOarea(Area oarea) {
		this.oarea = oarea;
	}

	//Sezione Costruttori
	public SottoCategoria() {
		this.inizializza();
	}
	
	public void inizializza() {
		this.chiave=0;
		this.budget=0;
		this.budgetSpeso=0;
		this.codice=0;
		this.sottoCategoria="";
		this.oarea=null;
	}
}