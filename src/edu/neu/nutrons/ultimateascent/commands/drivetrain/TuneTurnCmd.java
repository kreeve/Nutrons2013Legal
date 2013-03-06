/*
 * Useful for PID tuning
 */
package edu.neu.nutrons.ultimateascent.commands.drivetrain;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Tom Bottiglieri (tom@team254.com)
 */
public class TuneTurnCmd extends CommandBase {
  
  Timer t = new Timer();
  double timeout = 4;
  double angle = 90; // degrees?
  boolean on = true;

  protected void initialize() {
    t.start();
    driveController.disable();
    driveController.setTurnGoal(angle);
  }

  protected void execute() {
    if (t.get() > timeout) {
      on = !on;
      driveController.setTurnGoal(on ? angle : 0);
      t.reset();
    }
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    driveController.disable();
  }

  protected void interrupted() {
    driveController.disable();
  }
  
}
