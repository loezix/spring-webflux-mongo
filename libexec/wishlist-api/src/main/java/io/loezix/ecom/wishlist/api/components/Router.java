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

  private final WishlistHandler wishlistHandler;

  public Router(WishlistHandler wishlistHandler) {
    this.wishlistHandler = wishlistHandler;
  }

  @Bean
  public RouterFunction<ServerResponse> root() {
    return route().path("/customer/{customerId}/wishlist", r -> r
        .GET("", wishlistHandler::handleCustomerWishlist)
        .PATCH("/wishes/add", wishlistHandler::handleAddWishToWishlist)
        .PATCH("/wishes/remove", wishlistHandler::handleRemoveWishFromWishlist)
        .GET("/wishes/hasWishedProduct", wishlistHandler::handleHasProductOnWishlist)
      )
      .resources("/**", new ClassPathResource("public/"))
      .build()
      ;
  }
}
