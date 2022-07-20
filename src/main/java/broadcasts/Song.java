package broadcasts;

public class Song implements Content {
    private double time;
    private String name;
    private String singer;

    @Override
    public String toString() {
        return "Song{" +
                "time=" + time +
                ", name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public double getTime() {
        return time;
    }

    @Override
    public double getProfit() {
        return 0;
    }

    @Override
    public double getTimePaidContent() {
        return 0;
    }

    public static final class Builder {
        private Song song;
        private Builder() { song = new Song(); }

        public Builder setName(String name){
            song.name = name;
            return this;
        }
        public Builder setTime(double time){
            song.time = time;
            return this;
        }

        public Builder setSinger(String singer){
            song.singer = singer;
            return this;
        }

        public Song build(){
            return song;
        }
    }
}

