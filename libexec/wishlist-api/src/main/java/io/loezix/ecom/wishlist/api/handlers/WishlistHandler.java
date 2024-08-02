package io.loezix.ecom.wishlist.api.handlers;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

public class WishlistHandler {

  public static Mono<ServerResponse> handle(ServerRequest request) {
    return ok().contentType(MediaType.APPLICATION_JSON).bodyValue(
      """
        {
          "wishlist": [
            {"wishId": 1234, "date": "20240721T13:42:65", "productId": 514236985},
            {"wishId": 5678, "date": "20240721T13:43:65", "productId": 236958},
            {"wishId": 12345, "date": "20240722T13:42:65", "productId": 142562},
            {"wishId": 54321, "date": "20240401T13:42:65", "productId": 7542369}
          ]
        }
      """
    );
  }
}
