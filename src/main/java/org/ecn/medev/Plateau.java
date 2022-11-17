/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.ecn.medev;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

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

    //Indique si la partie est en cours
    public boolean partieEnCours = true;
    
    /** Constructeur du plateau. */
    public Plateau() {
        instance = this;
        init();
        //this.cases=new ArrayList<>();
    }
    
    /** Initialisation des joueurs et des cases du plateau. */
    public void init() {
        // Initialisation des joueurs
        this.joueurs = new LinkedList<>();
        for (int i = 0; i < NB_JOUEURS; i++) {
            Joueur j = new Joueur("Joueur " + i, 100000, 0);
            joueurs.add(j);
        }
        
        // Initialisation des cases
        cases = new ArrayList<>(NB_CASES);
        int numRue = 0;
        for (int i = 0; i < NB_CASES; i++) {
            numRue++;
            switch (i) {
                case 0:
                    cases.add( new CaseSpeciale("Depart"));
                    break;
                case 10:
                    cases.add( new CaseSpeciale("Prison"));
                    break;
                case 20:
                    cases.add(new CaseSpeciale("Parc Gratuit"));
                    break;
                case 30:
                    cases.add( new GoToPrison());
                    break;
                case 1: case 3: case 6: case 8: case 9: case 11: case 13: case 14: case 16: case 18: case 19:
                case 21: case 23: case 24: case 26: case 27: case 29: case 31: case 32: case 34: case 37: case 39:
                    cases.add( new Constructible("Rue n°" + numRue));
                    break;
                case 2: case 17: case 33:
                    cases.add( new CaseSpeciale("Caisse Communautaire"));
                    break;
                case 7: case 22: case 36:
                    cases.add( new CaseSpeciale("Chance"));
                    break;
                case 4: case 38:
                    cases.add( new CaseSpeciale("Taxes"));
                    break;
                case 5: case 15: case 25: case 35:
                    cases.add( new Gare("Gare n°" + (i + 5)/10));
                    break;
                case 12: case 28:
                    cases.add( new CaseSpeciale("Companie"));
                    break;
                default:
                    cases.add( new CaseSpeciale("Oups"));
                    break;
            }
        }
    }
    
        /** Fait un tour de jeu pour chaque joueur. */
    public void tourDeJeu() {
        Scanner scan = new Scanner(System.in);
        
        for (int i = 0; i < NB_JOUEURS; i++) {
            // Deplacement.
            Joueur j = joueurs.get(i);
            System.out.println("\n C'est le tour de " + j.getNom());
            int lance = j.lanceLeDe();
            System.out.println("Il avance de " + lance);
            j.avancer(lance);
            Case caseArrivee = cases.get(j.getPosition());
            System.out.println("Et arrive en :" + caseArrivee +" ");
            if (caseArrivee instanceof Achetable) {
                Achetable caseAchetable = (Achetable) caseArrivee;
                // Achat d'une case.
                if (caseAchetable.getProprietaire() == null) {
                    System.out.println(j.getNom() + ", voulez-vous acheter la case " + j.getPosition() + " ? (O/N)");
                    if (scan.next().equals("O")) {
                        try {
                            j.payer(caseAchetable.getPrix());
                            caseAchetable.acheter(j);
                        } catch (NoMoreMoney nmm) {
                            System.out.println(j.getNom() + " n'a plus un sou ! Il est elimine ...");
                            joueurs.remove(i);
                        }
                    }
                }
                // Paiement du loyer.
                else {
                    Joueur proprio = caseAchetable.getProprietaire();
                    if (joueurs.contains(proprio) && !proprio.getNom().equals(j.getNom())) {
                        try {
                            j.payer(caseAchetable.getLoyer(), proprio);
                        } catch (NoMoreMoney nmm) {
                            System.out.println(j.getNom() + " n'a plus un sou ! Il est elimine ...");
                            joueurs.remove(i);
                        }
                    }
                }
            }
            else {
                // Traitement du cas des cases speciales.
            }
            // On verifie que le joueur n'a pas fait faillite.
            if (joueurs.contains(j)) {
                // Construction de maisons et d'hotels.
                System.out.println(j.getNom() + ", voulez-vous construire sur une de vos proprietes ? (O/N)");
                if (scan.next().equals("O")) {
                    LinkedList<Constructible> proprietes = new LinkedList();
                    for (Case c : cases) {
                        if (c instanceof Constructible) {
                            Constructible constr = (Constructible) c;
                            if (constr.getProprietaire() == j) {
                                proprietes.add(constr);
                            }
                        } 
                    }
                    if (proprietes.isEmpty()) {
                        System.out.println("Vous n'avez pas de proprietes ...");
                    }
                    else {
                        System.out.println("Choisissez le lieu de la construction (numero) parmi :");
                        for (int l = 0; l < proprietes.size(); l++) {
                            System.out.println((l + 1) + ": " + proprietes.get(l).getNom());
                        }
                        int choix = Integer.parseInt(scan.next()) - 1;
                        if (choix < proprietes.size()) {
                            Constructible prop = proprietes.get(choix);
                            System.out.println("Combien de maisons voulez-vous construire ?");
                            int nbMaisons = Integer.parseInt(scan.next());
                            System.out.println("Combien d'hotels voulez-vous construire ?");
                            int nbHotels = Integer.parseInt(scan.next());
                            if (nbMaisons < 0 || nbHotels < 0) {
                                System.out.println("Nombre incorrect !");
                            }
                            else if (nbMaisons != 0 || nbHotels != 0) {
                                try {
                                    prop.construire(nbMaisons, nbHotels);
                                    j.payer(1000 * nbMaisons + 4000 * nbHotels);
                                } catch (NoMoreMoney nmm) {
                                    System.out.println(j.getNom() + " n'a plus un sou ! Il est elimine ...");
                                    joueurs.remove(i);
                                }
                            }
                        }
                    }
                }
            }
        }

        finDePartie();
    }
    
    /** 
     * Indicateur de fin de partie.
     * Set la variable partieEnCours sur False si la partie est terminée
    */
    public void finDePartie() {
        int nbJoueur = joueurs.size();
        partieEnCours = !(nbJoueur <= 1);
    }    
    
    /** Affichage des cases du plateau. */
    public void affiche() {
        for (Case c : cases) {
            System.out.println(c.toString());

            

        }

        System.out.println("");
            System.out.println("---------------------------------");
            System.out.println("Liste des joueurs: ");
            for (Joueur j : joueurs) {
                System.out.println(j.toString());
            }
    }
    
    /**
     * @author Meryam
     * Renvoie le nombre de gares.
     * @return Le nombre de gares.
     */
    public int nbGares(Joueur j){
        
        int n = 0;
        for (int i=1; i<this.cases.size(); i++){
            
            if (this.cases.get(i) instanceof Gare){
                Gare g = (Gare)this.cases.get(i);
                if(g.proprietaire!=null){
                    if (g.proprietaire.equals(j)){
                        n = n + 1;
                    }
                }

            }
        }
        
        return n;
    }
}
