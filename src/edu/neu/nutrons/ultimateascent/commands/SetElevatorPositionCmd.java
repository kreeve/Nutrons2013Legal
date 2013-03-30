/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

/**
 *
 * @author NUTRONs
 * Raises elevator to target position.
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
