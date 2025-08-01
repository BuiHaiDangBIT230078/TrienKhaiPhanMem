package com.example.CarRental2;  // Sửa package để khớp với dự án (com.project.CarRental2)

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = com.project.CarRental2.CarRental2Application.class)  // Chỉ định rõ class chính của ứng dụng
public class CarRental2ApplicationTests {

    @Test
    void contextLoads() {
        assertTrue(true);  // Test đơn giản để kiểm tra context
    }
}