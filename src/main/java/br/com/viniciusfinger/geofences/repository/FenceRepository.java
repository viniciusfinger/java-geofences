package br.com.viniciusfinger.geofences.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.viniciusfinger.geofences.model.Fence;
import java.util.List;


@Repository
public interface FenceRepository extends JpaRepository<Fence, Long> {
    
    List<Fence> findByCustomerId(Long customerId);

}
