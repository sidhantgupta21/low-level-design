package designpattern.builder;

public class Vehicle {

    // required param
    private String engine;
    private int wheels;

    // optional param
    private int airbags;
    private boolean isAutomatic;

    public static class VehicleBuilder {

        private String engine;
        private int wheels;
        private int airbags;
        private boolean isAutomatic;

        public VehicleBuilder(String engine, int wheels) {
            this.engine = engine;
            this.wheels = wheels;
        }

        public VehicleBuilder withAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public VehicleBuilder withAutomatic(boolean isAutomatic) {
            this.isAutomatic = isAutomatic;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }

    private Vehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.airbags = builder.airbags;
        this.isAutomatic = builder.isAutomatic;
    }

    public String getEngine() {
        return engine;
    }

    public int getWheels() {
        return wheels;
    }

    public int getAirbags() {
        return airbags;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "engine='" + engine + '\'' +
                ", wheels=" + wheels +
                ", airbags=" + airbags +
                ", isAutomatic=" + isAutomatic +
                '}';
    }
}
