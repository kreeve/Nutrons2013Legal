
package edu.neu.nutrons.ultimateascent;

import edu.neu.nutrons.lib.Utils;
import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.neu.nutrons.ultimateascent.commands.auto.Autonomous;
import edu.neu.nutrons.ultimateascent.commands.intake.DDIntakeCmd;
import edu.neu.nutrons.ultimateascent.commands.intake.DDIntakeStopCmd;
import edu.neu.nutrons.ultimateascent.commands.intake.IntakeFrisbeeCmd;
import edu.neu.nutrons.ultimateascent.commands.intake.IntakeSpitCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOFFCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetONCmd;
import edu.neu.nutrons.ultimateascent.commands.shooter.ShooterAimHighCmd;
import edu.neu.nutrons.ultimateascent.commands.shooter.ShooterFireCmd;
import edu.neu.nutrons.ultimateascent.commands.shooter.ShooterAimLowCmd;
import edu.neu.nutrons.ultimateascent.commands.shooter.ShooterHoldFireCmd;
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
    //aim and shoot buttons
    private Button readyAimLow = new JoystickButton(opPad, 2);
    private Button readyAimHigh = new JoystickButton(opPad, 3);
    private Button fireFrisbee = new JoystickButton(opPad, 6);
    private Button holdFire = new JoystickButton(opPad, 10);
    //intake buttons
    private Button intake = new JoystickButton(opPad, 5);
    private Button ddIntake = new JoystickButton(opPad,7);
    private Button spit = new JoystickButton(opPad, 8);
    private Button raiseClimber = new JoystickButton(opPad, 1);
    private Button chinUp = new JoystickButton(opPad, 4);
    private Button retract = new JoystickButton(opPad, 9);

    public OI()
    {
        //aim and fire
        readyAimLow.whenPressed(new ShooterAimLowCmd());
        readyAimHigh.whenPressed(new ShooterAimHighCmd());
        fireFrisbee.whenPressed(new ShooterFireCmd());
        //retract.whenPressed(new OOSetOffCmd(CommandBase.bolt));
        //intake commands
        intake.whileHeld(new IntakeFrisbeeCmd());
        intake.whenReleased(new OOSetOFFCmd(CommandBase.intake));
        spit.whileHeld(new IntakeSpitCmd());
        ddIntake.whileHeld(new DDIntakeCmd());
        ddIntake.whenReleased(new DDIntakeStopCmd());
        //climb
        raiseClimber.whenPressed(new OOSetONCmd(CommandBase.climber));
        chinUp.whenPressed(new OOSetOFFCmd(CommandBase.climber));
        holdFire.whenPressed(new ShooterHoldFireCmd());
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

    public int getAutoMode() {
        if(opPad.getRawButton(2)) {
            return Autonomous.THREE_DISC;
        } else if(opPad.getRawButton(3)) {
            return Autonomous.FIVE_DISC;
        } else if(opPad.getRawButton(4)) {
            return Autonomous.SEVEN_DISC;
        } else {
            return Autonomous.NONE;
        }
    }
}
