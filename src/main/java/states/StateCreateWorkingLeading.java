package states;

import converting.Converting;
import leadings.Leading;
import leadings.WorkingLeading;

import java.util.Scanner;

public class StateCreateWorkingLeading implements State {
    @Override
    public void run(StateContext sc) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name working leading \n");
        String nameWorkingLeading = scanner.next();

        scanner = new Scanner(System.in);
        System.out.println("Enter experience working leading \n");
        Double experienceWorkingLeading = Converting.convertFromStringToDouble(scanner.next());

        Leading leading = WorkingLeading.builder().setName(nameWorkingLeading).setExperience(experienceWorkingLeading).build();
        sc.setLeading(leading);
        System.out.println("working leading successfully created: " + leading.toString());

        scanner = new Scanner(System.in);
        System.out.println("1 -- create a Austrian broadcast \n" +
                "0 -- close the application \n");
        int number = Converting.convertFromStringToInt(scanner.next());

        State state = StateFactory.createState(sc, number);
        sc.setCurrentState(state);
        sc.run();
    }
}
