/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.subsystems;

import edu.neu.nutrons.lib.DebouncedBoolean;
import edu.neu.nutrons.lib.Utils;
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
    private final double SHOOTER_POWER = 1.0;

    private void set(double power) {
        // Don't shoot backwards!
        power = Utils.limit(power, 0, 1);
        sMotor1.set(-power);
        sMotor2.set(-power);
    }

    protected void initOn() {
    }

    protected void initOff() {
    }

    protected void execOn() {
        spinUpTime.feed(true);
        set(SHOOTER_POWER);
    }

    protected void execOff() {
        spinUpTime.feed(false);
        set(0);
    }

    public boolean isOn() {
        return spinUpTime.get();
    }

    public boolean isOff() {
        return !spinUpTime.get();
    }
}
