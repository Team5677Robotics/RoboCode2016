package org.usfirst.frc.team5677.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeConveyorToggleCommandGroup extends CommandGroup {
    
    public  IntakeConveyorToggleCommandGroup() {
        addParallel(new ConveyorMotorToggleCommand());
        addParallel(new IntakeToggleCommand());
        addParallel(new IntakeMotorToggleCommand());
    }
}
