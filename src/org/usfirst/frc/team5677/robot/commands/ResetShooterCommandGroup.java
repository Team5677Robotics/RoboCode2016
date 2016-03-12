package org.usfirst.frc.team5677.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ResetShooterCommandGroup extends CommandGroup {
    
    public  ResetShooterCommandGroup() {
        addSequential(new ShooterSetSpeedCommand(0));
        addSequential(new ConveyorSetSpeedCommand(0));
    }
}
