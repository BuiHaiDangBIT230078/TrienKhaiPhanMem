package com.example.CarRental2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@SpringBootTest
@AutoConfigureMockMvc
class CarRental2ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    // Test cơ bản cho trang chủ (GET /), kiểm tra trả về view "index" nếu không có session (giả sử không redirect)
    @Test
    void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    // Test cơ bản cho trang login (GET /login), kiểm tra trả về view "pages/login"
    @Test
    void testLoginPage() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("pages/login"));
    }

    // Test cơ bản cho trang đăng ký (GET /sign-up), kiểm tra trả về view "pages/resgiter"
    @Test
    void testSignUpPage() throws Exception {
        mockMvc.perform(get("/sign-up"))
                .andExpect(status().isOk())
                .andExpect(view().name("pages/resgiter"));
    }

    // Test cơ bản cho trang hỗ trợ (GET /help), kiểm tra trả về view "pages/help"
    @Test
    void testHelpPage() throws Exception {
        mockMvc.perform(get("/help"))
                .andExpect(status().isOk())
                .andExpect(view().name("pages/help"));
    }

    // Test cơ bản cho trang liên hệ (GET /contact), kiểm tra trả về view "pages/contact"
    @Test
    void testContactPage() throws Exception {
        mockMvc.perform(get("/contact"))
                .andExpect(status().isOk())
                .andExpect(view().name("pages/contact"));
    }

    // Test cơ bản cho logout (GET /logout), kiểm tra redirect về trang chủ
    @Test
    void testLogout() throws Exception {
        mockMvc.perform(get("/logout"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    // Test cơ bản cho POST /login (giả sử dữ liệu không hợp lệ, redirect về /login với flash message)
    @Test
    void testLoginPostInvalid() throws Exception {
        mockMvc.perform(post("/login")
                .param("username", "invalid")
                .param("password", "invalid"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }

    // Test cơ bản cho trang blog (GET /blog), kiểm tra trả về view "pages/blog"
    @Test
    void testBlogPage() throws Exception {
        mockMvc.perform(get("/blog"))
                .andExpect(status().isOk())
                .andExpect(view().name("pages/blog"));
    }

    // Lưu ý: Các test này là cơ bản, không mock service hoặc session đầy đủ. Để test chi tiết hơn, cần sử dụng @MockBean cho các service và mock session nếu cần.
}