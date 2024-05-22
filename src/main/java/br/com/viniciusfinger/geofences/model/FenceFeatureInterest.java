package br.com.viniciusfinger.geofences.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FenceFeatureInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Fence fence;

    @Enumerated(EnumType.STRING)
    private FenceFeature functionality;

    private Boolean active;

    @ManyToMany
    @JoinTable(
            name = "fence_feature_interested_person",
            joinColumns = @JoinColumn(name = "fence_feature_interest_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> interestedPersons;

}
