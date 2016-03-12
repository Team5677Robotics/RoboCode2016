package org.usfirst.frc.team5677.robot;

import org.usfirst.frc.team5677.robot.commands.ConveyorSetSpeedCommand;
import org.usfirst.frc.team5677.robot.commands.IntakeBoulderCommand;
import org.usfirst.frc.team5677.robot.commands.IntakeConveyorSetSpeedCommandGroup;
import org.usfirst.frc.team5677.robot.commands.IntakeConveyorToggleCommandGroup;
import org.usfirst.frc.team5677.robot.commands.IntakeLowerCommand;
import org.usfirst.frc.team5677.robot.commands.IntakeRaiseCommand;
import org.usfirst.frc.team5677.robot.commands.IntakeToggleCommand;
import org.usfirst.frc.team5677.robot.commands.ResetShooterCommandGroup;
import org.usfirst.frc.team5677.robot.commands.ShootCommandGroup;
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
	public OI() {
		gamepad = new GamepadWrapper(RobotMap.OI.GAMEPAD_PORT);
		
		gamepad.getButtonBumperRight().whenPressed(new IntakeConveyorToggleCommandGroup());
		
		gamepad.getButtonBumperLeft().whenPressed(new IntakeConveyorSetSpeedCommandGroup(-1));
		gamepad.getButtonBumperLeft().whenReleased(new IntakeConveyorSetSpeedCommandGroup(0));
		
		gamepad.getButtonA().whenPressed(new IntakeLowerCommand());
		gamepad.getButtonA().whenReleased(new IntakeRaiseCommand());
		
		gamepad.getButtonB().whenPressed(new ShootCommandGroup());
		gamepad.getButtonB().whenReleased(new ResetShooterCommandGroup());
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

