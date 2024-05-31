package br.com.viniciusfinger.geofences.model;

import br.com.viniciusfinger.geofences.dto.TelemetryDTO;
import br.com.viniciusfinger.geofences.enums.FenceFeature;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
public class FenceFeatureInterest {

    public FenceFeatureInterest(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Fence fence;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FenceFeature feature;

    private Boolean active;

    @ManyToMany
    @JoinTable(
            name = "fence_feature_interested_person",
            joinColumns = @JoinColumn(name = "fence_feature_interest_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> interestedPersons;

    public void execute(TelemetryDTO telemetry) {
        this.feature.getAction().execute(this, telemetry);
    }
}
