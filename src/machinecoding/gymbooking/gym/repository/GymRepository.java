package machinecoding.gymbooking.gym.repository;

import machinecoding.gymbooking.common.model.Timing;
import machinecoding.gymbooking.gym.model.Gym;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GymRepository {

    private static GymRepository instance = null;
    private final Map<String, Gym> gymMap;

    private GymRepository() {
        this.gymMap = new ConcurrentHashMap<>();
    }

    public static GymRepository getInstance() {
        if (instance == null) {
            synchronized (GymRepository.class) {
                if (instance == null) {
                    instance = new GymRepository();
                }
            }
        }
        return instance;
    }

    public Gym createGym(String name, List<Timing> gymTimingList) {
        if (gymMap.containsKey(name.toLowerCase())) {
            System.out.println("Gym already exists!!");
            return gymMap.get(name.toLowerCase());
        }

        Gym gym = new Gym(name.toLowerCase(), gymTimingList);
        gymMap.put(gym.getName(), gym);
        return gym;
    }

    public Gym getGym(String gymName) {
        return gymMap.get(gymName);
    }
}
