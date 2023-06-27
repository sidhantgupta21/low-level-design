package machinecoding.logging.level;

public class Logger {

    private static Logger instance = null;
    private static AbstractLogger chainOfLogger;

    private Logger() { }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                    chainOfLogger = LogManager.buildChainOfResponsibility();
                }
            }
        }
        return instance;
    }

    private void log(LoggingLevel loggingLevel, String msg) {
        chainOfLogger.log(loggingLevel, msg);
    }

    public void info(String msg) {
        log(LoggingLevel.INFO, msg);
    }

    public void error(String msg) {
        log(LoggingLevel.ERROR, msg);
    }

    public void debug(String msg) {
        log(LoggingLevel.DEBUG, msg);
    }
}
