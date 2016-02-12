package org.usfirst.frc.team5677.robot;

import org.usfirst.frc.team5677.robot.wrappers.GamepadWrapper;

import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * 
 * @author Vedaad Shakib
 * @version 02/11/16
 */
public class OI {
	private static OI oi;
	private static GamepadWrapper gamepad;
	
	/*
	 * Creates gamepad instance.
	 */
	public OI () {
		gamepad = new GamepadWrapper(RobotMap.OI.GAMEPAD_PORT);
	}
	
	public static void initialize() {
		if (oi == null)
			oi = new OI();
	}
	
	public static OI getInstance() {
		initialize();
		return oi;
	}
}

