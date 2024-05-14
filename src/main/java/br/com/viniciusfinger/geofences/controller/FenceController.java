package br.com.viniciusfinger.geofences.controller;

import java.util.List;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Polygon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.viniciusfinger.geofences.model.Fence;
import br.com.viniciusfinger.geofences.service.FenceService;

@RestController
@RequestMapping("/fences")
public class FenceController implements IFenceController {

    private final FenceService fenceService;

    public FenceController(FenceService fenceService) {
        this.fenceService = fenceService;
    }

    @PostMapping
    public Fence saveFence() {
        //to-do: receive fence as object
        Fence fence = new Fence();
        fence.setColor("blue");
        fence.setDescription("teste");
        fence.setName("teste");

        fence.setCustomerId(1L);

        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate[] coordinates = new Coordinate[] {
                new Coordinate(0, 0),
                new Coordinate(0, 10),
                new Coordinate(10, 10),
                new Coordinate(10, 0),
                new Coordinate(0, 0)
        };

        Polygon polygon = geometryFactory.createPolygon(coordinates);

        fence.setPolygon(polygon);

        return fenceService.save(fence);
    }

    @GetMapping("/customers/{customerId}")
    public List<Fence> getFencesByCustomerId(@PathVariable Long customerId) {
        return fenceService.findByCustomerId(customerId);
    }
}
