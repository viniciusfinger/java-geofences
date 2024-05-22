package br.com.viniciusfinger.geofences.dto;

import lombok.Data;

@Data
public class Telemetry {

    private String customerId;

    private String latitude;

    private String longitude;

    private String timestamp;

    private String speed;

    private String deviceId;


}
