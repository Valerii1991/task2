package broadcasts;

public class Advertising implements Content {
    private double time;
    private String name;
    private double price = 300;

    @Override
    public String toString() {
        return "Advertising{" +
                "time=" + time +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static Advertising.Builder builder() {
        return new Advertising.Builder();
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
        private Advertising advertising;
        private Builder() { advertising = new Advertising(); }

        public Advertising.Builder setName(String name){
            advertising.name = name;
            return this;
        }
        public Advertising.Builder setTime(double time){
            advertising.time = time;
            return this;
        }

        public Advertising.Builder setPrice(double price){
            advertising.price = price;
            return this;
        }

        public Advertising build(){
            return advertising;
        }
    }
}
