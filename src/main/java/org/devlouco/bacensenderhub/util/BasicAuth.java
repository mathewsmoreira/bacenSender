package org.devlouco.bacensenderhub.util;

import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class BasicAuth {

    public String createBasicAuthHeader(CredentialsModel credentials) {
        String auth = credentials.getLogin() + ":" + credentials.getPassword();
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        return "Basic " + encodedAuth;
    }



}
