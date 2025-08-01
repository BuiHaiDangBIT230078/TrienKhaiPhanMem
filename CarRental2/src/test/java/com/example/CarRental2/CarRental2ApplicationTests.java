package com.example.CarRental2;  // Đảm bảo package đúng với thư mục

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest  // Thêm dòng này để tải context Spring Boot
public class CarRental2ApplicationTests {

    @Test
    void contextLoads() {
        assertTrue(true);  // Test đơn giản
    }
}