package io.loezix.ecom.wishlist.svc.data;

import io.loezix.ecom.data.data.ReactiveRepository;
import io.loezix.ecom.wishlist.svc.documents.CustomerWishlist;
import io.loezix.ecom.wishlist.domain.Wish;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Repository
public class WishlistRepository implements ReactiveRepository<CustomerWishlist> {

  private final ReactiveMongoTemplate reactiveMongoTemplate;

  private final Function<String, Criteria> customerIdEq = customerId -> Criteria.where("customerId").is(customerId);
  private final Function<String, Criteria> productIdEq = productId -> Criteria.where("productId").is(productId);
  private static final String WISHES = "wishlist.wishes";

  public WishlistRepository(ReactiveMongoTemplate reactiveMongoTemplate) {
    this.reactiveMongoTemplate = reactiveMongoTemplate;
  }

  public Mono<CustomerWishlist> customerWishlist(String customerId) {
    var query = Query.query(customerIdEq.apply(customerId));
    return reactiveMongoTemplate.findOne(query, CustomerWishlist.class);
  }

  public Mono<CustomerWishlist> addWishToWishlist(String customerId, String productId) {
    var query = Query.query(customerIdEq.apply(customerId));
    return reactiveMongoTemplate.update(CustomerWishlist.class)
      .matching(query)
      .apply(new Update().push(WISHES, new Wish(productId)))
      .findAndModify()
      .flatMap(customerWishlist -> customerWishlist(customerWishlist.customerId()));
  }

  public Mono<CustomerWishlist> removeWishFromWishlist(String customerId, String productId) {
    var query = Query.query(customerIdEq.apply(customerId));
    var removeCriteria = Query.query(productIdEq.apply(productId));
    return reactiveMongoTemplate.update(CustomerWishlist.class)
      .matching(query)
      .apply(new Update().pull(WISHES, removeCriteria))
      .findAndModify()
      .flatMap(customerWishlist -> customerWishlist(customerWishlist.customerId()));
  }

  public Mono<CustomerWishlist> hasProduct(String customerId, String productId) {
    var query = Query.query(customerIdEq.apply(customerId))
      .addCriteria(Criteria.where(WISHES).elemMatch(productIdEq.apply(productId)));
    return reactiveMongoTemplate.findOne(query, CustomerWishlist.class);
  }
}
