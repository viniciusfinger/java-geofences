package br.com.viniciusfinger.geofences.repository;

import br.com.viniciusfinger.geofences.model.Telemetry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TelemetryRepository extends JpaRepository<Telemetry, Long> {

    Optional<Telemetry> findByDeviceId(Long deviceId);
}
