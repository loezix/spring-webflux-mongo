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
public class CustomerRetrievesWishlistTest extends WishlistIntegrationTest {

  private Wishlist wishlist;

  @When("the Customer retrieves his wishlist")
  public void the_customer_retrieves_his_wishlist() {
    this.wishlist = retrieveWishlist("123456789").block();
  }

  @Then("the Customer receives a list of wishes inside his wishlist")
  public void the_customer_receives_a_list_wishes_inside_his_wishlist() {
    Assertions.assertNotNull(this.wishlist.wishes());
  }

}
