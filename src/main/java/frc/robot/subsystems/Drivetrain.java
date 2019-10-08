/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.TeleDrive;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * A mecanum drivetrain with WPI_VictorSPX motor controllers.
 */
public class Drivetrain extends Subsystem {
	private VictorSP leftFront;
	private VictorSP rightFront;
	private VictorSP leftBack;
	private VictorSP rightBack;

	public void init() {
		leftFront = new VictorSP(RobotMap.drivetrainLF);
		rightFront = new VictorSP(RobotMap.drivetrainRF);
		leftBack = new VictorSP(RobotMap.drivetrainLB);
		rightBack = new VictorSP(RobotMap.drivetrainRB);

		leftFront.setInverted(RobotMap.lfInverted);
		rightFront.setInverted(RobotMap.rfInverted);
		leftBack.setInverted(RobotMap.lbInverted);
		rightBack.setInverted(RobotMap.rbInverted);
	}

	public void drive(double forward, double strafe, double rotate) {
		leftFront.set(forward + strafe + rotate);
		rightFront.set(forward - strafe - rotate);
		leftBack.set(forward - strafe + rotate);
		rightBack.set(forward + strafe - rotate);
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new TeleDrive(this));
	}
}