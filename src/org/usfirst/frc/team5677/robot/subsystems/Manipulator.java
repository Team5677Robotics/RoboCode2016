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

    // motors and solenoids for the intake mechanism
    private Solenoid intakeSolenoid;
    private Talon intakeTalon;

    // motors, solenoids, and limit switches for the conveyor mechanism
    private Spark conveyorSpark;
    private Solenoid conveyorPiston;
    private DigitalInput conveyorLimitSwitch;

    // motors, solenoids, and limit switches for the shooting mechanism
    private VictorSP shooterVictorSP;
    private Encoder shooterEncoder;
    private Spark shooterHorizRotSpark;
    private Spark shooterVertRotSpark;
    private DigitalInput shooterRightLimitSwitch;
    private DigitalInput shooterLeftLimitSwitch;

    // constants to scale the speed of the intake, conveyor, and shooter motors
    private final double INTAKE_SCALE = 0.7;
    private final double CONVEYOR_SCALE = 0.7;
    private final double SHOOTER_SCALE = 0.7;
    private final double HORIZ_ROT_SCALE = 0.7;

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
		shooterRightLimitSwitch = new DigitalInput(RobotMap.Manipulator.SHOOTER_R_LIMIT_SWITCH_PORT);
		shooterLeftLimitSwitch = new DigitalInput(RobotMap.Manipulator.SHOOTER_L_LIMIT_SWITCH_PORT);
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
     * Toggles the state of the intake by toggling the intake solenoid.
     */
    public void toggleIntake() {
    	intakeSolenoid.set(!intakeSolenoid.get());
    }

    /**
     * Lowers the intake by turning the solenoid on.
     */
    public void lowerIntake() {
    	intakeSolenoid.set(true);
    }

    /**
     * Raises the intake by turning the intake solenoid off.
     */
    public void raiseIntake() {
    	intakeSolenoid.set(false);
    }

    /**
     * Intakes boulders by running the intake talon forward.
     *
     * @precondition intake is lowered
     */
    public void intakeBoulder() {
    	if (isIntakeLowered()) intakeTalon.set(INTAKE_SCALE);
    }

    /**
     * Ejects boulders by running the intake talon in reverse.
     *
     * @precondition intake is lowered
     */
    public void ejectBoulder() {
    	if (isIntakeLowered()) intakeTalon.set(-INTAKE_SCALE);
    }

    /**
     * Raises the boulder via the conveyor by running the conveyor spark forward.
     */
    public void conveyorRaiseBoulder() {
    	conveyorSpark.set(CONVEYOR_SCALE);
    }

    /**
     * Lowers the boulder via the conveyor by running the conveyor spark in reverse.
     */
    public void conveyorLowerBoulder() {
    	conveyorSpark.set(-CONVEYOR_SCALE);
    }

    /**
     * Returns whether the ball in the conveyor has reached its maximum height.
     *
     * @return whether the ball in the conveyor has reached its maximum height.
     */
    public boolean isConveyorHeightMax() {
    	return conveyorLimitSwitch.get();
    }

    /**
     * Loads the boulder from the conveyor into the shooter by powering the conveyor solenoid.
     */
    public void loadBoulder() {
    	conveyorPiston.set(true);
    }

    /**
     * Resets the conveyor loader by turning off the conveyor solenoid.
     */
    public void resetLoader() {
    	conveyorPiston.set(false);
    }
    
    public double getShooterSpeed() {
    	return shooterVictorSP.get();
    }
    
    public void setShooterSpeed(double speed) {
    	shooterVictorSP.set(SHOOTER_SCALE*speed);
    }
    
    public int getEncoderCount() {
    	return shooterEncoder.get();
    }
    
    public boolean isRightLimitSwitchTriggered() {
    	return shooterRightLimitSwitch.get();
    }
    
    public boolean isLeftLimitSwitchTriggered() {
    	return shooterLeftLimitSwitch.get();
    }
    
    public double getHorizRotSpeed() {
    	return shooterHorizRotSpark.get();
    }
    
    public void setHorizRotSpeed(double speed) {
    	shooterHorizRotSpark.set(HORIZ_ROT_SCALE*speed);
    }
}

