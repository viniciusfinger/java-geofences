package br.com.viniciusfinger.geofences.action;

import br.com.viniciusfinger.geofences.dto.TelemetryDTO;
import br.com.viniciusfinger.geofences.enums.EventType;
import br.com.viniciusfinger.geofences.model.Event;
import br.com.viniciusfinger.geofences.model.Fence;
import br.com.viniciusfinger.geofences.model.FenceFeatureInterest;
import br.com.viniciusfinger.geofences.model.Telemetry;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Component;

@Component
public class FenceEntranceAction implements Action {

    @Override
    public void execute(FenceFeatureInterest fenceFeatureInterest, TelemetryDTO telemetryDTO, Telemetry lastTelemetry) {
        Fence fence = fenceFeatureInterest.getFence();

        GeometryFactory geometryFactory = new GeometryFactory();

        Point lastPositionPoint = geometryFactory.createPoint(new Coordinate(lastTelemetry.getLatitude(), lastTelemetry.getLongitude()));
        Point actualPositionPoint = geometryFactory.createPoint(new Coordinate(telemetryDTO.getLatitude(), telemetryDTO.getLongitude()));

        if (!fence.getPolygon().contains(lastPositionPoint) && fence.getPolygon().contains(actualPositionPoint)){
            //todo: add log
            Event entranceEvent = Event.builder()
                    .type(EventType.ENTER) //todo: renomear para entrance
                    .fenceFeatureInterest(fenceFeatureInterest)
                    .build();
        }

    }
}
