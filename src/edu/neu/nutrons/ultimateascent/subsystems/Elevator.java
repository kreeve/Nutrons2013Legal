/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.subsystems;

import edu.neu.nutrons.ultimateascent.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author NUTRONs
 */
public class Elevator extends OnOffSubsystem{
    private Victor motor1;
    private DigitalInput upLimit;
    private DigitalInput downLimit;
    public Elevator()
    {
        motor1 = new Victor(RobotMap.ELAVATOR_MOTOR);
        upLimit = new DigitalInput(RobotMap.DIGITAL_UP);
        downLimit = new DigitalInput(RobotMap.DIGITAL_DOWN);
    }

    private void set(double power) {
        motor1.set(power);
    }

    public void initDefaultCommand()
    {
       // setDefaultCommand(new ElevatorManualCmd());
    }
    protected void initOn() {
    }

    protected void initOff() {
    }

    protected void execOn() {
        if(upLimit.get())
        {
            set(0.3);
        } else {
            set(0.5);
        }
    }

    protected void execOff() {
        if(downLimit.get())
        {
            motor1.set(0);
        } else {
            motor1.set(-0.5);
        }
    }

    public boolean isOn() {
        return !upLimit.get();
    }

    public boolean isOff() {
        return !downLimit.get();
    }
    public void stop() {
        motor1.set(0);
    }
    public void manualControl(double power) {
        motor1.set(power);
    }
}
