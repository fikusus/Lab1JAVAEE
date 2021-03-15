package org.example.impls.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("Array")
public class CarPark {
    @Autowired
    public  List<CarImpl> nameList;

}
