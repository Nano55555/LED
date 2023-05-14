// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.led.Animation;
import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdleConfiguration;
import com.ctre.phoenix.led.ColorFlowAnimation;
import com.ctre.phoenix.led.CANdle.LEDStripType;
import com.ctre.phoenix.led.CANdle.VBatOutputMode;
import com.ctre.phoenix.led.ColorFlowAnimation.Direction;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LEDsubsystem extends SubsystemBase {
  /** Creates a new LEDsubsystem. */
  private final int LEDS_PER_ANIMATION = 30;
  public static Animation animate = null;
  public static CANdle led = new CANdle(Constants.ledport, "rio");
  public LEDsubsystem() {
    CANdleConfiguration configAll = new CANdleConfiguration();
    configAll.statusLedOffWhenActive = true;
    configAll.disableWhenLOS = false;
    configAll.stripType = LEDStripType.GRB;
    configAll.brightnessScalar = 0.1;
    configAll.vBatOutputMode = VBatOutputMode.Modulated;
    led.configAllSettings(configAll, 100);
  }

  public void turnledonoff(Integer status){

    if(status == 0){
      animate = new ColorFlowAnimation(128, 20, 70, 0, 0.7, LEDS_PER_ANIMATION, Direction.Forward, 0 * LEDS_PER_ANIMATION + 8);
    }
    else if(status ==1){
      led.setLEDs(255, 0, 0);
    }
    else if(status ==2){
      led.setLEDs(0, 0, 0);
    }
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
