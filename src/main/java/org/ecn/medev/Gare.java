package org.ecn.medev;

// As comments the parts of code that still need to be added once the other classes are created

public class Gare extends Achetable {

    public Gare(String nom, int prix,Joueur proprietaire) {
        super(nom, prix, proprietaire);
    }


    public Gare(String name){
        super(name,500);

    }


    @Override
    public String toString() {
        if (proprietaire.getNom() != null) {
            return "Gare de" + this.getNom() + " (coût :" + this.getPrix() + ") - " + proprietaire.getNom();
        } else {
            return "Gare de" + this.getNom() + " (coût :" + this.getPrix() + ") - ";
        }
    }
}
