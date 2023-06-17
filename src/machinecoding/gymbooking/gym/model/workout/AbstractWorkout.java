package machinecoding.gymbooking.gym.model.workout;

import machinecoding.gymbooking.common.model.Timing;
import machinecoding.gymbooking.gym.model.Gym;

public abstract class AbstractWorkout {

    private Gym gym;
    private Timing timing;
    private Integer slots;

    public AbstractWorkout(Gym gym, Timing timing, int slots) {
        this.gym = gym;
        this.timing = timing;
        this.slots = slots;
    }

    public Gym getGym() {
        return gym;
    }

    public Timing getTiming() {
        return timing;
    }

    public Integer getSlots() {
        return slots;
    }

    public void decrementSlot() {
        this.slots = this.slots - 1;
    }

    public void incrementSlot() {
        this.slots = this.slots + 1;
    }

    public abstract WorkoutType getWorkoutType();

}
