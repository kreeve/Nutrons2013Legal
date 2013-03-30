package edu.neu.nutrons.ultimateascent.subsystems;

import edu.neu.nutrons.lib.DebouncedBoolean;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author NUTRONs
 * OnOffSubsystem with pneumatics.
 * onState: default on state for the pistons
 * limboTimeOn: time delay for turning on
 * limboTimeOff: time delay for turning off
 */
public class PneumaticOnOffSubsystem extends OnOffSubsystem {

    boolean onState;
    protected Solenoid piston;
    protected DebouncedBoolean delayOn;
    protected DebouncedBoolean delayOff;
    public PneumaticOnOffSubsystem(int port, boolean onState, double limboTimeOn, double limboTimeOff) {
        // Make the solenoid.
        this.onState = onState;
        this.piston = new Solenoid(port);
        this.delayOn = new DebouncedBoolean(limboTimeOn);
        this.delayOff = new DebouncedBoolean(limboTimeOff);
    }
    public PneumaticOnOffSubsystem(int port, boolean onState, double limboTime) {
        this(port, onState, limboTime, limboTime);
    }

    protected void initOn() {
        piston.set(onState);

    }

    protected void initOff() {
        piston.set(!onState);

    }

    protected void execOn() {
        delayOn.feed(true);
        delayOff.feed(false);
    }

    protected void execOff() {
        delayOn.feed(false);
        delayOff.feed(true);
    }

    public boolean isOn() {
        return delayOn.get();
    }

    public boolean isOff() {
        return delayOff.get();
    }
    public boolean goalState()
    {
        return piston.get() && onState;
    }
}