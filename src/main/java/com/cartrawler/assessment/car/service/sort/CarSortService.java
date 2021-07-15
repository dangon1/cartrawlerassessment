package com.cartrawler.assessment.car.service.sort;

import com.cartrawler.assessment.car.entity.CarResult;
import com.cartrawler.assessment.car.service.filter.ICarFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;


@Service
public class CarSortService implements ICarSort {

    @Autowired
    private ICarFilter carFilter;
    /**
     * Return a List of sorted cars by Corporate. It's a list because the order matters
     * @param carResultSet
     * @return
     */
    @Override
    public List<CarResult> sortByCorporateFirstOrderedBySIPPAndPrice(final Collection<CarResult> carResultSet) {

        //Sort both lists by SIPP
        List<CarResult> carsSortedBySIPP = sortBySIPPAndPrice(carResultSet);

        //Filter between corporate and non corporate
        return buildCorporateAndNonCorporateCarsList(carsSortedBySIPP);
    }

    @Override
    public List<CarResult> sortByCorporateFirstOrderedBySIPPAndPriceRemoveOverpriced(Collection<CarResult> carResultSet) {
        //Sort both lists by SIPP
        List<CarResult> carsSortedBySIPP = sortBySIPPAndPriceFilteringOverpriced(carResultSet);
        return buildCorporateAndNonCorporateCarsList(carsSortedBySIPP);

    }

    private List<CarResult> buildCorporateAndNonCorporateCarsList(List<CarResult> carsSortedBySIPP) {
        //Filter between corporate and non corporate
        List<CarResult> corporateCars = carFilter.filterByCorporate(carsSortedBySIPP);
        List<CarResult> nonCorporateCars = carFilter.filterByNonCorporate(carsSortedBySIPP);


        //Add corporate and non corporate
        return Stream.of(corporateCars, nonCorporateCars)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<CarResult> sortBySIPPAndPrice(final Collection<CarResult> carResultSet) {

        List<CarResult> miniCars = carFilter.filterBySippCode(carResultSet, "M");
        List<CarResult> economyCars = carFilter.filterBySippCode(carResultSet, "E");
        List<CarResult> compactCars = carFilter.filterBySippCode(carResultSet, "C");
        List<CarResult> otherCars = carFilter.filterByOthers(carResultSet);

        miniCars.sort(comparing(CarResult::getRentalCost));
        economyCars.sort(comparing(CarResult::getRentalCost));
        compactCars.sort(comparing(CarResult::getRentalCost));
        otherCars.sort(comparing(CarResult::getRentalCost));

        return Stream.of(miniCars, economyCars, compactCars, otherCars)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());


    }

    private List<CarResult> sortBySIPPAndPriceFilteringOverpriced(final Collection<CarResult> carResultSet) {

        List<CarResult> miniCars = carFilter.filterBySippCode(carResultSet, "M");
        List<CarResult> economyCars = carFilter.filterBySippCode(carResultSet, "E");
        List<CarResult> compactCars = carFilter.filterBySippCode(carResultSet, "C");
        List<CarResult> otherCars = carFilter.filterByOthers(carResultSet);


        double medianMiniCars = miniCars.stream().map(CarResult::getRentalCost).reduce(0.0, Double::sum) / miniCars.size();
        double medianEconomyCars = economyCars.stream().map(CarResult::getRentalCost).reduce(0.0, Double::sum) / economyCars.size();
        double medianCompactCars = compactCars.stream().map(CarResult::getRentalCost).reduce(0.0, Double::sum) / compactCars.size();
        double medianOtherCars = otherCars.stream().map(CarResult::getRentalCost).reduce(0.0, Double::sum) / otherCars.size();

        miniCars = miniCars.stream().filter(c -> c.getRentalCost() > medianMiniCars).collect(Collectors.toList());
        economyCars = economyCars.stream().filter(c -> c.getRentalCost() > medianEconomyCars).collect(Collectors.toList());
        compactCars = compactCars.stream().filter(c -> c.getRentalCost() > medianCompactCars).collect(Collectors.toList());
        otherCars = otherCars.stream().filter(c -> c.getRentalCost() > medianOtherCars).collect(Collectors.toList());

        miniCars.sort(comparing(CarResult::getRentalCost));
        economyCars.sort(comparing(CarResult::getRentalCost));
        compactCars.sort(comparing(CarResult::getRentalCost));
        otherCars.sort(comparing(CarResult::getRentalCost));


        return Stream.of(miniCars, economyCars, compactCars, otherCars)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());


    }

}
