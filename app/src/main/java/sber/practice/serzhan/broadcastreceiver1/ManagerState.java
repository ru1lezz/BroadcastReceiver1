package sber.practice.serzhan.broadcastreceiver1;

public class ManagerState {
    private static ManagerState instance;
    private char state;
    private int remainder;

    private ManagerState() {
        remainder = 5;
    }

    public static ManagerState getInstance() {
        if(instance == null) {
            instance = new ManagerState();
        }
        return instance;
    }

    public void changeState() {
        calculateRemainder();
        switch (remainder) {
            case 0:
                state = 'A';
                break;
            case 1:
                state = 'B';
                break;
            case 2:
                state = 'C';
                break;
            case 3:
                state = 'D';
                break;
            case 4:
                state = 'E';
                break;
            default:
                state = 'F';
                break;
        }
    }

    public Character getState() {
        return state;
    }

    private void calculateRemainder () {
        remainder = (remainder+1) % 5;
    }

 }
