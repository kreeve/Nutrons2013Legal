package edu.neu.nutrons.lib;

/**
 *
 * @author NUTRONs
 */
public abstract class Controller {

    private double target;

    abstract public void feed(double in);

    public void setTarget(double target) {
        this.target = target;
    }

    public double getTarget() {
        return target;
    }

    abstract public double getOutput();
}
