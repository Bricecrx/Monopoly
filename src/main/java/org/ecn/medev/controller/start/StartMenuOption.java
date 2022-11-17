package org.ecn.medev.controller.start;

import lombok.Getter;
import org.ecn.medev.controller.OptionKey;


@Getter
public enum StartMenuOption implements OptionKey {
    ENTER_GAME("1");

    private final String inputKey;

    StartMenuOption(String s) {
        this.inputKey = s;
    }
}
