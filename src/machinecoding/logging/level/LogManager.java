package machinecoding.logging.level;

class LogManager {

    static AbstractLogger buildChainOfResponsibility() {
        AbstractLogger debugLogger = new DebugLogger(LoggingLevel.DEBUG, null);
        AbstractLogger errorLogger = new ErrorLogger(LoggingLevel.ERROR, debugLogger);
        AbstractLogger infoLogger = new InfoLogger(LoggingLevel.INFO, errorLogger);

        return infoLogger;
    }
}
