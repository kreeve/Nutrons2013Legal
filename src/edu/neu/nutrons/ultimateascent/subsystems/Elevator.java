/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.subsystems;

import edu.neu.nutrons.ultimateascent.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author NUTRONs
 */
public class Elevator extends OnOffSubsystem{
    private Talon motor1 = new Talon(RobotMap.ELAVATOR_MOTOR);
    private DigitalInput upLimit = new DigitalInput(0);
    private DigitalInput downLimit = new DigitalInput(0);
    protected void initOn() {
        if(!this.isOn())
        {
            motor1.set(1);
        }
    }

    protected void initOff() {
        if(!this.isOff())
        {
            motor1.set(-1);
        }
    }

    protected void execOn() {
          if(!this.isOn())
        {
            motor1.set(1);
        }
    }

    protected void execOff() {
          if(!this.isOff())
        {
            motor1.set(-1);
        }
    }

    public boolean isOn() {
        return upLimit.get();
    }

    public boolean isOff() {
        return downLimit.get();
    }
    public void stop()
    {
        motor1.set(0);
    }
}
