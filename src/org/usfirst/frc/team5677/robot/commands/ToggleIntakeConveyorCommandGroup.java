package org.usfirst.frc.team5677.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Toggle the following: intake lower, intake motor on, conveyor motor on
 */
public class ToggleIntakeConveyorCommandGroup extends CommandGroup {
    
    public  ToggleIntakeConveyorCommandGroup() {
    	addParallel(new IntakeToggleCommand());
    	addParallel(new IntakeMotorToggleCommand());
    	addParallel(new ConveyorMotorToggleCommand());
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
