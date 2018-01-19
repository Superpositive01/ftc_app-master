package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by Preston Robbins on 1/10/2018.
 */


/*Program that checks the color of the ball and moves a certain way*/
@Autonomous(name = "RED TEST",group = "Test")
public class AutoBlue extends LinearOpMode {
    HardwareTbot robot = new HardwareTbot();
    ColorSensor sensor;

    @Override
    public void runOpMode() {
        sensor = hardwareMap.get(ColorSensor.class, "Ball Color Sensor");

        robot.init(hardwareMap);
        boolean flag = true;
        robot.ballServo.setPosition(1);
        float hsvValues[] = {0F, 0F, 0F};

        final float values[] = hsvValues;

        final double SCALE_FACTOR = 255;

        int relativeLayoutId = hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hardwareMap.appContext.getPackageName());
        final View relativeLayout = ((Activity) hardwareMap.appContext).findViewById(relativeLayoutId);


        waitForStart();

        robot.ballServo.setPosition(0.2);
        int ctr1 = 0;
        while (ctr1 < 2000000 && opModeIsActive()) {
            ctr1++;
        }

        while (opModeIsActive() && flag) {

            Color.RGBToHSV((int) (sensor.red() * SCALE_FACTOR),
                    (int) (sensor.green() * SCALE_FACTOR),
                    (int) (sensor.blue() * SCALE_FACTOR),
                    hsvValues);

            if (sensor.red() > 60 && sensor.red() > sensor.blue()) {
                telemetry.addData("Color ", "RED");
                telemetry.update();
                robot.mRight.setPower(-1);
                robot.mLeft.setPower(1);

                int ctr = 0;
                while (ctr < 2000000 && opModeIsActive()) {
                    ctr++;
                }

                robot.mLeft.setPower(0);
                robot.mRight.setPower(0);

                flag = false;


                //robot.mRight.setPower(1);
            } else if (sensor.blue() > 40 && sensor.blue() > sensor.red()/*&& sensor.red() < 30*/) {
                telemetry.addData("Color ", "BLUE");
                telemetry.update();
                robot.mRight.setPower(1);
                robot.mLeft.setPower(-1);
                int ctr = 0;
                while (ctr < 2000000 && opModeIsActive()) {
                    ctr++;
                }

                robot.mLeft.setPower(0);
                robot.mRight.setPower(0);

                flag = false;


                // robot.mLeft.setPower(1);
            } else {
                telemetry.addData("No MAX", "NA");
                telemetry.update();

            /*    robot.mRight.setPower(1);
                robot.mLeft.setPower(-1);
                int ctr = 0;
                while (ctr < 2000000)
                {
                    ctr++;
                }

                robot.mLeft.setPower(0);
                robot.mRight.setPower(0);

                flag = false;*/

            }


            /*telemetry.addData("Alpha", sensor.alpha());
            telemetry.addData("Red  ", sensor.red());
            telemetry.addData("Green", sensor.green());
            telemetry.addData("Blue ", sensor.blue());
            telemetry.addData("Hue", hsvValues[0]);*/

        }


   /*     telemetry.addData("END OF LOOP", "END OF LOOP");
        telemetry.update();

        // Retrieve the arm
        robot.ballServo.setPosition(1);
        ctr1 = 0;

        while (ctr1 < 3000000) {
            ctr1++;
            idle();
        }

        ctr1 = 0;
        while (ctr1 < 3000000 && opModeIsActive()) {

            robot.mLeft.setPower(1);
            robot.mRight.setPower(1);

            idle();
            ctr1++;
        }

        robot.mLeft.setPower(0);
        robot.mRight.setPower(0);*/
    }

}

