package org.ecn.medev;

/**
 *
 * @author aulou
 */
public abstract class CaseSpeciale extends Case {

    /**
     *
     * @param nomCase
     */
    public CaseSpeciale(String nomCase){
        setNom(nomCase);
    }


    public abstract void effet(Joueur joueur);

    /**
     * @return
     */
    @Override
    public String toString(){
        return getNom();
    }
}
