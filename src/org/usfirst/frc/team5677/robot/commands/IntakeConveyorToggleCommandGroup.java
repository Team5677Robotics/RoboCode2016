package org.usfirst.frc.team5677.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeConveyorToggleCommandGroup extends CommandGroup {
    
    public  IntakeConveyorToggleCommandGroup() {
    	System.out.println("intake conveyor command called");
        addParallel(new ConveyorMotorToggleCommand());
        addParallel(new IntakeMotorToggleCommand());
    }
}
