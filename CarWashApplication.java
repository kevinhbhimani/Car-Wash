import java.util.Random;

//
//Car Wash Simulation Project:  CarWashApplication Class
//
//The Car Wash Simulation Project is described in 
//<a href="http://max.cs.kzoo.edu/cs210/Labs/Queues/CarWashProgram.html">Car
//Wash Project Description</a>.
//
//Authors:   Autumn C. Spaulding and Alyce Brady,
//         based on a description by
//         <a href="mailto:trollend@nb.net">Todd Ollendyke</a>.
//Date:      13 July 2000
//Modified:  12 October 2000
//Added Bay class and separated simulation behavior from main into
//the CarWashSimulation class.
//Modified:  29 October 2002
//Separated class templates into separate files.

//@author Kevin H. Bhimani
//@date October 14, 2017
//

/**
 * This is the main class for the Car Wash program.
 *
 */
public class CarWashApplication {
	/**
	 * The main function constructs a car wash simulation and asks it to run.
	 * 
	 * @param String
	 *            args[] is not used in this implementation
	 * @return void
	 */
	public static void main(String args[]) {

		Debug.turnOn();

		// Construct a simulation object and start the simulation.

		CarWashSimulation sim = new CarWashSimulation(4);

		// The car wash is open from 9am to 7pm (10 hours).
		sim.run(600);

		// the code below is to test the program. You can uncomment it and test the code
		/*
		 * KQueue myQueue = new LLQueue(); Bay theBay = new Bay(4);
		 * 
		 * for (int j = 0; j < 20; j++) { Random ranGen = new Random(); int ranNum =
		 * ranGen.nextInt(2); if (ranNum == 0) { Car myCar = new Car(j);
		 * myQueue.enqueue(myCar); Debug.println("TimeStamp: " + j + "  Car Arrived"); }
		 * else Debug.println("TimeStamp: " + j + "  Car did not Arrive"); }
		 * 
		 * for (int j = 0; j < 5; j++) { if (j == 1) { theBay.startWash();
		 * Debug.println("TimeStamp: " + j + "  Car Arrived" +
		 * "      minutes until Bay is open:  " + theBay.timeLeftTillEmpty); }
		 * 
		 * else {
		 * 
		 * if (!theBay.isEmpty()) { theBay.keepWashing(); } Debug.println("TimeStamp: "
		 * + j + "  No Car Arrived" + "   minutes until Bay is open:  " +
		 * theBay.timeLeftTillEmpty); } } System.out.println("Program done.");
		 */
	} // end main

}

// end class CarWashApplication class