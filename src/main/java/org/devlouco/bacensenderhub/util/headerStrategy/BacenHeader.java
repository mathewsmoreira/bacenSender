package org.devlouco.bacensenderhub.util.headerStrategy;

import org.devlouco.bacensenderhub.models.CredentialsModel;
import org.springframework.http.HttpHeaders;

public interface BacenHeader {

    public HttpHeaders getHeader(CredentialsModel credentialsModel);


}
