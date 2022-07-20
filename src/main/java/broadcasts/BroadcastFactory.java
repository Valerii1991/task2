package broadcasts;

public class BroadcastFactory {

    public static Broadcast createBroadcast(Country country){
        switch (country) {
            case AUSTRIAN:
                return new AustrianBroadcast();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
