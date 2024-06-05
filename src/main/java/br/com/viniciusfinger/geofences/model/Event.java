package br.com.viniciusfinger.geofences.model;

import br.com.viniciusfinger.geofences.enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Event {

    /**
     * Fence entrance and exit events (and another events)
     **/
    public Event() {}

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private EventType type;

    @ManyToOne
    @JoinColumn(nullable = false)
    private FenceFeatureInterest fenceFeatureInterest;
}
