package com.javarush.task.task15.task1522;

/* 
Закрепляем паттерн Singleton
*/

import java.util.Scanner;

public class Solution {
    public static Planet thePlanet;

    public static void main(String[] args) {

    }

    static {


        readKeyFromConsoleAndInitPlanet();

    }


    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();

        switch (key) {
            case Planet.EARTH:
                thePlanet = Earth.getInstance();
                break;
            case Planet.MOON:
                thePlanet = Moon.getInstance();
                break;
            case Planet.SUN:
                thePlanet = Sun.getInstance();
                break;
            default:
                thePlanet = null;
                break;
        }

    }
}
