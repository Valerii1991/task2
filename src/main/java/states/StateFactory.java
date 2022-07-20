package states;

import broadcasts.Broadcast;

public class StateFactory {
    public static State createState(StateContext sc, int number){
        State currentState = sc.getCurrentState();
        Broadcast broadcast = sc.getBroadcast();

        if(currentState.getClass().equals(StateStart.class)){
          State state = handlerStateStart(number, currentState);
          return state;
        }
        else if(currentState.getClass().equals(StateCreateWorkingLeading.class)){
            State state = handlerCreateWorkingLeading(number, currentState);
            return state;
        }
        else if(currentState.getClass().equals(StateCreateGuestLeading.class)){
            State state = handlerStateCreateGuestLeading(number, currentState);
            return state;
        }
        else if(currentState.getClass().equals(StateCreateAustrianBroadcast.class)){
            State state = handlerStateCreateAustrianBroadcast(number, currentState, broadcast, sc);
            return state;
        }
        else if(currentState.getClass().equals(StateCreateContent.class)){
            State state = handlerStateCreateContent(number, currentState, broadcast);
            return state;
        }
        else if(currentState.getClass().equals(StateCreateSong.class) || currentState.getClass().equals(StateCreateInterview.class)|| currentState.getClass().equals(StateCreateAdvertising.class)){
            State state = handlerStateCreateSongOrStateCreateAdvertisingOrStateCreateInterview(number, currentState);
            return state;
        }
        return null;
    }

    private static State handlerStateCreateSongOrStateCreateAdvertisingOrStateCreateInterview(int number, State currentState) {
        if(number == 1){
            return new StateCreateSong();
        }
        else if(number == 2){
            return new StateCreateInterview();
        }
        else if(number == 3){
            return new StateCreateAdvertising();
        }
        else if(number == 4){
            return new StateCreateContent();
        }
        else if(number == 0){
            return new StateFinish();
        }
        else {
            System.out.println("you entered an invalid value, please try again");
            return currentState;
        }
    }

    private static State handlerStateCreateContent(int number, State currentState, Broadcast broadcast) {
        if(number == 1){
            return new StateCreateSong();
        }
        else if(number == 2){
            return new StateCreateInterview();
        }
        else if(number == 3){
            return new StateCreateAdvertising();
        }
        else if(number == 4){
           return null;
        }
        else if(number == 5){
            System.out.println("profit " + broadcast.toString() + ": " + broadcast.getProfit());
            return null;
        }
        else if(number == 6){
            System.out.println("Contents: ");
            broadcast.showContent();
            return null;
        }
        else if(number == 7){
            broadcast.saveContent();
            return null;
        }
        else if(number == 0){
            return new StateFinish();
        }
        else {
            System.out.println("you entered an invalid value, please try again");
            return currentState;
        }
    }

    private static State handlerStateCreateAustrianBroadcast(int number, State currentState, Broadcast broadcast, StateContext sc) {
        if(number == 1){
            sc.setBroadcast(null);
            return new StateCreateAustrianBroadcast();
        }
        else if(number == 2){
            return new StateCreateContent();
        }
        else if(number == 3){
            System.out.println("profit " + broadcast.toString() + ": " + broadcast.getProfit());
            return currentState;
        }
        else if(number == 4){
            System.out.println("Contents: ");
            broadcast.showContent();
            return currentState;
        }
        else if(number == 5){
            broadcast.saveContent();
            return currentState;
        }
        else if(number == 0){
           return new StateFinish();
        }
        else {
            System.out.println("you entered an invalid value, please try again");
            return currentState;
        }
    }

    private static State handlerStateCreateGuestLeading(int number, State currentState) {
        if(number == 1){
            return  new StateCreateAustrianBroadcast();
        }
        else if(number == 0){
           return new StateFinish();
        }
        else {
            System.out.println("you entered an invalid value, please try again");
            return currentState;
        }
    }

    private static State handlerStateStart(int number, State currentState) {
        if(number == 1){
            return new StateCreateWorkingLeading();
        }
        else if(number == 2){
            return new StateCreateGuestLeading();
        }

        else if(number == 0){
            return new StateFinish();
        }

        else if(number == 2){
            return new StateCreateGuestLeading();
        }

        else{
            return currentState;
        }
    }

    private static State handlerCreateWorkingLeading(int number, State currentState) {
        if(number == 1){
            return new StateCreateAustrianBroadcast();
        }
        else if(number == 0){
            return new StateFinish();
        }
        else {
            System.out.println("you entered an invalid value, please try again");
            return currentState;
        }
    }
}
