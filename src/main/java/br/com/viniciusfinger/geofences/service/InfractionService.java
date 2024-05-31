package br.com.viniciusfinger.geofences.service;

import br.com.viniciusfinger.geofences.model.Infraction;
import br.com.viniciusfinger.geofences.repository.InfractionRepository;
import org.springframework.stereotype.Service;

@Service
public class InfractionService {

    private final InfractionRepository infractionRepository;

    public InfractionService(InfractionRepository infractionRepository) {
        this.infractionRepository = infractionRepository;
    }

    public Infraction save(Infraction infraction) {
        return infractionRepository.save(infraction);
    }
}
