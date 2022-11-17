package org.ecn.medev.controller;

/**
 * Class that return the key typed by user to select the option
 */
public interface OptionKey {
    /**
     *  example for a menu:
     *  <ol>
     *      <li>first item</li>
     *      <li>second item</li>
     *      <li>third item</li>
     *  </ol>
     *  the returned key can be 1 to designate that user had selected first item.
     * @return The key typed by user to select the option
     */
    String getInputKey();
}
