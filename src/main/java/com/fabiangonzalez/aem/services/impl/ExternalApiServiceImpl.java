package com.fabiangonzalez.aem.services.impl;

import com.fabiangonzalez.aem.services.ExternalApiService;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Content;
import org.osgi.service.component.annotations.Component;

@Component(service = ExternalApiService.class, immediate = true)
public class ExternalApiServiceImpl implements ExternalApiService {

    private static final String API_URL = "https://dummyjson.com/posts";

    @Override
    public String getExternalPosts() {
        try {
            Content content = Request.Get(API_URL)
                    .connectTimeout(3000)
                    .socketTimeout(3000)
                    .execute()
                    .returnContent();
            return content.asString();
        } catch (Exception e) {
            return "{\"error\": \"No se pudo obtener datos\"}";
        }
    }
}
