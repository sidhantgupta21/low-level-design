package machinecoding.gymbooking.customer.model;

import machinecoding.gymbooking.gym.model.workout.AbstractWorkout;

public class Booking {

    private int id;
    private Customer customer;
    private AbstractWorkout workout;

    public Booking(int id, Customer customer, AbstractWorkout workout) {
        this.id = id;
        this.customer = customer;
        this.workout = workout;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public AbstractWorkout getWorkout() {
        return workout;
    }
}
