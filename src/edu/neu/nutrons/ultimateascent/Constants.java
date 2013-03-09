/*
 * Reloadble constants
 */
package edu.neu.nutrons.ultimateascent;

import com.team254.lib.util.ConstantsBase;

/**
 *
 * @author Tom Bottiglieri (tom@team254.com)
 */
public class Constants extends ConstantsBase {
  public static Constant driveKP = new Constant("driveKP", 0);
  public static Constant driveKI = new Constant("driveKI", 0);
  public static Constant driveKD = new Constant("driveKD", 0);
  public static Constant turnKP = new Constant("turnKP", 0);
  public static Constant turnKI = new Constant("turnKI", 0);
  public static Constant turnKD = new Constant("turnKD", 0);
  public static Constant elevatorKP = new Constant("elevatorKP", 1);
  public static Constant elevatorKI = new Constant("elevatorKI", 0);
  public static Constant elevatorKD = new Constant("elevatorKD", 0);
  public static Constant humanLoadHeight = new Constant("humanLoadHeight", 0.5);


}
