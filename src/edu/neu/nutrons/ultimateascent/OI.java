
package edu.neu.nutrons.ultimateascent;

import edu.neu.nutrons.lib.Utils;
import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOffCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOnCmd;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    // Joystick mappings.
    private static final int DRIVE_THROTTLE = 1;
    private static final int DRIVE_WHEEL = 6;
    private static final int DRIVE_QUICK_TURN = 0;

    private DriverStationEnhancedIO io = DriverStation.getInstance().getEnhancedIO();
    private Joystick opPad = new Joystick(1);
    private Button intakeOn = new JoystickButton(opPad, 1);
    private Button intakeOff = new JoystickButton(opPad, 2);
    // private Button elevatorUp = new JoystickButton(opPad, 3);
    // private Button elevatorDown = new JoystickButton(opPad, 4);
    private Button shooterOn = new JoystickButton(opPad, 5);
    private Button shooterOff = new JoystickButton(opPad, 6);
    private Button boltOn = new JoystickButton(opPad, 7);
    private Button boltOff = new JoystickButton(opPad, 8);
    private Button magazineUp = new JoystickButton(opPad, 9);
    private Button magazineDown = new JoystickButton(opPad, 10);
    private Button shooterUp = new JoystickButton(opPad, 3);
    private Button shooterDown = new JoystickButton(opPad, 4);
    private Button dropIntake = new JoystickButton(opPad, 11);
    private Button raiseIntake = new JoystickButton(opPad, 12);

    public OI()
    {
         intakeOn.whenPressed(new OOSetOnCmd(CommandBase.intake));
         intakeOff.whenPressed(new OOSetOffCmd(CommandBase.intake));

        // elevatorUp.whenPressed(new OOSetOnCmd(CommandBase.elevator));
        // elevatorDown.whenPressed(new OOSetOffCmd(CommandBase.elevator));

        shooterOn.whenPressed(new OOSetOnCmd(CommandBase.shooter));
        shooterDown.whenPressed(new OOSetOffCmd(CommandBase.shooter));

        // boltOn.whenPressed(new OOSetOnCmd(CommandBase.bolt));
        // boltOff.whenPressed(new OOSetOffCmd(CommandBase.bolt));

        // magazineUp.whenPressed(new OOSetOnCmd(CommandBase.magazine));
        // magazineDown.whenPressed(new OOSetOffCmd(CommandBase.magazine));

        // shooterUp.whenPressed(new OOSetOnCmd(CommandBase.barrel));
        // shooterDown.whenPressed(new OOSetOffCmd(CommandBase.barrel));

        // dropIntake.whenPressed(new OOSetOnCmd(CommandBase.dropdown));
        // raiseIntake.whenPressed(new OOSetOffCmd(CommandBase.dropdown));
    }
    public double manElevator()
    {
        return -1*opPad.getRawAxis(2);
    }
    private double capAndBand(double value) {
        value = Utils.deadband(value, .075, -1);
        value = Utils.deadband(value, .075, 0);
        value = Utils.deadband(value, .075, 1);
        return Utils.limit(value, -1, 1);
    }

    private double scaleAnalog(double voltageIn) {
        double normalized = (2 * voltageIn / 3.25) - 1;
        return normalized;
    }

    private double getIOAnalog(int port) {
        double in;
        try {
            in = io.getAnalogIn(port);
        }
        catch(DriverStationEnhancedIO.EnhancedIOException ex) {
            return 0;
        }
        double refined = capAndBand(scaleAnalog(in));
        return refined;
    }

    private boolean getIODigital(int port) {
        boolean in = false;
        try {
            in = !io.getDigital(port); //active low
        }
        catch(DriverStationEnhancedIO.EnhancedIOException ex) {
        }
        return in;
    }

    public double getDriveThrottle() {
        return getIOAnalog(DRIVE_THROTTLE);
    }

    public double getDriveWheel() {
        return getIOAnalog(DRIVE_WHEEL);
    }

    public boolean getDriveQuickTurn() throws DriverStationEnhancedIO.EnhancedIOException {
        return getIODigital(DRIVE_QUICK_TURN);
    }

}
