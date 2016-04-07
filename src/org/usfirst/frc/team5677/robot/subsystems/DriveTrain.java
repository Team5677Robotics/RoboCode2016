package org.usfirst.frc.team5677.robot.subsystems;
import org.usfirst.frc.team5677.robot.RobotMap;
import org.usfirst.frc.team5677.robot.commands.DriveTrainManualDriveCommand;
import org.usfirst.frc.team5677.robot.commands.DriveTrainSetSpeedCommand;

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
    
    // speed scale
    private static final double SCALE = 0.9;

    // singleton instance of DriveTrain
    private static DriveTrain driveTrain;

    /*
     * Sets the default command to be manual drive, which allows the 
     * human player to drive the robot using the joysticks.
     */
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveTrainManualDriveCommand());
    }

    /*
     * Initializes the VictorSPs.
     */
    public DriveTrain() {
    	victorLeft = new VictorSP(RobotMap.DriveTrain.DT_VICTORSP_L_PORT);
    	victorRight = new VictorSP(RobotMap.DriveTrain.DT_VICTORSP_R_PORT);
    }

    /*
     * Initializes a (singleton) instance of the DriveTrain if none exist.
     *
     * @postcondition initializes singleton instance of DriveTrain
     */
    public static void initialize() {
		if (driveTrain == null) {
		    driveTrain = new DriveTrain();
		}
    }

    /* 
     * Gets the singleton instance of DriveTrain.
     * 
     * @return the singleton instance of DriveTrain
     */
    public static DriveTrain getInstance() {
    	initialize();
    	return driveTrain;
    }
    
    /*
     * Sets the speed of VictorSPs that control the left and right side.
     * 
     * @param left the speed of the left VictorSP (-1 <= right <= 1)
     * @param right the speed of the right VictorSP (-1 <= left <= 1)
     */
    public void setSpeed(double left, double right) {
    	left *= SCALE;
    	right *= SCALE;
    	
    	victorRight.set(-1*left);
    	victorLeft.set(right);
    }
    
    /*
     * Sets the speed of VictorSPs that control the left and right side.
     * 
     * @param speed the speed of both VictorSPs (-1 <= speed <= 1)
     */
    public void setSpeed(double speed) {
    	speed *= SCALE;
    	
    	setSpeed(speed, speed);
    }
}

