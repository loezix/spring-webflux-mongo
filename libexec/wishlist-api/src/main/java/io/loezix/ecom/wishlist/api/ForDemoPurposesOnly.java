package io.loezix.ecom.wishlist.api;

import io.loezix.ecom.wishlist.domain.Wish;
import io.loezix.ecom.wishlist.domain.Wishlist;
import io.loezix.ecom.wishlist.svc.documents.CustomerWishlist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ForDemoPurposesOnly {

  private static final Logger logger = LoggerFactory.getLogger(ForDemoPurposesOnly.class);
  private final ReactiveMongoTemplate reactiveMongoTemplate;

  public ForDemoPurposesOnly(ReactiveMongoTemplate reactiveMongoTemplate) {
    this.reactiveMongoTemplate = reactiveMongoTemplate;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void setup() {
    reactiveMongoTemplate.dropCollection(CustomerWishlist.class)
      .then(Mono.defer(() -> reactiveMongoTemplate.insert(
        Mono.just(new CustomerWishlist("123456789", new Wishlist(List.of(new Wish("987654321"))))
        ))))
      .doOnSuccess(cwl -> logger.info("Inserted customer 123456789, you're welcome"))
      .subscribe();
  }
}
