package org.ecn.medev.controller.start;

import org.ecn.medev.Joueur;
import org.ecn.medev.Plateau;
import org.ecn.medev.controller.GameSession;
import org.ecn.medev.controller.InputOption;
import org.ecn.medev.controller.MenuController;
import org.ecn.medev.controller.UiMenuType;
import org.ecn.medev.controller.util.UnsupportedActionException;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;


public class StartMenuController extends MenuController {
    public static final UiMenuType MENU_TYPE = UiMenuType.START_PAGE;
    public static final List<InputOption> OPTIONS = Collections.unmodifiableList(Arrays.asList(
            new InputOption(StartMenuOption.ENTER_GAME, "Lancer Jeu", "Lancer le jeu")
    ));

    public StartMenuController(GameSession gameSession) {
        super(MENU_TYPE, new ArrayList<>(OPTIONS), gameSession, null);
    }

    @Override
    protected void doInnerChoice(InputOption inputOption) throws UnsupportedActionException {
        StartMenuOption option;
        if (inputOption.getOptionKey() instanceof StartMenuOption) {
            option = (StartMenuOption) inputOption.getOptionKey();
        } else {
            throw new UnsupportedActionException("Expecting option key of type " + StartMenuOption.class
                    + ", provided : " + inputOption.getOptionKey().getClass());
        }
        switch (option) {
            case ENTER_GAME:
                if (getGameSession().getPlateau() == null) {
                    initializeJeu();
                }
                commencerLeJeu();
                break;
        }
        displayShortMenu();
        doTheChoice(getTheChoice());
    }

    private void commencerLeJeu() {
        Plateau gameBoard = getGameSession().getPlateau();
        while(gameBoard.partieEnCours){
            //gameBoard.tourDeJeu();
            gameBoard.affiche();
            gameBoard.tourDeJeu();
        }
    }

    private void initializeJeu() {
        System.out.println("Choisit le nombre de personne");
        int nombreDePersonne = MenuController.getIndexChoice(6, "Nombre de joueur", null) + 1;
        System.out.println("Creation de plateau");
        LinkedList<Joueur> joueurs = new LinkedList<>();
        for (int i = 0; i < nombreDePersonne; i++) {
            joueurs.add(readJoueur(i));
        }
        Plateau plateau = new Plateau();
        plateau.setJoueurs(joueurs);
        getGameSession().setPlateau(plateau);
    }


    private Joueur readJoueur(int index) {
        Joueur joueur = new Joueur();
        Scanner in = new Scanner(System.in);
        String nom = "";
        while(nom.isEmpty()) {
            System.out.print("Nom du joueur " + (index+1) + " : ");
            nom = in.nextLine();
            joueur.setNom(nom);
        }
        return joueur;
    }
}
