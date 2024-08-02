package io.loezix.ecom.wishlist.domain;

import io.github.thibaultmeyer.cuid.CUID;

import java.time.Instant;

public record Wish(String wishId, Long date, String productId) {

  public Wish(String productId) {
    this(CUID.randomCUID2().toString(), Instant.now().toEpochMilli(), productId);
  }
}
