package Models;

import java.util.*;

public class Professeur implements Comparable<Object>{

	Jury jury;
	ArrayList<ProjetFE> projetFE;
	private int IDProfesseur;
	private String nom;
	private String prenom;
	private String branch;
	private String cin;
	public Professeur(int IDProfesseur, String nom, String prenom, String branch, String cin) {
		this.IDProfesseur = IDProfesseur;
		this.nom = nom;
		this.prenom = prenom;
		this.branch = branch;
		this.cin = cin;
		projetFE = new ArrayList<ProjetFE>();
	}
	
	public Professeur() {
		// TODO Auto-generated constructor stub
	}

	public int getIDProfesseur() {
		return IDProfesseur;
	}

	public void setIDProfesseur(int iDProfesseur) {
		IDProfesseur = iDProfesseur;
	}

	public Jury getJury() {
		return jury;
	}
	public void setJury(Jury jury) {
		this.jury = jury;
	}
	public ArrayList<ProjetFE> getProjetFE() {
		return projetFE;
	}
	public void setProjetFE(ArrayList<ProjetFE> projetFE) {
		this.projetFE = projetFE;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}

	
	public int compareTo(Object o) {
		  Professeur p = (Professeur) o;
		  if(p.IDProfesseur == this.IDProfesseur)
		return 0;
		  if (p.IDProfesseur> this.IDProfesseur)
			  return -1;
		  else 
			  return 1; 
	}
}
