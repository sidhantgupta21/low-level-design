package machinecoding.gymbooking.common.model;

public class Timing {

    private int startTime;
    private int endTime;

    public Timing(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }
}
