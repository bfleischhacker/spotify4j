package org.spotify4j.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.spotify4j.SpotifyObjectMapper;

import java.io.IOException;

public class AbstractApiResource {
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final ObjectMapper OBJECT_MAPPER = SpotifyObjectMapper.defaultInstance;

    private static final String HOST = "https://api.spotify.com";

    private String accessToken;

    public AbstractApiResource() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public AbstractApiResource withAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    private HttpRequestFactory getRequestFactory() {
        final Credential credential = new Credential(BearerToken.authorizationHeaderAccessMethod())
                .setAccessToken(accessToken);
        return HTTP_TRANSPORT.createRequestFactory(credential);
    }

    private GenericUrl getUrl(String endpoint) {
        return new GenericUrl(HOST + endpoint);
    }

    private  <T> T parseAs(HttpResponse response, TypeReference<T> typeReference) throws IOException {
        return OBJECT_MAPPER.readValue(response.getContent(), typeReference);
    }

    protected  <T> T get(String path, TypeReference<T> typeReference) throws IOException {
        final HttpResponse response = getRequestFactory().buildGetRequest(getUrl(path)).execute();
        return parseAs(response, typeReference);
    }
}
