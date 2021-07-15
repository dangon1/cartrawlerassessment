package com.cartrawler.assessment.car.service.sort;

import com.cartrawler.assessment.car.entity.CarResult;
import com.cartrawler.assessment.car.entity.FuelPolicy;

import java.util.Arrays;
import java.util.List;

public class CarServiceSortTestData {

    public static final List<CarResult> MINI_CARS_EXPECTED
            = Arrays.asList(
            new CarResult("Peugeot 107", "ENTERPRISE", "MCMR", 9.53d, FuelPolicy.FULLEMPTY)
    );

    public static final List<CarResult> ECONOMIC_CARS_EXPECTED
            = Arrays.asList(
            new CarResult("Volkswagen Golf", "BUDGET", "EDMR", 32.81d, FuelPolicy.FULLEMPTY),
            new CarResult("Volkswagen Polo", "AVIS", "EDMR", 35.54d, FuelPolicy.FULLFULL)
    );

    public static final List<CarResult> COMPACT_CARS_EXPECTED
            = Arrays.asList(
            new CarResult("Ford C-Max Diesel", "NIZA", "CMMD", 22.04d, FuelPolicy.FULLEMPTY)
    );

    public static final List<CarResult> OTHER_CARS_EXPECTED
            = Arrays.asList(
            new CarResult("Ford C-SIXT", "SIXT", "BMMD", 22.04d, FuelPolicy.FULLEMPTY),
            new CarResult("Ford C-Max Electric", "THRIFTY", "FMMD", 22.11d, FuelPolicy.FULLEMPTY),
            new CarResult("Renault Scenic Diesel", "FIREFLY", "JGAD", 93.67d, FuelPolicy.FULLEMPTY),
            new CarResult("Renault Scenic", "HERTZ", "JGAD", 93.80d, FuelPolicy.FULLEMPTY)
    );



    public static final List<CarResult> SORT_BY_CORPORATE_ENTRY_DATA
            = Arrays.asList(
            new CarResult("Ford C-Max Diesel", "NIZA", "CMMD", 22.04d, FuelPolicy.FULLEMPTY),
            new CarResult("Ford C-Max Electric", "THRIFTY", "FMMD", 22.11d, FuelPolicy.FULLEMPTY),
            new CarResult("Ford C-SIXT", "SIXT", "BMMD", 22.04d, FuelPolicy.FULLEMPTY),
            new CarResult("Volkswagen Polo", "AVIS", "EDMR", 35.54d, FuelPolicy.FULLFULL),
            new CarResult("Renault Scenic Diesel", "FIREFLY", "JGAD", 93.67d, FuelPolicy.FULLEMPTY),
            new CarResult("Renault Scenic", "HERTZ", "JGAD", 93.80d, FuelPolicy.FULLEMPTY),
            new CarResult("Peugeot 107", "ENTERPRISE", "MCMR", 9.53d, FuelPolicy.FULLEMPTY),
            new CarResult("Volkswagen Golf", "BUDGET", "EDMR", 32.81d, FuelPolicy.FULLEMPTY)
    );

    public static final List<CarResult> SORT_BY_CORPORATE_DATA_EXPECTED_RESULT
            = Arrays.asList(
            new CarResult("Peugeot 107", "ENTERPRISE", "MCMR", 9.53d, FuelPolicy.FULLEMPTY),
            new CarResult("Volkswagen Golf", "BUDGET", "EDMR", 32.81d, FuelPolicy.FULLEMPTY),
            new CarResult("Volkswagen Polo", "AVIS", "EDMR", 35.54d, FuelPolicy.FULLFULL),
            new CarResult("Ford C-SIXT", "SIXT", "BMMD", 22.04d, FuelPolicy.FULLEMPTY),
            new CarResult("Ford C-Max Electric", "THRIFTY", "FMMD", 22.11d, FuelPolicy.FULLEMPTY),
            new CarResult("Renault Scenic Diesel", "FIREFLY", "JGAD", 93.67d, FuelPolicy.FULLEMPTY),
            new CarResult("Renault Scenic", "HERTZ", "JGAD", 93.80d, FuelPolicy.FULLEMPTY),
            new CarResult("Ford C-Max Diesel", "NIZA", "CMMD", 22.04d, FuelPolicy.FULLEMPTY)
    );

    public static final List<CarResult> SORT_BY_CORPORATE_CORPORATE_EXPECTED
            = Arrays.asList(
            new CarResult("Peugeot 107", "ENTERPRISE", "MCMR", 9.53d, FuelPolicy.FULLEMPTY),
            new CarResult("Volkswagen Golf", "BUDGET", "EDMR", 32.81d, FuelPolicy.FULLEMPTY),
            new CarResult("Volkswagen Polo", "AVIS", "EDMR", 35.54d, FuelPolicy.FULLFULL),
            new CarResult("Ford C-SIXT", "SIXT", "BMMD", 22.04d, FuelPolicy.FULLEMPTY),
            new CarResult("Ford C-Max Electric", "THRIFTY", "FMMD", 22.11d, FuelPolicy.FULLEMPTY),
            new CarResult("Renault Scenic Diesel", "FIREFLY", "JGAD", 93.67d, FuelPolicy.FULLEMPTY),
            new CarResult("Renault Scenic", "HERTZ", "JGAD", 93.80d, FuelPolicy.FULLEMPTY)
    );

    public static final List<CarResult> SORT_BY_NON_CORPORATE_CORPORATE_EXPECTED
            = Arrays.asList(
            new CarResult("Ford C-Max Diesel", "NIZA", "CMMD", 22.04d, FuelPolicy.FULLEMPTY)
    );


}
