// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Controls;
import frc.robot.Subsystems.Drivebase;

public class XboxMove extends Command {
  /** Creates a new XboxMove. */
   Drivebase drivebase;
   double speed;

  public XboxMove(Drivebase m_drivebase) {
    drivebase = m_drivebase;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivebase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //inputs
    double throttle = Controls.xbox_operator.getRightTriggerAxis();
    double reverse = -Controls.xbox_operator.getLeftTriggerAxis();
    double turn = Controls.xbox_operator.getLeftX();
   
    //moves backward
    if (reverse >= -0.05 && throttle <= 0.05){
      // turns right
      if (turn >= 0.2){
        drivebase.move(reverse, reverse*(1-turn));
      }
      //turns left
      else if (turn <= -0.2){
        drivebase.move(reverse*(1+turn), reverse);
      }
      // straight
      else{
        drivebase.move(reverse, reverse);
      }
    }
    //moves forward
    else if (throttle >= 0.05 && reverse <= -0.05){
      // turns right
      if (turn >= 0.2){
        drivebase.move(throttle, throttle*(1-turn));
      }
      // turns left
      else if (turn <= -0.2){
        drivebase.move(throttle*(1+turn), throttle);
      }
      // straight
      else{
        drivebase.move(throttle, throttle);
      }
    }
    else{
      drivebase.stop();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
