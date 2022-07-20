package broadcasts;

public class Interview implements Content {
    private double time;
    private String name;
    private double price = 30;

    @Override
    public String toString() {
        return "Interview{" +
                "time=" + time +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static Interview.Builder builder() {
        return new Interview.Builder();
    }

    @Override
    public double getTime() {
        return time;
    }

    @Override
    public double getProfit() {
        return price * time;
    }

    @Override
    public double getTimePaidContent() {
        return time;
    }

    public static final class Builder {
        private Interview interview;
        private Builder() { interview = new Interview(); }

        public Interview.Builder setName(String name){
            interview.name = name;
            return this;
        }
        public Interview.Builder setTime(double time){
            interview.time = time;
            return this;
        }

        public Interview.Builder setPrice(double price){
            interview.price = price;
            return this;
        }

        public Interview build(){
            return interview;
        }
    }
}
