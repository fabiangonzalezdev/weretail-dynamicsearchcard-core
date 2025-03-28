package com.fabiangonzalez.aem.servlets;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(AemContextExtension.class)
public class SearchCardServletTest {

    private final AemContext context = new AemContext();
    private SearchCardServlet servlet;

    @BeforeEach
    void setUp() {
        servlet = new SearchCardServlet();
        assertNotNull(servlet);
    }

    @Test
    void testServletInitialization() {
        assertNotNull(servlet);
    }
}
