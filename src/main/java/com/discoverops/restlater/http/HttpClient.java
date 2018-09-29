package com.discoverops.restlater.http;

import com.discoverops.restlater.domain.Request;
import com.discoverops.restlater.http.factory.HttpClientFactory;
import com.discoverops.restlater.http.factory.HttpRequestFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HttpClient {

    @Autowired
    HttpRequestFactory httpRequestFactory;

    @Autowired
    HttpClientFactory httpClientFactory;

    public HttpResponse execute(Request request) throws IOException {
        HttpUriRequest httpRequest = httpRequestFactory.create(request);
        org.apache.http.client.HttpClient httpClient = httpClientFactory.create();
        return httpClient.execute(httpRequest);
    }
}
