package br.com.viniciusfinger.geofences.exceptions;

public class EntityNotFoundException extends RuntimeException {
    
    public EntityNotFoundException(String message) {
        super(message);
    }
}
