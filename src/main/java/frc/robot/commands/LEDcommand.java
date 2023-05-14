// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LEDsubsystem;

public class LEDcommand extends CommandBase {
  /** Creates a new LEDcommand. */
  public static LEDsubsystem LEDsubsystem= new LEDsubsystem();
  public static XboxController controller = new XboxController(0);

  public LEDcommand(LEDsubsystem LEDsubsystem) {
    this.LEDsubsystem = LEDsubsystem;
    addRequirements(LEDsubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(controller.getAButtonPressed()){
      LEDsubsystem.turnledonoff(0);
    }
    if(controller.getXButtonPressed()){
      LEDsubsystem.turnledonoff(1);
    }
    else if(controller.getBButtonPressed()){
      LEDsubsystem.turnledonoff(2);
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
