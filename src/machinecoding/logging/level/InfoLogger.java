package machinecoding.logging.level;

class InfoLogger extends AbstractLogger {

    protected InfoLogger(LoggingLevel loggingLevel, AbstractLogger nextLogger) {
        super(loggingLevel, nextLogger);
    }

    @Override
    protected void display(String msg) {
        System.out.println("INFO : " + msg);
    }
}
