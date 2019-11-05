package frc.robot.commands.autonomous;

import frc.robot.Robot;
import frc.robot.commands.AutoDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class autonomousMvmt extends CommandGroup {
	public AutoDrive autonomousCommand; 


	public autonomousMvmt(Robot robot) {
		addSequential(new AutoDrive(robot.drivetrain, 0.5, 0.0, 0.0, 1.25));
		addSequential(new AutoDrive(robot.drivetrain, 0, -0.5, 0.0, 1.25));
		addSequential(new AutoDrive(robot.drivetrain, .5, 0, 0, .5));
		addSequential(new AutoDrive(robot.drivetrain, 0, 0, -.25, .65));
		addSequential(new AutoDrive(robot.drivetrain, 0.6, 0, 0, 1.3));
		addSequential(new AutoDrive(robot.drivetrain, 0, 0, .25, .75));
	}
}