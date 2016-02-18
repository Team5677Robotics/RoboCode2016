package org.usfirst.frc.team5677.robot.subsystems;

import org.usfirst.frc.team5677.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
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
    private Talon intakeTalon;

    private Spark conveyorSpark;
    private Solenoid conveyorPiston;
    private DigitalInput conveyorLimitSwitch;

    private VictorSP shooterVictorSP;
    private Encoder shooterEncoder;
    private Spark shooterHorizRotSpark;
    private Spark shooterVertRotSpark;
    
    private final double INTAKE_SCALE = 0.7;
    private final double CONVEYOR_SCALE = 0.7;

    /**
     * Initializes the various motors and solenoids of the manipulator.
     */
    public Manipulator() {
		intakeSolenoid = new Solenoid(RobotMap.Manipulator.INTAKE_SOLENOID_PORT);
		intakeTalon = new Talon(RobotMap.Manipulator.INTAKE_TALON_PORT);
		
		conveyorSpark = new Spark(RobotMap.Manipulator.CONVEYOR_SPARK_PORT);
		conveyorLimitSwitch = new DigitalInput(RobotMap.Manipulator.CONVEYOR_LIMIT_SWITCH_PORT);
		conveyorPiston = new Solenoid(RobotMap.Manipulator.CONVEYOR_PISTON_PORT);
		
		shooterVictorSP = new VictorSP(RobotMap.Manipulator.SHOOTER_VICTORSP_PORT);
		shooterEncoder = new Encoder(RobotMap.Manipulator.SHOOTER_ENCODER_PORT_A, RobotMap.Manipulator.SHOOTER_ENCODER_PORT_B);
		shooterHorizRotSpark = new Spark(RobotMap.Manipulator.SHOOTER_HORIZONTAL_ROTATION_SPARK_PORT);
		shooterVertRotSpark = new Spark(RobotMap.Manipulator.SHOOTER_VERTICAL_ROTATION_SPARK_PORT);
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
    	intakeSolenoid.set(true);
    }

    /**
     * Raises the intake.
     */
    public void raiseIntake() {
    	intakeSolenoid.set(false);
    }

    /**
     * Intakes boulders.
     *
     * @precondition intake is lowered
     */
    public void intakeBoulder() {
    	if (isIntakeLowered()) intakeTalon.set(INTAKE_SCALE);
    }

    /**
     * Ejects boulders.
     *
     * @precondition intake is lowered
     */
    public void ejectBoulder() {
    	if (isIntakeLowered()) intakeTalon.set(-INTAKE_SCALE);
    }

    public void conveyorRaiseBoulder() {
    	conveyorSpark.set(CONVEYOR_SCALE);
    }

    public void conveyorLowerBoulder() {
    	conveyorSpark.set(-CONVEYOR_SCALE);
    }

    public boolean isConveyorHeightMax() {
    	return conveyorLimitSwitch.get();
    }

    public void loadBoulder() {
    	conveyorPiston.set(true);
    }

    public void resetLoader() {
    	conveyorPiston.set(false);
    }
}

