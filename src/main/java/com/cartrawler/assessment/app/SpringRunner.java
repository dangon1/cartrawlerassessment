package com.cartrawler.assessment.app;

import com.cartrawler.assessment.car.entity.CarResult;
import com.cartrawler.assessment.car.service.filter.ICarFilter;
import com.cartrawler.assessment.car.service.sort.ICarSort;
import com.cartrawler.assessment.view.IDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpringRunner {

    @Autowired
    private IDisplayService displayService;

    @Autowired
    private ICarSort carSort;

    @Autowired
    private ICarFilter carFilter;

    public void run (){

//        List<CarResult> sortedCars = carSort.sortByCorporateFirstOrderedBySIPPAndPrice(CarsDatabase.CARS);
        List<CarResult> sortedCars = carSort.sortByCorporateFirstOrderedBySIPPAndPriceRemoveOverpriced(CarsDatabase.CARS);

        displayService.render(sortedCars);
    }
}
