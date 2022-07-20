package broadcasts;

import java.io.*;
import java.util.ArrayList;

public class AustrianBroadcast implements Broadcast {
    private double time;
    private String name;
    private ArrayList<Content> contents =new ArrayList<>();

    @Override
    public void addContent(Content content) {
        double totalTime = getTimeAllContent();
        totalTime += content.getTime();

        double totalPaidTime = getTimeAllPaidContent();
        totalPaidTime += content.getTimePaidContent();

        double percentageOfPaidContent;
        if(totalTime==0){
            percentageOfPaidContent = 0;
        }
        else {
            percentageOfPaidContent = totalPaidTime / totalTime;
        }

        if (time < totalTime )
        {
            System.out.println("It is not possible to add such a broadcast part, because the broadcast time " + time + " will be less than time all content " + totalTime);
        }
        else if(percentageOfPaidContent > 0.5){
            System.out.println("The amount of paid content is more than 50 percent. Can't add this content. time broadcast = " + totalTime + ", time paid content = " + totalPaidTime);
        }
        else {
            contents.add(content);
        }
    }

    @Override
    public String toString() {
        return "AustrianBroadcast{" +
                "time=" + time +
                ", name='" + name + '\'' +
                ", contents=" + contents +
                '}';
    }

    @Override
    public double getProfit() {
        double profit = 0;
        for (Content content: contents
        ) {
            profit += content.getProfit();
        }
        return profit;
    }

    @Override
    public void showContent() {
        for (Content content: contents
        ) {
            System.out.println(content.toString());
        }
    }

    @Override
    public void addTime(double time) {
        this.time += time;
    }

    @Override
    public double getTimeAllContent() {
        double totalTime = 0;
        for (Content content: contents
             ) {
            totalTime+= content.getTime();
        }
        return totalTime;
    }

    @Override
    public double getTimeAllPaidContent() {
        double totalPaidTime = 0;
        for (Content content: contents
        ) {
            totalPaidTime+= content.getTimePaidContent();
        }
        return totalPaidTime;
    }

    @Override
    public void saveContent() {
        for (Content content: contents
        ) {
            SaveContent SaveContent = new SaveContent(content.toString());
            SaveContent.save();
        }
    }

    @Override
    public int getSizeContents() {
        return contents.size();
    }

    @Override
    public double getTime() {
        return time;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public static class SaveContent {
        private final String content;

        public SaveContent(String content) {
            this.content = content;
        }

        public void save() {
            try (FileWriter writer = new FileWriter("history.txt", true);
                 BufferedWriter bw = new BufferedWriter(writer)) {

                bw.write(content);
                bw.newLine();
                System.out.println("Content " + content.toString() + " saved successfully");
            } catch (IOException e) {
                System.out.println("failed to write history to file due to: " + e.getMessage());
            }
        }
    }
}
