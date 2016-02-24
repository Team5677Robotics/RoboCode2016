//package org.usfirst.frc.team5677.robot.commands;
//
//import org.usfirst.frc.team5677.robot.subsystems.Manipulator;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// * Sets the speed of the shooter.
// * 
// * @author Vedaad Shakib
// */
//public class ShooterSetSpeedCommand extends Command {
//	Manipulator manipulator;
//	private double speed;
//	
//    public ShooterSetSpeedCommand(double speed) {
//    	this.speed = speed;
//    	
//        manipulator = Manipulator.getInstance();
//        requires(manipulator);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    	manipulator.setShooterSpeed(speed);;
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return true;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
//}
