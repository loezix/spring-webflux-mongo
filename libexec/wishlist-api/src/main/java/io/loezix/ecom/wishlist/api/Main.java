package io.loezix.ecom.wishlist.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = {"io.loezix.ecom.web", "io.loezix.ecom.wishlist"})
@EnableConfigurationProperties
public class Main {

  public static void main(String...args) {
    SpringApplication.run(Main.class, args);
  }
}
