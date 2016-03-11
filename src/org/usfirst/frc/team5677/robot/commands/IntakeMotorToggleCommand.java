package org.usfirst.frc.team5677.robot.commands;

import org.usfirst.frc.team5677.robot.subsystems.Manipulator;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Toggles the intake motor
 * 
 * @author Vedaad Shakib
 */
public class IntakeMotorToggleCommand extends Command {
	Manipulator manipulator;
	
    public IntakeMotorToggleCommand() {
        manipulator = Manipulator.getInstance();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (manipulator.intakeGetSpeed() < 0) {
    		manipulator.intakeSetSpeed(1);
    	} else {
    		manipulator.intakeSetSpeed(0);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
