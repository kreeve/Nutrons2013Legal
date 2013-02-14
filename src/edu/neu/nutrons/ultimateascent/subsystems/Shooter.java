/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.subsystems;

import edu.neu.nutrons.lib.DebouncedBoolean;
import edu.neu.nutrons.ultimateascent.RobotMap;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author NUTRONs
 */
public class Shooter extends OnOffSubsystem {

    private Talon sMotor1 = new Talon(RobotMap.SHOOTER_1);
    private Talon sMotor2 = new Talon(RobotMap.SHOOTER_2);
    private DebouncedBoolean spinUpTime = new DebouncedBoolean(500);
    private final double SHOOTER_POWER = -1.0;
    protected void initOn() {
        spinUpTime.reset();
        sMotor1.set(SHOOTER_POWER);
        sMotor2.set(SHOOTER_POWER);
    }

    protected void initOff() {
        spinUpTime.reset();
        sMotor1.set(0);
        sMotor2.set(0);
    }

    protected void execOn() {
        sMotor1.set(SHOOTER_POWER);
        sMotor2.set(SHOOTER_POWER);
    }

    protected void execOff() {
        sMotor1.set(0);
        sMotor2.set(0);
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
