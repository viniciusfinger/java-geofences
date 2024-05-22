package br.com.viniciusfinger.geofences.repository;

import br.com.viniciusfinger.geofences.model.Fence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FenceRepository extends JpaRepository<Fence, Long> {

    @Query(value = "SELECT * FROM fence WHERE ST_Contains(polygon, ST_SetSRID(ST_Point(?1, ?2), 4326))", nativeQuery = true)
    public List<Optional<Fence>> findByCoordinates(String latitude, String longitude);

}
