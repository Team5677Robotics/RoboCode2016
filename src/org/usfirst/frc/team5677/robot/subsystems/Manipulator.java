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

    /**
     * Initializes the various motors and solenoids of the manipulator.
     */
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

    /**
     * If the singleton instance of Manipulator is null, initialize it.
     */
    public static void initialize() {
	if (manipulator == null) {
	    manipulator = new Manipulator();
	}
    }

    /**
     * Gets the singleton instance of Manipulator.
     *
     * @return the singleton instance of Manipulator.
     */
    public static Manipulator getInstance() {
	initialize();
	return manipulator;
    }

    /**
     * Returns true if the intake is lowered; false otherwise.
     *
     * @return true if the intake is lowered; false otherwise
     */
    public boolean isIntakeLowered() {
	return intakeSolenoid.get();
    }

    /**
     * Returns false if the intake is raised; false otherwise.
     *
     * @return false if the intake is raised; false otherwise
     */
    public boolean isIntakeRaised() {
	return !intakeSolenoid.get();
    }

    /**
     * Toggles the state of the intake.
     */
    public void toggleIntake() {
	intakeSolenoid.set(!intakeSolenoid.get());
    }

    /**
     * Lowers the intake.
     */
    public void lowerIntake() {
	intakeSolenoid.set(1);
    }

    /**
     * Raises the intake.
     */
    public void raiseIntake() {
	intakeSolenoid.set(0);
    }

    /**
     * Intakes boulders.
     *
     * @precondition intake is lowered
     */
    public void intakeBoulder() {
	if (isIntakeLowered) intakeVictorSP.set(0.7);
    }

    /**
     * Ejects boulders.
     *
     * @precondition intake is lowered
     */
    public void intakeBoulder() {
	if (isIntakeLowered) intakeVictorSP.set(-0.7);
    }
}

