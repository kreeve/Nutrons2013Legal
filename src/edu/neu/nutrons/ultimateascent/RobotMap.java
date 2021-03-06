package edu.neu.nutrons.ultimateascent;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    // Motors
    public static final int DRIVE_LEFT_MOTOR_1 = 9;
    public static final int DRIVE_LEFT_MOTOR_2 = 10;
    public static final int DRIVE_RIGHT_MOTOR_1 = 5;
    public static final int DRIVE_RIGHT_MOTOR_2 = 6;
    public static final int INTAKE_MOTOR = 4;
    public static final int ELAVATOR_MOTOR = 2;
    public static final int COMPRESSOR_PORT = 1;
    public static final int SHOOTER_1 = 7;
    public static final int SHOOTER_2 = 8;
    public static final int DDROLLER = 3;

    // Pneumatics
    public static final int DROPDOWN = 4;
    public static final int CENTERER = 2;
    public static final int MAGAZINE = 3;
    public static final int BOLT = 1;
    public static final int CLIMBER = 5;
    public static final int SHIFTER = 6;

    // Inputs
    public static final int DIGITAL_UP = 3;
    public static final int DIGITAL_DOWN = 4;
    public static final int AIR_PRESSURE = 5;
    public static final int SHOOTER_ENC_A = 1;
    public static final int SHOOTER_ENC_B = 2;
    public static final int DRIVE_ENC_A = 6;
    public static final int DRIVE_ENC_B = 7;
    public static final int GYRO = 1;
    public static final int POT = 3;

    public static final boolean CENTERER_RETRACTED = false;
}
