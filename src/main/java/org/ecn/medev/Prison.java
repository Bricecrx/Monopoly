package org.ecn.medev;

/**
 * Classe Prison.
 */
public class Prison extends CaseSpeciale{

    /**
     * Constructeur par defaut
     */
    public Prison() {
        super("Prison");
    }

    /**
     * Ajoutt une contrainte sur le mouvement d'un joueur
     * @param joueur le joueur qui doit aller en prison
     */
    @Override
    public void effet(Joueur joueur) {

    }
}
