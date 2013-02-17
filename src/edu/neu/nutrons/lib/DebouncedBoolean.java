package edu.neu.nutrons.lib;

import edu.wpi.first.wpilibj.Timer;

/**
 * Boolean that returns true only after a string of consecutive trues.
 *
 * @author Ziv
 */
public class DebouncedBoolean {

    // TODO: make this time-based instead of count-based.
    private double length = 0;
    Timer time = new Timer();
    private boolean state = false;

    public DebouncedBoolean(double length) {
        this.length = length;
        time.start();
    }

    public void feed(boolean in) {
        System.out.println("Current timer: " + time.get());
        double currentTime;
        if(state) {
            state = in;
        }
        else if(in) {
            currentTime = time.get();
            if(currentTime >= length) {
                state = true;
            }
        }
        if(!in) {
            currentTime = 0;
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
