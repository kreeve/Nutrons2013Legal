/*
 * Controls the drivebase for autonomous mode
 */
package edu.neu.nutrons.ultimateascent.controllers;

import com.team254.lib.control.ControlOutput;
import com.team254.lib.control.ControlSource;
import com.team254.lib.control.Controller;
import com.team254.lib.control.PIDGains;
import com.team254.lib.control.impl.PIDController;
import edu.neu.nutrons.ultimateascent.Constants;
import edu.neu.nutrons.ultimateascent.subsystems.DriveTrain;

/**
 *
 * @author Tom Bottiglieri (tom@team254.com)
 */
public class DriveController {
  DriveTrain dt;
  double straight, turn;
  
  private class DriveControlSource implements ControlSource {
    boolean isStraightController;
    DriveControlSource(boolean isStraightController) {
      this.isStraightController = isStraightController;
    }

    public double get() {
      if (isStraightController) {
        return dt.getEncoderDistance();
      } else {
        return dt.getGyroValue();
      }
    }

    public void updateFilter() {
    }  
  }
  
  private class DriveControlOutput implements ControlOutput {
    boolean isStraightController;
    DriveControlOutput(boolean isStraightController) {
      this.isStraightController = isStraightController;
    }

    public void set(double value) {
      if (isStraightController) {
        straight = value;
      } else {
        turn = value;
      }
      dt.driveLR(straight - turn, straight + turn);
    }
    
  }
  PIDController straightController = new PIDController("straightController",
          new PIDGains(Constants.driveKP, Constants.driveKI, Constants.driveKD),
          new DriveControlSource(true),
          new DriveControlOutput(true));
  
  PIDController turnController = new PIDController("turnController",
          new PIDGains(Constants.turnKP, Constants.turnKI, Constants.turnKD),
          new DriveControlSource(false),
          new DriveControlOutput(false));
  
  public DriveController(DriveTrain dt) {
    this.dt = dt;
  }
  
  public void setTurnGoal(double t) {
    turnController.setGoal(t);
    turnController.enable();
  }
  
  public void setStraightGoal(double d) {
    straightController.setGoal(d);
    straightController.enable();
  }
  
  public void disable() {
    straightController.disable();
    turnController.disable();
    straight = 0;
    turn = 0;
    dt.driveLR(0, 0);
  }
  
  public void setMaxVel(double v) {
    // TODO: use this to set the profiled pid controller once that works
  }
  
  public void setOpenLoopStraight(double s) {
    straight = s;
  }
  
}
