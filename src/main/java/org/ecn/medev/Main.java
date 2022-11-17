package org.ecn.medev;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lancement du Jeu ");
        Plateau gameBoard=new Plateau();
        gameBoard.init();

        while(gameBoard.partieEnCours){
            //gameBoard.tourDeJeu();
            gameBoard.affiche();
            gameBoard.tourDeJeu();
        }


    }
}