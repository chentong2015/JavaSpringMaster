package com.spring.tester1.controller;

import com.spring.tester1.model.Product;
import com.spring.tester1.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.SerializationUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

// 添加IT测试注解，并自动装配MockMvc，才能完成自动注入
@SpringBootTest
@AutoConfigureMockMvc
class Test1ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void beforeEach() {
        // do something before unit test
    }

    @Test
    void testInsertProduct() throws Exception {
        // InputStream resourceAsStream = this.getClass().getResourceAsStream("products.json");
        // byte[] content = ByteStreams.toByteArray(resourceAsStream);
        Product product = new Product();
        product.setId("2");
        product.setName("test");
        byte[] content = SerializationUtils.serialize(product);

        // Mock掉ProductService Feign Client返回的结果
        ProductService productService = Mockito.mock(ProductService.class);
        // 使用build模式来构建
        // FeignException exception = FeignException.errorStatus("methodKey",
        //         Response.builder().request(new).body("Product already exists".getBytes()).build());

        Mockito.when(productService.testInsertProduct("2", product))
                .thenReturn(new ResponseEntity<>("Product already exists", HttpStatus.BAD_REQUEST));

        mockMvc.perform(post("/products/test/2")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(content().string("Product already exists"));
        // .andExpect(result -> assertTrue(result.getResolvedException() instanceof FeignException));
        // .andExpect(result -> assertEquals("bad arguments", result.getResolvedException().getMessage()));
    }
}