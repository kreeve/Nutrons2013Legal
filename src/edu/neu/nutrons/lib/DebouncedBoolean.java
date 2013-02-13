package edu.neu.nutrons.lib;

/**
 * Boolean that returns true only after a string of consecutive trues.
 *
 * @author Ziv
 */
public class DebouncedBoolean {

    // TODO: make this time-based instead of count-based.
    private double initialTime = 0;
    private double currentTime = 0;
    private double length = 0;
    private boolean state = false;

    public DebouncedBoolean(double length) {
        this.length = length;
        initialTime = System.currentTimeMillis();
        currentTime = System.currentTimeMillis();
    }

    public void feed(boolean in) {
        if(state) {
            state = in && state;
        }
        else if(in) {
            currentTime = System.currentTimeMillis() - initialTime;
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
        initialTime = System.currentTimeMillis();
        currentTime = System.currentTimeMillis();
    }
}
