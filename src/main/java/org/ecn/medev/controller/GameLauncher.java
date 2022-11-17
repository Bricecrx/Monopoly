package org.ecn.medev.controller;

import org.ecn.medev.controller.start.StartMenuController;

/**
 * Class used to start a new game session, it is the main class to start the game
 */
public class GameLauncher {
    public static void main(String args[]) {
        GameSession gameSession = new GameSession();
        StartMenuController startMenuController = new StartMenuController(gameSession);
        System.out.println("Le jeu est lance!\nTout moment vous pouvez taper 'help' pour avoir les options possibles");
        startMenuController.start();
    }
}
