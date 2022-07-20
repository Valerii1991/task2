package states;

import broadcasts.Broadcast;
import broadcasts.Content;
import broadcasts.Interview;
import converting.Converting;
import leadings.Leading;

import java.util.Scanner;

public class StateCreateInterview implements State {
    @Override
    public void run(StateContext sc) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name interview \n");
        String name = scanner.next();

        scanner = new Scanner(System.in);
        System.out.println("Enter time interview \n");
        Double time = Converting.convertFromStringToDouble(scanner.next());

        Content interview = Interview.builder()
                .setName(name)
                .setTime(time).build();

        System.out.println("interview successfully created: " + interview.toString());

        Broadcast broadcast = sc.getBroadcast();
        Leading leading = sc.getLeading();

        broadcast.addContent(interview);

        scanner = new Scanner(System.in);
        System.out.println("1 -- create a song broadcast: " + broadcast.toString() + " \n" +
                "2 -- create a interview broadcast: " + broadcast.toString() + " \n" +
                "3 -- create a adversting broadcast: " + broadcast.toString() + " \n" +
                "4 -- find next broadcast  \n" +
                "0 -- close the application \n");

       int number = Converting.convertFromStringToInt(scanner.next());

        State state = StateFactory.createState(sc, number);
        sc.setCurrentState(state);
        sc.run();
    }
}
