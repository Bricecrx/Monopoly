/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ecn.medev;
import java.util.Random;
/**
 * Classe Joueur
 * @author Erwan
 */
public class Joueur {
    
    /** 
     * Le nom du joueur. 
     */
    private String nom;
    
    /** 
     * La fortune du joueur. 
     */
    private int fortune;
    
    /** 
     * La position du joueur. 
     */
    private int position;
    
    /** Constructeur de Joueur.
     * @param nom le nom du Joueur.
     * @param fortune la fortune du Joueur.
     * @param position la position du Joueur.
    */
    public Joueur(String nom, int fortune, int position) {
        this.nom = nom;
        this.fortune = fortune;
        this.position = position;
    }
    
    /** 
     * Constructeur par defaut de Joueur avec nom. 
     * @param nom le nom du joueur
     */
    public Joueur(String nom) {
        this.nom = nom;
        this.fortune = 100000;
        this.position = 0;       
    }
    
    /** 
     * Constructeur par defaut de Joueur. 
     */
    public Joueur() {
        this.nom = "Jacques";
        this.fortune = 100000;
        this.position = 0;       
    }
    
    /** 
     * Paiement d'un autre joueur.
     * @param cout cout du paiement.
     * @param j Joueur a payer.
     * @throws org.ecn.medev.NoMoreMoney
    */    
    public void payer(int cout, Joueur j) throws NoMoreMoney {
        if(this.fortune > cout) {
            this.fortune -= cout;
            j.setFortune(j.getFortune() + cout);
        }
        else {
            j.setFortune(j.getFortune() + this.fortune);
            this.fortune = 0;
            throw new NoMoreMoney();
        }
    }
    
    /** 
     * Paiement a la banque.
     * @param cout cout du paiement.
     * @throws org.ecn.medev.NoMoreMoney
    */    
    public void payer(int cout) throws NoMoreMoney {
        if(this.fortune > cout) {
            this.fortune -= cout;
        }
        else {
            this.fortune = 0;
            throw new NoMoreMoney();
        }
    }

    /**
     * Renvoie le nom du joueur.
     * @return le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du joueur.
     * @param nom le nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Renvoie la fortune du joueur.
     * @return la fortune.
     */
    public int getFortune() {
        return fortune;
    }

    /**
     * Définit la fortune du joueur.
     * @param fortune la nouvelle fortune
     */
    public void setFortune(int fortune) {
        this.fortune = fortune;
    }

    /**
     * Renvoie la position du joueur.
     * @return la position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Définit la position du joueur.
     * @param position la nouvelle position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Retourne une valeur aléatoire représentant la valeur d'un dé lancé.
     * @return un entier qui represente la valeur du dé lancé
     */
    public static int lanceLeDe() {
        int deval = (int) Math.floor(Math.random()*6+1);
        return deval;
    }
    
    
    /**
     * Le joueur avance d'un nombre de cases.
     * @param nbCase le nombre de case dont on avance
     */
    public void avancer(int nbCase){
        for(int i=1; i<nbCase+1; i++){
            this.position += nbCase;
            if(this.position>39){
                this.position -= 40;
            }
        }
    }

    /**
     * Renvoie une chaine de caractères représentant le joueur.
     * @return la chaine de caractères
     */
    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                " est en " + position +
                '}' + " Il a les finances suivantes: " + fortune;
    }

    /**
     * Gère le tour de jeu.
     */
    public void tourDeJeu(){
        int de = lanceLeDe();
    }
}
