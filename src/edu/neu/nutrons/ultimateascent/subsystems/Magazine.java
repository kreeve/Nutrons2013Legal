/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.subsystems;

import edu.neu.nutrons.lib.DebouncedBoolean;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author NUTRONs
 */
public class Magazine extends OnOffSubsystem {

    private Solenoid magSolenoid = new Solenoid(0);
    private DebouncedBoolean delay = new DebouncedBoolean(500);

    protected void initOn() {
        delay.reset();
        magSolenoid.set(true);
    }

    protected void initOff() {
        delay.reset();
        magSolenoid.set(false);
    }

    protected void execOn() {
        magSolenoid.set(true);
    }

    protected void execOff() {
        magSolenoid.set(false);
    }

    public boolean isOn() {
        delay.feed(true);
        return delay.get();
    }

    public boolean isOff() {
        delay.feed(false);
        return delay.get();
    }

}
