/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author erwan
 */
public class Joueur {
    private String nom;
    private int fortune;
    private int position;
    
    Joueur(String nom, int fortune, int position) {
        this.nom = nom;
        this.fortune = fortune;
        this.position = position;
    }
    
    Joueur() {
        this.nom = "Jacques";
        this.fortune = 100000;
        this.position = 0;       
    }
    
    public void payer(int cout, Joueur j) {
        if(this.fortune > cout) {
            this.fortune -= cout;
            j.setFortune(j.getFortune() + cout);
        }
        else {
            j.setFortune(j.getFortune() + this.fortune);
            this.fortune = 0;
            finDePartie();
        }
    }
    public void finDePartie() {
        
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
    
    
}
