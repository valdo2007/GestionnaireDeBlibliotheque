package BIBLIO;

public interface Empruntable {
  public void emprunter(Utilisateur utilisateur);
  public void retourner();
  public boolean estDisponible();
}
