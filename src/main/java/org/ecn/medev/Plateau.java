/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.ecn.medev;

import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Le plateau de jeu.
 * @author eugene
 */

public class Plateau {
    /** L'instance du plateau de jeu. */
    public static Plateau instance;
    
    /** Le nombre de cases du plateau. */
    private static final int NB_CASES = 40;
    /** Le nombre de joueurs. */
    private static final int NB_JOUEURS = 6;
    /** Les cases du plateau. */
    private ArrayList<Case> cases;
    /** Les joueurs. */
    private LinkedList<Joueur> joueurs;
    
    /** Constructeur du plateau. */
    Plateau() {
        instance = this;
    }
    
    /** Initialisation des joueurs et des cases du plateau. */
    public void init() {
        // Initialisation des joueurs
        for (int i = 0; i < NB_JOUEURS; i++) {
            Joueur j = new Joueur("Joueur " + i);
            joueurs.add(j);
        }
        
        // Initialisation des cases
        cases = new ArrayList(NB_CASES);
        int numRue = 0;
        for (int i = 0; i < NB_CASES; i++) {
            numRue++;
            switch (i) {
                case 0:
                    cases.set(i, new CaseSpeciale("Depart"));
                    break;
                case 10:
                    cases.set(i, new CaseSpeciale("Prison"));
                    break;
                case 20:
                    cases.set(i, new CaseSpeciale("Parc Gratuit"));
                    break;
                case 30:
                    cases.set(i, new CaseSpeciale("Allez en Prison !"));
                    break;
                case 1: case 3: case 6: case 8: case 9: case 11: case 13: case 14: case 16: case 18: case 19:
                case 21: case 23: case 24: case 26: case 27: case 29: case 31: case 32: case 34: case 37: case 39:
                    cases.set(i, new Constructible("Rue n°" + numRue));
                    break;
                case 2: case 17: case 33:
                    cases.set(i, new CaseSpeciale("Caisse Communautaire"));
                    break;
                case 7: case 22: case 36:
                    cases.set(i, new CaseSpeciale("Chance"));
                    break;
                case 4: case 38:
                    cases.set(i, new CaseSpeciale("Taxes"));
                    break;
                case 5: case 15: case 25: case 35:
                    cases.set(i, new Gare("Gare n°" + (i + 5)/10));
                    break;
                case 12: case 28:
                    cases.set(i, new CaseSpeciale("Companie"));
                    break;
                default:
                    cases.set(i, new CaseSpeciale("Oups"));
                    break;
            }
        }
    }
    
    /** 
     * Affichage des cases du plateau.
     * @return Renvoie vrai si la partie est finie.
    */
    public boolean finDePartie() {
        int nbJoueur = joueurs.size();
        boolean partieFinie = nbJoueur <= 1;
        return partieFinie;
    }    
    
    /** Affichage des cases du plateau. */
    public void affiche() {
        for (Case c : cases) {
            c.toString();
        }
    }
    
    /**
     *
     * @author Meryam
     */
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
