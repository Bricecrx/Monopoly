package org.ecn.medev;

/**
 * Classe Gare.
 */
public class Gare extends Achetable {

    /**
     * Constructeurs de Gare.
     * @param nom nom de la gare
     * @param prix prix de la gare
     * @param proprietaire propriétaire de la gare
     */
    public Gare(String nom, int prix,Joueur proprietaire) {
        super(nom, prix, proprietaire);
    }

    /**
     * Constructeurs de Gare.
     * @param nom nom de la gare
     */
    public Gare(String nom){
        super(nom,5000);

    }

    /**
     * Renvoie une chaine de caractères représentant la gare.
     * @return la chaine de caractères.
     */
    @Override
    public String toString() {

        if (proprietaire != null) {
            return "Gare de " + this.getNom() + " (coût :" + this.getPrix() + ") - " + proprietaire.getNom();
        } else {
            return "Gare de" + this.getNom() + " (coût :" + this.getPrix() + ") ";

        }
    }
}
