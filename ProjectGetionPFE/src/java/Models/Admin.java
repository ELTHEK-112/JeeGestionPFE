package Models;

public class Admin {
 int ID;
 String Nom;
 
public Admin(int iD, String nom) {
	
	ID = iD;
	Nom = nom;
}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getNom() {
	return Nom;
}
public void setNom(String nom) {
	Nom = nom;
}
 
}

