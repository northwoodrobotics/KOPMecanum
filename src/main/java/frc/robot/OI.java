/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static final XboxController driveController = new XboxController(0);
	public static final JoystickButton driveA = new JoystickButton(driveController, 1);
	public static final JoystickButton driveB = new JoystickButton(driveController, 2);
	public static final JoystickButton driveX = new JoystickButton(driveController, 3);
	public static final JoystickButton driveY = new JoystickButton(driveController, 4);
	public static final JoystickButton driveLTrigger = new JoystickButton(driveController, 5);
	public static final JoystickButton driveRTrigger = new JoystickButton(driveController, 6);

	public static double deadband(double input) {
		double radius = 0.1;
		double output = 0;
		if (input > radius) {
			output = ((1 / 1 - radius) * (input - 1)) + 1;
		} else if (input < -radius) {
			output = ((1 / 1 - radius) * (input + 1)) - 1;
		}

		return output;
	}

	public OI() {

		// Add stuff in here to make the JoystickButtons trigger commands:

		// driveA.whenPressed(new ExampleCommand());
		// driveA.whenReleased(new ExampleCommand());
		// driveA.whileHeld(new ExampleCommand());

		// Of course, you should replace ExampleCommand with the name of the command you
		// want to trigger.
	}

	public static double deadzoneof(double input) {
		double deadzonewidth = 0.2;
		double result = 0;
		if (input <= -deadzonewidth) {
			result = ((1 / (1 - deadzonewidth)) * (input + 1)) - 1;
		} else if (input >= deadzonewidth) {
			result = ((1 / (1 - deadzonewidth)) * (input - 1)) + 1;
		}
		return result;
	}

}