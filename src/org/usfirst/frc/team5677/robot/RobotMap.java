package org.usfirst.frc.team5677.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * @author Vedaad Shakib
 */
public class RobotMap {
	/*
	 * Contains constants used by DriveTrain instance.
	 */
	public class DriveTrain {
	    public static final int DT_VICTORSP_L_PORT = 0;
	    public static final int DT_VICTORSP_R_PORT = 1;
	}
    
	/*
	 * Contains constants used by OI instance.
	 */
	public class OI {
	    // unknown
	    public static final int GAMEPAD_PORT = 0;
	}
}
