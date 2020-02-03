
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

import static frc.robot.Constants.*;

public class RobotContainer {

    // SUBSYSTEMS
    private final Climber CLIMBER = new Climber();

    // CLIMBER COMMMANDS
    private final StartEndCommand raiseLifter = new StartEndCommand(
        () -> CLIMBER.setLifterSpeed(0.75),
        () -> CLIMBER.setLifterSpeed(0),
        CLIMBER
    );

    private final StartEndCommand lowerLifter = new StartEndCommand(
        () -> CLIMBER.setLifterSpeed(-0.75),
        () -> CLIMBER.setLifterSpeed(0),
        CLIMBER
    );

    private final StartEndCommand gearClimb = new StartEndCommand(
        () -> CLIMBER.setGearMotorSpeed(0.75),
        () -> CLIMBER.setGearMotorSpeed(0),
        CLIMBER
    );



    // MAKE A NEW JOYSTICK

    public final Joystick opController = new Joystick(OPERATOR_CONTROLLER);
  
    // CONFIG BUTTON BINDINGS (See constants.java to change specific ports etc.)

    // CLIMB BUTTONS

    private final JoystickButton raiseUpButton = new JoystickButton(opController, RAISE_UP_BUTTON),
                                 lowerDownButton = new JoystickButton(opController, LOWER_DOWN_BUTTON),
                                 gearClimbButton = new JoystickButton(opController, GEAR_CLIMB_BUTTON);

    public RobotContainer() {
        configureButtonActions();
    }

    /**
     * Config button actions: it changes what does each button do. Don't touch this to change bindings
     */
    private void configureButtonActions() {
        // CLIMB BUTTONS
        raiseUpButton.whenHeld(raiseLifter);
        lowerDownButton.whenHeld(lowerLifter);
        gearClimbButton.whenHeld(gearClimb);
 
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */

    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return null;
    }

}