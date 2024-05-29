package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ControllerConstants;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj2.command.button.Trigger;
public class Controls {
  public static final String DriveConstants = null;
  /* The driver's controller */
  public static XboxController xbox_driver = new XboxController(ControllerConstants.DRIVER_PORT);
  public static XboxController xbox_operator = new XboxController(ControllerConstants.OPERATOR_PORT);
  public static CommandXboxController driver = new CommandXboxController(ControllerConstants.DRIVER_PORT); // Creates a CommandXboxController on port 1.
  public static CommandXboxController operator = new CommandXboxController(ControllerConstants.OPERATOR_PORT); // Creates a CommandXboxController on port 1.
}