package leadings;

import broadcasts.Broadcast;

import java.util.ArrayList;

public class GuestLeading implements Leading {
    private String name;
    private String resume;
    private ArrayList <Broadcast> broadcasts = new ArrayList<>();

    @Override
    public void addBroadcast(Broadcast broadcast) {
        broadcasts.add(broadcast);
    }

    @Override
    public ArrayList<Broadcast> getBroadcasts() {
        return broadcasts;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "GuestLeading{" +
                "name='" + name + '\'' +
                ", resume='" + resume + '\'' +
                ", broadcasts=" + broadcasts +
                '}';
    }

    public static final class Builder {
        private GuestLeading guestLeading;
        private Builder() { guestLeading = new GuestLeading(); }

        public GuestLeading.Builder setName(String name){
            guestLeading.name = name;
            return this;
        }
        public GuestLeading.Builder setResume(String resume){
            guestLeading.resume = resume;
            return this;
        }
        public GuestLeading build(){
            return guestLeading;
        }
    }
}
