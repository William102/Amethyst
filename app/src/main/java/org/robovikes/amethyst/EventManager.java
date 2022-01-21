package org.robovikes.amethyst;

public class EventManager {

    private String currentEvent;

    public EventManager() {

    }
    public String getCurrentEvent() {
        return currentEvent;
    }
    public void setCurrentEvent(String currentEvent) {
        this.currentEvent = currentEvent;
    }
}
