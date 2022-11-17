package org.ecn.medev.controller.util;

import org.ecn.medev.controller.*;

public class UnsupportedActionException extends Exception {
    /**
     * Create a new exception describing that controller handling the {@link InputOption#getOptionKey()}
     * does not support its implemented class {@link OptionKey}
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
    public UnsupportedActionException(String message) {
        super(message);
    }
}
