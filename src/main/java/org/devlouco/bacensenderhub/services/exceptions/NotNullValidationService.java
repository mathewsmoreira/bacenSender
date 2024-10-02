package org.devlouco.bacensenderhub.services.exceptions;

import org.springframework.stereotype.Component;

@Component
public class NotNullValidationService {

    public static <T> void notNull(T object, String message){
        if(object == null){
            throw new IllegalArgumentException(message);

        }
    }

    public static <T> void notBlank(T object, String message){
        if(object == null || object.equals("")){
            throw new IllegalArgumentException(message);

        }
    }

}
