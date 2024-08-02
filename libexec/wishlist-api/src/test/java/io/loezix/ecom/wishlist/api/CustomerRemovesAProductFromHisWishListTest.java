package io.loezix.ecom.wishlist.api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.loezix.ecom.wishlist.domain.Wishlist;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features")
public class CustomerRemovesAProductFromHisWishListTest extends WishlistIntegrationTest {

  private Wishlist wishlist;

  @When("the Customer removes a product from his wishlist")
  public void the_customer_removes_a_product_from_his_wishlist() {
    this.wishlist = removeProductFromWishlist("123456789", "ABC456789").block();
    Assertions.assertNotNull(this.wishlist.wishes());
  }

  @Then("the removed product should not be in his list of wishes")
  public void the_removed_product_should_not_be_in_his_list_of_wishes() {
    var count = this.wishlist.wishes().stream().filter(wish -> wish.productId().equals("ABC456789")).count();
    Assertions.assertEquals(0L, count);
  }

}
