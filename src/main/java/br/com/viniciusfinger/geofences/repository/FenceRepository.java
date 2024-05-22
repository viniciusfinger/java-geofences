package br.com.viniciusfinger.geofences.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.viniciusfinger.geofences.model.Fence;
import java.util.List;
import java.util.UUID;


@Repository
public interface FenceRepository extends JpaRepository<Fence, UUID> {
    
    List<Fence> findByCustomerId(UUID customerId);

}
