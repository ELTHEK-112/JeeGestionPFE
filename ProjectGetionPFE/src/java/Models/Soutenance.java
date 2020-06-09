package Models;

import java.util.*;

public class Soutenance implements Comparable<Object> {

	Jury Jury;
	Rapport rapport;
	private int idSoutenance;
	private double note;
	private Date date;
	public Soutenance(int idSoutenance,  double note, Date date) {
		this.idSoutenance = idSoutenance;
		this.note = note;
		this.date = date;
	}
	
	public int getIdSoutenance() {
		return idSoutenance;
	}

	public void setIdSoutenance(int idSoutenance) {
		this.idSoutenance = idSoutenance;
	}

	public Jury getJury() {
		return Jury;
	}
	public void setJury(Jury jury) {
		Jury = jury;
	}
	public Rapport getRapport() {
		return rapport;
	}
	public void setRapport(Rapport rapport) {
		this.rapport = rapport;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int compareTo(Object o) {
		Soutenance r = (Soutenance) o;
		
		 if( r.idSoutenance == this.idSoutenance)
		return 0;
		 if (r.idSoutenance > this.idSoutenance)
			 return -1;
		 else 
			 return 1;
	}
}
