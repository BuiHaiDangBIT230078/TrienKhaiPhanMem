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

    // Mock TẤT CẢ service trong HomePageController
    @MockBean
    private com.project.CarRental2.service.UserService userService;

    @MockBean
    private com.project.CarRental2.service.ProvinceService provinceService;

    @MockBean
    private com.project.CarRental2.service.CarService carService;

    @MockBean
    private com.project.CarRental2.service.DistrictService districtService;

    @MockBean
    private com.project.CarRental2.service.BookingService bookingService;

    @MockBean
    private com.project.CarRental2.service.BlogService blogService;

    @MockBean
    private com.project.CarRental2.service.InsuranceService insuranceService;

    @MockBean
    private com.project.CarRental2.service.ContractService contractService;

    @MockBean
    private com.project.CarRental2.service.NotificationService notificationService;

    @MockBean
    private com.project.CarRental2.service.DetailNotificationService detailNotificationService;

    @MockBean
    private com.project.CarRental2.service.RequestWithdrawalService requestWithdrawalService;

    @Test
    void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}