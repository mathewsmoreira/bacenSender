package org.devlouco.bacensenderhub.util.headerStrategy;

import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.devlouco.bacensenderhub.util.BasicAuth;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class HeaderProtocol implements BacenHeader{

    private HttpHeaders headers;
    private BasicAuth basicAuth;
    public HeaderProtocol(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
        this.headers = new HttpHeaders();
    }

    @Override
    public HttpHeaders getHeader(CredentialsModel credentialsModel) {
        headers.add("Authorization", basicAuth.createBasicAuthHeader(credentialsModel));
        headers.add("Content-Type", "application/xml");

        return headers;
    }
}
