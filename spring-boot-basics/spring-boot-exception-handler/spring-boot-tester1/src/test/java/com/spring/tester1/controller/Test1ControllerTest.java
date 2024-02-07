package com.spring.tester1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.tester1.model.Product;
import com.spring.tester1.service.ProductService;
import feign.FeignException;
import feign.Request;
import feign.Response;
import feign.Util;
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

import java.nio.charset.StandardCharsets;
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

    // 报错 java.lang.IllegalStateException: original request is required
    // 使用以下mock的异常能够进行指定的catch条件
    // doThrow(new RuntimeException("test exception")).when(productService).testInsertProduct(anyString(), any(Product.class));
    @Test
    void testInsertProductWithFeignException() throws Exception {
        byte[] content = getRequestBodyContent();
        ProductService productService = Mockito.mock(ProductService.class);
        // TODO. 创建自定义Feign Client请求返回的Response
        Response response = Response.builder()
                .status(400)
                .reason("bad request body")
                .headers(Collections.emptyMap())
                .request(Request.create(Request.HttpMethod.POST, "/products/test/2", Collections.emptyMap(), null, Util.UTF_8))
                .body("Product already exists", StandardCharsets.UTF_8)
                .build();

        doThrow(FeignException.errorStatus("method key test", response))
                .when(productService).testInsertProduct(anyString(), any(Product.class));
        mockMvc.perform(post("/products/test/2")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(content().string("Product already exists"));
    }

    // 报错 org.springframework.web.util.NestedServletException: Request processing failed;
    // 后端的server没有启动，所以无法测试
    @Test
    void testInsertProductWithExceptionAndResponseBody() throws Exception {
        byte[] content = getRequestBodyContent();
        ProductService productService = Mockito.mock(ProductService.class);
        // TODO. 这种直接返回new ResponseEntity<>的方式，
        //       不会进入 } catch (FeignException exception) {的条件
        Mockito.doReturn(new ResponseEntity<>("Product already exists 11", HttpStatus.BAD_REQUEST))
                .when(productService).testInsertProduct(anyString(), any(Product.class));
        mockMvc.perform(post("/products/test/2")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(content().string("Product already exists"));
    }

    // 补充测试覆盖率，设置返回的ResponseEntity的另一个条件
    @Test
    void testInsertProductWithExceptionWithoutResponseBody() throws Exception {
        byte[] content = getRequestBodyContent();
        ProductService productService = Mockito.mock(ProductService.class);
        Mockito.when(productService.testInsertProduct(anyString(), any(Product.class)))
                .thenAnswer(invocationOnMock -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
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