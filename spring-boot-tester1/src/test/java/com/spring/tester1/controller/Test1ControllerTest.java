package com.spring.tester1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.tester1.model.Product;
import com.spring.tester1.service.ProductService;
import feign.FeignException;
import feign.Response;
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

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class Test1ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // TODO. 测试抛出的FeignException ??
    @Test
    void testInsertProductWithFeignException() throws Exception {
        byte[] content = getRequestBodyContent();
        ProductService productService = Mockito.mock(ProductService.class);
        doThrow(FeignException.errorStatus("method key test",
                Response.builder().headers(Collections.emptyMap()).status(400).build()))
                .when(productService).testInsertProduct(anyString(), any(Product.class));
        mockMvc.perform(post("/products/test/2")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(content().string("Product already exists"));
    }

    // TODO. 通过指定异常状态的ResponseEntity<>来进入FeignException的捕获条件
    @Test
    void testInsertProductWithExceptionAndResponseBody() throws Exception {
        byte[] content = getRequestBodyContent();
        ProductService productService = Mockito.mock(ProductService.class);
        Mockito.doReturn(new ResponseEntity<>("Product already exists 11", HttpStatus.BAD_REQUEST))
                .when(productService).testInsertProduct(anyString(), any(Product.class));
        mockMvc.perform(post("/products/test/2")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(content().string("Product already exists"));
    }

    // 补充测试的覆盖率
    @Test
    void testInsertProductWithExceptionWithoutResponseBody() throws Exception {
        byte[] content = getRequestBodyContent();
        ProductService productService = Mockito.mock(ProductService.class);
        Mockito.when(productService.testInsertProduct(anyString(), any(Product.class)))
                .thenAnswer(invocationOnMock ->
                        new ResponseEntity<>(HttpStatus.BAD_REQUEST)
                );
        mockMvc.perform(post("/products/test/2")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(content().string("error: without response body"));
    }

    private byte[] getRequestBodyContent() throws JsonProcessingException {
        // Resource resource = new ClassPathResource("products.json");
        // FileInputStream file = new FileInputStream(resource.getFile());
        // byte[] content = ByteStreams.toByteArray(file);

        Product product = new Product();
        product.setId("2");
        product.setName("test");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(product);
        return json.getBytes();
    }
}