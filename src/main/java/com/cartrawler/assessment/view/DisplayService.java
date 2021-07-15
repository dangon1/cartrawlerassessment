package com.cartrawler.assessment.view;

import com.cartrawler.assessment.car.entity.CarResult;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class DisplayService implements IDisplayService{
    public void render(Collection<CarResult> cars) {
        cars.forEach(System.out::println);
        System.out.println(cars.size());
    }
}
