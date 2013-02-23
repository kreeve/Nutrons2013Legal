/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

/**
 *
 * @author NUTRONs
 * TEST COMMAND
 * For button testing purposes
 */
public class TestCmd extends CommandBase {

    private int button;

    public TestCmd(int button) {
        this.button = button;
    }

    protected void initialize() {
        System.out.println("Button " + button + " Pressed");
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
