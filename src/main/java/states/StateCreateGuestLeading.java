package states;

import converting.Converting;
import leadings.GuestLeading;
import leadings.Leading;

import java.util.Scanner;

public class StateCreateGuestLeading implements State {
    @Override
    public void run(StateContext sc) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name guest leading \n");
        String name = scanner.next();

        scanner = new Scanner(System.in);
        System.out.println("Enter resume guest leading \n");
        String resume = scanner.next();

        Leading leading = GuestLeading.builder().setName(name).setResume(resume).build();
        sc.setLeading(leading);
        System.out.println("guest leading successfully created: " + leading.toString());

        scanner = new Scanner(System.in);
        System.out.println("1 -- create a Austrian broadcast \n" +
                "0 -- close the application \n");
        int number = Converting.convertFromStringToInt(scanner.next());

        State state = StateFactory.createState(sc, number);
        sc.setCurrentState(state);
        sc.run();
    }
}
