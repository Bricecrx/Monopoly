/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ecn.medev;

/**
 * Classe constructible
 * @author Pierre Baudet
 */
public class Constructible extends Achetable {
    
    /**
     * Nombre de maisons construites sur la case.
     */
    private int nbMaisons;
    
    /**
     * Nombre d'hotels construits sur la case.
     */
    private int nbHotels;

    public Constructible(String nom, int prix, int loyer, Joueur proprietaire, int nbMaisons, int nbHotels) {
        super(nom, prix, loyer, proprietaire);
        this.nbMaisons = nbMaisons;
        this.nbHotels = nbHotels;
    }
    

    public int getNbMaisons() {
        return nbMaisons;
    }

    public int getNbHotels() {
        return nbHotels;
    }

    public void setNbMaisons(int nbMaisons) {
        this.nbMaisons = nbMaisons;
    }

    public void setNbHotels(int nbHotels) {
        this.nbHotels = nbHotels;
    }
    
    /**
     * Construit de nouvelles maisons et de nouveaux hotels
     * @param nbNouvellesMaisons le nombre de nouvelles maisons
     * @param nbNouveauxHotels le nombre de nouveaux hotels
     */
    private void construire(int nbNouvellesMaisons, int nbNouveauxHotels) {
        this.nbMaisons += nbNouvellesMaisons;
        this.nbHotels += nbNouveauxHotels;
    }
}
