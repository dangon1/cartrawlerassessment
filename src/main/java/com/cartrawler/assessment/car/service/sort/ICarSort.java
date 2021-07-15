package com.cartrawler.assessment.car.service.sort;

import com.cartrawler.assessment.car.entity.CarResult;

import java.util.Collection;
import java.util.List;

public interface ICarSort {

    List<CarResult> sortByCorporateFirstOrderedBySIPPAndPrice(Collection<CarResult> carResultSet);
    List<CarResult> sortByCorporateFirstOrderedBySIPPAndPriceRemoveOverpriced(Collection<CarResult> carResultSet);
}
