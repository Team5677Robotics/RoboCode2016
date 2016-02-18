package org.usfirst.frc.team5677.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Collects a boulder from the ground with the following steps:
 * 1) lowers the intake, 2) sucks in the boulder, and 3) raises the intake
 */
public class CollectBoulderCommandGroup extends CommandGroup {
    Timer timer;
    
    // time taken for the intake mechanism to successfully intake a boulder
    private final double INTAKE_TIME = 1.;
    
    public  CollectBoulderCommandGroup() {
    	timer = new Timer();
    	
    	addSequential(new LowerIntakeCommand());
    	addSequential(new IntakeBoulderCommand());
    	timer.delay(INTAKE_TIME);
    	addSequential(new RaiseIntakeCommand());
    }
}