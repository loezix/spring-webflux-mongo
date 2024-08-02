package io.loezix.ecom.wishlist.domain;

import io.github.thibaultmeyer.cuid.CUID;

import java.time.Instant;

public record Wish(String wishId, Long date, String productId) {

  public Wish {
    wishId = CUID.randomCUID2().toString();
    date = Instant.now().toEpochMilli();
  }

  public Wish(String productId) {
    this(null, null, productId);
  }
}
