package org.ecn.medev.controller;

import lombok.Data;
import org.ecn.medev.Plateau;

/**
 * Class that hold temporary user information when joining the game such as login information
 */
@Data
public class GameSession {
    private Plateau plateau;
}
