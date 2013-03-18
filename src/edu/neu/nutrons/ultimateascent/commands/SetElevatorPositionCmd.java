/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.subsystems.Elevator;

/**
 *
 * @author NUTRONs
 */
public class SetElevatorPositionCmd extends CommandBase{
    double pos;
    public SetElevatorPositionCmd(double pos) {
        this.pos = pos;
        requires(elevator);
    }
    protected void initialize() {
        elevator.enableControlLoop();
        
        elevator.setPosition(pos);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
