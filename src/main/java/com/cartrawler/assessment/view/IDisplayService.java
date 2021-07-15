package com.cartrawler.assessment.view;

import com.cartrawler.assessment.car.entity.CarResult;

import java.util.Collection;
import java.util.Set;

public interface IDisplayService {

    void render(Collection<CarResult> cars);
}
