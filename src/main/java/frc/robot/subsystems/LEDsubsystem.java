// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdleConfiguration;
import com.ctre.phoenix.led.CANdle.LEDStripType;
import com.ctre.phoenix.led.CANdle.VBatOutputMode;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LEDsubsystem extends SubsystemBase {
  /** Creates a new LEDsubsystem. */
  public static CANdle led = new CANdle(Constants.ledport, "LED");
  public LEDsubsystem() {
    CANdleConfiguration configAll = new CANdleConfiguration();
    configAll.statusLedOffWhenActive = true;
    configAll.disableWhenLOS = false;
    configAll.stripType = LEDStripType.GRB;
    configAll.brightnessScalar = 0.1;
    configAll.vBatOutputMode = VBatOutputMode.Modulated;
    led.configAllSettings(configAll, 100);
  }

  public void turnledonoff(boolean status){

    if(status){
      led.setLEDs(255, 0, 0);
    }
    else{
      led.setLEDs(0, 0, 0);
    }
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
