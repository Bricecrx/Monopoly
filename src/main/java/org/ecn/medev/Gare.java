package org.ecn.medev;

// As comments the parts of code that still need to be added once the other classes are created

public class Gare extends Achetable {

    public Gare(int nom, int prix,Joueur proprietaire) {
        super(nom, prix, proprietaire);
    }

    public int calculLoyer(){
        return getPrix() ;
    }


    @Override
    public String toString() {
        return "Gare de" + this.getNom() +" (coût :"+this.getPrix()+ ") - " + proprietaire.getNom();
    }
}
