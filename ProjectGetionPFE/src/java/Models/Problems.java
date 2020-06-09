package Models;
import java.util.*;


public class Problems implements Comparable<Object>{

	Task task;
	private int idProblems;
	private String description;
	private Date date;
	
	public Problems(int idProblems, String description, Date date) {
		this.idProblems = idProblems;
		this.description = description;
		this.date = date;
	}
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public int getIdProblems() {
		return idProblems;
	}

	public void setIdProblems(int idProblems) {
		this.idProblems = idProblems;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}


	public int compareTo(Object o) {
	     Problems p = (Problems) o;
	     if (p.idProblems == this.idProblems)
	    		 return 0;
	     if (p.idProblems  > this.idProblems)
	    	 return -1;
	     else 
	    	 return 1;
	}
	
}
