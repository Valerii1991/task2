package states;

import broadcasts.Advertising;
import broadcasts.Broadcast;
import broadcasts.Content;
import converting.Converting;
import leadings.Leading;

import java.util.Scanner;

public class StateCreateAdvertising implements State {
    @Override
    public void run(StateContext sc) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name advertising \n");
        String name = scanner.next();

        scanner = new Scanner(System.in);
        System.out.println("Enter time advertising \n");
        Double time = Converting.convertFromStringToDouble(scanner.next());

        Content advertising = Advertising.builder()
                .setName(name)
                .setTime(time).build();

        System.out.println("advertising successfully created: " + advertising.toString());

        Broadcast broadcast = sc.getBroadcast();

        broadcast.addContent(advertising);

        scanner = new Scanner(System.in);
        System.out.println("1 -- create a song broadcast: " + broadcast.toString() + " \n" +
                "2 -- create a interview broadcast: " + broadcast.toString() + " \n" +
                "3 -- create a advertising broadcast: " + broadcast.toString() + " \n" +
                "4 -- find next broadcast  \n" +
                "0 -- close the application \n");

       int number = Converting.convertFromStringToInt(scanner.next());

        State state = StateFactory.createState(sc, number);
        sc.setCurrentState(state);
        sc.run();
    }
}
