package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

/**
 * Basic TeleOp for Tar
 */

@TeleOp(name = "TeleOp",group = "TAR")
public class TeleOpT extends OpMode
{
    HardwareTbot robot = new HardwareTbot();


    @Override
    public void init()
    {

        robot.init(hardwareMap);
        robot.ballServo.setPosition(1);

    }

    @Override
    public void loop()
    {
        double left  = -gamepad1.left_stick_y;
        double right = -gamepad1.right_stick_y;


        robot.mLeft.setPower(left);
        robot.mRight.setPower(right);



        if(gamepad1.b)
        {
            robot.lift.setPower(1 * .50);
        }

        else if(gamepad1.y)
        {
            robot.lift.setPower(-1 * .50);
        }

        else
        {
            robot.lift.setPower(0);
        }


        if(gamepad1.right_bumper)
        {
            robot.leftServo.setPosition(.0);
            robot.rightServo.setPosition(.0);
            telemetry.addData("LEft pos",robot.leftServo.getPosition());
            telemetry.addData("right pos",robot.rightServo.getPosition());

            telemetry.update();
        }

        if(gamepad1.left_bumper)
        {
            robot.leftServo.setPosition(.79);
            robot.rightServo.setPosition(.5);
            telemetry.addData("right pos",robot.rightServo.getPosition());
            telemetry.addData("LEft pos",robot.leftServo.getPosition());

            telemetry.update();
        }

    }

    @Override
    public void stop()
    {

    }
}
