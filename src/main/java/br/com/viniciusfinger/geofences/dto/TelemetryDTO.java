package br.com.viniciusfinger.geofences.dto;

import lombok.Data;

@Data
public class TelemetryDTO {

    private String customerId;

    private String latitude;

    private String longitude;

    private String timestamp;

    private Float speed;

    private String deviceId;

}