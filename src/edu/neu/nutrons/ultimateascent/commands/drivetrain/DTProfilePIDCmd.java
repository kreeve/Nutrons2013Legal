package edu.neu.nutrons.ultimateascent.commands.drivetrain;

import com.team254.lib.control.ControlOutput;
import com.team254.lib.control.ControlSource;
import com.team254.lib.control.PIDGains;
import com.team254.lib.control.impl.ProfiledPIDController;
import edu.neu.nutrons.ultimateascent.Constants;
import edu.neu.nutrons.ultimateascent.commands.CommandBase;

/**
 *
 * @author NUTRONs
 */
public class DTProfilePIDCmd extends CommandBase {

    private final double TIME_TO_MAX = 1;

    private PIDGains gains = new PIDGains(Constants.profiledDriveKP, Constants.profiledDriveKI, Constants.profiledDriveKD);
    private ProfiledPIDController driveController = new ProfiledPIDController("Auto Drive Controller", gains, new DTControlSource(), new DTControlOutput(), 1, TIME_TO_MAX);


    public DTProfilePIDCmd(double goal) {
        driveController.setGoal(goal);
    }

    protected void initialize() {
    }

    protected void execute() {
        driveController.update();
    }

    protected boolean isFinished() {
        return driveController.onTarget();
    }

    protected void end() {
    }

    protected void interrupted() {
    }

    private class DTControlSource implements ControlSource{
        public double get() {
            return CommandBase.dt.getEncoderValue();
        }
        public void updateFilter() {
        }
    }

    private class DTControlOutput implements ControlOutput {
        public void set(double value) {
            CommandBase.dt.driveLR(value, value);
        }
    }

}
