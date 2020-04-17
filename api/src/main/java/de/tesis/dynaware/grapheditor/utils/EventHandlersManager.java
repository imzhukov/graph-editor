package de.tesis.dynaware.grapheditor.utils;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.layout.Region;

import java.util.HashMap;

public class EventHandlersManager {

    private Node node;
    private HashMap<EventHandler<? extends Event>, EventType> eventHandlersMap;

    public EventHandlersManager(Node node){
        this.node = node;
        eventHandlersMap = new HashMap<>();
    }

    /**
     *
     * */
    public void addAndSaveEventHandler(EventType type, EventHandler<? extends Event> eventHandler){
        node.addEventHandler(type, eventHandler);
        eventHandlersMap.put(eventHandler, type);
    }

    public void removeEventHandler(EventType type, EventHandler<? extends Event> eventHandler, boolean removeFromStorage){
        node.removeEventHandler(type, eventHandler);
        if(removeFromStorage){
            eventHandlersMap.remove(eventHandler);
        }
    }

    public void removeAllEventHandlersFromNode(){
        eventHandlersMap.entrySet().forEach(entrySet -> {
            node.removeEventHandler(entrySet.getValue(), entrySet.getKey());
        });
    }

    public void restoreEventHandlers(){
        eventHandlersMap.entrySet().forEach(entrySet -> {
            node.addEventHandler(entrySet.getValue(), entrySet.getKey());
        });
    }

    public void clearStorage(){
        eventHandlersMap.clear();
    }

}
