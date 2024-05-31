package br.com.viniciusfinger.geofences.service;

import br.com.viniciusfinger.geofences.dto.TelemetryDTO;
import br.com.viniciusfinger.geofences.model.Fence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FenceService {

    public List<Fence> findByTelemetry(TelemetryDTO telemetryDTO) {
        //todo: implementar
        return null;
    }
}
