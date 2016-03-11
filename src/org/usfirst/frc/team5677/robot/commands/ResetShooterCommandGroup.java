package org.usfirst.frc.team5677.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ResetShooterCommandGroup extends CommandGroup {
    
    public  ResetShooterCommandGroup() {
        addParallel(new ShooterSetSpeedCommand(0));
        addParallel(new ConveyorResetLoaderCommand());
        addParallel(new ConveyorSetSpeedCommand(0));
        
    }
}
