package br.com.viniciusfinger.geofences.repository;

import br.com.viniciusfinger.geofences.model.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InfractionRepository extends JpaRepository<Infraction, UUID> {

}
