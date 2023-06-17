package machinecoding.gymbooking.gym.model.workout;

import machinecoding.gymbooking.common.model.Timing;
import machinecoding.gymbooking.gym.model.Gym;

public class Yoga extends AbstractWorkout {

    public Yoga(Gym gym, Timing timing, int slots) {
        super(gym, timing, slots);
    }

    @Override
    public WorkoutType getWorkoutType() {
        return WorkoutType.YOGA;
    }
}
