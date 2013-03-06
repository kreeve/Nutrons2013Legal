package edu.neu.nutrons.ultimateascent;

import edu.neu.nutrons.lib.Utils;
import edu.neu.nutrons.ultimateascent.commands.*;
import edu.neu.nutrons.ultimateascent.commands.auto.Autonomous_OLD;
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

// TESTING CENTERER IN BUTTON 1

public class OI {

    // Joystick mappings.
    private static final int DRIVE_THROTTLE = 1;
    private static final int DRIVE_WHEEL = 6;
    private static final int DRIVE_QUICK_TURN = 0;

    private DriverStationEnhancedIO io = DriverStation.getInstance().getEnhancedIO();
    private Joystick opPad = new Joystick(1);
    //test
    private Button centererTest = new JoystickButton(opPad, 1);

    // Control Board Buttons (Needs Testing)
    private DigitalIOButton intake = new DigitalIOButton(12);
    private DigitalIOButton spit= new DigitalIOButton(14);
    private DigitalIOButton shooterLow = new DigitalIOButton(10);
    private DigitalIOButton shooterHigh = new DigitalIOButton(2);
    private DigitalIOButton fire = new DigitalIOButton(4);
    private DigitalIOButton humanLoad = new DigitalIOButton(6);

    public OI() {
        // testing
        centererTest.whenPressed(new TestCentererCmd(RobotMap.CENTERER_RETRACTED));

        // control board
        intake.whenPressed(new ActivateIntakeCmd());
        intake.whenReleased(new DeactivateIntakeCmd());
        spit.whenPressed(new IntakeSpitCmd());
        spit.whenReleased(new DeactivateIntakeCmd());
        shooterLow.whenPressed(new ActivateShooterLowCmd());
        shooterHigh.whenPressed(new ActivateShooterHighCmd());
        fire.whenPressed(new ShooterFireCmd());
        humanLoad.whenPressed(new HumanLoadCmd());

    }

    // For elevator testing purposes
    public double manElevator()
    {
        return -1*opPad.getRawAxis(2);
    }

    // Deadband on joystick
    private double capAndBand(double value) {
        value = Utils.deadband(value, .075, -1);
        value = Utils.deadband(value, .15, 0);
        value = Utils.deadband(value, .075, 1);
        return Utils.limit(value, -1, 1);
    }

    private double scaleAnalog(double voltageIn) {
        double normalized = (2 * voltageIn / 3.25) - 1;
        return normalized;
    }

    // Gets input from driver station joysticks
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

    // Gets input from buttons on driver station
    private boolean getIODigital(int port) {
        boolean in = false;
        try {
            in = !io.getDigital(port); //active low
        }
        catch(DriverStationEnhancedIO.EnhancedIOException ex) {
        }
        return in;
    }

    public double getDriveLeft() {
        return getIOAnalog(DRIVE_THROTTLE);
    }

    public double getDriveRight() {
        return getIOAnalog(DRIVE_WHEEL);
    }

    public boolean getDriveQuickTurn() throws DriverStationEnhancedIO.EnhancedIOException {
        // Not in use
        return getIODigital(DRIVE_QUICK_TURN);
    }

    // Selects number of frisbees to fire during auto
    public int getAutoMode() {
        if(opPad.getRawButton(2)) {
            return Autonomous_OLD.THREE_DISC;
        } else if(opPad.getRawButton(3)) {
            return Autonomous_OLD.FIVE_DISC;
        } else if(opPad.getRawButton(4)) {
            return Autonomous_OLD.SEVEN_DISC;
        } else {
            return Autonomous_OLD.NONE;
        }
    }
}
