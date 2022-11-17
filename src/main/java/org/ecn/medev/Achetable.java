package org.ecn.medev;

/**
 * Classe achetable
 */
public abstract class Achetable extends Case{

    public int prix;
    public int loyer;
    public Joueur proprietaire;

    public Achetable(int cost,Joueur J) {
        this.prix = cost;
        this.proprietaire = new Joueur(J) ;
    }

    public void acheter(){

    }

    public int CalculLoyer() {

    }
}
