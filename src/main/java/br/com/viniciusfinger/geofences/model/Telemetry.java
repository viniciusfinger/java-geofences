package br.com.viniciusfinger.geofences.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Telemetry {

    @Id
    private Long deviceId;

    @ManyToOne
    private Customer customer;

    private Double latitude;

    private Double longitude;

    private String timestamp;

    private Float speed;

}
