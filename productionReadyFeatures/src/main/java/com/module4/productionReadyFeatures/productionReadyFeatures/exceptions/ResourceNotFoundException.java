package com.module4.productionReadyFeatures.productionReadyFeatures.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
