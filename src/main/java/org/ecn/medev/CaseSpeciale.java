package org.ecn.medev;

/**
 *
 * @author aulou
 */
public class CaseSpeciale extends Case {
   
    
    // Constructeur par défaut : case départ

    /**
     *
     */
     public CaseSpeciale(){
        super("Depart");
    }
   
   public CaseSpeciale(String nom){
      super(nom);
   }
    
    /**
     *
     * @return
     */
    @Override
    public String getNom(){
        return(nom);
    }

    public void effet(Joueur joueur) {
        
    }
}
