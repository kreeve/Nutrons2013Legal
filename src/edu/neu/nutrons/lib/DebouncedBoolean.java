package edu.neu.nutrons.lib;

import edu.wpi.first.wpilibj.Timer;

/**
 * Boolean that returns true only after a string of consecutive trues.
 * Length: time to wait until returning true in milliseconds.
 */
public class DebouncedBoolean {

    private double length = 0;
    Timer time = new Timer();
    private boolean state = false;
    private boolean timerStarted = false;

    public DebouncedBoolean(double length) {
        this.length = length;
        time.start();
    }

    public void feed(boolean in) {
        if(state) {
            state = in;
        } else if(in) {
            if(!timerStarted) {
                time.reset();
                time.start();
                timerStarted = true;
            }
            if(time.get() >= length) {
                state = true;
            }
        }
        if(!in) {
            time.stop();
            time.reset();
            timerStarted = false;
        }
    }

    public boolean get() {
        return state;
    }

    public void reset() {
        time.reset();
        time.start();
    }
    
}
