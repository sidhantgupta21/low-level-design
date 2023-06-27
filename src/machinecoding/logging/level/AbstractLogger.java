package machinecoding.logging.level;

abstract class AbstractLogger {

    private final LoggingLevel loggingLevel;
    private final AbstractLogger nextLogger;

    protected AbstractLogger(LoggingLevel loggingLevel, AbstractLogger nextLogger) {
        this.loggingLevel = loggingLevel;
        this.nextLogger = nextLogger;
    }

    void log (LoggingLevel loggingLevel, String msg) {
        if (this.loggingLevel == loggingLevel) {
            this.display(msg);
        } else {
            nextLogger.log(loggingLevel, msg);
        }
    }

    protected abstract void display(String msg);
}
