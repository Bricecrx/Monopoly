package org.ecn.medev;

/**
 * Classe achetable
 */
public abstract class Achetable extends Case {

    public int prix;
    public int loyer;
    public Joueur proprietaire;

    /**
     * 
     * @param prix
     * @param loyer
     * @param propietaire 
     */
    public Achetable(int prix, int loyer, Joueur propietaire) {
        this.prix = prix;
        this.loyer = loyer;
        this.proprietaire = proprietaire;
    }

    public void acheter() {
    }

    public int calculLoyer(Joueur j) {
    }
}
