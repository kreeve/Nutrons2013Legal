/*
 * Drive to a certain distance (absolute coordinates)
 */
package edu.neu.nutrons.ultimateascent.commands.drivetrain;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;

/**
 *
 * @author Tom Bottiglieri (tom@team254.com)
 */
public class DriveToDistanceCmd extends CommandBase {
  double distance, angle, vel;

  public DriveToDistanceCmd(double distance, double angle, double vel, double timeout) {
    this.distance = distance;
    this.angle = angle;
    this.vel = vel;
    setTimeout(timeout);
    requires(dt);
  }

  protected void initialize() {
    driveController.disable();
    driveController.setStraightGoal(distance);
    driveController.setTurnGoal(angle);
    driveController.setMaxVel(vel);
  }

  protected void execute() {
  }

  protected boolean isFinished() {
    return isTimedOut(); // make this return onTarget too
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
