/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.neu.nutrons.ultimateascent.subsystems.OnOffSubsystem;

/**
 *
 * @author NUTRONs
 */
public class Lawyer {

    public boolean legalToSet(OnOffSubsystem sys, boolean on) {
        return true;
        // TODO: write me!
        // Replace the nulls with subsystems and the trues with actual logic.
        /*
        if(sys == CommandBase.elevator) {
            if(on) {
               // return CommandBase.magazine.isOn() && CommandBase.intake.isOff();
                return true;
            } else {
               // return CommandBase.magazine.isOff();
                return true;
            }
        } else if(sys == CommandBase.dropdown) {
            if(on) {
                return this.legalToSet(CommandBase.intake, true);
            } else {
                return true;
            }
        } else if(sys == CommandBase.intake) {
            if(on) {
              //  return CommandBase.elevator.isOff() && CommandBase.magazine.isOff() && CommandBase.dropdown.isOn();
                return true;
            } else {
                return true;
            }
        } else if(sys == CommandBase.magazine) {
            if(on) {
                return true;
            } else {
                return true;
            }
        } else if(sys == CommandBase.bolt) {
            if(on) {
                return true;
            } else {
                return true;
            }
        } else if(sys == CommandBase.barrel) {
            if(on) {
                return true;
            } else {
                return true;
            }
        } else if(sys == CommandBase.shooter) {
            if(on) {
                //returning true for testing purposes
                return true;
            } else {
                return true;
            }
        } else {
            return true; // Make it so that this case is never reached!
        }
        */
    }
}
