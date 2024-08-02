package io.loezix.ecom.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "ecom")
public class ConfigProperties {
  public Map<String, ?> web;
}
