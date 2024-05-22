package br.com.viniciusfinger.geofences.service;

import java.util.List;
import java.util.UUID;

import br.com.viniciusfinger.geofences.model.Fence;
import br.com.viniciusfinger.geofences.repository.FenceRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FenceService {

    private final FenceRepository fenceRepository;

    public FenceService(FenceRepository fenceRepository) {
        this.fenceRepository = fenceRepository;
    }

    public Fence save(Fence fence) {
        return fenceRepository.save(fence);
    }

    public Fence findById(UUID id) {
        return fenceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Fence not found"));
    }

    public void deleteById(UUID id) {
        fenceRepository.deleteById(id);
    }

    public List<Fence> findByCustomerId(UUID customerId) {
        return fenceRepository.findByCustomerId(customerId);
    }
}
