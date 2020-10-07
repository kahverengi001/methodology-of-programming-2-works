package com.ahmetduruer.methodologyofprogramming2;

import java.util.ArrayList;
import java.util.List;

/**
 * The BreathRefreshBonbonDispenser class is a silly device which gets human in constructor
 * and listens for events.
 *
 * @author kahverengi (Ahmet Enes Duruer)
 * @version 1.0
 */
public class BreathRefreshBonbonDispenser {

    /**
     * List of Bonbons in device.
     */
    private final List<Bonbon> mBonbons = new ArrayList<>();

    /**
     * The "Human" who uses this device.
     */
    private final Human mPerson;

    /**
     * An event listener for listening events in this and other connected devices.
     */
    private final EventListener mEventListener = new EventListener(this);

    /**
     * An Android app which is connected to this device.
     */
    private final AndroidApp mAndroidApp = new AndroidApp(mEventListener);


    /**
     * Creates a new BreathRefreshBonbonDispenser object that represents the Breath Refresh Bonbon Dispenser.
     *
     * @param person A Human class who uses this device.
     */
    public BreathRefreshBonbonDispenser(Human person) {
        refreshBonbons();

        this.mPerson = person;
    }

    /**
     * Return EventListener object in this class
     *
     * @return Returns an eventListener object in this class.
     */
    public EventListener getEventListener() {
        return mEventListener;
    }

    /**
     * isBreathBad() checks is human object's breath is smelling or not.
     *
     * @return Check Human's breath. (is it smelling or not)
     */
    public boolean isBreathBad() {
        return mPerson.mBreath.equals(Breath.SMELLS);
    }

    /**
     * onPress() listens onPress event which is occur on device and refreshes human's breath with bonbons.
     */
    public void onPress() {
        refreshBreath();
    }

    /**
     * onBeforeMeeting() listens calendar event and sends a notification to user over Android app.
     */
    private void onBeforeMeeting() {
        mAndroidApp.sendNotification("Sir! You should use a bonbon fresher before your meeting :)");
    }

    /**
     * onBeforeRendezvous() listens calender event and sends a notification to user over Android app.
     */
    private void onBeforeRendezvous() {
        mAndroidApp.sendNotification("Sir! You should use a bonbon fresher before your Rendezvous :)");
    }

    /**
     * onBeforeAppointment() listens calender event and sends a notification to user over Android app.
     */
    private void onBeforeAppointment() {
        mAndroidApp.sendNotification("Sir! You should use a bonbon fresher before your Appointment :)");
    }

    /**
     * onUserAccept() listens Android app which happens on user input. It refreshes breath on input.
     */
    private void onUserAccept() {
        refreshBreath();
    }

    /**
     * Removes one Bonbon from device to consume.
     */
    private void consumeBonbon() {
        this.mBonbons.remove(0);
    }

    /**
     * Refreshes bonbons by adding +100 bonbons.
     */
    private void refreshBonbons() {
        for (int i = 0; i < 100; i++) {
            this.mBonbons.add(new Bonbon());
        }
    }

    /**
     * @return Returns a Boolean which is equal to is Bonbon list in device empty or not.
     */
    private boolean isThereBonbon() {
        return this.mBonbons.size() != 0;
    }

    /**
     * Checks is there enough Bonbon and is breath bad or not. Then consumes a Bonbon and refreshes human's breath.
     */
    private void refreshBreath() {
        if (isBreathBad()) {
            if (isThereBonbon()) {
                consumeBonbon();

                mPerson.useBonbon();

                System.out.println("Your breath is fresh as new born! :)");
            } else {
                System.out.println("I'm sorry, there is no bonbon left :(");
            }
        }
    }

    /**
     * Enum for representing Breath as object.
     */
    public static enum Breath {
        SMELLS,
        FRESH
    }

    /**
     * The Human class object for representing user.
     */
    public static class Human {
        /**
         * Name of Human.
         */
        private final String mName;
        /**
         * Breath of human.
         */
        private Breath mBreath;

        /**
         * Creates a new Human object that represents the user.
         *
         * @param breath Breath of user.
         * @param name   Name of user.
         */
        public Human(Breath breath, String name) {
            this.mBreath = breath;
            this.mName = name;
        }

        /**
         * Creates a new Human object that represents the user.
         * It fills Breath Smelling as default value
         *
         * @param name Name of user.
         */
        public Human(String name) {
            this.mBreath = Breath.SMELLS;
            this.mName = name;
        }

        /**
         * Makes Human's breath fresh.
         */
        public void useBonbon() {
            this.mBreath = Breath.FRESH;
        }

        /**
         * Gets Human's breath.
         *
         * @return Breath of human.
         */
        public Breath getBreath() {
            return mBreath;
        }

        /**
         * Gets Human's name.
         *
         * @return Name of human.
         */
        public String getName() {
            return mName;
        }
    }

    /**
     * Bonbon class which represents Bonbons as object.
     */
    private static class Bonbon {
    }

    /**
     * AndroidApp class which represents virtual Android app.
     */
    private static class AndroidApp {
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

    /**
     * EventListener class for listening events in Android app and device inputs.
     */
    public static class EventListener {
        /**
         * BreathRefreshBonbonDispenser object for calling events.
         */
        private final BreathRefreshBonbonDispenser mBreathRefreshBonbonDispenser;

        /**
         * Constructor class which creates EventListener object.
         *
         * @param breathRefreshBonbonDispenser BreathRefreshBonbonDispenser object for calling events.
         */
        public EventListener(BreathRefreshBonbonDispenser breathRefreshBonbonDispenser) {
            this.mBreathRefreshBonbonDispenser = breathRefreshBonbonDispenser;
        }

        /**
         * onUserAccept method called when user accepts warning by Android app.
         */
        public void onUserAccept() {
            mBreathRefreshBonbonDispenser.onUserAccept();
        }

        /**
         * onBeforeMeeting method called when day in schedule comes in Android app.
         */
        public void onBeforeMeeting() {
            mBreathRefreshBonbonDispenser.onBeforeMeeting();
        }

        /**
         * onBeforeRendezvous method called when day in schedule comes in Android app.
         */
        public void onBeforeRendezvous() {
            mBreathRefreshBonbonDispenser.onBeforeRendezvous();
        }

        /**
         * onBeforeAppointment method called when day in schedule comes in Android app.
         */
        public void onBeforeAppointment() {
            mBreathRefreshBonbonDispenser.onBeforeAppointment();
        }
    }
}
