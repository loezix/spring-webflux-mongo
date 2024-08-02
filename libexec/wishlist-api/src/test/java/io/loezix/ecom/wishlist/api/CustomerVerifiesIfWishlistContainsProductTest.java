package io.loezix.ecom.wishlist.api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.loezix.ecom.web.types.Message;
import io.loezix.ecom.wishlist.domain.Wishlist;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features")
public class CustomerVerifiesIfWishlistContainsProductTest extends WishlistIntegrationTest {

  private Wishlist wishlist;
  private static final String IF_EXISTS = "O produto está presente na lista de desejos do cliente.";
  private static final String IF_DOESNT_EXIST = "O produto não foi encontrado na lista de desejos do cliente.";
  private Message message;

  @When("the Customer verifies if a product is in his wishlist")
  public void the_customer_verifies_if_a_product_is_in_his_wishlist() {
    addProductToWishlist("123456789", "ABC456789").block();
    message = hasProductOnWishlist("123456789", "ABC456789").block();
    Assertions.assertNotNull(message);
  }

  @Then("if the product exists, the message should be")
  public void if_the_product_exists_the_message_should_be() {
    Assertions.assertEquals(IF_EXISTS, message.message());
  }

  @Then("and if Not then the message should be")
  public void and_if_not_then_the_message_should_be() {
    message = hasProductOnWishlist("123456789", "DEF987654").block();
    Assertions.assertEquals(IF_DOESNT_EXIST, message.message());
  }

}
