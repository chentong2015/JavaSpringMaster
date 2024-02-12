package spring.controller.mock_mvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import spring.controller.HomeController;
import spring.controller.HomeControllerAdvice;
import spring.service.HomeService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 不使用注解，而是使用MockMvcBuilders来build构建MockMvc
public class MockMvcBuilderIT {

    private MockMvc mockMvc;
    private HomeController homeController;

    // TODO. 如果要测试ExceptionHandler的处理，则必须设置注定的ControllerAdvice
    @BeforeEach
    public void init() {
        HomeService homeService = Mockito.mock(HomeService.class);
        homeController = new HomeController(homeService);
        mockMvc = MockMvcBuilders.standaloneSetup(homeController)
                .setControllerAdvice(new HomeControllerAdvice())
                .build();
    }

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(content().string("Index Page"));
    }
}
