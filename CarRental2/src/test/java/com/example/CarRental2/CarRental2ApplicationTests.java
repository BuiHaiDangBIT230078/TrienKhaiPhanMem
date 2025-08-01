package com.example.CarRental2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.project.CarRental2.controller.HomePageController;
import com.project.CarRental2.service.BlogService;
import com.project.CarRental2.service.BookingService;
import com.project.CarRental2.service.CarService;
import com.project.CarRental2.service.ContractService;
import com.project.CarRental2.service.DetailNotificationService;
import com.project.CarRental2.service.DistrictService;
import com.project.CarRental2.service.InsuranceService;
import com.project.CarRental2.service.NotificationService;
import com.project.CarRental2.service.ProvinceService;
import com.project.CarRental2.service.RequestWithdrawalService;
import com.project.CarRental2.service.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(HomePageController.class)
class HomePageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Mock all autowired services to avoid null errors
    @MockBean
    private UserService userService;

    @MockBean
    private ProvinceService provinceService;

    @MockBean
    private CarService carService;

    @MockBean
    private DistrictService districtService;

    @MockBean
    private BookingService bookingService;

    @MockBean
    private BlogService blogService;

    @MockBean
    private InsuranceService insuranceService;

    @MockBean
    private ContractService contractService;

    @MockBean
    private NotificationService notificationService;

    @MockBean
    private DetailNotificationService detailNotificationService;

    @MockBean
    private RequestWithdrawalService requestWithdrawalService;

    @Test
    void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}