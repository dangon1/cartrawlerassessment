package com.cartrawler.assessment.car.service.filter;

import com.cartrawler.assessment.car.entity.CarResult;

import java.util.Collection;
import java.util.List;

public interface ICarFilter {
    List<CarResult> filterByCorporate(Collection<CarResult> s);
    List<CarResult> filterByNonCorporate(Collection<CarResult> carResultSet);
    List<CarResult> filterBySippCode(Collection<CarResult> carResultSet,String sippCode);
    List<CarResult> filterByOthers(Collection<CarResult> carResultSet);

    //Additional
    List<CarResult> filterOverpriced(Collection<CarResult> carResultSet);
}
