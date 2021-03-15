package org.example.impls.Car;

import org.example.interfaces.*;

public class CarImpl {
    private Engine engine;
    private Body body;
    private Wheels wheels;
    private Battery battery;
    private AudioSystem audioSystem;
    private String name;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public void setAudioSystem(AudioSystem audioSystem) {
        this.audioSystem = audioSystem;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name  +
                ": engine=" + engine +
                ", body=" + body +
                ", wheels=" + wheels +
                ", battery=" + battery +
                ", audioSystem=" + audioSystem;
    }
}

