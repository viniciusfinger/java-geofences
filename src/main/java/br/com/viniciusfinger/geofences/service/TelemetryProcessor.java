package br.com.viniciusfinger.geofences.service;

import br.com.viniciusfinger.geofences.dto.TelemetryDTO;
import br.com.viniciusfinger.geofences.model.Fence;
import br.com.viniciusfinger.geofences.model.FenceFeatureInterest;
import br.com.viniciusfinger.geofences.model.Telemetry;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelemetryProcessor {

    private final ModelMapper modelMapper;
    private final TelemetryService telemetryService;
    private final FenceService fenceService;
    private final FenceFeatureInterestService fenceFeatureInterestService;

    public TelemetryProcessor(ModelMapper modelMapper, TelemetryService telemetryService, FenceService fenceService, FenceFeatureInterestService fenceFeatureInterestService) {
        this.modelMapper = modelMapper;
        this.telemetryService = telemetryService;
        this.fenceService = fenceService;
        this.fenceFeatureInterestService = fenceFeatureInterestService;
    }

    /**
     * This is the core of telemetry processor. Can be coupled to a controller to
     * receive telemetry by HTTPS or a listener to consume from a queue.
     **/
    public void process(TelemetryDTO telemetryDTO) {
        //todo: implementar busca de cercas. Pensar como fazer.
        //todo: validar se o customer existe
        //todo: tratar melhor as exceptions
        List<Fence> fences = fenceService.findByTelemetry(telemetryDTO);

        fences.forEach(fence ->
                processFeaturesByFence(fenceFeatureInterestService.findByFence(fence), telemetryDTO)
        );

        this.updateLastTelemetry(telemetryDTO);
    }

    private void updateLastTelemetry(TelemetryDTO telemetryDTO) {
        Telemetry lastTelemetry = modelMapper.map(telemetryDTO, Telemetry.class);
        telemetryService.save(lastTelemetry);
    }

    private void processFeaturesByFence(List<FenceFeatureInterest> fenceFeatureInterestList, TelemetryDTO telemetryDTO) {
        fenceFeatureInterestList.forEach(fenceFeatureInterest -> {
            Telemetry lastTelemetry = telemetryService.findByDeviceId(Long.valueOf(telemetryDTO.getDeviceId()));
            fenceFeatureInterest.getFeature().getAction().execute(fenceFeatureInterest, telemetryDTO, lastTelemetry);
        });
    }
}
