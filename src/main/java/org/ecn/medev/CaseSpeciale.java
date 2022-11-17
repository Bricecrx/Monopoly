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
        this.nom = "Depart";
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
