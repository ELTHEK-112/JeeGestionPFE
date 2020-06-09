package Models;

import java.util.*;

public class Jury {

	ArrayList<Professeur> lesprofesseur;
	ArrayList<Soutenance> lessoutenance;
	private int Idjury;
	private String nom,branch;
	public Jury(int Idjury, String nom , String branch) {
		this.branch = branch;
		this.Idjury = Idjury;
		this.nom = nom;
           lesprofesseur = new ArrayList<Professeur>();
           lessoutenance = new ArrayList<Soutenance>();
	}
	
	public int getIdjury() {
		return Idjury;
	}
	

	public ArrayList<Professeur> getLesprofesseur() {
		return lesprofesseur;
	}

	public void setLesprofesseur(ArrayList<Professeur> lesprofesseur) {
		this.lesprofesseur = lesprofesseur;
	}

	public ArrayList<Soutenance> getLessoutenance() {
		return lessoutenance;
	}

	public void setLessoutenance(ArrayList<Soutenance> lessoutenance) {
		this.lessoutenance = lessoutenance;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public void setIdjury(int idjury) {
		Idjury = idjury;
	}

	public ArrayList<Professeur> getProfesseur() {
		return lesprofesseur;
	}
	public void setProfesseur(ArrayList<Professeur> professeur) {
		this.lesprofesseur = professeur;
	}
	public ArrayList<Soutenance> getSoutenance() {
		return lessoutenance;
	}
	public void setSoutenance(ArrayList<Soutenance> soutenance) {
		this.lessoutenance = soutenance;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
}
