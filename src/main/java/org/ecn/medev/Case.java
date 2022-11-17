/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.projet.objet.medevtp1;

/**
 *
 * @author Meryam
 */
public class Case {
    
    @override
    public String toString(){
        
        if (this instanceof ParcGratuit){
            String s = "Parc Gratuit : " + this.nom;
            return s
        }
        if (this instanceof Prison){
            String s = "Prison : " + this.nom;
            return s
        }
        if (this instanceof Police){
            String s = "Police : " + this.nom;
            return s
        }
        if (this instanceof Chance){
            String s = "C'est une case de chance : " + this.nom;
            return s
        }
        if (this instanceof Gare){
            String s = "Gare : " + this.nom;
            Gare g = (Gare)this;
            s = s + ", coût : " + g.prix;
            if (g.proprietaire.equals(null)){
                s = s + " , sans propiétaire ";
            }
            else{
                s = s + " , propriétaire : " + g.proprietaire.nom
            }
            
            s = s + " , loyer = " + g.loyer " €";
            
            return s
        }
        if (this instanceof Constructible){
                
            String s = this.nom;
            Constructible c = (Constructible)this;
            s = s + ", coût : " + c.prix;
            if (g.proprietaire.equals(null)){
                s = s + " , sans propiétaire ";
            }
            else{
                s = s + " , propriétaire : " + c.proprietaire.nom;
            }
            if (c.nbMaison !=null){
                s = s + " , " + c.nbMaison + " maison ";
            }
            
            s = s + " , loyer = " + c.loyer " €";
            
    }
        
        
    }
}
