package machinecoding.logging;

import machinecoding.logging.level.Logger;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.info("This is info msg");
        logger.error("This is error msg");
        logger.debug("This is debug msg");
    }
}
