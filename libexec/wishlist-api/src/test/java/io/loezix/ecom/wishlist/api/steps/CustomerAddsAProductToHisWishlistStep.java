package io.loezix.ecom.wishlist.api.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.thibaultmeyer.cuid.CUID;
import io.loezix.ecom.wishlist.api.WishlistIT;
import io.loezix.ecom.wishlist.domain.Wishlist;
import org.junit.jupiter.api.Assertions;

import java.util.stream.IntStream;

public class CustomerAddsAProductToHisWishlistStep {

  private Wishlist wishlist;
  private final WishlistIT wishlistIT;

  public CustomerAddsAProductToHisWishlistStep(WishlistIT wishlistIT) {
    this.wishlistIT = wishlistIT;
  }

  @When("the Customer adds a product to his wishlist")
  public void the_customer_adds_a_product_to_his_wishlist() {
    this.wishlist = wishlistIT.addProductToWishlist("123456789", "ABC456789").block();
    Assertions.assertNotNull(this.wishlist.wishes());
  }

  @Then("the added product should be in his list of wishes")
  public void the_added_product_should_be_in_his_list_of_wishes() {
    var count = this.wishlist.wishes().stream().filter(wish -> wish.productId().equals("ABC456789")).count();
    Assertions.assertEquals(1L, count);
  }

  @And("the Customer wishlist cannot exceed 20 items")
  public void the_customer_wishlist_cannot_exceed_20_items() {
    IntStream.range(1, 21).forEach(i -> wishlistIT.addProductToWishlist("123456789", CUID.randomCUID2().toString()).block());
    this.wishlist = wishlistIT.retrieveWishlist("123456789").block();
    Assertions.assertNotNull(this.wishlist.wishes());
    var count = (long) this.wishlist.wishes().size();
    Assertions.assertEquals(20L, count);
  }
}
