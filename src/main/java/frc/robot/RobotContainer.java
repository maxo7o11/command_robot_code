
package frc.robot;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;


public class RobotContainer {

private final CommandXboxController robotController =
    new CommandXboxController(0);
  private final DriveTrain drivetrain = new DriveTrain();
  private final Wrist wrist = new Wrist();
  private final Turret turret = new Turret();
  private final Launcher launcher = new Launcher();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

    drivetrain.setDefaultCommand(Commands.run(()-> drivetrain.drive.tankDrive(robotController.getLeftY(), robotController.getRightY()), drivetrain));
    
    robotController.povUp().whileTrue(
      Commands.runEnd(
        ()-> wrist.moveWrist(0.1),
        () -> wrist.stopWrist(),
      wrist)
    );
    robotController.povDown().whileTrue(
      Commands.runEnd(
        () -> wrist.moveWrist(-0.1),
        () -> wrist.moveWrist(),
        wrist)
      );
    )
  }
}
