package machinecoding.gymbooking.gym.service;

import machinecoding.gymbooking.common.model.Timing;
import machinecoding.gymbooking.gym.factory.WorkoutFactory;
import machinecoding.gymbooking.gym.model.Gym;
import machinecoding.gymbooking.gym.model.workout.AbstractWorkout;
import machinecoding.gymbooking.gym.model.workout.WorkoutType;
import machinecoding.gymbooking.gym.repository.WorkoutRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WorkoutService {

    private static WorkoutService instance = null;
    private final WorkoutRepository workoutRepository;

    private WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public static WorkoutService getInstance(WorkoutRepository workoutRepository) {
        if (instance == null) {
            synchronized (WorkoutService.class) {
                if (instance == null) {
                    instance = new WorkoutService(workoutRepository);
                }
            }
        }
        return instance;
    }

    public boolean addWorkout(Gym gym, WorkoutType workoutType, Timing timing, int slots) {
        if (!validateWorkoutTimings(gym, timing)) {
            return false;
        }

        AbstractWorkout workout = WorkoutFactory.getInstance(workoutType, gym , timing, slots);
        List<AbstractWorkout> gymWorkoutList = workoutRepository.getGymWorkoutList(gym.getName());

        if (gymWorkoutList == null) {
            gymWorkoutList = new ArrayList<>();
        }
        gymWorkoutList.add(workout);
        workoutRepository.saveWorkout(gym.getName(), gymWorkoutList);

        List<AbstractWorkout> workoutTypeList = workoutRepository.getWorkoutListByType(workoutType);
        if (workoutTypeList == null) {
            workoutTypeList = new ArrayList<>();
        }
        workoutTypeList.add(workout);
        workoutRepository.saveWorkoutByType(workoutType, workoutTypeList);

        return true;
    }

    private boolean validateWorkoutTimings(Gym gym, Timing workoutTiming) {
        boolean isValidTiming = false;

        for (Timing t : gym.getGymTiming()) {
            if (workoutTiming.getStartTime() >= t.getStartTime() &&
                    workoutTiming.getEndTime() <= t.getEndTime()) {
                isValidTiming = true;
                break;
            }
        }

        if (!isValidTiming) {
            System.out.println("Invalid workout timings!!!");
            return false;
        }

        List<AbstractWorkout> workoutList = workoutRepository.getGymWorkoutList(gym.getName());
        if (workoutList != null) {
            for (AbstractWorkout w : workoutList) {
                if (w.getTiming().getStartTime() == workoutTiming.getStartTime().intValue()) {
                    System.out.println("workout timing already booked!!");
                    return false;
                }
            }
        }

        return true;
    }

    public List<AbstractWorkout> getGymWorkoutList(String gymName) {
        return workoutRepository.getGymWorkoutList(gymName);
    }

    public void viewWorkoutSlots(WorkoutType workoutType, String gymName) {
        List<AbstractWorkout> filterList = workoutRepository.getGymWorkoutList(gymName).stream()
                .filter(w -> w.getWorkoutType() == workoutType)
                .sorted(Comparator.comparing(AbstractWorkout::getSlots))
                .collect(Collectors.toList());

        for (AbstractWorkout w : filterList) {
            System.out.println(gymName + ", " + w.getWorkoutType() + ", " + w.getTiming().getStartTime() +
                    ", " + w.getTiming().getEndTime() + ", " + w.getSlots());
        }

    }

    public void viewWorkoutSlots(WorkoutType workoutType) {
        List<AbstractWorkout> sortedList = workoutRepository.getWorkoutListByType(workoutType).stream()
                .sorted(Comparator.comparing(w -> w.getTiming().getStartTime()))
                .collect(Collectors.toList());

        for (AbstractWorkout w : sortedList) {
            System.out.println(w.getGym().getName() + ", " + w.getWorkoutType() + ", " + w.getTiming().getStartTime() +
                    ", " + w.getTiming().getEndTime() + ", " + w.getSlots());
        }

    }
}
