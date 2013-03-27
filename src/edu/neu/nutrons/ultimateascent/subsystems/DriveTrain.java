
package edu.neu.nutrons.ultimateascent.subsystems;

import edu.neu.nutrons.lib.Utils;
import edu.neu.nutrons.ultimateascent.RobotMap;
import edu.neu.nutrons.ultimateascent.commands.drivetrain.DTManualCmd;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Drive train moves around and cool stuff like that.
 * Uses tank drive.
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private double tSens = 1;
    private final double HIGH_GEAR_T_SENS = 1.5;
    private final double LOW_GEAR_T_SENS = 1.3;
    private Talon leftMotor1 = new Talon(RobotMap.DRIVE_LEFT_MOTOR_1);
    private Talon leftMotor2 = new Talon(RobotMap.DRIVE_LEFT_MOTOR_2);
    private Talon rightMotor1 = new Talon(RobotMap.DRIVE_RIGHT_MOTOR_1);
    private Talon rightMotor2 = new Talon(RobotMap.DRIVE_RIGHT_MOTOR_2);
    private Solenoid shifter = new Solenoid(RobotMap.SHIFTER);

    private Encoder enc = new Encoder(RobotMap.DRIVE_ENC_A, RobotMap.DRIVE_ENC_B);
    private Gyro gyro = new Gyro(RobotMap.GYRO);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DTManualCmd());
    }
     public void setTSens(boolean highGear) {
        if(highGear) {
            tSens = HIGH_GEAR_T_SENS;
        }
        else {
            tSens = LOW_GEAR_T_SENS;
        }
    }
    public void driveLR(double left, double right) {
        System.out.println(left + " " + right);
        left = Utils.limit(left, -1, 1);
        right = Utils.limit(right, -1, 1);
        leftMotor1.set(-left);
        leftMotor2.set(-left);
        rightMotor1.set(right);
        rightMotor2.set(right);
    }

    public void driveTW(double throttle, double wheel) {
        // TODO: write me! But here's what Ziv thinks:
        wheel = Utils.limit(wheel, -1, 1);
        throttle = Utils.limit(throttle, -1+Math.abs(wheel), 1-Math.abs(wheel));
        driveLR(throttle-wheel, throttle+wheel);
    }

    public void driveCheesy(double throttle, double wheel, boolean quickTurn) {
        // Variables.
        double angularPower;
        double overPower;
        double rPower;
        double lPower;

        // start turning if quickturn button is pressed.
        if(quickTurn) {
            overPower = 1.0;
            angularPower = wheel;
        }
        else {
            overPower = 0.0;
            angularPower = Math.abs(throttle) * wheel * tSens;
        }
        rPower = throttle;
        lPower = throttle;
        lPower += angularPower;
        rPower -= angularPower;
        if(lPower > 1.0) {
           rPower -= overPower * (lPower - 1.0);
           lPower = 1.0;
        }
        else if(rPower > 1.0) {
          lPower -= overPower * (rPower - 1.0);
          rPower = 1.0;
        }
        else if(lPower < -1.0) {
            rPower += overPower * (-1.0 - rPower);
            lPower = -1.0;
        }
        else if (rPower < -1.0) {
            lPower += overPower * (-1.0 - rPower);
            rPower = -1.0;
        }
        driveLR(lPower, rPower);
    }
        public int getEncoderValue() {
        return enc.get();
    }

    public double getEncoderDistance() {
      return enc.getDistance();
    }

    public double getGyroValue() {
        return gyro.getAngle();
    }

    public void resetGyro() {
        gyro.reset();
    }

    public void stop() {
        driveLR(0, 0);
    }

    public void setHighGear(boolean gear) {
        shifter.set(gear);
    }

    public void resetEncoder() {
      enc.reset();
    }
}
