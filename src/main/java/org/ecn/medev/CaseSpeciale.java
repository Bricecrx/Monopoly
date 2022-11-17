package org.ecn.medev;

/**
 * Classe CaseSpeciale
 */
public class CaseSpeciale extends Case {
   
    /**
     * Constructeur par défaut : case départ
     */
   public CaseSpeciale(){
        super("Depart");
   }
   
   /**
     * Constructeur avec un nom specifique
     * @param nom nom de la case
     */
   
   public CaseSpeciale(String nom){
      super(nom);
   }
    
    /**
     * Renvoie une chaine de caractères représentant la case.
     * @return une chaine de caractères représentant la case.
     */
    @Override
    public String getNom(){
        return(nom);
    }
   
   /**
     * Definie les possibles effets de cette case a chaque Jouer
     * @param joueur le jouer qu'a le tour de jeu
     */

    public void effet(Joueur joueur) {
        
    }
}
