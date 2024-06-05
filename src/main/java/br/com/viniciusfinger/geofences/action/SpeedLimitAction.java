package br.com.viniciusfinger.geofences.action;

import br.com.viniciusfinger.geofences.dto.TelemetryDTO;
import br.com.viniciusfinger.geofences.enums.InfractionType;
import br.com.viniciusfinger.geofences.model.Fence;
import br.com.viniciusfinger.geofences.model.FenceFeatureInterest;
import br.com.viniciusfinger.geofences.model.Infraction;
import br.com.viniciusfinger.geofences.model.Telemetry;
import br.com.viniciusfinger.geofences.service.InfractionService;
import br.com.viniciusfinger.geofences.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpeedLimitAction implements Action {

    @Autowired
    private InfractionService infractionService;

    @Autowired
    private NotificationService notificationService;

    public void execute(FenceFeatureInterest fenceFeatureInterest, TelemetryDTO telemetryDTO, Telemetry lastTelemetry) {
        Fence fence = fenceFeatureInterest.getFence();

        if (telemetryDTO.getSpeed() > fence.getSpeedLimit()) {
            log.info("device id {} exceeded the speed limit fence id {}. The limit is {}, but it was {}",
                    telemetryDTO.getDeviceId(), fence.getId(), fence.getSpeedLimit(), telemetryDTO.getSpeed());

            var infraction = Infraction.builder()
                    .type(InfractionType.HIGH_SPEED)
                    .fenceFeatureInterest(fenceFeatureInterest)
                    .build();

            infractionService.save(infraction);
            notificationService.notificateInteresteds(fenceFeatureInterest);
        }
    }
}
