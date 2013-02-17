/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.subsystems;

import edu.neu.nutrons.ultimateascent.RobotMap;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author NUTRONs
 */
public class Intake extends OnOffSubsystem {

    private Talon motor = new Talon(RobotMap.INTAKE_MOTOR);

    protected void initOn() {
        motor.set(1);
    }

    protected void initOff() {
        motor.set(0);
    }

    public void reverse()
    {
        motor.set(-1);
    }

    public void stop()
    {
        motor.set(0);
    }

    protected void execOn() {
        motor.set(1);
    }

    protected void execOff() {
        motor.set(0);
    }

    public boolean isOn() {
        return rawState();
    }

    public boolean isOff() {
        return !rawState();
    }
}