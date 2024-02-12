package spring.controller.mock_mvc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.InputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcIT2 {

    @Autowired
    private MockMvc mockMvc;

    // 使用模拟的账号进行安全登陆，进行测试
    @Test
    @WithMockUser(username = "ctong", password = "ctong123")
    void get_index() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/index").accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Index Page"));
        } catch (Exception exception) {
            System.out.println("Error");
        }
    }

    @Test
    void test_with_param() throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/accounts/login.action")
                        .param("username", "20116524")
                        .param("password", "Password"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isSuccessful").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isUsernameEmpty").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isPasswordEmpty").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isAccountValid").value(false))
                .andReturn();
        Assertions.assertNotNull(result);
    }

    // TODO. 提供的JSON格式的数据流和发送请求的contentType类型必须保持一致
    // 从classpath资源文件路径添加测试数据
    @Test
    void testPostMethod() throws Exception {
        InputStream resourceStream = this.getClass().getResourceAsStream("myObject.json");
        assert resourceStream != null;
        mockMvc.perform(post("/post")
                        .content(resourceStream.readAllBytes())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("OK"));
    }
}
