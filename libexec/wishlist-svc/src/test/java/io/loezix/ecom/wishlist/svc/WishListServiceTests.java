package io.loezix.ecom.wishlist.svc;

import io.loezix.ecom.wishlist.svc.documents.CustomerWishlist;
import io.loezix.ecom.wishlist.svc.services.WishlistService;
import io.loezix.ecom.wishlist.domain.Wish;
import io.loezix.ecom.wishlist.domain.Wishlist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

@SpringBootTest()
class WishListServiceTests {

  @Autowired
  ReactiveMongoTemplate reactiveMongoTemplate;

  @Autowired
  WishlistService wishlistService;

  @BeforeEach
  void setup() {

    reactiveMongoTemplate.dropCollection(CustomerWishlist.class)
      .as(StepVerifier::create) //
      .verifyComplete();

    var operation = reactiveMongoTemplate.insert(Mono.just(
      new CustomerWishlist("123456789", new Wishlist(List.of(new Wish("987654321"))))
    ));

    operation.as(StepVerifier::create).expectNextCount(1).verifyComplete();
  }

  @Test
  void wishList() {
    wishlistService.customerWishlist("123456789")
      .as(StepVerifier::create)
      .expectNextCount(1)
      .verifyComplete();
  }

  @Test
  void addWishToWishlist() {
    wishlistService.addWishToWishlist("123456789", "1234")
      .map(Wishlist::wishes)
      .flatMapMany(Flux::fromIterable)
      .as(StepVerifier::create)
      .expectNextCount(2)
      .verifyComplete();
  }

  @Test
  void hasProductOnWishlist() {
    wishlistService.hasProductOnWishlist("123456789", "987654321")
      .map(Wishlist::wishes)
      .flatMapMany(Flux::fromIterable)
      .as(StepVerifier::create)
      .expectNextCount(1)
      .verifyComplete();
  }

  @Test
  void removeWWishFromWishlist() {
    wishlistService.removeWishFromWishlist("123456789", "987654321")
      .map(Wishlist::wishes)
      .flatMapMany(Flux::fromIterable)
      .as(StepVerifier::create)
      .expectNextCount(0)
      .verifyComplete();
  }
}
