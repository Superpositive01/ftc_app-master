package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Basic TeleOp for Tar
 */

@TeleOp(name = "Servo Test",group = "TAR")
public class TestServo extends OpMode
{
    HardwareTbot robot = new HardwareTbot();


    double count = 0;

    double count2 = 0;

    boolean servoStatLeft = false;
    boolean previousButtonX = false;
    boolean currentButtonX = false;

    boolean servoStatRight = false;
    boolean previousButtonY = false;
    boolean currentButtonY = false;

    @Override
    public void init()
    {

        robot.init(hardwareMap);



    }

    @Override
    public void loop()
    {
        previousButtonX = currentButtonX;
        currentButtonX = gamepad1.x;

        if(currentButtonX && !previousButtonX)
        {
            servoStatLeft = servoStatLeft ? false : true;
            count += .1;
        }

        robot.ballServo.setPosition(servoStatLeft ? count: count);


        previousButtonY = currentButtonY;
        currentButtonY= gamepad1.y;

        if(currentButtonY && !previousButtonY)
        {
            servoStatRight = servoStatRight ? false : true;
            count += .1;
        }

        robot.rightServo.setPosition(servoStatRight ? count: count);

        telemetry.addData("LEFT POS ",robot.leftServo.getPosition());
        telemetry.addData("RIGHT POS ",robot.rightServo.getPosition());
        telemetry.update();


    }

    @Override
    public void stop()
    {

    }
}
