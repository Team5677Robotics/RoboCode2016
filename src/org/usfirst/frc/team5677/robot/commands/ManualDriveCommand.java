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
public class ManualDriveCommand extends Command {
	DriveTrain driveTrain;
	
    public ManualDriveCommand() {
        driveTrain = DriveTrain.getInstance();
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	for (int i = 0; i < 12; i++) {
    		System.out.println(i+": "+OI.getGamepad().getRawAxis(i));
    	}
    	driveTrain.setSpeed(OI.getGamepad().getRawAxis(1), OI.getGamepad().getRawAxis(3));
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
