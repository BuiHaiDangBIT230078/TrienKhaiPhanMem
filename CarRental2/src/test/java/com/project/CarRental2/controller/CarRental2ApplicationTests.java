package com.project.CarRental2.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HomePageController.class)
class HomePageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Mock chỉ các service cần thiết cho endpoint GET /
    @MockBean
    private com.project.CarRental2.service.ProvinceService provinceService;

    @MockBean
    private com.project.CarRental2.service.CarService carService;

    @MockBean
    private com.project.CarRental2.service.InsuranceService insuranceService;

    @MockBean
    private com.project.CarRental2.service.DetailNotificationService detailNotificationService;

    @Test
    void testHomePage() throws Exception {
        // Gửi request GET /
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}