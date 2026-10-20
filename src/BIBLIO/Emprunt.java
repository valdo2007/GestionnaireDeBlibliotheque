package BIBLIO;




import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprunt {

    private int id;
    private LocalDate dateEmprunt;
    private LocalDate dateRetourPrevue;
    private LocalDate dateRetour;
    private Livre livre;
    private Utilisateur utilisateur;

    public Emprunt() {
        this.livre = null;
        this.utilisateur = null;
        this.dateEmprunt = null;
        this.dateRetourPrevue = null;
        this.dateRetour = null;
    }

    public Emprunt(Livre livre, Utilisateur utilisateur,
                   LocalDate dateEmprunt,
                   LocalDate dateRetourPrevue) {
        this.livre = livre;
        this.utilisateur = utilisateur;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevue = dateRetourPrevue;
        this.dateRetour = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDate getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    public void setDateRetourPrevue(LocalDate dateRetourPrevue) {
        this.dateRetourPrevue = dateRetourPrevue;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void retournerEmprunt() {
        if (dateRetour != null) {
            System.out.println("Cet emprunt a déjà été retourné.");
            return;
        }

        if (livre == null) {
            System.out.println("Aucun livre n'est associé à cet emprunt.");
            return;
        }

        dateRetour = LocalDate.now();
        livre.retourner();
    }

    public double calculerPenalite() {
        if (dateRetourPrevue == null) {
            return 0.0;
        }

        LocalDate dateVerification =
                (dateRetour == null) ? LocalDate.now() : dateRetour;

        if (dateVerification.isAfter(dateRetourPrevue)) {
            long joursRetard = ChronoUnit.DAYS.between(
                    dateRetourPrevue, dateVerification
            );

            return joursRetard * 0.50;
        }

        return 0.0;
    }

    public boolean estEnRetard() {
        if (dateRetourPrevue == null) {
            return false;
        }

        LocalDate dateVerification =
                (dateRetour == null) ? LocalDate.now() : dateRetour;

        return dateVerification.isAfter(dateRetourPrevue);
    }

    public String getInfos() {
        String titreLivre = (livre != null)
                ? livre.getTitre() : "Aucun livre";

        String nomUtilisateur = (utilisateur != null)
                ? utilisateur.getNom() : "Aucun utilisateur";

        return "ID : " + id
                + "\nLivre : " + titreLivre
                + "\nUtilisateur : " + nomUtilisateur
                + "\nDate d'emprunt : " + dateEmprunt
                + "\nDate de retour prévue : " + dateRetourPrevue
                + "\nDate de retour effective : "
                + (dateRetour == null
                    ? "Pas encore retourné" : dateRetour)
                + "\nEn retard : " + estEnRetard()
                + "\nPénalité : " + calculerPenalite() + " €";
    }

    @Override
    public String toString() {
        return "Emprunt [id =" + id
                + ", dateEmprunt=" + dateEmprunt
                + ", dateRetourPrevue=" + dateRetourPrevue
                + ", dateRetour=" + dateRetour
                + ", livre=" + livre
                + ", utilisateur=" + utilisateur
                + "]";
    }
}
