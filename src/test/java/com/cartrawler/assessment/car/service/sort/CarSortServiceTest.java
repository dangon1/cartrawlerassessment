package com.cartrawler.assessment.car.service.sort;

import com.cartrawler.assessment.car.entity.CarResult;
import com.cartrawler.assessment.car.service.filter.ICarFilter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.cartrawler.assessment.car.service.sort.CarServiceSortTestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarSortServiceTest {

    @InjectMocks
    private CarSortService carSortService;

    @Mock
    private ICarFilter mockCarFilter;

    @Test
    void sortByCorporateFirstOrderedBySIPPAndPrice() {
        List<CarResult> firstCars = CarServiceSortTestData.SORT_BY_CORPORATE_ENTRY_DATA;

        when(mockCarFilter.filterBySippCode(firstCars,"M")).thenReturn(MINI_CARS_EXPECTED);
        when(mockCarFilter.filterBySippCode(firstCars,"E")).thenReturn(ECONOMIC_CARS_EXPECTED);
        when(mockCarFilter.filterBySippCode(firstCars,"C")).thenReturn(COMPACT_CARS_EXPECTED);
        when(mockCarFilter.filterByOthers(firstCars)).thenReturn(OTHER_CARS_EXPECTED);

        when(mockCarFilter.filterByCorporate(anyList())).thenReturn(SORT_BY_CORPORATE_CORPORATE_EXPECTED);
        when(mockCarFilter.filterByNonCorporate(anyList())).thenReturn(SORT_BY_NON_CORPORATE_CORPORATE_EXPECTED);

        assertEquals(SORT_BY_CORPORATE_DATA_EXPECTED_RESULT,carSortService.sortByCorporateFirstOrderedBySIPPAndPrice(firstCars));
    }

}