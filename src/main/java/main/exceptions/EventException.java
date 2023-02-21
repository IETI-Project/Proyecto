package main.exceptions;

public class EventException extends Exception {
    public static String EVENT_NOT_FOUND_EXCEPTION = "Could not find event";
    public static String EVENT_NOT_CREATED_EXCEPTION = "Could not create event";
    public static String EVENT_NOT_UPDATE_EXCEPTION = "Could not update event";
    public EventException(String message){
        super(message);
    }
}