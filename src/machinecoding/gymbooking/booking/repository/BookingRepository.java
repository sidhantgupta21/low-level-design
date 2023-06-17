package machinecoding.gymbooking.booking.repository;

import machinecoding.gymbooking.booking.model.Booking;
import machinecoding.gymbooking.customer.model.Customer;
import machinecoding.gymbooking.gym.model.workout.AbstractWorkout;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BookingRepository {

    private static BookingRepository instance = null;
    private final Map<Integer, Booking> bookingMap;
    private int bookingCount;

    private BookingRepository() {
        this.bookingMap = new ConcurrentHashMap<>();
        this.bookingCount = 0;
    }

    public static BookingRepository getInstance() {
        if (instance == null) {
            synchronized (BookingRepository.class) {
                if (instance == null) {
                    instance = new BookingRepository();
                }
            }
        }
        return instance;
    }

    public Booking createBooking(Customer customer, AbstractWorkout workout) {
        Booking booking =  new Booking(bookingCount + 1, customer, workout);
        bookingMap.put(booking.getId(), booking);
        bookingCount++;
        return booking;
    }

    public Booking getBooking(int bookingId) {
        return bookingMap.get(bookingId);
    }

    public void deleteBooking(int bookingId) {
        bookingMap.remove(bookingId);
    }
}
