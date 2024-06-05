package br.com.viniciusfinger.geofences.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TelemetryDTO {
    
    private Long deviceId;
    
    private UUID customerId;

    private Double latitude;

    private Double longitude;

    private String timestamp;

    private Float speed;

}
