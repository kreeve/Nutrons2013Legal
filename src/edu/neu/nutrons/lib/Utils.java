package edu.neu.nutrons.lib;

/**
 *
 * @author NUTRONs
 */
public class Utils {

    // If a value is within center +- deadband then it returns center. Else it returns the value.
    public static double deadband(double value, double deadband, double center) {
        return (value < (center + deadband) && value > (center - deadband)) ? center : value;
    }

    // Limits the number to be within min and max.
    public static double limit(double x, double min, double max) {
        return Math.max(Math.min(x, max), min);
    }

    // Finds the distance between two cartesian coordinates
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }
    
}
