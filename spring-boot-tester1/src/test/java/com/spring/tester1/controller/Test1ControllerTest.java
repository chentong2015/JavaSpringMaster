package com.spring.tester1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.ByteStreams;
import com.spring.tester1.model.Product;
import com.spring.tester1.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.FileInputStream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class Test1ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // TODO. 如何测试抛出的FeignException，返回指定的ResponseEntity<>
    @Test
    void testInsertProductWithExceptionAndResponseBody() throws Exception {
        // Resource resource = new ClassPathResource("products.json");
        // FileInputStream file = new FileInputStream(resource.getFile());
        // byte[] content = ByteStreams.toByteArray(file);

        Product product = new Product();
        product.setId("2");
        product.setName("test");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(product);
        byte[] content = json.getBytes();

        ProductService productService = Mockito.mock(ProductService.class);
        // Mockito.doReturn(new ResponseEntity<>("Product already exists", HttpStatus.BAD_REQUEST))
        //         .when(productService).testInsertProduct(anyString(), any(Product.class));

        Mockito.when(productService.testInsertProduct(anyString(), any(Product.class)))
                .thenAnswer(invocationOnMock ->
                        new ResponseEntity<>("Product already exists", HttpStatus.BAD_REQUEST)
                );
        // .thenReturn(new ResponseEntity<>("Product already exists", HttpStatus.BAD_REQUEST));

        mockMvc.perform(post("/products/test/2")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(content().string("Product already exists"));
    }

    @Test
    void testInsertProductWithExceptionWithoutResponseBody() throws Exception {
        Resource resource = new ClassPathResource("products.json");
        FileInputStream file = new FileInputStream(resource.getFile());
        byte[] content = ByteStreams.toByteArray(file);

        ProductService productService = Mockito.mock(ProductService.class);
        Mockito.when(productService.testInsertProduct("2", any(Product.class)))
                .thenReturn(new ResponseEntity<>(HttpStatus.BAD_REQUEST));

        mockMvc.perform(post("/products/test/2")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(content().string("error: without response body"));
    }
}