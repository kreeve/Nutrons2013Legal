/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class TestCentererCmd extends CommandGroup {

    public TestCentererCmd(boolean stateInWhichtoPutIt ) {
        addSequential(new OOTurnCmd(CommandBase.centerer, stateInWhichtoPutIt));
    }

}
