/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.OI;

/**
 * An example command. You can replace me with your own command.
 */
public class TeleDrive extends Command {
	Drivetrain drivetrain;

	public TeleDrive(Drivetrain drivetrain) {
		this.drivetrain = drivetrain;
		requires(drivetrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		drivetrain.drive(OI.deadband(-OI.driveController.getY(Hand.kLeft)),
				OI.deadband(OI.driveController.getX(Hand.kLeft)), OI.deadband(OI.driveController.getX(Hand.kRight)));
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}