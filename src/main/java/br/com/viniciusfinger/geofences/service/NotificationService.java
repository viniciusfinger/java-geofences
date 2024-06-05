package br.com.viniciusfinger.geofences.service;

import br.com.viniciusfinger.geofences.model.FenceFeatureInterest;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void notificateInteresteds(FenceFeatureInterest fenceFeatureInterest) {
        fenceFeatureInterest.getInterestedPersons().forEach(
                //todo: chamar serviço de email e disparar email
                //todo: dar uma mensagem detalhada de acordo com o tipo de infração/evento.
                interestedPerson -> System.out.println("Notificando " + interestedPerson.getFirstName())
        );
    }

}
