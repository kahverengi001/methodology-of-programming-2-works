package com.ahmetduruer.methodologyofprogramming2;

/**
 * EventListener class for listening events in Android app and device inputs.
 */
public interface EventListener {

    /**
     * onUserAccept method called when user accepts warning by Android app.
     */
    public void onUserAccept();

    /**
     * onBeforeMeeting method called when day in schedule comes in Android app.
     */
    public void onBeforeMeeting();

    /**
     * onBeforeRendezvous method called when day in schedule comes in Android app.
     */
    public void onBeforeRendezvous();

    /**
     * onBeforeAppointment method called when day in schedule comes in Android app.
     */
    public void onBeforeAppointment();
}
