package io.loezix.ecom.wishlist.api.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loezix.ecom.wishlist.api.WishlistIT;
import io.loezix.ecom.wishlist.domain.Wishlist;
import org.junit.jupiter.api.Assertions;

public class CustomerRemovesAProductFromHisWishListStep {

  private Wishlist wishlist;
  private final WishlistIT wishlistIT;

  public CustomerRemovesAProductFromHisWishListStep(WishlistIT wishlistIT) {
    this.wishlistIT = wishlistIT;
  }

  @When("the Customer removes a product from his wishlist")
  public void the_customer_removes_a_product_from_his_wishlist() {
    this.wishlist = wishlistIT.removeProductFromWishlist("123456789", "ABC456789").block();
    Assertions.assertNotNull(this.wishlist.wishes());
  }

  @Then("the removed product should not be in his list of wishes")
  public void the_removed_product_should_not_be_in_his_list_of_wishes() {
    var count = this.wishlist.wishes().stream().filter(wish -> wish.productId().equals("ABC456789")).count();
    Assertions.assertEquals(0L, count);
  }

}
