/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ecn.medev;

/**
 * Classe Joueur
 * @author erwan
 */
public class Joueur {
    
    /** Le nom du joueur. */
    private String nom;
    /** La fortune du joueur. */
    private int fortune;
    /** La position du joueur. */
    private int position;
    
    /** Constructeur de Joueur.
     * @param nom Nom du Joueur.
     * @param fortune Fortune du Joueur.
     * @param position Position du Joueur.
    */
    Joueur(String nom, int fortune, int position) {
        this.nom = nom;
        this.fortune = fortune;
        this.position = position;
    }
    
    /** Constructeur par defaut de Joueur. */
    Joueur() {
        this.nom = "Jacques";
        this.fortune = 100000;
        this.position = 0;       
    }
    
    /** Paiement d'un autre joueur.
     * @param cout cout du paiement.
     * @param j Joueur a payer.
    */    
    public void payer(int cout, Joueur j) throws NoMoreMoney {
        if(this.fortune > cout) {
            this.fortune -= cout;
            j.setFortune(j.getFortune() + cout);
        }
        else {
            j.setFortune(j.getFortune() + this.fortune);
            this.fortune = 0;
            throw NoMoreMoney;
        }
    }
    
    /** Paiement a la banque.
     * @param cout cout du paiement.
    */    
    public void payer(int cout) throws NoMoreMoney {
        if(this.fortune > cout) {
            this.fortune -= cout;
        }
        else {
            this.fortune = 0;
            throw NoMoreMoney;
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getFortune() {
        return fortune;
    }

    public void setFortune(int fortune) {
        this.fortune = fortune;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
    /**
     * Le joueur avance d'un nb de cases
     * @param nbCase
     */
    public void avancer(int nbCase){
        for(int i=1; i<nbCase+1; i++){
            this.position += nbCase;
            if(this.position>39){
                this.position -= 40;
            }
        }
    }
}
