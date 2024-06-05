package br.com.viniciusfinger.geofences.action;

import br.com.viniciusfinger.geofences.dto.TelemetryDTO;
import br.com.viniciusfinger.geofences.model.FenceFeatureInterest;
import br.com.viniciusfinger.geofences.model.Telemetry;

public interface Action {
    void execute(FenceFeatureInterest fenceFeatureInterest, TelemetryDTO telemetryDTO, Telemetry lastTelemetry);
}
