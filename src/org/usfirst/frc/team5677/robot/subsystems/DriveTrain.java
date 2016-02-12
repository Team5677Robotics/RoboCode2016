package org.usfirst.frc.team5677.robot.subsystems;

import org.usfirst.frc.team5677.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This subsystem operates the DriveTrain and includes methods 
 * that drive forward, turn, etc.
 * 
 * @author Vedaad Shakib
 * @version 2/10/16
 */
public class DriveTrain extends Subsystem {

    private static VictorSP victorLeft;
    private static VictorSP victorRight;
    
    // scale the speed
    private static final double SCALE = 1;

    public void initDefaultCommand() {
    }

    /*
     * Initializes the VictorSPs.
     */
    public DriveTrain() {
    	victorLeft = new VictorSP(RobotMap.DT_VICTORSP_L_PORT);
    	victorRight = new VictorSP(RobotMap.DT_VICTORSP_R_PORT);
    }
    
    public void setSpeed(double left, double right) {
    	victorRight.set(left);
    	victorLeft.set(right);
    }
}

