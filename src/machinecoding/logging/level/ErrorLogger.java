package machinecoding.logging.level;

class ErrorLogger extends AbstractLogger {

    protected ErrorLogger(LoggingLevel loggingLevel, AbstractLogger nextLogger) {
        super(loggingLevel, nextLogger);
    }

    @Override
    protected void display(String msg) {
        System.out.println("ERROR : " + msg);
    }
}
