package states;

import converting.Converting;


import java.util.Scanner;

public class StateStart implements State{
    @Override
    public void run(StateContext sc) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 -- create a working leading \n" +
                "2 -- create a guest leading \n" +
                "0 -- close the application \n");

        int number = Converting.convertFromStringToInt(scanner.next());

        State state = StateFactory.createState(sc, number);
        sc.setCurrentState(state);
        sc.run();
    }
}
