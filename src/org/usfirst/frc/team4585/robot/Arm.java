package org.usfirst.frc.team4585.robot;

import edu.wpi.first.wpilibj.Spark;


public class Arm {
	Spark motor;

	public Arm(int port) {
		motor = new Spark(port);
	}

	public void move(double value) {
		motor.set(value);
	}
}
