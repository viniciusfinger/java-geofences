package br.com.viniciusfinger.geofences.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.locationtech.jts.geom.Polygon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @OneToMany
    @JoinColumn(name = "fence_id")
    private List<FenceFeatureInterest> features;

    private Float speedLimit;

    @Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$", message = "Invalid color hex code")
    private String colorHex;

    @Column(name = "polygon", columnDefinition = "Geometry(Polygon)", nullable = false)
    private Polygon polygon;

    @ManyToOne
    private Customer customer;

}

