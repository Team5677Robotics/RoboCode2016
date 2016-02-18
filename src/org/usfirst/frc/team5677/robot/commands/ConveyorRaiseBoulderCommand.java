package org.usfirst.frc.team5677.robot.commands;

import org.usfirst.frc.team5677.robot.subsystems.Manipulator;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Raises the ball via the conveyor by powering the conveyor motor.
 * 
 * @author Vedaad Shakib
 */
public class ConveyorRaiseBoulderCommand extends Command {
	Manipulator manipulator;
	
    public ConveyorRaiseBoulderCommand() {
        manipulator = Manipulator.getInstance();
        requires(manipulator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	manipulator.conveyorRaiseBoulder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return manipulator.isConveyorHeightMax();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
