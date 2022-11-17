package org.ecn.medev;

/**
 * Exception déclenchée par les méthodes payer()
 * Permet de signaler qu'une transaction n'est pas possible
 * @version 1.0
 * @author vincent
 */
public class NoMoreMoney extends Exception {

    //la logique de quoi faire quand un joueur n'a pas assez d'argent sera à gérer dans tourDeJeu()
    //il faudra des blocks try-catch lorsqu'on appelera les méthodes payer

    /**
     * Creates a new instance of <code>NoMoreMoney</code> without detail
     * message.
     */
    public NoMoreMoney() {
    }

    /**
     * Constructs an instance of <code>PvInfOuEgalAZero</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoMoreMoney(String msg) {
        super(msg);
    }
}