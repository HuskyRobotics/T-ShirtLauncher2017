package org.usfirst.frc.team4585.robot;

import edu.wpi.first.wpilibj.SampleRobot;

public class Robot extends SampleRobot {
	
	int driveLPort = 0;
	int driveRPort = 1;
	int cannonTriggerPort = 0;
	int armPort = 2;
	
	int joystickPort = 0;
	
	int upButton = 6;
	int downButton = 4;
	int fireButton = 1;
	int fireSafetyButton = 3;
	
	long time;
	long startTime;
	long timeTaken;
	int millisPerIteration = 5;
	
	TankDrive chassis = new TankDrive(driveLPort, driveRPort);
	Extreme3DPro joy = new Extreme3DPro(joystickPort);
	//QDSKeyboard keyboard = new QDSKeyboard(joystickPort);
	Launcher gun = new Launcher(cannonTriggerPort);
	Arm arm = new Arm(armPort);
	
	public Robot() {
		
	}
	
	@Override
	public void robotInit() {
		
	}
	
	@Override
	public void autonomous() {
		
	}
	
	@Override
	public void operatorControl() {
		time = System.currentTimeMillis();
		while (isEnabled() & isOperatorControl()) {
			if (System.currentTimeMillis() >= time + millisPerIteration) {
				startTime = System.currentTimeMillis();
				
				chassis.arcadeDrive(-joy.getZ(), joy.getY());
				//chassis.arcadeDrive(-keyboard.getAxisAD(), keyboard.getAxisWS());
				
				gun.setFiring(joy.getButton(fireButton) && joy.getButton(fireSafetyButton));
				
				if (joy.getButton(upButton))
					arm.move(.5);
				else if (joy.getButton(downButton))
					arm.move(-.5);
				else
					arm.move(0);
				
				time = System.currentTimeMillis();
				
				timeTaken = time - startTime;
			}
		}
	}
	
	@Override
	public void test() {
		
	}
}
