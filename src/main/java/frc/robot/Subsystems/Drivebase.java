// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivebase extends SubsystemBase {
    /** Creates a new Motor. */
    //declare drive motors
    CANSparkMax left_motor_1;
    CANSparkMax left_motor_2;
    CANSparkMax right_motor_1;
    CANSparkMax right_motor_2;


    public Drivebase() {
        //init motors
        left_motor_1 = new CANSparkMax(1, MotorType.kBrushed);
        left_motor_2 = new CANSparkMax(2, MotorType.kBrushed);
        right_motor_1 = new CANSparkMax(3, MotorType.kBrushed);
        right_motor_2 = new CANSparkMax(4, MotorType.kBrushed);

        // motor 2 follors motor 1
        left_motor_2.follow(left_motor_1);
        right_motor_2.follow(right_motor_1);
        // sets idle mode to brake
        left_motor_1.setIdleMode(IdleMode.kBrake);
        right_motor_1.setIdleMode(IdleMode.kBrake);
        //sets left motor 1 to be inverted
        left_motor_1.setInverted(true);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void forward(){
        left_motor_1.set(1);
        right_motor_1.set(1);
    }
    public void backward(){
        left_motor_1.set(-1);
        right_motor_1.set(-1);
    }
    public void stop(){
        left_motor_1.set(0);
        right_motor_1.set(0);
    }
    public void move(double left, double right){
        left_motor_1.set(left);
        right_motor_1.set(right);
    }
}
