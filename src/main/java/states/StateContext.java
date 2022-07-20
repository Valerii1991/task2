package states;

import broadcasts.Broadcast;
import leadings.Leading;

import java.util.Scanner;

public class StateContext {
    private Leading leading;
    private Broadcast broadcast;
    private Scanner scanner;
    private int number;
    private State currentState;

    public StateContext() {
        this.currentState = new StateStart();
    }

    public Leading getLeading() {
        return leading;
    }

    public void setLeading(Leading leading) {
        this.leading = leading;
    }

    public Broadcast getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(Broadcast broadcast) {
        this.broadcast = broadcast;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void run(){
        this.currentState.run(this);
    }
}
