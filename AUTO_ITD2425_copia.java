

package org.firstinspires.ftc.teamcode;

import static com.qualcomm.robotcore.util.ElapsedTime.Resolution.SECONDS;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Autónomo copia Into The Deep 2024- 2025
 */
@Autonomous(name = "AUTO ITD 24-25 COPIA", preselectTeleOp = "TeleOp_ITD2425")

public class AUTO_ITD2425_copia extends LinearOpMode {



    //Definir y declarar posiciones iniciales del robot
    public enum POSICION_INICIO{
        IZQUIERDA,
        DERECHA
    }
    public static POSICION_INICIO posicion_inicio;

    DcMotor motor_brazo;

    Servo servo;

    Servo servo_tope;

    @Override
    public void runOpMode() throws InterruptedException {


        //Seleccionar la posición inicial del robot por medio del gamepad 1
        telemetry.setAutoClear(true);
        telemetry.clearAll();
        while(!isStopRequested()){
            telemetry.addData("Inicialización del periodo autónomo...","*AZTROID 17632");
            telemetry.addData("---------------------------------------","");
            telemetry.addData("Seleccionar posición inicial (sin importar la alianza) en el gamepad 1:","");
            telemetry.addData("    Izquierda   ", "(X)");
            telemetry.addData("    Derecha ", "(Y)");

            if(gamepad1.x){
                posicion_inicio = POSICION_INICIO.IZQUIERDA;
                break;
            }
            if(gamepad1.y){
                posicion_inicio = POSICION_INICIO.DERECHA;
                break;
            }
            telemetry.update();
        }
        telemetry.setAutoClear(false);
        telemetry.clearAll();

        telemetry.addData("Posición inicial seleccionada", posicion_inicio);
        telemetry.update();

        motor_brazo = hardwareMap.dcMotor.get("motor_brazo");

        servo = hardwareMap.servo.get("servo");

        servo_tope = hardwareMap.servo.get("servo_tope");



        waitForStart();

        //Se presiona el botón de play
        if (opModeIsActive() && !isStopRequested()) {
            //Se construye la trayectoria para realizar las funciones del autónomo
            correrAuto();
        }
    }   // Termina runOpMode()

