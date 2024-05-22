// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.MotorStop;
import frc.robot.Commands.MoveBackward;
import frc.robot.Commands.MoveForward;
import frc.robot.Subsystems.Motor;
import frc.robot.Controls;

public class RobotContainer {
  Motor motor = new Motor();
  CommandXboxController operator = Controls.operator;

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    operator.rightTrigger().onTrue(new MoveForward(motor));
    operator.leftTrigger().onTrue(new MoveBackward(motor));
    operator.rightBumper().onTrue(new MotorStop(motor));
  }

  public Command getAutonomousCommand(){
    return Commands.print("No autonomous command configured");
  }
}
