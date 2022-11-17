package org.ecn.medev.controller;

import lombok.Getter;
import lombok.Setter;
import org.ecn.medev.controller.util.CallbackToDo;
import org.ecn.medev.controller.util.UnsupportedActionException;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public abstract class MenuController {

    @Getter
    private enum MenuOption implements OptionKey {
        SHUTDOWN("*"),
        GO_PARENT("*");

        private final String inputKey;

        MenuOption(String s) {
            this.inputKey = s;
        }
    }

    private final Map<MenuOption, InputOption> COMMON_OPTIONS = Collections.unmodifiableMap(new HashMap<MenuOption, InputOption>() {{
        put(MenuOption.SHUTDOWN, new InputOption(MenuOption.SHUTDOWN, "Terminer", "Terminer le jeu."));
        put(MenuOption.GO_PARENT, new InputOption(MenuOption.GO_PARENT, "Menu precedant", "Revenir au menu precedant"));
    }});
    private final UiMenuType MENU_TYPE;

    private MenuController parentMenu;

    private Map<String, InputOption> options;

    private GameSession gameSession;

    public MenuController(UiMenuType MENU_TYPE, List<InputOption> options, GameSession gameSession, MenuController parentMenu) {
        this.MENU_TYPE = MENU_TYPE;
        if (parentMenu != null) {
            this.parentMenu = parentMenu;
            options.add(COMMON_OPTIONS.get(MenuOption.GO_PARENT));
        } else {
            options.add(COMMON_OPTIONS.get(MenuOption.SHUTDOWN));
        }
        this.options = options.stream().collect(Collectors.toMap(o -> o.getOptionKey().getInputKey(), o -> o));
        this.gameSession = gameSession;
    }

    public void displayLongMenu() {
        System.out.println("Choisir une option de la menu:");
        options.values().stream().forEach(o -> System.out.println(o.getOptionKey().getInputKey() + " - " + o.getLongDescription()));
    }

    public void displayShortMenu() {
        System.out.print("Options: ");
        options.values().stream().forEach(o -> System.out.print(" (" + o.getOptionKey().getInputKey() + ")" + o.getShortDescription()));
        System.out.print("\nYour choice: ");
    }

    public boolean conditionToStart() {
        return true;
    }
    public void start() {
        if (!conditionToStart()) {
            System.out.println("Condition to start menu are not met");
            if (parentMenu != null)
                parentMenu.start();
            return;
        }
        displayLongMenu();
        try {
            doTheChoice(getTheChoice());
        } catch (UnsupportedActionException e) {
            e.printStackTrace();
        }
    }

    public InputOption getTheChoice() {
        String choice = "", st;
        System.out.println("---------------------------------");
        int i;
        boolean isValidInput = false;
        Scanner in = new Scanner(System.in);
        do {
            choice = in.next();
            if (choice.equalsIgnoreCase("help")) {
                displayLongMenu();
            }
            if (choice.equalsIgnoreCase("*")) {
                if (parentMenu == null) {
                    return new InputOption(MenuOption.SHUTDOWN);
                } else {
                    return new InputOption(MenuOption.GO_PARENT);
                }
            }
            isValidInput = options.containsKey(choice);
            if (!isValidInput) {
                displayShortMenu();
            }
        } while (!isValidInput);
        return options.get(choice);
    }

    public static Integer getIndexChoiceFromList(String header, List<String> options) {
        if (options == null || options.size() == 0) {
            return null;
        }
        CallbackToDo callbackToDo = () -> {
            System.out.println(header);
            int i = 1;
            for (String option : options) {
                System.out.println(i + " - " + option);
                i++;
            }
            System.out.println("---------------------------------");
        };
        callbackToDo.call();

        return getIndexChoice(options.size(), callbackToDo);
    }

    public static Integer getIndexChoice(int arraySize, CallbackToDo helpFunction) {
        return getIndexChoice(arraySize, "Your choice", helpFunction);
    }

    public static Integer getIndexChoice(int arraySize, String indexMeaning, CallbackToDo helpFunction) {
        if(arraySize <= 0){
            return null;
        }
        Scanner in = new Scanner(System.in);
        boolean isValidChoice = false;
        String choice = "", st;
        Integer indexChoice = null, i = 1;
        do {
            System.out.print(indexMeaning + " [1-" + arraySize + "]: ");
            choice = in.next();
            if (choice.equalsIgnoreCase("help") && helpFunction != null) {
                helpFunction.call();
            }
            for (i = 1; i <= arraySize; i++) {
                st = "" + i;
                if (choice.equals(st)) {
                    isValidChoice = true;
                    indexChoice = i - 1;
                }
            }
        } while (!isValidChoice);
        return indexChoice;
    }


    public void doTheChoice(InputOption inputOption) throws UnsupportedActionException {
        if (inputOption.getOptionKey() instanceof MenuOption) {
            switch ((MenuOption) inputOption.getOptionKey()) {
                case SHUTDOWN:
                    System.out.println("Shutting down...");
                    return;
                case GO_PARENT:
                    System.out.println("Going back.");
                    parentMenu.start();
                    return;
            }
        }
        doInnerChoice(inputOption);
    }

    /**
     * Use {@link #doTheChoice(InputOption)} instead to get functionalities such as going back and exiting application.
     * <p>
     * This function have recursive behavior that do action based on
     * parameter provided. Then it call again itself by {@link #doInnerChoice(InputOption)} {@link #getTheChoice()}
     * unless the program end, or it starts another menu controller.
     *
     * @param inputOption
     */
    protected abstract void doInnerChoice(InputOption inputOption) throws UnsupportedActionException;
}
