package states;

public class StateFinish implements State {
    @Override
    public void run(StateContext sc) {
        System.out.println("application is closed");
        System.exit(0);
    }
}
