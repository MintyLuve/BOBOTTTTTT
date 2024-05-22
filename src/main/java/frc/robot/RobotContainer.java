// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.DriveStop;
import frc.robot.Commands.DriveBackward;
import frc.robot.Commands.DriveForward;
import frc.robot.Commands.XboxMove;
import frc.robot.Subsystems.Drivebase;
import frc.robot.Controls;

public class RobotContainer {
  Drivebase drivebase = new Drivebase();
  XboxMove xboxMove = new XboxMove(drivebase);
  private CommandXboxController operator = Controls.operator;


  public RobotContainer() {
    drivebase.setDefaultCommand(xboxMove);
    configureBindings();
  }

  private void configureBindings() {
    //operator.rightTrigger().onTrue(new MoveForward(drivebase, operator.getRightTriggerAxis()));
    //operator.leftTrigger().onTrue(new MoveBackward(drivebase, operator.getLeftTriggerAxis()));
    operator.rightBumper().onTrue(new DriveStop(drivebase));

  }

  public Command getAutonomousCommand(){
    return Commands.print("No autonomous command configured");
  }
}
