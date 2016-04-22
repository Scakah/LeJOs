




import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;



public class Demo
{
	
	//Attribute
	private RegulatedMotor m1;
	private RegulatedMotor m2;
	private EV3UltrasonicSensor sensor;
	private EV3GyroSensor gyros;
	//Konstruktor
	public Demo()
	{
		m1 = new EV3LargeRegulatedMotor(MotorPort.C);
		m2 = new EV3LargeRegulatedMotor(MotorPort.A);
		 sensor = new EV3UltrasonicSensor(SensorPort.S1);
		 gyros =  new EV3GyroSensor(SensorPort.S4);
		RegulatedMotor[] array = new RegulatedMotor[1];
		array[0] = m2;
		
		m1.synchronizeWith(array);
		
	}
	
	//Einsprung-Methode _STATISCH_
	public static void main(String[] args)
	{
		Demo myDemo = new Demo();
		
		for(int a = 0; a<5; a++)
		{
					myDemo.gyrosSensor();
		}
				
		
	}
	
	public void gyrosToLCD()
	{
		gyros.reset();
	 SampleProvider provider = gyros.getAngleMode();
	 float[] samples = new float[200];

	 provider.fetchSample(samples, 0);
	 m1.startSynchronization();
	 m1.forward();
	 m2.backward();
	 LCD.drawInt((int)samples[0], 0, 0);
	 
	 
	 
	
	}
	

	public void gyrosSensor()
	{ 
		SampleProvider provider = gyros.getAngleMode();
		float[] samples = new float[200];
		gyros.reset();
		m1.startSynchronization();
		m1.backward();
		m2.forward();
		
		for(int i = 0 ; i<1000;i++)
		{
		
		
			if(samples[0] >=179 && samples[0] <181)
			{
				m1.stop();
				m2.stop();
			}
			LCD.drawInt((int ) samples[0],1,1);
			Delay.msDelay(5);
		
		}
		m1.endSynchronization();
	}
	
	public void syncMotorDemo()
	{
		m1.startSynchronization();
		m1.forward();
		m2.forward();
		m1.endSynchronization();
		
		Delay.msDelay(2000);
		m1.stop(true);
		m2.stop(true);
	}
	
	public void ultraSchallDemo()
	{
		
		SampleProvider provider = sensor.getDistanceMode();
		float[] samples = new float[200];
		
		m1.startSynchronization();
		m1.forward();
		m2.forward();
		m1.endSynchronization();
		
		boolean freieFahrt = true;
		while(freieFahrt)
		{
			provider.fetchSample(samples, 0);
			if(samples[0] < 0.2)
			{
				freieFahrt = false;
			}
			Delay.msDelay(50);
		}
		m1.stop(true);
		m2.stop(true);
	}
	
}



