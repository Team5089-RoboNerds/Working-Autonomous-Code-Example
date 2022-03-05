// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class autonomousCommand extends CommandBase {
  /** Creates a new autonomousCommand. */

  Timer time;
  public autonomousCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  addRequirements(RobotContainer.mButtonExampleSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    time = new Timer();

    time.reset();
    time.start();

    System.out.println("Auto Init");

    RobotContainer.mButtonExampleSubsystem.setRaw(0);


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if(time.get()<=2)
    {
    RobotContainer.mButtonExampleSubsystem.setRaw(0.5);
    }
    else if(time.get()>=2 && time.get()<=6)
    {
     RobotContainer.mButtonExampleSubsystem.setRaw(-0.5); 
    }
    else if(time.get()>6){
      RobotContainer.mButtonExampleSubsystem.setRaw(0); 

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
