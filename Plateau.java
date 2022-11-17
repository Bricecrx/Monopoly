/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.projet.objet.medevtp1;

/**
 *
 * @author Meryam
 */
public class Plateau {
    
    public int nbGares(Joueur j){
        
        int n = 0;
        for (int i=1; i<this.cases.size(); i++){
            
            if (this.cases.get(i) instanceof Gare){
                Gare g = (Gare)this.cases.get(i);
                if (g.proprietaire.equals(j)){
                    n = n + 1;
                }
            }
        }
        
        return n;
    }
}
