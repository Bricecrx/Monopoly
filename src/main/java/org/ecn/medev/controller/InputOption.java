package org.ecn.medev.controller;

import lombok.Data;

/**
 * Class used to designate the simple text interface to user
 */
@Data
public class InputOption {
    /**
     * The key typed by user to select the option
     */
    private OptionKey optionKey;

    /**
     * Short description of the option. usually one word so all options could be printed on one line
     * example: login
     */
    private String shortDescription;
    /**
     * Long description of the option. usually one line so each option is printed on one line
     * example: login with username and password
     */
    private String longDescription;


    public InputOption(OptionKey optionKey) {
        this.optionKey = optionKey;
        this.shortDescription = "no description provided";
        this.longDescription = "no description provided";
    }

    public InputOption(OptionKey optionKey, String shortDescription, String longDescription) {
        this.optionKey = optionKey;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }
}
