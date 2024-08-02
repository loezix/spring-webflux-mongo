package io.loezix.ecom.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class WebConfig implements WebFluxConfigurer {

  private final WebConfigProperties config;

  public WebConfig(WebConfigProperties config) {
    this.config = config;
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    config.getCors().getMappings().forEach(mapping -> {
      registry.addMapping(mapping.getPath())
        .allowedOrigins(mapping.getOrigins().toArray(new String[0]))
        .allowedMethods(mapping.getMethods().toArray(new String[0]))
        .allowedHeaders(mapping.getAllowedHeaders().toArray(new String[0]))
        .exposedHeaders(mapping.getExposedHeaders().toArray(new String[0]))
        .allowCredentials(mapping.getAllowCredentials())
        .maxAge(mapping.getMaxAge());
    });
  }
}
