/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// DRIVETRAIN
	public static final int drivetrainLF = 3;
	public static final int drivetrainRF = 0;
	public static final int drivetrainLB = 2;
	public static final int drivetrainRB = 1;
	public static final boolean lfInverted = true;
	public static final boolean rfInverted = false;
	public static final boolean lbInverted = true;
	public static final boolean rbInverted = false;
}