/*
 * Drives a minimum distance at a certain motor speed (raw pwm)
 */
package edu.neu.nutrons.ultimateascent.commands.drivetrain;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;

/**
 *
 * @author Tom Bottiglieri (tom@team254.com)
 */
public class DriveMinDistanceAtSpeedCmd extends CommandBase {

  double speed, angle, distance;
  boolean goingForward = true;
  public DriveMinDistanceAtSpeedCmd(double distance, double angle, double speed, double timeout) {
    this.speed = speed;
    this.distance = distance;
    this.angle = angle;
    setTimeout(timeout);
    requires(dt);
  }
  protected void initialize() {
    driveController.disable();
    if (distance < dt.getEncoderDistance()) {
      goingForward = false;
      speed = speed * -1;
    }
    driveController.setTurnGoal(angle);
    driveController.setOpenLoopStraight(speed);
  }

  protected void execute() {
  }

  protected boolean isFinished() {
    if (goingForward)
      return (dt.getEncoderDistance() > distance) || isTimedOut();
    else
      return dt.getEncoderDistance() < distance || isTimedOut();
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
