package org.ecn.medev;

/**
 * Classe achetable
 */
public abstract class Achetable extends Case {

    /**
     * Prix de la case.
     */
    protected int prix;
    
    /**
     * Loyer sur la case.
     */
    protected int loyer;
    
    /**
     * Propriétaire de la case.
     */
    protected Joueur proprietaire;

    /**
     * Constructeur pour une case achetable avec propriétaire. Le loyer est mis à 0 par défaut.
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

    /**
     * Constructeur pour une case achetable sans propriétaire. Le loyer est mis à 0 par défaut.
     * @param nom le nom de la case
     * @param prix le prix de la case
     */
    public Achetable(String nom, int prix) {
        super(nom);
        this.prix = prix;
        this.loyer = 0;

    }

    /**
     * Renvoie le prix d'achat de la case.
     * @return le prix
     */
    public int getPrix() {
        return prix;
    }

    /**
     * Renvoie le loyer sur la case.
     * @return le loyer
     */
    public int getLoyer() {
        return loyer;
    }

    /**
     * Renvoie le joueur propriétaire de la case.
     * @return le joueur propriétaire
     */
    public Joueur getProprietaire() {
        return proprietaire;
    }

    /**
     * Définit le prix de la case.
     * @param prix le nouveau prix
     */
    public void setPrix(int prix) {
        this.prix = prix;
    }

    /**
     * Définit le loyer sur la case.
     * @param loyer le nouveau loyer
     */
    public void setLoyer(int loyer) {
        this.loyer = loyer;
    }

    /**
     * Définit le propriétaire de la case.
     * @param proprietaire le propriétaire de la case.
     */
    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    /**
     * Permet au joueur d'acheter la case.
     * @param j le joueur acheteur
     * @throws org.ecn.medev.NoMoreMoney
     */
    public void acheter(Joueur j) throws NoMoreMoney{
        this.setProprietaire(j);
        j.payer(this.prix);
        
        // On maj le loyer 
        this.calculLoyer();
    }

    /**
    * Calcule le loyer sur la case. Le calcul est fait en fonction du type de case et du nombres de maisons et d'hotels.
    * @author  Thomas Canal
    */
    public void calculLoyer() {
        int loyer = 0;
        int a,b;
        
        a = 500;
        b = 100;
       
        //  est-ce une gare ?
        if(this instanceof Constructible) {
            loyer = a * this.prix *  ((Constructible)this).getNbHotels() + b * this.prix * ((Constructible)this).getNbMaisons();
        }
        // ou un constructible ?
        else if(this instanceof Gare) {
            loyer = 2500 * Plateau.instance.nbGares(this.getProprietaire());
        }
        
        this.setLoyer(loyer);
    }
    
    

    /**
     * Renvoie une chaine de caractères représentant la case.
     * @return une chaine de caractères représentant la case.
     */
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
