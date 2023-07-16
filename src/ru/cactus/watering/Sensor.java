package ru.cactus.watering;

import java.util.Random;

/**
 * Класс сенсора для определения влажности воздуха
 */
public class Sensor {
    public static int getHumidity() {
        Random random = new Random();
        //random.setSeed(19); // Раскомментировать, чтобы владжность была >= 30%
        return random.nextInt(101);
    }
}
