package com.ahmetduruer.methodologyofprogramming2;

import java.io.Serializable;

/**
 * AndroidApp class which represents virtual Android app.
 */
public class AndroidApp implements Serializable {
    /**
     * Event listener for user inputs.
     */
    private final EventListener mEventListener;

    /**
     * Constructor for Android app which gets eventListener.
     *
     * @param eventListener Event listener for user inputs.
     */
    public AndroidApp(EventListener eventListener) {
        this.mEventListener = eventListener;
    }

    /**
     * Sends user a notification with message.
     *
     * @param message String message to send.
     */
    public void sendNotification(String message) {
        System.out.println(message);
    }

    /**
     * An event for getting user input. It calls event listener's method.
     */
    public void onUserAccepts() {
        mEventListener.onUserAccept();
    }
}
