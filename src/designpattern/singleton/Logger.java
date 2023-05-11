package designpattern.singleton;

public class Logger {

    private static Logger instance = null;

    private Logger() {
        System.out.println("Logger instance created!!!");
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
}
