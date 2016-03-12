package org.usfirst.frc.team5677.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * @author Vedaad Shakib
 * @version 02/10/16
 */
public class RobotMap {
    public class DriveTrain {
       public static final int DT_VICTORSP_L_PORT = 0;
       public static final int DT_VICTORSP_R_PORT = 1;
    }
    
    /*
     * Contains constants used by OI instance.
     */
    public class OI {
       public static final int GAMEPAD_PORT = 0;
    }
        
    /*
     * Contains constants used by Manipulator instance.
     */
    public class Manipulator {
    	// 0 = unknown
        public static final int INTAKE_SOLENOID_PORT = 6;
        public static final int INTAKE_TALON_PORT = 6;
        
        public static final int CONVEYOR_SPARK_PORT = 4;
        public static final int CONVEYOR_PISTON_PORT = 7;
        public static final int CONVEYOR_LIMIT_SWITCH_PORT = 1;
        
        public static final int SHOOTER_VICTORSP_PORT = 2;
        public static final int SHOOTER_ENCODER_PORT_A = 0;
        public static final int SHOOTER_ENCODER_PORT_B = 1;
        public static final int SHOOTER_L_LIMIT_SWITCH_PORT = 4;
        public static final int SHOOTER_R_LIMIT_SWITCH_PORT = 5;
        public static final int SHOOTER_HORIZONTAL_ROTATION_SPARK_PORT = 3;
        public static final int SHOOTER_VERTICAL_ROTATION_SPARK_PORT = 7;
    }
}
