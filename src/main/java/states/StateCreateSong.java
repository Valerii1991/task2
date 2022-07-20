package states;

import broadcasts.Broadcast;
import broadcasts.Content;
import broadcasts.Song;
import converting.Converting;

import leadings.Leading;

import java.util.Scanner;

public class StateCreateSong implements State {
    @Override
    public void run(StateContext sc) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name Song \n");
        String name = scanner.next();

        scanner = new Scanner(System.in);
        System.out.println("Enter singer \n");
        String singer = scanner.next();

        scanner = new Scanner(System.in);
        System.out.println("Enter time song \n");
        Double time = Converting.convertFromStringToDouble(scanner.next());

        Content song = Song.builder()
                .setName(name)
                .setSinger(singer)
                .setTime(time).build();

        System.out.println("song successfully created: " + song.toString());
        Broadcast broadcast = sc.getBroadcast();

        broadcast.addContent(song);

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
