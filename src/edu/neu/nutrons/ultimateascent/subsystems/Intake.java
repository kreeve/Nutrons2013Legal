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
 * Intake without drop down
 * ON: Motors on
 * OFF: Motors off
 * SPIT: Motors reversed
 */
public class Intake extends OnOffSubsystem {

    private Talon motor = new Talon(RobotMap.INTAKE_MOTOR);

    private void setPower(double power) {
        motor.set(power);
    }

    protected void initOn() {
    }

    protected void initOff() {
    }

    public void spit() {
        setPower(-1);
    }

    public void stop()
    {
        setPower(0);
    }

    protected void execOn() {
        setPower(1);
    }

    protected void execOff() {
        setPower(0);
    }

    public boolean isOn() {
        return rawState();
    }

    public boolean isOff() {
        return !rawState();
    }
}
