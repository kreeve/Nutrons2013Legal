/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.subsystems;

import edu.neu.nutrons.lib.DebouncedBoolean;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author NUTRONs
 */
public class Shooter extends OnOffSubsystem {

    private Talon sMotor = new Talon(0);
    private DebouncedBoolean spinUpTime = new DebouncedBoolean(500);

    protected void initOn() {
        spinUpTime.reset();
        sMotor.set(1);
    }

    protected void initOff() {
        spinUpTime.reset();
        sMotor.set(0);
    }

    protected void execOn() {
        sMotor.set(1);
    }

    protected void execOff() {
        sMotor.set(0);
    }

    public boolean isOn() {
        spinUpTime.feed(true);
        return spinUpTime.get();
    }

    public boolean isOff() {
        spinUpTime.feed(false);
        return spinUpTime.get();
    }

}
