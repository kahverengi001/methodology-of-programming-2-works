package com.ahmetduruer.methodologyofprogramming2

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val ahmet = BreathRefreshBonbonDispenser.Human("Ahmet");

            val breathRefreshBonbonDispenser = BreathRefreshBonbonDispenser(ahmet);

            breathRefreshBonbonDispenser.onPress()
        }
    }
}