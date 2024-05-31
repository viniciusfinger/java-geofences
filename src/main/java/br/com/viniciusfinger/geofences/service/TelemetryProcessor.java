package br.com.viniciusfinger.geofences.service;

import br.com.viniciusfinger.geofences.dto.TelemetryDTO;
import org.springframework.stereotype.Service;

@Service
public class TelemetryProcessor {

    /**
     * This is the core of telemetry processor. Can be coupled to a controller
     * or a listener to consume from a queue.
     **/
    public void processTelemetry(TelemetryDTO telemetryDTO) {
        //to-do: implementar primeiro a funcionalidade de velocidade
        // Verificar se o Customer existe, caso contrário lançar exceção
        // Usando as coordenadas do telemetry, verificar se está dentro de um fence

    }
}
