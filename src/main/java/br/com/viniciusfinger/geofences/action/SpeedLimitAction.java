package br.com.viniciusfinger.geofences.action;

import br.com.viniciusfinger.geofences.dto.TelemetryDTO;
import br.com.viniciusfinger.geofences.enums.InfractionType;
import br.com.viniciusfinger.geofences.model.FenceFeatureInterest;
import br.com.viniciusfinger.geofences.model.Infraction;
import br.com.viniciusfinger.geofences.service.InfractionService;
import br.com.viniciusfinger.geofences.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpeedLimitAction implements Action {

    @Autowired
    private InfractionService infractionService;

    @Autowired
    private NotificationService notificationService;

    public void execute(FenceFeatureInterest fenceFeatureInterest, TelemetryDTO telemetry) {
        var fence = fenceFeatureInterest.getFence();

        if (telemetry.getSpeed() > fence.getSpeedLimit()){
            var infraction = Infraction.builder()
                    .type(InfractionType.HIGH_SPEED)
                    .fenceFeatureInterest(fenceFeatureInterest)
                    .build();

            infractionService.save(infraction);
            notificationService.notificateInteresteds(fenceFeatureInterest);
        }
    }
}
