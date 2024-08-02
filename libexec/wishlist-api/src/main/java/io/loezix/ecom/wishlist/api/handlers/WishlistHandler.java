package io.loezix.ecom.wishlist.api.handlers;

import io.loezix.ecom.web.types.Message;
import io.loezix.ecom.wishlist.domain.Wish;
import io.loezix.ecom.wishlist.svc.services.WishlistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
public class WishlistHandler {

  private final WishlistService service;

  private static final String CUSTOMER_ID = "customerId";

  public WishlistHandler(WishlistService service) {
    this.service = service;
  }

  public Mono<ServerResponse> handleCustomerWishlist(ServerRequest request) {
    return service.customerWishlist(request.pathVariable(CUSTOMER_ID))
      .flatMap(wishlist -> ok().contentType(MediaType.APPLICATION_JSON).bodyValue(wishlist))
      .switchIfEmpty(notFound().build())
      ;
  }

  public Mono<ServerResponse> handleAddWishToWishlist(ServerRequest request) {
        return service.customerWishlist(request.pathVariable(CUSTOMER_ID))
      .flatMap(wishlist -> {
        return wishlist.wishes().size() >= 20
          ? ServerResponse.status(HttpStatus.FORBIDDEN).bodyValue(new Message("Limite de desejos por cliente excedido"))
          : request.bodyToMono(Wish.class)
      .flatMap(wish -> service.addWishToWishlist(request.pathVariable(CUSTOMER_ID), wish.productId())
        .flatMap(wishlist1 -> ok().contentType(MediaType.APPLICATION_JSON).bodyValue(wishlist1))
        .switchIfEmpty(notFound().build()));
        })
      ;
  }

  public Mono<ServerResponse> handleRemoveWishFromWishlist(ServerRequest request) {
    return request.bodyToMono(Wish.class)
      .flatMap(wish -> service.removeWishFromWishlist(request.pathVariable(CUSTOMER_ID), wish.productId())
        .flatMap(wishlist -> ok().contentType(MediaType.APPLICATION_JSON).bodyValue(wishlist))
        .switchIfEmpty(notFound().build()))
      ;
  }

  public Mono<ServerResponse> handleHasProductOnWishlist(ServerRequest request) {
    return request.queryParam("productId")
      .map(productId -> service.hasProductOnWishlist(request.pathVariable(CUSTOMER_ID), productId)
        .flatMap(wishlist -> ok().contentType(MediaType.APPLICATION_JSON).bodyValue(new Message("O produto está presente na lista de desejos do cliente.")))
        .switchIfEmpty(ok().contentType(MediaType.APPLICATION_JSON).bodyValue(new Message("O produto não foi encontrado na lista de desejos do cliente."))))
      .orElse(badRequest().bodyValue(new Message("Necessário parâmetro de pesquisa `productId`")))
      ;
  }

}
