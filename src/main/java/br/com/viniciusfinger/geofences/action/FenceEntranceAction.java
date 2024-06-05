package br.com.viniciusfinger.geofences.action;

import br.com.viniciusfinger.geofences.dto.TelemetryDTO;
import br.com.viniciusfinger.geofences.enums.EventType;
import br.com.viniciusfinger.geofences.model.Event;
import br.com.viniciusfinger.geofences.model.Fence;
import br.com.viniciusfinger.geofences.model.FenceFeatureInterest;
import br.com.viniciusfinger.geofences.model.Telemetry;
import br.com.viniciusfinger.geofences.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FenceEntranceAction implements Action {

    @Autowired
    private EventService eventService;

    @Override
    public void execute(FenceFeatureInterest fenceFeatureInterest, TelemetryDTO telemetryDTO, Telemetry lastTelemetry) {
        Fence fence = fenceFeatureInterest.getFence();

        GeometryFactory geometryFactory = new GeometryFactory();

        Point lastPosition = geometryFactory.createPoint(
                new Coordinate(lastTelemetry.getLatitude(), lastTelemetry.getLongitude())
        );

        Point actualPosition = geometryFactory.createPoint(
                new Coordinate(telemetryDTO.getLatitude(), telemetryDTO.getLongitude())
        );

        if (isEnteringFence(fence, lastPosition, actualPosition)) {
            log.info("Device {} has entered fence id {}", telemetryDTO.getDeviceId(), fence.getId());

            Event entranceEvent = Event.builder().type(EventType.FENCE_ENTRANCE)
                    .fenceFeatureInterest(fenceFeatureInterest).build();

           this.eventService.save(entranceEvent);
            //todo: notification service enviar email
        }
    }

    private boolean isEnteringFence(Fence fence, Point lastPosition, Point actualPosition) {
        return !fence.getPolygon().contains(lastPosition) && fence.getPolygon().contains(actualPosition);
    }
}
