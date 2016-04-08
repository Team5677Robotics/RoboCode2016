package org.usfirst.frc.team5677.robot.commands;

import org.usfirst.frc.team5677.robot.OI;
import org.usfirst.frc.team5677.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Enables the joystick to control the drivetrain.
 * 
 * @author Vedaad Shakib
 * @version 02/11/16
 */
public class DriveTrainManualDriveCommand extends Command {
	DriveTrain driveTrain;
	
    public DriveTrainManualDriveCommand() {
        driveTrain = DriveTrain.getInstance();
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.setSpeed(OI.getLeftJoystick().getRawAxis(1), OI.getRightJoystick().getRawAxis(1));
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
