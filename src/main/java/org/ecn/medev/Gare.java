package org.ecn.medev;

/**
 * Classe Gare extension de Achetable
 */

public class Gare extends Achetable {
     /**
     * Constructeur de la classe Gare que reçoit Nom, Prix et un Jouer
     * @param nom
     * @param prix
     * @param proprietaire
     */

    public Gare(String nom, int prix,Joueur proprietaire) {
        super(nom, prix, proprietaire);
    }

    /**
     * Constructeur simple de la classe Gare que reçoit Nom
     * @param name
     */
    public Gare(String name){
        super(name,500);

    }


    /**
     * Renvoie une chaine de caractères représentant la case Gare.
     * @return une chaine de caractères représentant la case Gare.
     */
    
    @Override
    public String toString() {

        if (proprietaire != null) {
            return "Gare de" + this.getNom() + " (coût :" + this.getPrix() + ") - " + proprietaire.getNom();
        } else {
            return "Gare de" + this.getNom() + " (coût :" + this.getPrix() + ") - ";

        }
    }
}
