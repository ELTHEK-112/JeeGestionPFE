package Models;

import java.util.*;



public class ProjetFE implements Comparable<Object> {

	Professeur professeur;
	ArrayList<Etudiant> lesetudiant;
	ArrayList<Rapport> lesrapport;
	ArrayList<Phase> lesphase;
	private int idProjetFE;
	private String nom;
	private String description;
	private Date date_de_livraison_du_projet;

	public ProjetFE(int idProjetFE, String nom, String description, Date date_de_livraison_du_projet) {
		this.idProjetFE = idProjetFE;

		this.nom = nom;
		this.description = description;
		this.date_de_livraison_du_projet = date_de_livraison_du_projet;

		this.professeur = new Professeur();
		this.lesetudiant = new ArrayList<Etudiant>();
		this.lesrapport = new ArrayList<Rapport>();
		this.lesphase = new ArrayList<Phase>();
	}

	public int getIdProjetFE() {
		return idProjetFE;
	}

	public void setIdProjetFE(int idProjetFE) {
		this.idProjetFE = idProjetFE;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public ArrayList<Etudiant> getEtudiant() {
		return lesetudiant;
	}

	public void setEtudiant(ArrayList<Etudiant> etudiant) {
		this.lesetudiant = etudiant;
	}

	public ArrayList<Rapport> getRapport() {
		return lesrapport;
	}

	public void setRapport(ArrayList<Rapport> rapport) {
		this.lesrapport = rapport;
	}

	public ArrayList<Phase> getPhase() {
		return lesphase;
	}

	public void setPhase(ArrayList<Phase> phase) {
		this.lesphase = phase;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_de_livraison_du_projet() {
		return date_de_livraison_du_projet;
	}

	public void setDate_de_livraison_du_projet(Date date_de_livraison_du_projet) {
		this.date_de_livraison_du_projet = date_de_livraison_du_projet;
	}

	

	public boolean addPhase(Phase p) {
		return lesphase.add(p);
	}

	public boolean addEtudiant(Etudiant e) {
		return lesetudiant.add(e);
	}

	public boolean addrapport(Rapport r) {
		return lesrapport.add(r);
	}

	public Rapport delRapport(int index) {

		if (index <= 0 && index > lesrapport.size())
			return lesrapport.remove(index);

		return null;
	}


	public Phase delphase(int index) {

		if (index <= 0 && index > lesrapport.size())
			return lesphase.remove(index);

		return null;
	}

	public Etudiant delREtudiant(int index) {

		if (index <= 0 && index > lesrapport.size())
			return lesetudiant.remove(index);

		return null;
	}

	
	public int compareTo(Object o) {
		ProjetFE p = (ProjetFE) o;
		if (p.idProjetFE == this.idProjetFE)
		return 0;
		if(p.idProjetFE > this.idProjetFE)
			return -1;
		else
		return 0;
	}
}
