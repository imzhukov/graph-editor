package de.tesis.dynaware.grapheditor.utils;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.layout.Region;

import java.util.HashMap;

/**
 * Improve management of event handlers.
 * Main perspective is using storage for event handlers.
 * Give opportunity to disable handlers temporarily
 * */
public class EventHandlersManager {

    private Node node;
    private HashMap<EventHandler<? extends Event>, EventType> eventHandlersMap;

    public EventHandlersManager(Node node){
        this.node = node;
        eventHandlersMap = new HashMap<>();
    }

    /**
     * Provide addEventHandler() and save a handler to storage
     * */
    public void addAndSaveEventHandler(EventType type, EventHandler<? extends Event> eventHandler){
        node.addEventHandler(type, eventHandler);
        eventHandlersMap.put(eventHandler, type);
    }

    /**
     * Provide removeEventHandler() and can remove a handler from storage
     *
     * @param removeFromStorage - if true - remove handler from storage
     * */
    public void removeEventHandler(EventType type, EventHandler<? extends Event> eventHandler, boolean removeFromStorage){
        node.removeEventHandler(type, eventHandler);
        if(removeFromStorage){
            eventHandlersMap.remove(eventHandler);
        }
    }

    /**
     * Provide removeEventHandler() for all handlers, but they stay in storage.
     * If you want remove handlers from storage use following {@link #clearStorage}
     * */
    public void removeAllEventHandlersFromNode(){
        eventHandlersMap.entrySet().forEach(entrySet -> {
            node.removeEventHandler(entrySet.getValue(), entrySet.getKey());
        });
    }

    /**
     * Restore all event handlers from storage
     * */
    public void restoreEventHandlers(){
        eventHandlersMap.entrySet().forEach(entrySet -> {
            node.addEventHandler(entrySet.getValue(), entrySet.getKey());
        });
    }

    public void clearStorage(){
        eventHandlersMap.clear();
    }

}
