package br.com.viniciusfinger.geofences.model;

import br.com.viniciusfinger.geofences.enums.InfractionType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Infraction {

    /*
    Some features generate infractions
     */

    //to-do: terminar de implementar. Associar a funcionalidade que gerou a infração.

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private InfractionType type;

}
