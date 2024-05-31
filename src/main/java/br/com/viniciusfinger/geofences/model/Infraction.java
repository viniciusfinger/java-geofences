package br.com.viniciusfinger.geofences.model;

import br.com.viniciusfinger.geofences.enums.InfractionType;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.UUID;


@Entity
@Builder
public class Infraction {

    public Infraction() {}

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InfractionType type;

    @ManyToOne
    @JoinColumn(nullable = false)
    private FenceFeatureInterest fenceFeatureInterest;
}
