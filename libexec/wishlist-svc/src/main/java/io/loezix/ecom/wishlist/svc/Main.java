package io.loezix.ecom.wishlist.svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@SpringBootApplication(scanBasePackages = {"io.loezix.ecom.data", "io.loezix.ecom.wishlist.svc"}, nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class)
@EnableConfigurationProperties
public class Main {

  public static void main(String... args) {
    SpringApplication.run(Main.class, args);
  }
}
