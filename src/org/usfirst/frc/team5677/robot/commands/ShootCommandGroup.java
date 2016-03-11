package org.usfirst.frc.team5677.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShootCommandGroup extends CommandGroup {
    
    public  ShootCommandGroup() {
        addParallel(new ConveyorLoadBoulderCommand());
        addParallel(new ShooterSetSpeedCommand(1));
        addParallel(new ConveyorSetSpeedCommand(1));
    }
}
