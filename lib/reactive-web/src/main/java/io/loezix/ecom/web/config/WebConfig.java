package io.loezix.ecom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class WebConfig implements WebFluxConfigurer {

  private final ConfigProperties config;

  public WebConfig(ConfigProperties config) {
    this.config = config;
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {

    config.web.get("mappings");

    registry.addMapping("/")
      .allowedOrigins("*")
      .allowedMethods("PUT", "DELETE")
      .allowedHeaders("header1", "header2", "header3")
      .exposedHeaders("header1", "header2")
      .allowCredentials(true).maxAge(3600);

    // Add more mappings...
  }
}