    public void correrAuto() {
        //Posiciones izquierda - Samples
        Pose2d initPose = new Pose2d(0, 0, Math.toRadians(0)); // Starting Pose
        Pose2d netZone = new Pose2d(9  ,15,Math.toRadians(-45));
        Pose2d sampleAmarillo1 = new Pose2d(18,12,Math.toRadians(-14));
        Pose2d sampleAmarillo2 = new Pose2d(18,18,Math.toRadians(1));
        Pose2d preSubmersiblePark = new Pose2d(58,11,Math.toRadians(0));
        Pose2d submersiblePark = new Pose2d(59,-15,Math.toRadians(90));

        //Posiciones derecha - Specimens

        Pose2d submersibleSpecimen1 = new Pose2d(29,10,Math.toRadians(0));

        Pose2d preColorSampleOne = new Pose2d(23,-20,Math.toRadians(0));

        Pose2d prePushColorSampleOne = new Pose2d(49,-15,Math.toRadians(0));

        Pose2d colorSampleOne = new Pose2d(49,-29,Math.toRadians(0));

        Pose2d observationZone = new Pose2d(8,-29,Math.toRadians(0));

        Pose2d specimenPickup = new Pose2d(3,-30,Math.toRadians(180));


        Pose2d submersibleSpecimen2 = new Pose2d(31,10,Math.toRadians(0));

        Pose2d submersibleSpecimen3 = new Pose2d(31,10,Math.toRadians(0));

        Pose2d submersibleSpecimen4 = new Pose2d(31,10,Math.toRadians(0));


        Pose2d colorSampleTwo = new Pose2d(49,-45,Math.toRadians(0));
        Pose2d observationZoneTwo = new Pose2d(8,-35,Math.toRadians(0));


        Pose2d preObservationPickUp = new Pose2d(25,-29,Math.toRadians(0));

        Pose2d preSpecimenPickUp = new Pose2d(6,-30,Math.toRadians(180));


        Pose2d observationPark = new Pose2d(5,-30,Math.toRadians(0));



        MecanumDrive drive = new MecanumDrive(hardwareMap, initPose);

        if (posicion_inicio == POSICION_INICIO.IZQUIERDA) {

            //Mover robot a la NetZone
            Actions.runBlocking(
                    drive.actionBuilder(initPose)
                            .strafeToLinearHeading(netZone.position, netZone.heading)
                            .build());

            telemetry.addLine("*");
            telemetry.update();

            //Add code to drop sample in basket

            telemetry.addLine("*");
            telemetry.update();

            //Move robot to pick yellow sample one
            Actions.runBlocking(
                    drive.actionBuilder(netZone)
                            .strafeToLinearHeading(sampleAmarillo1.position, sampleAmarillo1.heading)
                            .build());
            telemetry.addLine("Move robot ");
            telemetry.update();

            //Add code to pick up yellow sample
            telemetry.addLine("Pick up yellow sample");
            telemetry.update();

            //Move robot to net zone to drop sample
            Actions.runBlocking(
                    drive.actionBuilder(sampleAmarillo1)
                            .strafeToLinearHeading(netZone.position, netZone.heading)
                            .build());
            telemetry.addLine("Move robot to net zone to drop sample");
            telemetry.update();

            //Add code to drop sample in bucket
            telemetry.addLine("Drop sample in bucket");
            telemetry.update();

            //Move robot to yellow sample two
            Actions.runBlocking(
                    drive.actionBuilder(netZone)
                            .strafeToLinearHeading(sampleAmarillo2.position, sampleAmarillo2.heading)
                            .build());
            telemetry.addLine("Move robot to yellow sample two");
            telemetry.update();

            //Add code to pick up yellow sample
            telemetry.addLine("Pick up yellow sample");
            telemetry.update();

            //Move robot to net zone
            Actions.runBlocking(
                    drive.actionBuilder(sampleAmarillo2)
                            .strafeToLinearHeading(netZone.position, netZone.heading)
                            .build());
            telemetry.addLine("Move robot to net zone");
            telemetry.update();

            //Add code to drop sample in bucket
            telemetry.addLine("Drop sample in bucket");
            telemetry.update();

            //Move robot to submersible parking
            Actions.runBlocking(
                    drive.actionBuilder(netZone)
                            .strafeToLinearHeading(preSubmersiblePark.position, preSubmersiblePark.heading)
                            .build());
            telemetry.addLine("Move robot to preSubmersible parking");
            telemetry.update();
            Actions.runBlocking(
                    drive.actionBuilder(preSubmersiblePark)
                            .strafeToLinearHeading(submersiblePark.position, submersiblePark.heading)
                            .build());
            telemetry.addLine("hitting bottom rung");
            telemetry.update();



        } else { // RIGHT

            //Mover robot hacia submersible para colgar specimen precargado

            Subir_brazo();
            sleep(100);
            Cerrar_Tope();

            Actions.runBlocking(
                    drive.actionBuilder(drive.pose)
                            .strafeTo(submersibleSpecimen1.position)
                            .build());
            Subir_brazo();
            sleep(500);
            Brazo_cero();
            sleep(500);
            Abrir_Garra();
            telemetry.addLine("*");
            telemetry.update();


            //Movimiento del robot desde que cuelga el primer specimen hasta que empuja un sample en la observation zone
            Actions.runBlocking(
                    drive.actionBuilder(submersibleSpecimen1)
                            .strafeToLinearHeading(preColorSampleOne.position, preColorSampleOne.heading)
                            .strafeToLinearHeading(prePushColorSampleOne.position, prePushColorSampleOne.heading)
                            .strafeToLinearHeading(colorSampleOne.position, colorSampleOne.heading)
                            .strafeToLinearHeading(observationZone.position, observationZone.heading)
                            .strafeToLinearHeading(colorSampleOne.position, colorSampleOne.heading)
                            .strafeToLinearHeading(colorSampleTwo.position, colorSampleTwo.heading)
                            .strafeToLinearHeading(observationZoneTwo.position, observationZoneTwo.heading)
                            .build());



            Actions.runBlocking(
                    drive.actionBuilder(observationZoneTwo)
                            .strafeToLinearHeading(preObservationPickUp.position, preObservationPickUp.heading)
                            .build());

            telemetry.addLine("*");
            telemetry.update();


            Actions.runBlocking(
                    drive.actionBuilder(preObservationPickUp)
                            .strafeToLinearHeading(preSpecimenPickUp.position, preSpecimenPickUp.heading)
                            .build());

            telemetry.addLine("*");
            telemetry.update();

            Abrir_Garra();
            Actions.runBlocking(
                    drive.actionBuilder(preSpecimenPickUp)
                            .strafeToLinearHeading(specimenPickup.position, specimenPickup.heading)
                            .build());
            sleep (300);
            Cerrar_Garra();
            sleep(250);
            Subir_brazo();

            //safeWaitSeconds(1);
            telemetry.addLine("*");
            telemetry.update();


            Actions.runBlocking(
                    drive.actionBuilder(specimenPickup)
                            .waitSeconds(0.5)
                            .strafeToLinearHeading(submersibleSpecimen2.position, submersibleSpecimen2.heading)
                            .waitSeconds(0.5)
                            .build());
            Cerrar_Garra();
            sleep(10);
            Subir_brazo();
            sleep(10);
            Brazo_cero();
            sleep(200);
            Abrir_Garra();
            telemetry.addLine("*");
            telemetry.update();


            Actions.runBlocking(
                    drive.actionBuilder(submersibleSpecimen2)
                            .strafeToLinearHeading(preSpecimenPickUp.position, preSpecimenPickUp.heading)
                            .build());


            telemetry.addLine("*");
            telemetry.update();

            Actions.runBlocking(
                    drive.actionBuilder(preSpecimenPickUp)
                            .strafeToLinearHeading(specimenPickup.position, specimenPickup.heading)
                            .build());
            sleep (300);
            Cerrar_Garra();
            sleep(250);
            Subir_brazo();

            telemetry.addLine("*");
            telemetry.update();


            Actions.runBlocking(
                    drive.actionBuilder(specimenPickup)
                            .waitSeconds(0.5)
                            .strafeToLinearHeading(submersibleSpecimen3.position, submersibleSpecimen3.heading)
                            .waitSeconds(0.5)
                            .build());
            Subir_brazo();
            sleep(10);
            Brazo_cero();
            sleep(100);
            Abrir_Garra();

            Actions.runBlocking(
                    drive.actionBuilder(submersibleSpecimen3)
                            .strafeToLinearHeading(specimenPickup.position, specimenPickup.heading)
                            .build()
            );

            Actions.runBlocking(
                    drive.actionBuilder(specimenPickup)
                            .strafeToLinearHeading(submersibleSpecimen4.position, submersibleSpecimen4.heading)
                            .build()
            );




            telemetry.addLine(">>>AUTÓNOMO COMPLETADO");
            telemetry.update();





        }

    }

    /*
    public void safeWaitSeconds(double time) {
        ElapsedTime timer = new ElapsedTime(SECONDS);
        timer.reset();
        while (!isStopRequested() && timer.time() < time) {
        }
    } */

    //Métodos para accionar los subsistemas del robot
    private void Subir_brazo() {

        motor_brazo.setDirection(DcMotor.Direction.REVERSE);
        motor_brazo.setPower(0.8);

    }

    private void Brazo_cero() {

        motor_brazo.setDirection(DcMotor.Direction.REVERSE);
        motor_brazo.setPower(0);

    }

    private void Abrir_Garra(){

        servo.setPosition(0.2);

    }

    private void Cerrar_Garra(){

        servo.setPosition(0.6);

    }

    private void Cerrar_Tope(){

        servo_tope.setPosition(1);

    }

}   // 17632 - 43
