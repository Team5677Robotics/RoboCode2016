package org.usfirst.frc.team5677.robot;

import org.usfirst.frc.team5677.robot.commands.ConveyorLoadAndResetBoulderCommandGroup;
import org.usfirst.frc.team5677.robot.commands.ConveyorLoadBoulderCommand;
import org.usfirst.frc.team5677.robot.commands.ConveyorResetLoaderCommand;
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
import org.usfirst.frc.team5677.robot.wrappers.JoystickButtonWrapper;

import edu.wpi.first.wpilibj.Joystick;
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
	private static Joystick leftJoystick;
	private static Joystick rightJoystick;
	private static Joystick manipulatorJoystick;
	
	/*
	 * Creates gamepad instance.
	 */
	public OI() {
		gamepad = new GamepadWrapper(RobotMap.OI.GAMEPAD_PORT);
	
		gamepad.getButtonBumperRight().whenPressed(new IntakeConveyorSetSpeedCommandGroup(1));
		gamepad.getButtonBumperRight().whenReleased(new IntakeConveyorSetSpeedCommandGroup(0));
		
		gamepad.getButtonBumperLeft().whenPressed(new IntakeConveyorSetSpeedCommandGroup(-1));
		gamepad.getButtonBumperLeft().whenReleased(new IntakeConveyorSetSpeedCommandGroup(0));
		
		gamepad.getButtonA().whenPressed(new IntakeToggleCommand());
		
		gamepad.getButtonB().whenPressed(new ShootCommandGroup());
		gamepad.getButtonB().whenReleased(new ResetShooterCommandGroup());
		
		gamepad.getButtonTriggerRight().whenPressed(new ConveyorLoadBoulderCommand());
		gamepad.getButtonTriggerRight().whenReleased(new ConveyorResetLoaderCommand());
		
		leftJoystick = new Joystick(0);
		rightJoystick = new Joystick(1);
		manipulatorJoystick = new Joystick(2);
		
		JoystickButtonWrapper button12 = new JoystickButtonWrapper(manipulatorJoystick, 12);
		button12.whenPressed(new IntakeConveyorSetSpeedCommandGroup(1));
		button12.whenReleased(new IntakeConveyorSetSpeedCommandGroup(0));
		
		JoystickButtonWrapper button8 = new JoystickButtonWrapper(manipulatorJoystick, 8);
		button8.whenPressed(new IntakeConveyorSetSpeedCommandGroup(-1));
		button8.whenReleased(new IntakeConveyorSetSpeedCommandGroup(0));
		
		JoystickButtonWrapper button2 = new JoystickButtonWrapper(manipulatorJoystick, 2);
		button2.whenPressed(new IntakeToggleCommand());
		
		JoystickButtonWrapper button1 = new JoystickButtonWrapper(manipulatorJoystick, 1);
		button1.whenPressed(new ShootCommandGroup());
		button1.whenReleased(new ResetShooterCommandGroup());
		
		JoystickButtonWrapper button9 = new JoystickButtonWrapper(manipulatorJoystick, 9);
		button9.whenPressed(new ConveyorLoadBoulderCommand());
		button9.whenReleased(new ConveyorResetLoaderCommand());
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
	
	public static Joystick getLeftJoystick() {
		return leftJoystick;
	}
	
	public static Joystick getRightJoystick() {
		return rightJoystick;
	}
	
	public static Joystick getManipulatorJoystick() {
		return manipulatorJoystick;
	}
}

