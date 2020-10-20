package com.ahmetduruer.methodologyofprogramming2;

import java.io.Serializable;

/**
 * The Human class object for representing user.
 */
public class Human implements Serializable {
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