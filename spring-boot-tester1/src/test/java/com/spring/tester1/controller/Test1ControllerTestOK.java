package com.spring.tester1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.tester1.exception.TestHandlerException;
import com.spring.tester1.model.Product;
import com.spring.tester1.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class Test1ControllerTestOK {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testInsertProductWithExceptionWithoutResponseBody() throws Exception {
        byte[] content = getRequestBodyContent();
        ProductService productService = Mockito.mock(ProductService.class);
        Mockito.when(productService.testInsertProduct(anyString(), any(Product.class)))
                .thenThrow(new TestHandlerException("Product already exists"));
        mockMvc.perform(post("/products/handler/2")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(content().string("Product already exists"));
    }

    private byte[] getRequestBodyContent() throws JsonProcessingException {
        Product product = new Product();
        product.setId("2");
        product.setName("test");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(product);
        return json.getBytes();
    }
}