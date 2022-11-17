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
      this.nom = nom;
   }
    
    /**
     *
     * @return
     */
    @Override
    public String getNom(){
        return(nom);
    }
}
