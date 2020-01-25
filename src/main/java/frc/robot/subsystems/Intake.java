/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;


public class Intake extends SubsystemBase {
  
  // TODO: check intake deploy method (we need a piston??)
  private VictorSP wheelMotor;
  private DoubleSolenoid intakePiston;

  public Intake() {
    wheelMotor = new VictorSP(WHEEL_INTAKE_MOTOR);
    intakePiston = new DoubleSolenoid(INTAKE_PISTON_1, INTAKE_PISTON_2);

  }

  // MOTORS & PISTONS

  public void wheelSpeed(double speed){
    wheelMotor.set(speed);
  }

  public void deployPiston() {
    intakePiston.set(DoubleSolenoid.Value.kForward);
  }

  public void retractPiston() {
    intakePiston.set(DoubleSolenoid.Value.kReverse);
  }

  public void pistonOff() {
    intakePiston.set(DoubleSolenoid.Value.kOff);
  }

  /* TESTING CODE FOR ONE MOTOR
  public void wheelOnFore() {
    wheelMotor.set(0.5);
  }
  public void wheelOnBack() {
    wheelMotor.set(-0.5);
  }
  public void wheelOff() {
    wheelMotor.set(0);
  }
  
  */

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
