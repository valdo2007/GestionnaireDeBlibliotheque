package BIBLIO;

import java.util.*;
import java.io.*;

public class Bibliotheque {
	private String nom;
	private String adresse;
	private List<Livre> livres = new ArrayList<>();
	private List<Utilisateur> utilisateurs = new ArrayList<>();
	private List<Emprunt> emprunts = new ArrayList<>();
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public List<Livre> getLivres() {
		return livres;
	}
	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	public List<Utilisateur> getUtilisateur() {
		return utilisateurs;
	}
	public void setUtilisateur(List<Utilisateur> utilisateur) {
		this.utilisateurs = utilisateur;
	}
	public List<Emprunt> getEmprunts() {
		return emprunts;
	}
	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	
	
   public void ajouterLivre(Livre livre) {
	   livres.add(livre);
   }
   public void retirerLivre(int id) {
	   for (Livre livre : livres) {
		   if(livre.getId() == id){
			   livres.remove(livre);
			   
		   }
	   }
   }
   public void inscrireUtilisateur(Utilisateur utilisateur) {
	   utilisateurs.add(utilisateur);
   }
   public List<Livre> rechercherLivre(String titre){
	List<Livre> resultats = new ArrayList<>();
	for (Livre livre : livres) {
		if (livre.getTitre().equalsIgnoreCase(titre)) {
			resultats.add(livre);
		}
	}
	return resultats;   
   }
   public void sauvegarder(String fichier) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier))) {
	        for (Livre livre : livres) {
	            writer.write(livre.getTitre());
	            writer.newLine();
	        }
	    } catch (IOException e) {
	        System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
	    }
	}
   public void charger(String fichier) {
	   try(BufferedReader reader = 
			   new BufferedReader(new FileReader(fichier) ) ){
		   String ligne;
		   
		   while( (ligne =reader.readLine()) != null) {
			   Livre livre = new Livre();
			   livre.setTitre(ligne);
			   livres.add(livre);
		   }
	   }
	   catch(IOException e){
		   System.out.println("Eurreur de chargement :" + e.getMessage());
	   }
   }
   public void afficherLivres() {
	    for (Livre livre : livres) {
	        System.out.println(livre);
	    }
	}
   @Override
   public String toString() {
	return "Bibliotheque [nom=" + nom + ", adresse=" + adresse + ", livres=" + livres + ", utilisateurs=" + utilisateurs
			+ ", emprunts=" + emprunts + "]";
   }
   
   
   
   
	
}
