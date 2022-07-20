package leadings;

import broadcasts.Broadcast;

import java.util.ArrayList;

public interface Leading {
    public void addBroadcast(Broadcast broadcast);
    public ArrayList<Broadcast> getBroadcasts();
}
