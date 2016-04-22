import lejos.utility.Delay;

public class Main {

	public static void main(String[] args) {
		lejos.hardware.motor.Motor.A.forward();
		 lejos.hardware.motor.Motor.C.forward();
		 Delay.msDelay(100000);

	}

}
