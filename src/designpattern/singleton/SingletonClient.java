package designpattern.singleton;

public class SingletonClient {

    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        System.out.println(log1);

        Logger log2 = Logger.getInstance();
        System.out.println(log2);
    }
}
