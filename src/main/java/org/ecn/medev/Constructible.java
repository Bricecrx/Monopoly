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
    protected int nbMaisons;
    
    /**
     * Nombre d'hotels construits sur la case.
     */
    protected int nbHotels;

    /**
     * Constructeur pour une case constructible.
     * @param nom le nom de la case
     * @param prix le prix d'achat de la case
     * @param proprietaire le propriétaire de la case
     * @param nbMaisons le nombre de maisons sur la case
     * @param nbHotels le nombre d'hotels sur la case
     */
    public Constructible(String nom, int prix, Joueur proprietaire, int nbMaisons, int nbHotels) {
        super(nom, prix, proprietaire);
        this.nbMaisons = nbMaisons;
        this.nbHotels = nbHotels;
    }
    
     /**
     * Constructeur pour une case constructible.
     * @param nom le nom de la case
     */
    public Constructible(String nom){
        super(nom, -1);
    }

     /**
     * Constructeur pour une case constructible.
     * @param nom le nom de la case
     * @param prix le prix de la case
     */
    public Constructible(String nom, int prix){
        super(nom, prix);
    }
    
     /**
     * Renvoie le nombre de maisons sur la case.
     * @return le nombre de maisons
     */
    public int getNbMaisons() {
        return nbMaisons;
    }

     /**
     * Renvoie le nombre d'hotels sur la case.
     * @return le nombre de cases
     */
    public int getNbHotels() {
        return nbHotels;
    }

     /**
     * Définit le nombre de maisons sur la case.
     * @param nbMaisons le nouveau nombre de maison
     */
    public void setNbMaisons(int nbMaisons) {
        this.nbMaisons = nbMaisons;
    }

     /**
     * Définit le nombre d'hotels sur la case.
     * @param nbHotels le nouveau nombre d'hotels
     */
    public void setNbHotels(int nbHotels) {
        this.nbHotels = nbHotels;
    }
    
    /**
     * Construit de nouvelles maisons et de nouveaux hotels
     * @param nbNouvellesMaisons le nombre de nouvelles maisons
     * @param nbNouveauxHotels le nombre de nouveaux hotels
     */
    public void construire(int nbNouvellesMaisons, int nbNouveauxHotels) {
        this.nbMaisons += nbNouvellesMaisons;
        this.nbHotels += nbNouveauxHotels;
        this.calculLoyer();
    }
}
