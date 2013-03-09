/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.subsystems;

import com.team254.lib.control.ControlOutput;
import com.team254.lib.control.ControlSource;
import com.team254.lib.control.PIDGains;
import com.team254.lib.control.impl.PIDController;
import com.team254.lib.util.ThrottledPrinter;
import edu.neu.nutrons.ultimateascent.Constants;
import edu.neu.nutrons.ultimateascent.RobotMap;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author NUTRONs
 * Elevator subsystem
 * ON: High position
 * OFF: Low position
 */
public class Elevator extends OnOffSubsystem{
    private Victor motor1;
    private DigitalInput upLimit;
    private DigitalInput downLimit;
    private AnalogChannel pot;
    double elevatorDownPos = 0;
    double potScale = 1. / 400.0;

    PIDController controller = new PIDController("elevator",
            new PIDGains(Constants.elevatorKP,Constants.elevatorKI,Constants.elevatorKD),
            new ElevatorControlSource(),
            new ElevatorControlOutput());

    private class ElevatorControlSource implements ControlSource {

        public double get() {
            return (pot.getValue() - elevatorDownPos) * potScale;
        }

        public void updateFilter() {
        }

    }

    private class ElevatorControlOutput implements ControlOutput {

        public void set(double value) {
            motor1.set(value);
        }

    }

    public Elevator() {
        motor1 = new Victor(RobotMap.ELAVATOR_MOTOR);
        upLimit = new DigitalInput(RobotMap.DIGITAL_UP);
        downLimit = new DigitalInput(RobotMap.DIGITAL_DOWN);
        pot = new AnalogChannel(RobotMap.POT);
    }

    private void setPower(double power) {
        motor1.set(-power);
    }

    public void initDefaultCommand() {
       // setDefaultCommand(new ElevatorManualCmd());
    }

    protected void initOn() {
    }

    protected void initOff() {
    }

    protected void execOn()
    {
        if (controller.isEnabled())
            return;
        if(isUp())
        {
            setPower(0.3);
        } else {
            setPower(0.85);
        }
    }

    protected void execOff() {
        if (controller.isEnabled())
            return;
        if(isDown())
        {
            setPower(0);
        } else {
            setPower(-0.85);
        }
    }

    public boolean isUp() {
        return !upLimit.get();
    }

    public boolean isDown()
    {
        //System.out.println("DOWN: " + !downLimit.get());
        return !downLimit.get();
    }

    public boolean isOn() {
        return isUp();
    }

    public boolean isOff() {
        return isDown();
    }

    public void stop() {
        motor1.set(0);
    }
    public void manualControl(double power) {
        motor1.set(power);
    }

    public double getPosition() {
        return pot.getAccumulatorCount();
    }

    public void enableControlLoop() {
        controller.enable();
        System.out.println("Enabled: " + controller.isEnabled());
    }

    public void disableControlLoop() {
        controller.disable();
    }

    public void setPosition(double position) {
        enableControlLoop();
        controller.setGoal(position);
        System.out.println("Goal: " + controller.getGoal() + " scaled goal: " + controller.getGoal()*potScale);
    }

    public double getPotVal() {
        return (pot.getValue() - elevatorDownPos) * potScale;
    }

    public void resetPot() {
        elevatorDownPos = pot.getValue();
    }
}
