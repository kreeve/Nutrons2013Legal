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
 * Elevator subsystem
 * ON: High position
 * OFF: Low position
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

    private void setPower(double power) {
        motor1.set(-power);
    }

    public void initDefaultCommand()
    {
       // setDefaultCommand(new ElevatorManualCmd());
    }
    protected void initOn() {
    }

    protected void initOff() {
    }

    protected void execOn()
    {
        if(isUp())
        {
            setPower(0.3);
        } else {
            setPower(0.85);
        }
    }

    protected void execOff() {
        if(isDown())
        {
            setPower(0);
        } else {
            setPower(-0.85);
        }
    }

    public boolean isUp() {
        return !upLimit.get();
    }

    public boolean isDown()
    {
        //System.out.println("DOWN: " + !downLimit.get());
        return !downLimit.get();
    }

    public boolean isOn() {
        return isUp();
    }

    public boolean isOff() {
        return isDown();
    }

    public void stop() {
        motor1.set(0);
    }
    public void manualControl(double power) {
        motor1.set(power);
    }
}
