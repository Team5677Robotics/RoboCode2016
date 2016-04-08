package org.usfirst.frc.team5677.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ConveyorLoadAndResetBoulderCommandGroup extends CommandGroup {
    
    public  ConveyorLoadAndResetBoulderCommandGroup() {
       addSequential(new ConveyorLoadBoulderCommand());
       for (int i = 0; i < 100000; i++) {
    	   int a = 5;
       }
       addSequential(new ConveyorResetLoaderCommand());
    }
}
