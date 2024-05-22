package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj2.command.button.Trigger;
public class Controls {
  public static final String DriveConstants = null;
  /* The driver's controller */
  public static XboxController xbox_driver = new XboxController(0);
  public static XboxController xbox_operator = new XboxController(1);
  public static CommandXboxController driver = new CommandXboxController(0); // Creates a CommandXboxController on port 1.
  public static CommandXboxController operator = new CommandXboxController(1); // Creates a CommandXboxController on port 1.
}