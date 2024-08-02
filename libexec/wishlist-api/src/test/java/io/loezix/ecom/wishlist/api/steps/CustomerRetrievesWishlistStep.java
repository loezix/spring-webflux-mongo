package io.loezix.ecom.wishlist.api.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loezix.ecom.wishlist.api.WishlistIT;
import io.loezix.ecom.wishlist.domain.Wishlist;
import org.junit.jupiter.api.Assertions;

public class CustomerRetrievesWishlistStep {

  private Wishlist wishlist;

  private final WishlistIT wishlistIT;

  public CustomerRetrievesWishlistStep(WishlistIT wishlistIT) {
    this.wishlistIT = wishlistIT;
  }

  @When("the Customer retrieves his wishlist")
  public void the_customer_retrieves_his_wishlist() {
    this.wishlist = wishlistIT.retrieveWishlist("123456789").block();
  }

  @Then("the Customer receives a list of wishes inside his wishlist")
  public void the_customer_receives_a_list_wishes_inside_his_wishlist() {
    Assertions.assertNotNull(this.wishlist.wishes());
  }

}
