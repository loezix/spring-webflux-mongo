package io.loezix.ecom.wishlist.svc.documents;

import io.loezix.ecom.wishlist.domain.Wishlist;

public record CustomerWishlist(String customerId, Wishlist wishlist) {

  public CustomerWishlist(String customerId) {
    this(customerId, new Wishlist());
  }
}
