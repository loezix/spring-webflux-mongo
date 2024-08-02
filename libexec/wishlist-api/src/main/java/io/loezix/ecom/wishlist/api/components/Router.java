package io.loezix.ecom.wishlist.api.components;

import io.loezix.ecom.wishlist.api.handlers.WishlistHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class Router {

  @Bean
  public RouterFunction<ServerResponse> root() {
    return route().path("/wishlist", r -> r
        .GET(WishlistHandler::handle)
      )
      .resources("/**", new ClassPathResource("public/"))
      .build()
      ;
  }
}
