package com.finalproject.factory;

import com.finalproject.service.ValidationService;

public class ServiceFactory {
    private static ValidationService validationService = new ValidationService();

    public ServiceFactory() {
    }

    public static ValidationService getValidationService() {
        return validationService;
    }
}
