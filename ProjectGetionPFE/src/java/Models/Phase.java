package Models;

import java.util.*;

public class Phase implements Comparable<Object> {

	ProjetFE projetFE;
	Rapport rapport;
	ArrayList<Task> lestask;
	private int idphase;
	private String nom;
	private Date dateStar;
	private Date dateFin;
	
	
	public Phase(int idphase, String nom, Date dateStar,Date dateFin) {
		
		this.idphase = idphase;
		this.nom = nom;
		this.dateStar = dateStar;
		this.dateFin = dateFin;
		lestask = new ArrayList<Task>();
	}
	public int getIdPhase() {
		return idphase;
	}
	public void setPhase(int idphase) {
		this.idphase = idphase;
	}
	public ProjetFE getProjetFE() {
		return projetFE;
	}
	public void setProjetFE(ProjetFE projetFE) {
		this.projetFE = projetFE;
	}
	public Rapport getRapport() {
		return rapport;
	}
	public void setRapport(Rapport rapport) {
		this.rapport = rapport;
	}
	public ArrayList<Task> getLesTask() {
		return lestask;
	}
	public void setLesTask(ArrayList<Task> lestask) {
		this.lestask = lestask;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDateStar() {
		return dateStar;
	}
	public void setDateStar(Date dateStar) {
		this.dateStar = dateStar;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	public int compareTo(Object o) {
		Phase p = (Phase) o;
		if(p.idphase == this.idphase)
		return 0;
		if (p.idphase > this.idphase)
			return -1;
		else 
			return 1;
	}
	
}
