package br.com.viniciusfinger.geofences.action;

import br.com.viniciusfinger.geofences.dto.TelemetryDTO;
import br.com.viniciusfinger.geofences.model.FenceFeatureInterest;

public interface Action {
    void execute(FenceFeatureInterest fenceFeatureInterest, TelemetryDTO telemetry);
}
