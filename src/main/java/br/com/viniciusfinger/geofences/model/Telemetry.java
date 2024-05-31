package br.com.viniciusfinger.geofences.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Telemetry {

    @Id
    private Long deviceId;

    @ManyToOne
    private Customer customer;

    private String latitude;

    private String longitude;

    private String timestamp;

    private Float speed;

}
