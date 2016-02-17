package org.usfirst.frc.team5677.robot.subsystems;

import org.usfirst.frc.team5677.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This subsystem operates the Manipulator and 
 * contains methods to do a variety of functions.
 * 
 * @author Vedaad Shakib
 * @version 2/16/16
 */
public class Manipulator extends Subsystem {
    // singleton instance of Manipulator
    private static Manipulator manipulator;

    private Solenoid intakeSolenoid;
    private VictorSP intakeVictorSP;

    private VictorSP conveyorVictorSP;
    // assuming it's a solenoid until further notification
    private Solenoid conveyorPiston;

    private VictorSP shooterVictorSP;
    private Encoder shooterEncoder;
    private VictorSP shooterHorizRotVictorSP;
    private VictorSP shooterVertRotVictorSP;

    public Manipulator() {
		intakeSolenoid = new Solenoid(RobotMap.Manipulator.INTAKE_SOLENOID_PORT);
		intakeVictorSP = new VictorSP(RobotMap.Manipulator.INTAKE_VICTORSP_PORT);
		
		conveyorVictorSP = new VictorSP(RobotMap.Manipulator.CONVEYOR_VICTORSP_PORT);
		conveyorPiston = new Solenoid(RobotMap.Manipulator.CONVEYOR_PISTON_PORT);
		
		shooterVictorSP = new VictorSP(RobotMap.Manipulator.SHOOTER_VICTORSP_PORT);
		shooterEncoder = new Encoder(RobotMap.Manipulator.SHOOTER_ENCODER_PORT_A, RobotMap.Manipulator.SHOOTER_ENCODER_PORT_B);
		shooterHorizRotVictorSP = new VictorSP(RobotMap.Manipulator.SHOOTER_HORIZONTAL_ROTATION_VICTORSP_PORT);
		shooterVertRotVictorSP = new VictorSP(RobotMap.Manipulator.SHOOTER_VERTICAL_ROTATION_VICTORSP_PORT);
    }

    public void initDefaultCommand() {
    }

    public static void initialize() {
	if (manipulator == null) {
	    manipulator = new Manipulator();
	}
    }

    public static Manipulator getInstance() {
	initialize();
	return manipulator;
    }
}

