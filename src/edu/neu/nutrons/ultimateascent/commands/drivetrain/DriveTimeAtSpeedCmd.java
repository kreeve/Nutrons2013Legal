/*
 * Drives a minimum distance at a certain motor speed (raw pwm)
 */
package edu.neu.nutrons.ultimateascent.commands.drivetrain;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;

/**
 *
 * @author Tom Bottiglieri (tom@team254.com)
 */
public class DriveTimeAtSpeedCmd extends CommandBase {

  double speed, angle, distance;
  boolean goingForward = true;
  public DriveTimeAtSpeedCmd(double speed, double timeout) {
    this.speed = speed;
    setTimeout(timeout);
  }
  protected void initialize() {
    driveController.disable();
    dt.stop();
  }

  protected void execute() {
    dt.driveTW(speed,0);
  }

  protected boolean isFinished() {
    return isTimedOut();
  }

  protected void end() {
    driveController.disable();
    dt.stop();
  }

  protected void interrupted() {
    driveController.disable();
    dt.stop();
  }

}
