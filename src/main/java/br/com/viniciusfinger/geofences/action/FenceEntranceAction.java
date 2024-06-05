package br.com.viniciusfinger.geofences.action;

import br.com.viniciusfinger.geofences.dto.TelemetryDTO;
import br.com.viniciusfinger.geofences.enums.EventType;
import br.com.viniciusfinger.geofences.model.Event;
import br.com.viniciusfinger.geofences.model.Fence;
import br.com.viniciusfinger.geofences.model.FenceFeatureInterest;
import br.com.viniciusfinger.geofences.model.Telemetry;
import br.com.viniciusfinger.geofences.service.EventService;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Component;

@Component
public class FenceEntranceAction implements Action {

    private final EventService eventService;

    public FenceEntranceAction(EventService eventService) {
        this.eventService = eventService;
    }

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
            Event entranceEvent = Event.builder().type(EventType.FENCE_ENTRANCE)
                    .fenceFeatureInterest(fenceFeatureInterest).build();

           this.eventService.save(entranceEvent);
        }
    }

    private boolean isEnteringFence(Fence fence, Point lastPosition, Point actualPosition) {
        return !fence.getPolygon().contains(lastPosition) && fence.getPolygon().contains(actualPosition);
    }
}
