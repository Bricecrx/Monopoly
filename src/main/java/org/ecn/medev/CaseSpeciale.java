package org.ecn.medev;

/**
 * Classe des cases spéciales
 */
public abstract class CaseSpeciale extends Case {


    /**
     * Constructeurs par défaut.
     */
     public CaseSpeciale(){
        super("Depart");
    }
   
     /**
      * Constructeurs pour une case spéciale.
      * @param nom le nom de la case spéciale
      */
    public CaseSpeciale(String nom){
       super(nom);
    }
    
    /**
     * Renvoie le nom de la case.
     * @return le nom
     */
    @Override
    public String getNom(){
        return(nom);
    }

    /**
     * Gère l'effet de la case sur le joueur.
     * @param joueur le joueur affecté
     */
    public void effet(Joueur joueur) {  
    }
}
