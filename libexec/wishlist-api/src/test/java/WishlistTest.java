import io.loezix.ecom.wishlist.api.Main;
import io.loezix.ecom.wishlist.api.components.Router;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(classes = Main.class)
class WishlistTest {

  @Autowired
  private Router router;

  @Test
  void wishlist() {
    WebTestClient
      .bindToRouterFunction(router.root())
      .build()

      .get()
      .uri("/wishlist")
      .exchange()
      .expectStatus()
      .isOk();
  }
}
