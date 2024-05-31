package br.com.viniciusfinger.geofences.enums;

import br.com.viniciusfinger.geofences.action.Action;
import br.com.viniciusfinger.geofences.action.SpeedLimitAction;
import lombok.Getter;

@Getter
public enum FenceFeature {
    SPEED_LIMIT(new SpeedLimitAction()),
    ENTRANCE_CONTROL(null), //todo: implement entrance control action
    EXIT_CONTROL(null); //todo: implement exit_control action

    private final Action action;

    private FenceFeature(Action action) {
        this.action = action;
    }

}

