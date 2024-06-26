package br.com.viniciusfinger.geofences.service;

import br.com.viniciusfinger.geofences.model.Telemetry;
import br.com.viniciusfinger.geofences.repository.TelemetryRepository;

import org.springframework.stereotype.Service;

@Service
public class TelemetryService {

    private final TelemetryRepository telemetryRepository;

    public TelemetryService(TelemetryRepository telemetryRepository) {
        this.telemetryRepository = telemetryRepository;
    }

    public Telemetry save(Telemetry telemetry) {
        return telemetryRepository.save(telemetry);
    }

    public Telemetry findByDeviceId(Long deviceId) {
        //todo: melhorar essa exception
        return telemetryRepository.findByDeviceId(deviceId).orElseThrow(() -> new RuntimeException("Telemetry not found"));
    }
}
