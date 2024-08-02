package io.loezix.ecom.wishlist.api;

import io.cucumber.spring.CucumberContextConfiguration;
import io.loezix.ecom.web.types.Message;
import io.loezix.ecom.wishlist.api.components.Router;
import io.loezix.ecom.wishlist.domain.Wish;
import io.loezix.ecom.wishlist.domain.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@CucumberContextConfiguration
@SpringBootTest(classes = Main.class)
class WishlistIntegrationTest {

  @Autowired
  private Router router;

  public Mono<Wishlist> retrieveWishlist(String customerId) {
    return WebTestClient.bindToRouterFunction(router.root())
      .build()
      .get()
      .uri(String.format("/customer/%s/wishlist", customerId))
      .exchange()
      .returnResult(Wishlist.class)
      .getResponseBody()
      .singleOrEmpty()
      ;
  }

  public Mono<Wishlist> addProductToWishlist(String customerId, String productId) {
    return WebTestClient.bindToRouterFunction(router.root())
      .build()
      .patch()
      .uri(String.format("/customer/%s/wishlist/wishes/add", customerId))
      .body(Mono.just(new Wish(productId)), Wish.class)
      .exchange()
      .returnResult(Wishlist.class)
      .getResponseBody()
      .singleOrEmpty()
      ;
  }

  public Mono<Wishlist> removeProductFromWishlist(String customerId, String productId) {
    return WebTestClient.bindToRouterFunction(router.root())
      .build()
      .patch()
      .uri(String.format("/customer/%s/wishlist/wishes/remove", customerId))
      .body(Mono.just(new Wish(productId)), Wish.class)
      .exchange()
      .returnResult(Wishlist.class)
      .getResponseBody()
      .singleOrEmpty()
      ;
  }

  public Mono<Message> hasProductOnWishlist(String customerId, String productId) {
    return WebTestClient.bindToRouterFunction(router.root())
      .build()
      .get()
      .uri(builder -> builder.path(String.format("/customer/%s/wishlist/wishes/hasWishedProduct", customerId))
        .queryParam("productId", productId)
        .build()
      )
      .exchange()
      .returnResult(Message.class)
      .getResponseBody()
      .singleOrEmpty()
      ;
  }
}
