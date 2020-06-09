package Models;
import java.util.*;

public class Rapport implements Comparable<Object>{

	ProjetFE projetFE;
	Soutenance soutenans;
	private int idRapport;
	private Date Date;
   public Rapport(int idRapport) {
		this.idRapport = idRapport;
	
		Date = new Date();
		}
	public Rapport(int idRapport, Date date) {
	this.idRapport = idRapport;
	Date = date;
	}
	
	public int getIdRapport() {
		return idRapport;
	}

	public void setIdRapport(int idRapport) {
		this.idRapport = idRapport;
	}

	public ProjetFE getProjetFE() {
		return projetFE;
	}
	public void setProjetFE(ProjetFE projetFE) {
		this.projetFE = projetFE;
	}
	public Soutenance getSoutenans() {
		return soutenans;
	}
	public void setSoutenans(Soutenance soutenans) {
		this.soutenans = soutenans;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}

	public int compareTo(Object o) {
		Rapport r = (Rapport) o;
		
		 if( r.idRapport == this.idRapport)
		return 0;
		 if (r.idRapport > this.idRapport)
			 return -1;
		 else 
			 return 1;
	}
	
	
}
