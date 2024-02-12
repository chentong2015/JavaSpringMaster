package spring.controller.web_test_client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest()
@AutoConfigureWebTestClient
public class SpringWebTestClient {

    @Autowired
    private WebTestClient webClient;

    @Test
    void whenGetBooksThenReturn() {
        webClient.get().uri("/")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(String.class)
                .isEqualTo("Spring Native and Beyond!");
    }
}
