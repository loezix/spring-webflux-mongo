package io.loezix.ecom.data.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ecom.data")
public class DataConfigProperties {

  private String database;
  private String connectionString;

  public String getDatabase() {
    return database;
  }

  public void setDatabase(String database) {
    this.database = database;
  }

  public String getConnectionString() {
    return connectionString;
  }

  public void setConnectionString(String connectionString) {
    this.connectionString = connectionString;
  }
}
