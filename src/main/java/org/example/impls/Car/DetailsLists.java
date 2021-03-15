package org.example.impls.Car;

import org.example.impls.BOSCH.BatteryImpl;
import org.example.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("Details")
public class DetailsLists {
    @Autowired
    public List<Engine> engines;

    @Autowired
    public List<AudioSystem> audioSystems;

    @Autowired
    public List<Battery> batteries;

    @Autowired
    public List<Wheels> wheels;

    @Autowired
    public List<Body> bodies;
}
