package BIBLIO;

public abstract class Utilisateur {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private int nbEmpruntsActuals;
	
     public Utilisateur (){
    	this.nbEmpruntsActuals = 0;
    	this.email = "contactentreprise@gmail.com";
     }
     public Utilisateur(int id, String nom,String prenom, String email,int nbEmpruntsActuals) {
    	 this.id = id;
    	 this.nom = nom;
    	 this.prenom = prenom;
    	 this.nbEmpruntsActuals = nbEmpruntsActuals;
     }
	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNbEmpruntsActuals() {
		return nbEmpruntsActuals;
	}
	public void setNbEmpruntsActuals(int nbEmpruntsActuals) {
		this.nbEmpruntsActuals = nbEmpruntsActuals;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public void ajouterEmprunt(Emprunt emprunt) {
	    nbEmpruntsActuals++;
	}

	public void retirerEmprunt() {
	    if (nbEmpruntsActuals > 0) {
	        nbEmpruntsActuals--;
	    }
	}
	public String getInfos() {
	    return "ID : " + id
	            + ", Nom : " + nom
	            + ", Prénom : " + prenom
	            + ", Email : " + email
	            + ", Nombre d'emprunts actuels : " + nbEmpruntsActuals;
	}
	public abstract void calculerPenalite();
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", nbEmpruntsActuals=" + nbEmpruntsActuals + "]";
	}

	

}
