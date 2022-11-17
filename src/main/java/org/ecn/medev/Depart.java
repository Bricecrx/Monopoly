package org.ecn.medev;

/**
 * Classe de la case Départ.
 */
public class Depart extends CaseSpeciale {

    /**
     * Constructeur de la case spéciale Départ.
     */
    public Depart() {
        super("Depart");
    }

    /**
     * Réalise l'effet de la case Départ sur le joueur.
     * @param joueur le joueur affecté.
     */
    @Override
    public void effet(Joueur joueur) {
    }
}
