package machinecoding.logging.level;

enum LoggingLevel {

    INFO(1),
    ERROR(2),
    DEBUG(3);

    private final int value;

    LoggingLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
