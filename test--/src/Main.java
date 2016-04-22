import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;


public class Main {

	 RegulatedMotor A = Motor.A;
	RegulatedMotor C = Motor.C;
	
	public static void main(String[] args)
	{

		RegulatedMotor A = Motor.A;
		RegulatedMotor C = Motor.C;
		
		RegulatedMotor[] arr = new RegulatedMotor[1];
		arr[0] = C;
		
	    A.synchronizeWith( arr);
		A.startSynchronization();
		
		 A.forward();
		 C.forward();
		
		 A.endSynchronization();
		 Delay.msDelay(1000);
		 Motor.A.stop(true);
		 Motor.C.stop(true);
	
		 A.rotate(360);
		 C.rotate(360);
				 
		
		
		 
		 

	}

}
