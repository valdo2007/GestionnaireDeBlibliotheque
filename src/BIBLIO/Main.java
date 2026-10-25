package BIBLIO;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {

		// --- Bibliothèque ---
		Bibliotheque biblio = new Bibliotheque();
		biblio.setNom("Bibliothèque centrale");
		biblio.setAdresse("1 rue des Livres");

		// --- Livres ---
		Livre l1 = new Livre("Java pour débutants", 1, "Gosling", 2);
		Livre l2 = new Livre(1, "Python avancé", 2, "Guido", "ISBN-123", true, 0);
		Livre l3 = new Livre("Algorithmique", 3, "Knuth", 1);
		biblio.ajouterLivre(l1);
		biblio.ajouterLivre(l2);
		biblio.ajouterLivre(l3);

		// --- Utilisateurs ---
		Etudiant etu = new Etudiant("E001", "Informatique");
		etu.setId(1);
		etu.setNom("Dupont");
		etu.setPrenom("Ali");

		Professeur prof = new Professeur("Titulaire", "Mathématiques");
		prof.setId(2);
		prof.setNom("Martin");
		prof.setPrenom("Sophie");

		biblio.inscrireUtilisateur(etu);
		biblio.inscrireUtilisateur(prof);

		System.out.println("===== LIVRES =====");
		biblio.afficherLivres();

		System.out.println("\n===== UTILISATEURS =====");
		System.out.println(etu.getInfos());
		System.out.println(prof.getInfos());

		// --- Test 1 : emprunt normal ---
		System.out.println("\n===== TEST 1 : emprunt =====");
		l1.emprunter(etu);
		Emprunt e1 = new Emprunt(l1, etu, LocalDate.now(), LocalDate.now().plusDays(14));
		e1.setId(1);
		etu.ajouterEmprunt(e1);
		biblio.getEmprunts().add(e1);
		System.out.println("Exemplaires dispo de " + l1.getTitre() + " : " + l1.getNbExemplairesDisponibles());
		System.out.println("Emprunts actuels de " + etu.getNom() + " : " + etu.getNbEmpruntsActuals());

		// --- Test 2 : livre indisponible ---
		System.out.println("\n===== TEST 2 : livre indisponible =====");
		l2.emprunter(prof);
		l2.emprunter(etu); // plus d'exemplaire
		System.out.println("l2 disponible ? " + l2.estDisponible());

		// --- Test 3 : emprunt en retard + pénalité ---
		System.out.println("\n===== TEST 3 : retard et pénalité =====");
		l3.emprunter(etu);
		Emprunt e2 = new Emprunt(l3, etu, LocalDate.now().minusDays(20), LocalDate.now().minusDays(10));
		e2.setId(2);
		etu.ajouterEmprunt(e2);
		biblio.getEmprunts().add(e2);
		System.out.println(e2.getInfos());
		System.out.println("Pénalité (5 €/10j attendue) : " + e2.calculerPenalite() + " €");

		// --- Test 4 : retour ---
		System.out.println("\n===== TEST 4 : retour =====");
		e2.retournerEmprunt();
		e2.retournerEmprunt(); // déjà retourné
		System.out.println("Emprunts actuels de " + etu.getNom() + " : " + etu.getNbEmpruntsActuals());
		System.out.println("l3 disponible ? " + l3.estDisponible());

		// --- Test 5 : recherche ---
		System.out.println("\n===== TEST 5 : recherche =====");
		System.out.println("Recherche 'java' : " + biblio.rechercherLivre("java"));
		System.out.println("Recherche 'xyz'  : " + biblio.rechercherLivre("xyz"));

		// --- Test 6 : sauvegarde / chargement ---
		System.out.println("\n===== TEST 6 : sauvegarde / chargement =====");
		biblio.sauvegarder("livres.txt");
		biblio.charger("livres.txt");
		biblio.afficherLivres();

		// --- Test 7 : suppression ---
		System.out.println("\n===== TEST 7 : suppression =====");
		biblio.retirerLivre(2);
		System.out.println("Nombre de livres après suppression : " + biblio.getLivres().size());
	}
}