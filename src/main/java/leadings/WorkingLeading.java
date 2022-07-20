package leadings;

import broadcasts.Broadcast;

import java.util.ArrayList;

public class WorkingLeading implements Leading {
    private String name;
    private double experience;
    private ArrayList<Broadcast> broadcasts = new ArrayList<>();

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
        return "WorkingLeading{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", broadcasts=" + broadcasts +
                '}';
    }

    public static final class Builder {
        private WorkingLeading workingLeading;
        private Builder() { workingLeading = new WorkingLeading(); }

        public WorkingLeading.Builder setName(String name){
            workingLeading.name = name;
            return this;
        }
        public WorkingLeading.Builder setExperience(double experience){
            workingLeading.experience = experience;
            return this;
        }
        public WorkingLeading build(){
            return workingLeading;
        }
    }
}
