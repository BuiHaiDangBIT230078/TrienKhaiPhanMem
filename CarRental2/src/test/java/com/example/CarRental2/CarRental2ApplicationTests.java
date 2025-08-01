package com.example.CarRental2;  // Phải khớp với thư mục src/test/java/com/example/CarRental2

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest  // Tải context Spring Boot tự động
// Hoặc nếu cần chỉ định class chính: @SpringBootTest(classes = CarRental2Application.class)
public class CarRental2ApplicationTests {

    @Test
    void contextLoads() {
        assertTrue(true);  // Test đơn giản để kiểm tra context
    }
}