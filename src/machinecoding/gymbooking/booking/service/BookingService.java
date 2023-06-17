package machinecoding.gymbooking.booking.service;

import machinecoding.gymbooking.common.model.Timing;
import machinecoding.gymbooking.common.service.LockService;
import machinecoding.gymbooking.booking.model.Booking;
import machinecoding.gymbooking.customer.model.Customer;
import machinecoding.gymbooking.booking.repository.BookingRepository;
import machinecoding.gymbooking.gym.model.workout.AbstractWorkout;
import machinecoding.gymbooking.gym.model.workout.WorkoutType;
import machinecoding.gymbooking.gym.service.WorkoutService;

public class BookingService {

    private static BookingService instance = null;
    private final WorkoutService workoutService;
    private final BookingRepository bookingRepository;

    private BookingService(WorkoutService workoutService, BookingRepository bookingRepository) {
        this.workoutService = workoutService;
        this.bookingRepository = bookingRepository;
    }

    public static BookingService getInstance(WorkoutService workoutService, BookingRepository bookingRepository) {
        if (instance == null) {
            synchronized (BookingService.class) {
                if (instance == null) {
                    instance = new BookingService(workoutService, bookingRepository);
                }
            }
        }
        return instance;
    }

    public Booking doBooking(Customer customer, String gymName, WorkoutType workoutType, Timing timing) {
        AbstractWorkout workout = workoutService.getGymWorkoutList(gymName).stream()
                .filter(w -> w.getWorkoutType() == workoutType &&
                                w.getTiming().getStartTime() == timing.getStartTime().intValue())
                .findFirst().orElse(null);

        if (workout != null) {
            String key = gymName + workoutType + timing.getStartTime().toString();
            synchronized (LockService.getLockObject(key)) {
                if (workout.getSlots() > 0) {
                    workout.decrementSlot();
                    Booking booking = bookingRepository.createBooking(customer, workout);
                    System.out.println("Booking done for customer : " + customer.getName());
                    return booking;
                } else {
                    System.out.println("No Slots available!!");
                }
            }
        } else {
            System.out.println("Invalid workout for the gym!!");
        }

        return null;
    }

    public boolean cancelBooking(int bookingId) {
        Booking booking = bookingRepository.getBooking(bookingId);
        if (booking == null) {
            System.out.println("invalid booking id");
            return false;
        }

        AbstractWorkout workout = booking.getWorkout();
        String key = workout.getGym().getName() + workout.getWorkoutType() + workout.getTiming().getStartTime().toString();
        synchronized (LockService.getLockObject(key)) {
            workout.incrementSlot();
            bookingRepository.deleteBooking(bookingId);
            System.out.println("Booking cancelled!!!");
            return true;
        }
    }

}
