package BIBLIO;
public abstract  class Professeur extends Utilisateur {
    private String grade;
    private final int nbEmprunts = 5;
	private String departement;
    
    public Professeur () {
    	this.grade = "vacataire";
    	this.departement = "";
    	
    }
    public Professeur(String grade,String departement) {
    	this.grade = grade;
    	this.departement = departement;
    }

	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDepartemet() {
		return departement;
	}
	public void setDepartemet(String departement) {
		this.departement = departement;
	}
	
	
	public String getInfos() {
	    String departement = null;
		return "le grade du proffesseur est  :" + grade
	            + ", departement: " + departement;
	           
	}
	@Override
	public abstract double calculerPenalite();
	@Override
	public String toString() {
		return "Professeur [grade=" + grade + ", nbEmprunts=" + nbEmprunts + ", departement=" + departement + "]";
	}

	
 
}
