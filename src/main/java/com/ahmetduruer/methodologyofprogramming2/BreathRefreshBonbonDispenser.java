package com.ahmetduruer.methodologyofprogramming2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The BreathRefreshBonbonDispenser class is a silly device which gets human in constructor
 * and listens for events.
 *
 * @author kahverengi (Ahmet Enes Duruer)
 * @version 1.0
 */
public class BreathRefreshBonbonDispenser implements Serializable, EventListener {

    /**
     * List of Bonbons in device.
     */
    private final List<Bonbon> mBonbons = new ArrayList<>();

    /**
     * The "Human" who uses this device.
     */
    private final Human mPerson;

    /**
     * An Android app which is connected to this device.
     */
    private final AndroidApp mAndroidApp = new AndroidApp(this);

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
     * isBreathBad() checks is human object's breath is smelling or not.
     *
     * @return Check Human's breath. (is it smelling or not)
     */
    public boolean isBreathBad() {
        return mPerson.getBreath().equals(Breath.SMELLS);
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
    @Override
    public void onBeforeMeeting() {
        mAndroidApp.sendNotification("Sir! You should use a bonbon fresher before your meeting :)");
    }

    /**
     * onBeforeRendezvous() listens calender event and sends a notification to user over Android app.
     */
    @Override
    public void onBeforeRendezvous() {
        mAndroidApp.sendNotification("Sir! You should use a bonbon fresher before your Rendezvous :)");
    }

    /**
     * onBeforeAppointment() listens calender event and sends a notification to user over Android app.
     */
    @Override
    public void onBeforeAppointment() {
        mAndroidApp.sendNotification("Sir! You should use a bonbon fresher before your Appointment :)");
    }

    /**
     * onUserAccept() listens Android app which happens on user input. It refreshes breath on input.
     */
    @Override
    public void onUserAccept() {
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
}
