package machinecoding.gymbooking.gym.model;

import machinecoding.gymbooking.common.model.Timing;

import java.util.List;

public class Gym {

    private String name;
    private List<Timing> gymTiming;

    public Gym(String name, List<Timing> gymTiming) {
        this.name = name;
        this.gymTiming = gymTiming;
    }

    public String getName() {
        return name;
    }

    public List<Timing> getGymTiming() {
        return gymTiming;
    }
}
