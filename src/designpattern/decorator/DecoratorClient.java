package designpattern.decorator;

public class DecoratorClient {

    public static void main(String[] args) {
        IDress dress = new BasicDress();
        System.out.println(dress.getDescription());
        System.out.println(dress.cost());

        dress = new FormalDressDecorator(dress);

        System.out.println(dress.getDescription());
        System.out.println(dress.cost());

        dress = new CasualDressDecorator(dress);
        System.out.println(dress.getDescription());
        System.out.println(dress.cost());

    }
}
