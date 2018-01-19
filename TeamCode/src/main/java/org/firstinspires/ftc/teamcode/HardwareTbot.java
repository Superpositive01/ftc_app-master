package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Preston Robbins on 11/6/2017.
 */

public class HardwareTbot
{
    /*Public hardware*/


    //all these motors support tank drive so the robot can move
    public DcMotor mRight;
    public DcMotor mLeft;


    //for rack
    public DcMotor lift;


    //for servo
    public Servo leftServo;
    public Servo rightServo;
    public Servo ballServo;

    //public Servo gemServo;

    //start init


    HardwareMap hwMap;

    public HardwareTbot()
    {

    }

    public void init(HardwareMap ahwMap)
    {
        hwMap = ahwMap;

        //map the parts holo motors
        mRight= ahwMap.get(DcMotor.class, "right motor");
        mLeft = ahwMap.get(DcMotor.class, "left motor");

        mLeft.setDirection(DcMotor.Direction.REVERSE);

        lift = ahwMap.get(DcMotor.class,"lift");

        leftServo = ahwMap.get(Servo.class,"left servo");
        rightServo = ahwMap.get(Servo.class,"right servo");
        ballServo = ahwMap.get(Servo.class,"ball servo");

        //gemServo = ahwMap.get(Servo.class,"gem servo");
        leftServo.setDirection(Servo.Direction.REVERSE);




    }
}
