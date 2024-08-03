package io.loezix.ecom.wishlist.api.steps.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest
public class CucumberSpringConfig {

  @TestConfiguration
  static class SpringTest {}
}
