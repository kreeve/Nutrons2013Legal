/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.subsystems;

import edu.neu.nutrons.lib.DebouncedBoolean;
import edu.neu.nutrons.ultimateascent.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author NUTRONs
 * OnOffSubsystems with two pneumatics.
 */
public class PneumaticDoubleSystem extends OnOffSubsystem {
    protected DoubleSolenoid piston;
    protected boolean onState;
    protected double timeout;
    protected DebouncedBoolean delayOn;
    protected DebouncedBoolean delayOff;
    public PneumaticDoubleSystem(int port, boolean state, double limboTimeOn, double limboTimeOff)
    {
        this.onState = state;
        this.timeout = timeout;
        // Don't forget to initialize barrel1 and barrel2
        // For a pneumatic double solenoid system, I think it would be better if we custom-passed in ports
        // via the constructor as opposed to just have one set of it
        this.piston = new DoubleSolenoid(RobotMap.BARREL_1, RobotMap.BARREL_2);
        this.delayOn = new DebouncedBoolean(limboTimeOn);
        this.delayOff = new DebouncedBoolean(limboTimeOff);
    }

    public PneumaticDoubleSystem(int port, boolean onState, double limboTime) {
        this(port, onState, limboTime, limboTime);
    }

    protected void initOn() {
        piston.set(DoubleSolenoid.Value.kForward);
    }

    protected void initOff() {
        piston.set(DoubleSolenoid.Value.kReverse);
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
}
