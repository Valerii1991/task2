package broadcasts;

public interface Broadcast {
    public void addContent(Content content);
    public double getProfit();
    public void showContent();
    public void addTime(double time);
    public double getTimeAllContent();
    public double getTimeAllPaidContent();
    public void saveContent();
    public int getSizeContents();
    public double getTime();
    public void setName(String name);
    public String getName();
}

