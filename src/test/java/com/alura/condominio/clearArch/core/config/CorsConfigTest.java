package com.alura.condominio.clearArch.core.config;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CorsConfigTest {

    @Test
    void deveCriarCorsConfigurer() {
        CorsConfig corsConfig = new CorsConfig();
        WebMvcConfigurer configurer = corsConfig.corsConfigurer();
        
        assertNotNull(configurer);
    }

    @Test
    void deveConfigurarCorsMappings() {
        CorsConfig corsConfig = new CorsConfig();
        WebMvcConfigurer configurer = corsConfig.corsConfigurer();
        
        CorsRegistry registry = mock(CorsRegistry.class);
        CorsRegistration registration = mock(CorsRegistration.class);
        
        when(registry.addMapping("/**")).thenReturn(registration);
        when(registration.allowedOrigins("*")).thenReturn(registration);
        when(registration.allowedMethods(any())).thenReturn(registration);
        when(registration.allowedHeaders("*")).thenReturn(registration);
        
        configurer.addCorsMappings(registry);
        
        verify(registry).addMapping("/**");
        verify(registration).allowedOrigins("*");
        verify(registration).allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS");
        verify(registration).allowedHeaders("*");
    }
}
