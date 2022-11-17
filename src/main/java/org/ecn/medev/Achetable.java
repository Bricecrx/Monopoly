package org.ecn.medev;

/**
 * Classe achetable
 */
public abstract class Achetable extends Case {

    /**
     * Prix de la case.
     */
    private int prix;
    
    /**
     * Loyer sur la case.
     */
    private int loyer;
    
    /**
     * Propriétaire de la case.
     */
    private Joueur proprietaire;

    /**
     * Constructeur pour une case achetable
     * @param nom nom de la case
     * @param prix le prix de la case
     * @param proprietaire le proprietaire de la case
     */
    public Achetable(String nom, int prix, Joueur proprietaire) {
        super(nom);
        this.prix = prix;
        this.loyer = 0;
        this.proprietaire = proprietaire;
    }

    public int getPrix() {
        return prix;
    }

    public int getLoyer() {
        return loyer;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setLoyer(int loyer) {
        this.loyer = loyer;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }
    
   
    public void acheter() {
    }

    public int calculLoyer(Joueur j) {
        return 0;
    }

    @Override
    public String toString() {
        String achetableString = getNom() + "(cout : " + getPrix() + " )";
        if (getProprietaire() == null) {
            return achetableString + " - Sans proprietaire";
        } else {
            return achetableString + " - Proprietaire : " + getProprietaire() + ", loyer: " + getLoyer();
        }
    }

}
