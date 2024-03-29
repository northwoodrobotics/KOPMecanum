/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;


import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.autonomous.autonomousMvmt;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
	public Drivetrain drivetrain;
	public OI oi;
	public autonomousMvmt autonomousCommand;
	private enum Direction {FORWARD, BACKWARD}
	SendableChooser<Direction> sideChooser= new SendableChooser<>();


	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		drivetrain = new Drivetrain();
		drivetrain.init();
		oi = new OI();
		sideChooser.addDefault("Move Forward", Direction.FORWARD);
		sideChooser.addObject("Move Backward", Direction.BACKWARD);
		SmartDashboard.putData("Move", sideChooser);
	;
	
	}

	/**
	 * This function is called every robot packet, no matter the mode. Use this for
	 * items like diagnostics that you want ran during disabled, autonomous,
	 * teleoperated and test.
	 *
	 * <p>
	 * This runs after the mode specific periodic functions, but before LiveWindow
	 * and SmartDashboard integrated updating.
	 */
	@Override
	public void robotPeriodic() {
		SmartDashboard.putNumber("deadzone of driver left x ", OI.deadzoneof(OI.driveController.getX(Hand.kLeft)));
		SmartDashboard.putNumber("deadzone of driver left y ", OI.deadzoneof(-OI.driveController.getY(Hand.kLeft)));
		SmartDashboard.putNumber("deadzone of driver right x ", OI.deadzoneof(OI.driveController.getX(Hand.kRight)));

	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called once each time the robot enters Autonomous mode.
	 */
	@Override
	public void autonomousInit() {
		// schedule the autonomous command
		autonomousCommand = new autonomousMvmt(this);
		Direction direction = sideChooser.getSelected();
			
			if(direction == Direction.FORWARD) {
				autonomousCommand.goForward(this);
			} else if (direction == Direction.BACKWARD){
				autonomousCommand.goBackward(this);
			}
		
		autonomousCommand.start();
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
	}
}
