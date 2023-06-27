package machinecoding.logging.level;

class DebugLogger extends AbstractLogger {

    protected DebugLogger(LoggingLevel loggingLevel, AbstractLogger nextLogger) {
        super(loggingLevel, nextLogger);
    }

    @Override
    protected void display(String msg) {
        System.out.println("DEBUG : " + msg);
    }
}
