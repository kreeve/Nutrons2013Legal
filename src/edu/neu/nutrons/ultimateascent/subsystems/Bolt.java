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
public class Bolt extends OnOffSubsystem {

    private Solenoid bolt = new Solenoid(0);
    private DebouncedBoolean delay = new DebouncedBoolean(0);

    protected void initOn() {
        delay.reset();
        bolt.set(true);
    }

    protected void initOff() {
        delay.reset();
        bolt.set(false);
    }

    protected void execOn() {
        bolt.set(true);
    }

    protected void execOff() {
        bolt.set(false);
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
