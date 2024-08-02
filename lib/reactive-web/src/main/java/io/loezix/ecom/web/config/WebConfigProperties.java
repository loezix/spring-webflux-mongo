package io.loezix.ecom.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "ecom.web")
public class WebConfigProperties {

  public static class Mapping {
    private String path;
    private List<String> origins;
    private List<String> methods;
    private List<String> allowedHeaders;
    private List<String> exposedHeaders;
    private Boolean allowCredentials;
    private Integer maxAge;

    public String getPath() {
      return path;
    }

    public void setPath(String path) {
      this.path = path;
    }

    public List<String> getOrigins() {
      return origins;
    }

    public void setOrigins(List<String> origins) {
      this.origins = origins;
    }

    public List<String> getMethods() {
      return methods;
    }

    public void setMethods(List<String> methods) {
      this.methods = methods;
    }

    public List<String> getAllowedHeaders() {
      return allowedHeaders;
    }

    public void setAllowedHeaders(List<String> allowedHeaders) {
      this.allowedHeaders = allowedHeaders;
    }

    public List<String> getExposedHeaders() {
      return exposedHeaders;
    }

    public void setExposedHeaders(List<String> exposedHeaders) {
      this.exposedHeaders = exposedHeaders;
    }

    public Boolean getAllowCredentials() {
      return allowCredentials;
    }

    public void setAllowCredentials(Boolean allowCredentials) {
      this.allowCredentials = allowCredentials;
    }

    public Integer getMaxAge() {
      return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
      this.maxAge = maxAge;
    }
  }

  public static class Cors {
    private List<Mapping> mappings;

    public List<Mapping> getMappings() {
      return mappings;
    }

    public void setMappings(List<Mapping> mappings) {
      this.mappings = mappings;
    }
  }

  private Integer port;
  private Cors cors;

  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public Cors getCors() {
    return cors;
  }

  public void setCors(Cors cors) {
    this.cors = cors;
  }

}
