package machinecoding.gymbooking.gym.model.workout;

import machinecoding.gymbooking.common.model.Timing;
import machinecoding.gymbooking.gym.model.Gym;

public class Weights  extends AbstractWorkout {

    public Weights(Gym gym, Timing timing, int slots) {
        super(gym, timing, slots);
    }

    @Override
    public WorkoutType getWorkoutType() {
        return WorkoutType.WEIGHTS;
    }
}
