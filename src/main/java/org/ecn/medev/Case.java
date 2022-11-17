package org.ecn.medev;

/**
 * Classe décrivant une case du plateau.
 */
public abstract class Case {
    
    /**
     * Nom de la case.
     */
    String nom;
    
    /**
     * Constructeurs pour une case.
     * @param nom le nom de la case.
     */
    public Case(String nom) {
        this.nom = nom;
    }
    
    /**
     * Renvoie le nom de la case.
     * @return le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la case.
     * @param nom le nouveau nom.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Renvoie une chaine de caractères représentant la case.
     * @return 
     */
    @Override
    public String toString() {
        return "Case{ " +
                "nom='" + nom + '\'' +
                '}';
    }
}
