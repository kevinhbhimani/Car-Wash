/* Car Wash Simulation Project
 * 
 * This class defines a car object.
 * 
 * @author Kevin H. Bhimani
 * @date October 14, 2017
*/

public class Car

{
	// instance variables
	int arrivalTime;

	/*
	 * Creates a new Car object
	 * 
	 * @param arrivalTime0 The time at which the car arrived at the car wash.
	 *
	 */
	public Car(int arrivalTime0) {
		this.arrivalTime = arrivalTime0;
	}

	/*
	 * Returns the arrival time of the Car object
	 * 
	 * @return arrivalTime The time at which the car arrived at the car wash.
	 *
	 */

	/**
	 * Returns returns the size of the queue
	 */
	public int getArrivalTime() {
		return this.arrivalTime;
	}

}
