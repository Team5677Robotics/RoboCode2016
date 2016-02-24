package org.usfirst.frc.team5677.robot;

import org.usfirst.frc.team5677.robot.commands.ConveyorSetSpeedCommand;
import org.usfirst.frc.team5677.robot.commands.IntakeBoulderCommand;
import org.usfirst.frc.team5677.robot.commands.IntakeLowerCommand;
import org.usfirst.frc.team5677.robot.commands.IntakeRaiseCommand;
import org.usfirst.frc.team5677.robot.subsystems.Manipulator;
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
		
		//gamepad.getButtonBumperLeft().whenActive(new IntakeBoulderCommand());
		gamepad.getButtonBumperLeft().whenPressed(new IntakeBoulderCommand(1));
		gamepad.getButtonBumperLeft().whenReleased(new IntakeBoulderCommand(0));
		
		gamepad.getButtonBumperRight().whenPressed(new ConveyorSetSpeedCommand(1));
		gamepad.getButtonBumperRight().whenReleased(new ConveyorSetSpeedCommand(0));
		
		gamepad.getButtonA().whenPressed(new IntakeLowerCommand());
		gamepad.getButtonA().whenReleased(new IntakeRaiseCommand());
	}
	
	public static void initialize() {
		if (oi == null)
			oi = new OI();
	}
	
	public static OI getInstance() {
		initialize();
		return oi;
	}
	
	public static GamepadWrapper getGamepad() {
		return gamepad;
	}
}

