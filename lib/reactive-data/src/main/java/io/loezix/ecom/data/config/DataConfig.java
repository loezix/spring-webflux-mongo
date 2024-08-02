package io.loezix.ecom.data.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;

@Configuration
public class DataConfig {

  private final DataConfigProperties config;

  public DataConfig(DataConfigProperties config) {
    this.config = config;
  }

  @Bean
  public MongoClient mongoClient() {
    return MongoClients.create(config.getConnectionString());
  }

  @Bean
  public ReactiveMongoDatabaseFactory reactiveMongoDatabaseFactory() {
    return new SimpleReactiveMongoDatabaseFactory(mongoClient(), config.getDatabase());
  }

  @Bean
  public ReactiveMongoTemplate reactiveMongoTemplate() {
    return new ReactiveMongoTemplate(reactiveMongoDatabaseFactory());
  }
}
