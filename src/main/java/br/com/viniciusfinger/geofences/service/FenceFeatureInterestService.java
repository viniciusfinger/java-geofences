package br.com.viniciusfinger.geofences.service;

import br.com.viniciusfinger.geofences.model.Fence;
import br.com.viniciusfinger.geofences.model.FenceFeatureInterest;
import br.com.viniciusfinger.geofences.repository.FenceFeatureInterestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FenceFeatureInterestService {

    private final FenceFeatureInterestRepository fenceFeatureInterestRepository;

    public FenceFeatureInterestService(FenceFeatureInterestRepository fenceFeatureInterestRepository) {
        this.fenceFeatureInterestRepository = fenceFeatureInterestRepository;
    }

    public List<FenceFeatureInterest> findByFence(Fence fence) {
        return fenceFeatureInterestRepository.findByFence(fence);
    }

}
