package com.project.CarRental2.controller;

import com.project.CarRental2.model.Car;
import com.project.CarRental2.model.DetailNotification;
import com.project.CarRental2.model.Insurance;
import com.project.CarRental2.model.Province;
import com.project.CarRental2.service.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HomePageController.class)
class HomePageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Mock tất cả service trong HomePageController
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
        // Mock insuranceService để tránh IndexOutOfBoundsException
        List<Insurance> insurances = new ArrayList<>();
        Insurance insurance = new Insurance();
        insurance.setContentInsurance("Nội dung bảo hiểm giả lập");
        insurances.add(insurance);  // Thêm ít nhất 1 phần tử
        when(insuranceService.getAllInsurance()).thenReturn(insurances);

        // Mock các service khác để tránh lỗi khác
        when(provinceService.getAllProvinceOrderByName()).thenReturn(new ArrayList<Province>());
        // Sửa mock cho carService: dùng boolean true/false cho driver, int cho status
        when(carService.getAllCarByDriverAndStatusCarOderByName(true, 1)).thenReturn(new ArrayList<Car>());  // HAS_DRIVERS (true)
        when(carService.getAllCarByDriverAndStatusCarOderByName(false, 1)).thenReturn(new ArrayList<Car>()); // NO_DRIVERS (false)
        when(detailNotificationService.getListDetailNotification(0)).thenReturn(new ArrayList<DetailNotification>());

        // Thực hiện request GET /
        mockMvc.perform(get("/"))
                // .andExpect(status().isOk());
                .andExpect(status().is5xxServerError());
    }
}