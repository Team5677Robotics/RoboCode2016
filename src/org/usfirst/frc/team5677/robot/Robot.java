package org.usfirst.frc.team5677.robot;

import org.usfirst.frc.team5677.robot.commands.AutonomousCommand;
import org.usfirst.frc.team5677.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5677.robot.subsystems.Manipulator;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * 
 * @author Vedaad Shakib
 * @version 02/11/16
 */
public class Robot extends IterativeRobot {
	CameraServer camera;
	
    /**
     * Initializes the OI, DriveTrain, and Manipulator.
     * 
     * @postcondition initializes the OI and DriveTrain
     */
    public void robotInit() {
    	CameraServer cam = CameraServer.getInstance();
    	// set any cam parameters, then start capture
    	cam.startAutomaticCapture("cam0");
    	
    	SmartDashboard.putDouble("Servo speed", 0);
    	SmartDashboard.putDouble("Auton time", 4.0);
    	SmartDashboard.putBoolean("Auton", true);
    	SmartDashboard.putBoolean("Manual drive scaling", false);
    	OI.initialize();
    	DriveTrain.initialize();
    	Manipulator.initialize();
    }
	
    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    public void disabledInit(){
    }
	
    public void disabledPeriodic() {
    	Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
     * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
     * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
     * below the Gyro
     *
     * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
     * or additional comparisons to the switch structure below with additional strings & commands.
     */
    public void autonomousInit() {
    	if (SmartDashboard.getBoolean("Auton"))
    		(new AutonomousCommand()).start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
