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


    public Achetable(String nom, int prix) {
        super(nom);
        this.prix = prix;
        this.loyer = 0;

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

    /**
     *
     * @param j
     */
    public void Acheter(Joueur j) {
        this.proprietaire = new Joueur(j);
        j.setFortune(j.getFortune() - this.prix);
        
        // On maj le loyer 
        this.calculLoyer();
    }

    /**
    * <h1>CalculLoyer</h1>
    * La méthode MAJ le prix du loyer lors de l'achat ou de la construction
    * <p>
    *
    * @author  Thomas Canal
    * @version 1.0
    * @since   2022-11-17
    */
    public void calculLoyer()
    {
        int loyer = 0;
        int a,b;
        
        a = 500;
        b = 100;
       
        //  est-ce une gare ?
        if(this instanceof Constructible)
        {
            loyer = a * this.loyer *  ((Constructible)this).getNbHotels() + b * this.loyer * ((Constructible)this).getNbMaisons();
        }
        // ou un constructible ?
        else if(this instanceof Gare)
        {
            loyer = 2500 * this.getProprietaire().nbGare();
        }
        
        this.setLoyer(loyer);
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
