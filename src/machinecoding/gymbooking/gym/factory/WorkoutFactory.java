package machinecoding.gymbooking.gym.factory;

import machinecoding.gymbooking.common.model.Timing;
import machinecoding.gymbooking.gym.model.Gym;
import machinecoding.gymbooking.gym.model.workout.*;

public class WorkoutFactory {

    private WorkoutFactory() { }

    public static AbstractWorkout getInstance(WorkoutType workoutType, Gym gym, Timing timing, int slots) {
        if (workoutType == null) {
            return null;
        }

        switch(workoutType) {
            case CARDIO:
                return new Cardio(gym, timing, slots);
            case WEIGHTS:
                return new Weights(gym, timing, slots);
            case YOGA:
                return new Yoga(gym, timing, slots);
            default:
                System.out.println("WorkoutType is invalid !!!");
                return null;
        }
    }
}
