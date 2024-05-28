// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
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
    double sensitivity = Constants.ControllerConstants.CONTROLLER_SENSITIVITY;
    XboxController driver = Controls.xbox_driver;
    //get controller inputs
    double throttle = driver.getRightTriggerAxis();
    double reverse = -1 * driver.getLeftTriggerAxis();
    boolean pirouette = driver.getLeftStickButton();
    boolean precision = driver.getRightBumper();
    boolean stop = driver.getLeftBumper();
    
    //gets percent
    double percent = 1;
    if (precision){
      percent = Constants.ControllerConstants.PRECISION_PRECENT;
    }
    if (stop){
      percent = 0;
    }
    // calc power + get turn
    double power = (throttle + reverse) * percent;
    double turn = driver.getLeftX() * percent;

    // if moving forward
    if (throttle >= sensitivity && Math.abs(reverse) <= sensitivity){
      drivebase.move(power*(1+turn), power*(1-turn));
    }
    // if moving backward
    else if (Math.abs(reverse) >= sensitivity && throttle <= sensitivity){
      drivebase.move(power*(1+turn), power*(1-turn));
    }
    // if not moving
    else{
      drivebase.move(0, 0);
    }

    //piroutette
    if (pirouette){
      //turning left
      if (turn < sensitivity){
        drivebase.move(-1 * Math.abs(turn), Math.abs(turn));
      }
      //turning right
      else if (turn > sensitivity) {
        drivebase.move(Math.abs(turn), -1 * Math.abs(turn));
      }
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
