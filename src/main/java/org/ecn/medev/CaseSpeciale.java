package edu.ecn.medev;

/**
 *
 * @author aulou
 */
public class CaseSpeciale extends Case {
    // Nom de la case
    private String nom;
    
    
    /**
     *
     * @param nomCase
     */
    public CaseSpeciale(String nomCase){
        nom = nomCase;
    }
    
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
    public String GetNom(){
        return(nom);
    }

    /**
     *
     */
    @Override
    public void toString(){
        System.out.println(nom);
    }
}
