package io.loezix.ecom.wishlist.domain;

import java.util.List;

public record Wishlist(List<Wish> wishes) {

  public Wishlist() {
    this(List.of());
  }
}
