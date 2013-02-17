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
public class DDRoller extends OnOffSubsystem {
    private Talon DDMotor = new Talon(RobotMap.DDROLLER);

    protected void initOn() {
        DDMotor.set(1);
    }

    protected void initOff() {
        DDMotor.set(0);
    }

    protected void execOn() {
        DDMotor.set(1);
    }

    protected void execOff() {
        DDMotor.set(0);
    }

    public boolean isOn() {
        return rawState();
    }

    public boolean isOff() {
        return !rawState();
    }

}
