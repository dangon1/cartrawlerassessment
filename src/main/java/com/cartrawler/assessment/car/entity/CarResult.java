package com.cartrawler.assessment.car.entity;

import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode //This removes the duplicates. Fields that define an unique instance are all but rentalCost.
public class CarResult {
    private final String description;
    private final String supplierName;
    private final String sippCode;
    private final FuelPolicy fuelPolicy;
    @EqualsAndHashCode.Exclude private final double rentalCost;

    public static final List<String> corporateCarsList = Arrays.asList("AVIS", "BUDGET", "ENTERPRISE", "FIREFLY", "HERTZ", "SIXT", "THRIFTY");

    public CarResult(String description, String supplierName, String sipp, double cost, FuelPolicy fuelPolicy) {
        this.description = description;
        this.supplierName = supplierName;
        this.sippCode = sipp;
        this.rentalCost = cost;
        this.fuelPolicy = fuelPolicy;
    }
    
    public String getDescription() {
        return this.description;        
    }
    
    public String getSupplierName() {
        return this.supplierName;        
    }
    
    public String getSippCode() {
        return this.sippCode;        
    }
    
    public double getRentalCost() {
        return this.rentalCost;        
    }
    
    public FuelPolicy getFuelPolicy() {
        return this.fuelPolicy;
    }
    
    public String toString() {
        return this.supplierName + " : " +
            this.description + " : " +
            this.sippCode + " : " +
            this.rentalCost + " : " +
            this.fuelPolicy;
    }
}
