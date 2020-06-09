package Models;

import java.util.*;

public class Task implements Comparable<Object> {

	Phase phase;
	ArrayList<Problems> problems;
	ArrayList<Avancement> avancement;
	private int idTask;
	private String nom;
	private Date dateStar;
	private Date dateFin;
	public Task( int idTask,  String nom, Date dateStar, Date dateFin) {
		this.idTask = idTask;
		this.problems = new ArrayList<Problems>();
		this.avancement = new ArrayList<Avancement>();
		this.nom = nom;
		this.dateStar = dateStar;
		this.dateFin = dateFin;
	}
	
	public int getIdTask() {
		return idTask;
	}

	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}

	public Phase getPhase() {
		return phase;
	}
	public void setPhase(Phase phase) {
		this.phase = phase;
	}
	public ArrayList<Problems> getProblems() {
		return problems;
	}
	public void setProblems(ArrayList<Problems> problems) {
		this.problems = problems;
	}
	public ArrayList<Avancement> getAvancement() {
		return avancement;
	}
	public void setAvancement(ArrayList<Avancement> avancement) {
		this.avancement = avancement;
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
		Task r = (Task) o;
		
		 if( r.idTask == this.idTask)
		return 0;
		 if (r.idTask > this.idTask)
			 return -1;
		 else 
			 return 1;
	}
	
}
