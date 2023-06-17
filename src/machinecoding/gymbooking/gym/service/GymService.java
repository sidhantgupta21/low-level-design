package machinecoding.gymbooking.gym.service;

import machinecoding.gymbooking.common.model.Timing;
import machinecoding.gymbooking.gym.model.Gym;
import machinecoding.gymbooking.gym.repository.GymRepository;

import java.util.List;

public class GymService {

    private static GymService instance = null;
    private final GymRepository gymRepository;

    private GymService(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }

    public static GymService getInstance(GymRepository gymRepository) {
        if (instance == null) {
           synchronized (GymService.class) {
               if (instance == null) {
                   instance = new GymService(gymRepository);
               }
           }
        }
        return instance;
    }

    public Gym createGym(String name, List<Timing> gymTimingList) {
        return gymRepository.createGym(name.toLowerCase(), gymTimingList);
    }

    public Gym getGym(String gymName) {
        return gymRepository.getGym(gymName.toLowerCase());
    }
}
