package states;

import broadcasts.Broadcast;
import broadcasts.BroadcastFactory;
import broadcasts.Country;
import converting.Converting;
import leadings.Leading;

import java.util.Scanner;

public class StateCreateAustrianBroadcast implements State {
    @Override
    public void run(StateContext sc) {
        Broadcast broadcast = sc.getBroadcast();
        Leading leading = sc.getLeading();
        Scanner scanner;

        if(broadcast == null) {
            scanner = new Scanner(System.in);
            System.out.println("Enter name broadcast \n");
            String nameBroadcast = scanner.next();

            scanner = new Scanner(System.in);
            System.out.println("Enter time broadcast \n");
            Double time = Converting.convertFromStringToDouble(scanner.next());

            broadcast = BroadcastFactory.createBroadcast(Country.AUSTRIAN);
            broadcast.setName(nameBroadcast);
            broadcast.addTime(time);
            leading.addBroadcast(broadcast);
            sc.setBroadcast(broadcast);
            System.out.println("broadcast successfully created: " + broadcast.toString());
        }
        scanner = new Scanner(System.in);
        System.out.println("1 -- create a Austrian broadcast \n" +
                "2 -- add content \n" +
                "3 -- show profit broadcast  \n" +
                "4 -- show content broadcast  \n" +
                "5 -- save content broadcast  \n" +
                "0 -- close the application \n");

       int number = Converting.convertFromStringToInt(scanner.next());

        State state = StateFactory.createState(sc, number);
        sc.setCurrentState(state);
        sc.run();
    }
}
