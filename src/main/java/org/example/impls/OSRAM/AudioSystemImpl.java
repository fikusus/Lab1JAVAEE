package org.example.impls.OSRAM;

import org.example.interfaces.AudioSystem;

public class AudioSystemImpl implements AudioSystem {
    public void play(){
        System.out.println("Play sound as Bosch");
    }
    @Override
    public String toString() {
        return "OSRAM AudioSystem";
    }
}
