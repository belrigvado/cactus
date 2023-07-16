package ru.cactus;

import ru.cactus.watering.WateringSchedule;

public class Main {
    public static void main(String[] args) {
        new WateringSchedule().determineNextDate();
    }
}