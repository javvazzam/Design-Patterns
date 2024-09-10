package state.antipattern;

enum TrafficLightState {
    RED, YELLOW, GREEN
}

class TrafficLight {
    private TrafficLightState currentState;

    public TrafficLight() {
        this.currentState = TrafficLightState.RED;
    }

    public void changeLight() {
        switch (currentState) {
            case RED:
                System.out.println("Red -> Switching to Green");
                currentState = TrafficLightState.GREEN;
                break;
            case GREEN:
                System.out.println("Green -> Switching to Yellow");
                currentState = TrafficLightState.YELLOW;
                break;
            case YELLOW:
                System.out.println("Yellow -> Switching to Red");
                currentState = TrafficLightState.RED;
                break;
        }
    }
}
