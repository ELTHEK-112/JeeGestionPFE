package Models;

import java.util.*;

public class Etudiant implements Comparable<Object>{

	ProjetFE projetFE;
	ArrayList<Avancement> lesAvancements;
	private int IdEtudiant;
	private String nom;
	private String prenom;
	private String Branch;
	private String cne;
	
	public Etudiant(int IdEtudiant, String nom,String prenom, String branch, String cne) {
	    this.IdEtudiant =  IdEtudiant;
		lesAvancements = new ArrayList<Avancement>();
		this.nom = nom;
		this.prenom = prenom;
		Branch = branch;
		this.cne = cne;
	}
	
	public int getIdEtudiant() {
		return IdEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		IdEtudiant = idEtudiant;
	}

	public ProjetFE getProjetFE() {
		return projetFE;
	}
	public void setProjetFE(ProjetFE projetFE) {
		this.projetFE = projetFE;
	}
	public ArrayList<Avancement> getAvancement() {
		return lesAvancements;
	}
	public void setAvancement(ArrayList<Avancement> avancement) {
		lesAvancements = avancement;
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
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}

	
	public int compareTo(Object o) {
		     Etudiant e = (Etudiant) o;
		     if (e.IdEtudiant == this.IdEtudiant)
		    return 0;
		     if (e.IdEtudiant > this.IdEtudiant)
		    	 return -1;
		     else 
		    	 return 1;
	}
	
	public boolean addAvancement(Avancement a) {
		return lesAvancements.add(a);
	}
	public Avancement delAvancement(int index) {
		if (index <= 0 && index > lesAvancements.size()) {
			index --;
			return lesAvancements.remove(index);
		}
		return null;
	}
	public int serchAvancement(Avancement v) {
		 
		for (int i = 0 ; i<lesAvancements.size();i++){
			
			if (lesAvancements.get(i).compareTo((Object) v) == 0)
				
				return lesAvancements.indexOf(lesAvancements.get(i)) + 1;
				
		}
		  return 0;
			
		}
	}

	
