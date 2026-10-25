package BIBLIO;
public abstract  class Etudiant extends Utilisateur {
    private String numeroEtudiant;
    private String filiere;
    private final int nbEmprunts = 3;
    
    public Etudiant () {
    	
    }
    
    public Etudiant(String numeroEtudiant,String filiere) {
    	this.numeroEtudiant = numeroEtudiant;
    	this.filiere = filiere;
    }

	public String getNumeroEtudiant() {
		return numeroEtudiant;
	}

	public void setNumeroEtudiant(String numeroEtudiant) {
		this.numeroEtudiant = numeroEtudiant;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public int getNbEmprunts() {
		return nbEmprunts;
	}
	public String getInfos() {
	    return "le numero de etudiant est :" + numeroEtudiant
	            + ", filiere: " + filiere;
	           
	}
	@Override
	public abstract double calculerPenalite();

	@Override
	public String toString() {
		return "Etudiant [numeroEtudiant=" + numeroEtudiant + ", filiere=" + filiere + ", nbEmprunts=" + nbEmprunts
				+ "]";
	}
 
}
