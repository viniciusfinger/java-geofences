package br.com.viniciusfinger.geofences.enums;

import br.com.viniciusfinger.geofences.action.Action;
import br.com.viniciusfinger.geofences.action.FenceEntranceAction;
import br.com.viniciusfinger.geofences.action.FenceExitAction;
import br.com.viniciusfinger.geofences.action.SpeedLimitAction;
import lombok.Getter;

@Getter
public enum FenceFeature {
    SPEED_LIMIT(new SpeedLimitAction()),
    ENTRANCE_CONTROL(new FenceEntranceAction()),
    EXIT_CONTROL(new FenceExitAction());

    private final Action action;

    FenceFeature(Action action) {
        this.action = action;
    }
}

