package com.fabiangonzalez.aem.servlets;

import com.fabiangonzalez.aem.services.ExternalApiService;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import javax.servlet.Servlet;
import java.io.IOException;

@Component(
        service = Servlet.class,
        property = {
                "sling.servlet.paths=/bin/api/searchcards",
                "sling.servlet.methods=GET"
        }
)
public class SearchCardServlet extends SlingAllMethodsServlet {

    @Reference
    private ExternalApiService externalApiService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        String jsonData = externalApiService.getExternalPosts();
        response.getWriter().write(jsonData);
    }
}
