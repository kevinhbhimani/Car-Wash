import java.util.Random;

//
//   Car Wash Simulation Project:  CarWashSimulation Class
//
//   The Car Wash Simulation Project is described in 
//   <a href="http://max.cs.kzoo.edu/cs210/Labs/Queues/CarWashProgram.html">Car
//   Wash Project Description</a>.
//
//   Authors:   Autumn C. Spaulding and Alyce Brady,
//              based on a description by
//              <a href="mailto:trollend@nb.net">Todd Ollendyke</a>.
//   Date:      13 July 2000
//   Modified:  12 October 2000
//    Separated simulation behavior from main into the CarWashSimulation class.
//   Modified:  29 October 2002
//    Separated class templates into separate files.
//  Modified:  27 October 2003
//   Set up waitingLine to use LLQueue instead of QueueVector
// Modified: Kevin H. Bhimani
// Date: October 14, 2017
// implemented the code for the simulation class.
//

/*
 * @author: Kevin H. Bhimani
 * @with assitance from: Tim Rutledge
 * @date: October 14, 2017
 */

/**
 * This class is a template, or starting point, for a class that will manage the
 * simulation of cars arriving at a car wash, waiting in line, and going through
 * the wash cycle.
 *
 */
public class CarWashSimulation {
	int currentTime; // how many minutes the car wash has been open
	int closingTime; // when the car wash should close
	Bay bay; // car wash bay
	KQueue<Car> waitingLine; // line of cars waiting to be washed

	double totalWaitingTime; // total time spent waiting by all cars
	int numCars; // how many cars were washed
	int tenMinCar;// how many cars were washed

	double avgWaintingTime; // average waiting time of all cars.

	Random randGen; // random number generator

	/**
	 * Construct a car wash simulation object.
	 * 
	 * @param minutesToRun
	 *            numberof minutes the car wash takes to wash a car.
	 */
	public CarWashSimulation(int minutesToWash)

	{
		bay = new Bay(minutesToWash);
		waitingLine = new LLQueue();
		reset();
	}

	/** Reset the state of the simulation for a new run. */
	public void reset() {
		// All times and number of cars should be reset to 0 (closingTime
		// will be set to the appropriate value when the simulation is run).
		// The bay and waitingLine should be reset using appropriate
		// methods from their classes.

		this.currentTime = 0;
		this.bay.reset();
		this.waitingLine = new LLQueue();
		this.totalWaitingTime = 0;
		this.numCars = 0;
		this.tenMinCar = 0;
		this.avgWaintingTime = 0;

	}

	/**
	 * Run the simulation for a specified number of minutes (or whatever the unit
	 * for a single step of the simulation is).
	 * 
	 * @param minutesToRun
	 *            the number of steps of the simulation to run
	 */
	public void run(int minutesToRun)

	{
		closingTime = minutesToRun;

		// Run for as many minutes as specified or until there are no cars
		// left waiting to be washed, whichever is longer.

		if (closingTime > waitingLine.size()) {
			for (int j = 0; j < closingTime; j++) {
				step();
			}
		}

		/*
		 * else if (waitingLine.size() > closingTime) { for (int j = 0; j <
		 * waitingLine.size(); j++) { step(); } }
		 */

		// Print results of simulation.

		avgWaintingTime = totalWaitingTime / numCars;
		System.out.println("Number of cars washed: " + numCars);
		System.out.println("Time spent waiting by all cars: " + totalWaitingTime);
		System.out.println("Average time waited by all cars: " + avgWaintingTime);
		System.out.println("Cars that waited for 10 minutes or more: " + tenMinCar);
		this.reset();
	}

	/**
	 * Execute a single step of the simulation.
	 * 
	 * if a car arrives increment the number of cars that have arrived note the
	 * arrival time of the car (store this with the car) add the car to the queue
	 * 
	 * if the car wash bay is empty and there is a car waiting to be washed move the
	 * car from the queue to the car wash bay determine how long that car was
	 * waiting and add to total wait time start washing the car (bay will be
	 * occupied for next 2 minutes)
	 * 
	 * otherwise, if there is a car already being washed decrease the amount of time
	 * left before the bay is available
	 */
	public void step() {
		// generates a random number out of 4. This simulates a car coming in 4 minutes.
		Random ranGen = new Random();
		int ranNum = ranGen.nextInt(3);

		// 1 in 4 chance that a car will be added to the queue.
		if (ranNum == 0) {
			Car myCar = new Car(currentTime);
			numCars++;
			waitingLine.enqueue(myCar);
		}

		if (bay.isEmpty() && !waitingLine.isEmpty()) {
			Car CarToWash = waitingLine.dequeue();
			totalWaitingTime = (int) totalWaitingTime + (currentTime - CarToWash.getArrivalTime());

			if (currentTime - CarToWash.getArrivalTime() >= 10) {
				tenMinCar++;
			}

			bay.startWash();
		}

		if (!bay.isEmpty()) {
			bay.keepWashing();
		}

		currentTime++;
	}

} // end CarWashSimulation class