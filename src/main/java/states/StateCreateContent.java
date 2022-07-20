package states;

import broadcasts.Broadcast;
import converting.Converting;
import leadings.Leading;

import java.util.Scanner;

public class StateCreateContent implements State {
    @Override
    public void run(StateContext sc) {
        Leading leading = sc.getLeading();
        Scanner scanner;
        int number;
        for (Broadcast broadcast:leading.getBroadcasts()
        ) {
            scanner = new Scanner(System.in);
            System.out.println("1 -- create a song broadcast: " + broadcast.toString() + " \n" +
                    "2 -- create a interview broadcast: " + broadcast.toString() + " \n" +
                    "3 -- create a advertising broadcast: " + broadcast.toString() + " \n" +
                    "4 -- find next broadcast  \n" +
                    "5 -- show profit broadcast  \n" +
                    "6 -- show content broadcast  \n" +
                    "7 -- save content broadcast  \n" +
                    "0 -- close the application \n");

            number = Converting.convertFromStringToInt(scanner.next());

            sc.setBroadcast(broadcast);

            State state = StateFactory.createState(sc, number);
            if(state == null){
                continue;
            }
            else {
                sc.setCurrentState(state);
                sc.run();
            }
        }
        sc.run();
    }
}
