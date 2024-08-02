package io.loezix.ecom.wishlist.svc.services;

import io.loezix.ecom.data.services.ReactiveService;
import io.loezix.ecom.wishlist.svc.data.WishlistRepository;
import io.loezix.ecom.wishlist.svc.documents.CustomerWishlist;
import io.loezix.ecom.wishlist.domain.Wishlist;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class WishlistService extends ReactiveService<CustomerWishlist, WishlistRepository> {

  public WishlistService(WishlistRepository repository) {
    super(repository);
  }

  /**
   * Consultar todos os produtos da Wishlist do cliente
   */
  public Mono<Wishlist> customerWishlist(String customerId) {
    return repository().customerWishlist(customerId)
      .map(CustomerWishlist::wishlist)
      ;
  }

  /**
   * Adicionar um produto na Wishlist do cliente;
   */
  public Mono<Wishlist> addWishToWishlist(String customerId, String productId) {
    return hasProductOnWishlist(customerId, productId)
      .switchIfEmpty(repository().addWishToWishlist(customerId, productId)
        .map(CustomerWishlist::wishlist))
      ;
  }

  /**
   * Remover um produto da Wishlist do cliente;
   */
  public Mono<Wishlist> removeWishFromWishlist(String customerId, String productId) {
    return repository().removeWishFromWishlist(customerId, productId)
      .map(CustomerWishlist::wishlist)
      ;
  }

  /**
   * Consultar se um determinado produto está na Wishlist do cliente;;
   */
  public Mono<Wishlist> hasProductOnWishlist(String customerId, String productId) {
    return repository().hasProduct(customerId, productId)
      .map(CustomerWishlist::wishlist)
      ;
  }
}
