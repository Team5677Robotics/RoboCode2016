package org.usfirst.frc.team5677.robot.commands;

import org.usfirst.frc.team5677.robot.subsystems.Manipulator;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Turns on the motor for the intake to suck in the boulder.
 * 
 * @author Vedaad Shakib
 */
public class IntakeBoulderCommand extends Command {
	Manipulator manipulator;
	private double speed;
	
    public IntakeBoulderCommand(double speed) {
    	this.speed = speed;
    	
        manipulator = Manipulator.getInstance();
        requires(manipulator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	manipulator.intakeSetSpeed(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
