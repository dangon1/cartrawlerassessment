package com.cartrawler.assessment.car.service.filter;

import com.cartrawler.assessment.app.CarsDatabase;
import com.cartrawler.assessment.car.entity.CarResult;
import com.cartrawler.assessment.car.service.sort.CarServiceSortTestData;
import com.cartrawler.assessment.car.service.sort.CarSortService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.cartrawler.assessment.car.entity.CarResult.corporateCarsList;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CarFilterServiceTest {

    @InjectMocks
    private CarFilterService carFilterService;

    @Test
    void filterByCorporate() {
        List<CarResult> carResults = carFilterService.filterByCorporate(CarsDatabase.CARS);

        assertFalse(carResults.stream().anyMatch(c -> !corporateCarsList.contains(c.getSupplierName())));
    }

    @Test
    void filterByNonCorporate() {

        List<CarResult> carResults = carFilterService.filterByNonCorporate(CarsDatabase.CARS);
        assertFalse(carResults.stream().anyMatch(c -> corporateCarsList.contains(c.getSupplierName())));
    }

    @Test
    void filterBySippCode() {
        List<CarResult> carResults = carFilterService.filterBySippCode(CarsDatabase.CARS,"M");
        assertFalse(carResults.stream().anyMatch(c -> c.getSippCode().charAt(0) != 'M'));
    }

    @Test
    void filterByOthers() {
        List<CarResult> carResults = carFilterService.filterByOthers(CarsDatabase.CARS);
        assertFalse(carResults.stream().anyMatch(c -> c.getSippCode().charAt(0) == 'M'));
        assertFalse(carResults.stream().anyMatch(c -> c.getSippCode().charAt(0) == 'E'));
        assertFalse(carResults.stream().anyMatch(c -> c.getSippCode().charAt(0) == 'C'));
    }
}