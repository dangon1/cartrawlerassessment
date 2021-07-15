package com.cartrawler.assessment.car.service.filter;

import com.cartrawler.assessment.car.entity.CarResult;
import com.cartrawler.assessment.car.entity.FuelPolicy;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import static com.cartrawler.assessment.car.entity.CarResult.corporateCarsList;
import static java.util.Locale.ROOT;
import static java.util.stream.Collectors.toList;

@Service
public class CarFilterService implements ICarFilter {
    @Override
    public List<CarResult> filterByCorporate(Collection<CarResult> carResultSet) {
        return carResultSet.stream().filter(c -> corporateCarsList.contains(c.getSupplierName())).collect(toList());
    }

    @Override
    public List<CarResult> filterByNonCorporate(Collection<CarResult> carResultSet) {
        return carResultSet.stream().filter(c -> !corporateCarsList.contains(c.getSupplierName())).collect(toList());
    }

    @Override
    public List<CarResult> filterBySippCode(Collection<CarResult> carResultSet,String sippCode) {
        return carResultSet.stream()
                .filter(c -> c.getSippCode().toUpperCase(ROOT).substring(0,1).equals(sippCode.toUpperCase(ROOT)))
                .collect(toList());
    }

    @Override
    public List<CarResult> filterByOthers(Collection<CarResult> carResultSet) {
        return carResultSet.stream()
                .filter(c -> c.getSippCode().toUpperCase(ROOT).charAt(0) != 'M')
                .filter(c -> c.getSippCode().toUpperCase(ROOT).charAt(0) != 'E')
                .filter(c -> c.getSippCode().toUpperCase(ROOT).charAt(0) != 'C')
                .collect(toList());
    }

    @Override
    public List<CarResult> filterOverpriced(Collection<CarResult> carResultSet) {

        carResultSet.stream()
                .filter(c -> c.getFuelPolicy().equals(FuelPolicy.FULLFULL))
                ;

        return carResultSet.stream()
                .filter(c -> c.getSippCode().toUpperCase(ROOT).charAt(0) != 'M')
                .filter(c -> c.getSippCode().toUpperCase(ROOT).charAt(0) != 'E')
                .filter(c -> c.getSippCode().toUpperCase(ROOT).charAt(0) != 'C')
                .collect(toList());
    }
}
