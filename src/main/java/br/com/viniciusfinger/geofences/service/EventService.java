package br.com.viniciusfinger.geofences.service;

import br.com.viniciusfinger.geofences.model.Event;
import br.com.viniciusfinger.geofences.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event save(Event event){
        return eventRepository.save(event);
    }

}
