package BIBLIO;

public class Livre implements Empruntable {
 private int id;
 private String titre;
 private String auteur;
 private String isbn;
 private boolean disponible;
 private static int  nbEmprunts;
 private  int nbExemplaires;
 
 
 private int nbExemplairesDisponibles;
 
 
 
 
 
 public Livre(int nbExemplaires,String titre, int id,String auteur,
		 String isbn,boolean disponible,int nbEmprunts ) {
	 this.titre = titre;
	 this.id = id;
	 this.auteur = auteur;
	 this.disponible = disponible;
	 this.nbEmprunts = nbEmprunts;
	 this.isbn = isbn;
	 this.nbExemplaires = nbExemplaires;
	 
 }
 public Livre(String titre, int id,String auteur,int nbExemplaires ) {
	 this.titre = titre;
	 this.id = id;
	 this.auteur = auteur;
	 this.nbExemplaires = nbExemplaires;
	 
	 
 }
 public Livre(String titre , int nbExemplaires) {
	 this.titre = titre;
	 this.nbExemplaires = nbExemplaires;
 }
 public Livre() {
     this.nbExemplaires = 1;
     
 }
 
 
 
 public int getId() {
	return id;
 }
 public void setId(int id) {
	this.id = id;
 }
 public String getTitre() {
	return titre;
 }
 public void setTitre(String titre) {
	this.titre = titre;
 }
 public String getAuteur() {
	return auteur;
 }
 public void setAuteur(String auteur) {
	this.auteur = auteur;
 }
 public String getIsbn() {
	return isbn;
 }
 public void setIsbn(String isbn) {
	this.isbn = isbn;
 }
 public boolean isDisponible() {
	return disponible;
 }
 public void setDisponible(boolean disponible) {
	this.disponible = disponible;
	 if (!disponible) {
         this.nbExemplairesDisponibles = 0;
     } else if (this.nbExemplairesDisponibles == 0
             && this.nbExemplaires > 0) {
         this.nbExemplairesDisponibles = 1;
     }
 }
 public static int getNbEmprunts() {
	return nbEmprunts;
 }
 public  int getNbExemplaires() {
		return nbExemplaires;
	}
 public void setNbExemplaires(int nbExemplaires) {
		this.nbExemplaires = nbExemplaires;
	}
public  int getNbExemplairesDisponibles() {
	return nbExemplairesDisponibles;
}
      
 
 @Override
 public boolean estDisponible() {
	 if(this.nbExemplairesDisponibles == 0) {
		 this.disponible =false;
	 }
	 else {
		  this.disponible=true;
	 }
	 
	return disponible;
	 
 }
 @Override
 public void emprunter(Utilisateur utilisateur) {
	 if(estDisponible()) {
		 nbExemplairesDisponibles--;
		 nbEmprunts++;
		 disponible = nbExemplairesDisponibles > 0;
		 System.out.println("Le livre: " +getTitre()
		                        +"avec isbn : " +getIsbn()+ " a été empreinter par "
		                        + utilisateur.getNom());
		 
		 
	 }
	 else {
		 
		 System.out.println("Le livre " + titre + " n'est pas disponible.");
	 }
	 
 }
 @Override
 public void retourner() {
	 if (nbExemplairesDisponibles < nbExemplaires) {
         nbExemplairesDisponibles++;
         disponible = true;
         System.out.println("Le livre " + titre
                 + " a été retourné.");
     } else {
         System.out.println(
             "Aucun retour possible pour le livre " + titre + "."
         );
     }
 }
 public String getInfo() {
	 return "ID : " + id
		        + "\nTitre : " + titre
		        + "\nAuteur : " + auteur
		        + "\nISBN : " + isbn
		        + "\nDisponible : " + estDisponible()
		        + "\nNombre d'emprunts : " + nbEmprunts
		        + "\nNombre d'exemplaires : " + nbExemplaires
		        + "\nExemplaires disponibles : " + nbExemplairesDisponibles;
 }
 @Override
 public String toString() {
 	return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", isbn=" + isbn + ", disponible="
 			+ disponible + "]";
 }

 
	

}
