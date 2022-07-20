package broadcasts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AustrianBroadcastTest {
    Broadcast broadcast;
    @BeforeEach
    void setUp() {
        broadcast = BroadcastFactory.createBroadcast(Country.AUSTRIAN);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAddContentCheckLengthBroadcast() {
        Content song1 = Song.builder()
                .setName("Solomiya")
                .setSinger("Kalush")
                .setTime(5).build();

        Content interview1 = Interview.builder()
                .setName("Ivanov")
                .setTime(30)
                .build();

        Content advertising1 = Advertising.builder()
                .setName("Car Ford")
                .setTime(2)
                .build();

        broadcast.addTime(5);
        broadcast.addContent(song1);
        broadcast.addContent(interview1);
        broadcast.addContent(advertising1);

        int expected = 1;

        assertEquals(expected,broadcast.getSizeContents(),"AddContentCheckLengthBroadcast AustrianBroadcast is incorrect");
    }

    @Test
    void testAddContentCheckPaidContent() {
        Content song1 = Song.builder()
                .setName("crazy dances")
                .setSinger("Ruslana")
                .setTime(4).build();

        Content interview1 = Interview.builder()
                .setName("Petrov")
                .setTime(20)
                .build();

        Content advertising1 = Advertising.builder()
                .setName("Car Ferrari")
                .setTime(3)
                .build();

        broadcast.addTime(4);
        broadcast.addContent(song1);
        broadcast.addContent(interview1);
        broadcast.addContent(advertising1);

        broadcast.addTime(20);
        broadcast.addContent(interview1);

        broadcast.addContent(advertising1);

        int expected = 2;

        assertEquals(expected,broadcast.getSizeContents(),"testAddContentCheckPaidContent AustrianBroadcast is incorrect");
    }

    @Test
    void testGetProfit() {
        Content song1 = Song.builder()
                .setName("Verka Serdychka")
                .setSinger("everything will be fine")
                .setTime(30).build();

        Content interview1 = Interview.builder()
                .setName("Sidorov")
                .setTime(10)
                .setPrice(35)
                .build();

        Content advertising1 = Advertising.builder()
                .setName("Car Shevrolet")
                .setTime(3)
                .setPrice(400)
                .build();

        broadcast.addTime(43);

        broadcast.addContent(song1);
        broadcast.addContent(interview1);
        broadcast.addContent(advertising1);


        double expected = 1550;

        assertEquals(expected,broadcast.getProfit(),"get profit AustrianBroadcast is incorrect");
    }

    @Test
    void testAddTime() {
        broadcast.addTime(10);
        broadcast.addTime(20);
        broadcast.addTime(30);

        double expected = 60;

        assertEquals(expected,broadcast.getTime(),"AddTime AustrianBroadcast is incorrect");
    }

    @Test
    void testGetTimeAllContent() {
        Content song1 = Song.builder()
                .setName("Polyakova")
                .setSinger("night queen")
                .setTime(27).build();

        Content interview1 = Interview.builder()
                .setName("Ivanova")
                .setTime(7)
                .build();

        Content advertising1 = Advertising.builder()
                .setName("Car Mustang")
                .setTime(4)
                .build();

        broadcast.addTime(50);

        broadcast.addContent(song1);
        broadcast.addContent(interview1);
        broadcast.addContent(advertising1);


        double expected = 38;

        assertEquals(expected,broadcast.getTimeAllContent(),"GetTimeAllContent AustrianBroadcast is incorrect");
    }

    @Test
    void testGetTimeAllPaidContent() {
        Content song1 = Song.builder()
                .setName("Mozgi")
                .setSinger("Ayabo")
                .setTime(27).build();

        Content interview1 = Interview.builder()
                .setName("Petrova")
                .setTime(7)
                .setPrice(40)
                .build();

        Content advertising1 = Advertising.builder()
                .setName("Car Porshe")
                .setTime(4)
                .setPrice(385)
                .build();

        broadcast.addTime(50);

        broadcast.addContent(song1);
        broadcast.addContent(interview1);
        broadcast.addContent(advertising1);


        double expected = 11;

        assertEquals(expected,broadcast.getTimeAllPaidContent(),"GetTimeAllPaidContent AustrianBroadcast is incorrect");
    }
}