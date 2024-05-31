package br.com.viniciusfinger.geofences.repository;

import br.com.viniciusfinger.geofences.model.Telemetry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelemetryRepository extends JpaRepository<Telemetry, Long> {
}
