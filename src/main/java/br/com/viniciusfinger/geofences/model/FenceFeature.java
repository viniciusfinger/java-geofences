package br.com.viniciusfinger.geofences.model;

public enum FenceFeature {
    SPEED_LIMIT,
    ENTRANCE_CONTROL,
    EXIT_CONTROL
    //to-do: vai ser um enum mesmo?
    //estruturar bem como vai ser
    //me inspirar no design pattern que fiz para o itau

    //to-do: pensar num modelo de alerta (como notificará os interessados? como será armazenado os usuários associados a
    //funcionalidade?)
    //as vezes um interessado num evento x nao esta interessado num evento y.
    //criar grupos de interessados e associar a funcionalidades
}
