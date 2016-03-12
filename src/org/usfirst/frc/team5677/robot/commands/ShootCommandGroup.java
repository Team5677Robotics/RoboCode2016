package org.usfirst.frc.team5677.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShootCommandGroup extends CommandGroup {    
	
    public  ShootCommandGroup() {
        addSequential(new ShooterSetSpeedCommand(1));
        addSequential(new ConveyorSetSpeedCommand(1));
    }
}
