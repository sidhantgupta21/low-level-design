package machinecoding.gymbooking;

import machinecoding.gymbooking.common.model.Timing;
import machinecoding.gymbooking.customer.model.Customer;
import machinecoding.gymbooking.booking.repository.BookingRepository;
import machinecoding.gymbooking.booking.service.BookingService;
import machinecoding.gymbooking.customer.repository.CustomerRepository;
import machinecoding.gymbooking.customer.service.CustomerService;
import machinecoding.gymbooking.gym.model.Gym;
import machinecoding.gymbooking.gym.model.workout.WorkoutType;
import machinecoding.gymbooking.gym.repository.GymRepository;
import machinecoding.gymbooking.gym.repository.WorkoutRepository;
import machinecoding.gymbooking.gym.service.GymService;
import machinecoding.gymbooking.gym.service.WorkoutService;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GymBookingAppMain {

    public static void main(String[] args) {

        GymService gymService = GymService.getInstance(GymRepository.getInstance());
        Timing morTiming = new Timing(7,10);
        Timing eveTiming = new Timing(19, 22);
        Gym gym = gymService.createGym("Kormangla", Arrays.asList(morTiming, eveTiming));

        WorkoutService workoutService = WorkoutService.getInstance(WorkoutRepository.getInstance());
        workoutService.addWorkout(gym, WorkoutType.CARDIO, new Timing(7,8), 1);
        workoutService.addWorkout(gym, WorkoutType.WEIGHTS, new Timing(8,9), 50);
        workoutService.addWorkout(gym, WorkoutType.YOGA, new Timing(9,10), 50);
        workoutService.addWorkout(gym, WorkoutType.CARDIO, new Timing(19,20), 20);

        workoutService.viewWorkoutSlots(WorkoutType.CARDIO);


        CustomerService customerService = CustomerService.getInstance(CustomerRepository.getInstance());
        Customer customer1 = customerService.createCustomer("sidhant", "sidhantgupta66@gmail.com");
        Customer customer2 = customerService.createCustomer("abc", "abc@gmail.com");
        List<Customer> customers = Arrays.asList(customer1, customer2);

        BookingService bookingService = BookingService.getInstance(workoutService, BookingRepository.getInstance());

        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (Customer customer : customers) {
            executor.execute(() ->
                    bookingService.doBooking(customer, "Kormangla", WorkoutType.CARDIO, new Timing(7,8)));
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            // waiting for executor to shutdown.
        }
        workoutService.viewWorkoutSlots(WorkoutType.CARDIO, "Kormangla");

        bookingService.cancelBooking(1);
        workoutService.viewWorkoutSlots(WorkoutType.CARDIO, "Kormangla");
    }
}
