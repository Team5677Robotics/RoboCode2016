package org.usfirst.frc.team5677.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Completely primes the boulder for shooting by executing the following actions:
 * 1) Raises the boulder via the conveyor and 2) Pushes the boulder into the shooting mechanism.
 */
public class ConveyorPrimeBoulderCommandGroup extends CommandGroup {
    Timer timer;
    
    // time it takes the loading mechanism to load the boulder
    private final double LOADING_TIME = 0.5;
    
    public ConveyorPrimeBoulderCommandGroup() {
    	addSequential(new ConveyorRaiseBoulderCommand());
    	addSequential(new ConveyorLoadBoulderCommand());
    	timer.delay(LOADING_TIME);
    	addSequential(new ConveyorResetLoaderCommand());
    }
}
