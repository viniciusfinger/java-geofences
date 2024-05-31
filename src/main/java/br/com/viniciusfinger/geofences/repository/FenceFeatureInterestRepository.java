package br.com.viniciusfinger.geofences.repository;

import br.com.viniciusfinger.geofences.model.Fence;
import br.com.viniciusfinger.geofences.model.FenceFeatureInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FenceFeatureInterestRepository extends JpaRepository<FenceFeatureInterest, Long> {

    List<FenceFeatureInterest> findByFence(Fence fence);
}
