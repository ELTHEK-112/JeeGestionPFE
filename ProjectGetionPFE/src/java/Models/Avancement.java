package Models;
import java.util.*;

public class Avancement  implements Comparable<Object>{

	 // tpst =  Le_temps_passé_a_la_semain_sur_Task
	// trst = Le_temps_restant_estimé_à_la_semaine_sur_Task;
	Etudiant etudiant;
	Task task;
	private int idAvancement;
	private int tpst;
	private int trst;
	private Date date;
	
	/**
	 * @param etudiant
	 * @param task
	 * @param idAvancement
	 * @param tpst
	 * @param trst
	 * @param date
	 */
	public Avancement(int idAvancement, int tpst,int trst, Date date) {
		
		this.idAvancement = idAvancement;
		this.tpst = tpst;
		this.trst = trst;
		this.date = date;
	}
	public int getIdAvancement() {
		return idAvancement;
	}
	public void setIdAvancement(int idAvancement) {
		this.idAvancement = idAvancement;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	
	public int getTpst() {
		return tpst;
	}
	public void setTpst(int tpst) {
		this.tpst = tpst;
	}
	public int getTrst() {
		return trst;
	}
	public void setTrst(int trst) {
		this.trst = trst;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Avancement [etudiant=" + etudiant + ", task=" + task + ", idAvancement=" + idAvancement + ", tpst="
				+ tpst + ", trst=" + trst + ", date=" + date + "]";
	}
	public int compareTo(Object o) {
		Avancement av = (Avancement) o;
		
		if (av.idAvancement == this.idAvancement) 
			return 0;
		if (av.idAvancement > this.idAvancement)
			return -1;
		else   
			return 1;
			
	}
	
	
}
