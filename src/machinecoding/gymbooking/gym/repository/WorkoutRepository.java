package machinecoding.gymbooking.gym.repository;

import machinecoding.gymbooking.gym.model.workout.AbstractWorkout;
import machinecoding.gymbooking.gym.model.workout.WorkoutType;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WorkoutRepository {

    private static WorkoutRepository instance = null;
    private final Map<String, List<AbstractWorkout>> gymWorkoutMap;
    private final Map<WorkoutType, List<AbstractWorkout>> workoutTypeMap;

    private WorkoutRepository() {
        this.gymWorkoutMap = new ConcurrentHashMap<>();
        this.workoutTypeMap = new ConcurrentHashMap<>();
    }

    public static WorkoutRepository getInstance() {
        if (instance == null) {
            synchronized (WorkoutRepository.class) {
                if (instance == null) {
                    instance = new WorkoutRepository();
                }
            }
        }
        return instance;
    }

    public List<AbstractWorkout> getGymWorkoutList(String gymName) {
        return gymWorkoutMap.get(gymName.toLowerCase());
    }

    public void saveWorkout(String gymName, List<AbstractWorkout> gymWorkoutList) {
        gymWorkoutMap.put(gymName.toLowerCase(), gymWorkoutList);
    }

    public List<AbstractWorkout> getWorkoutListByType(WorkoutType workoutType) {
        return workoutTypeMap.get(workoutType);
    }

    public void saveWorkoutByType(WorkoutType workoutType, List<AbstractWorkout> workoutTypeList) {
        workoutTypeMap.put(workoutType, workoutTypeList);
    }
}
