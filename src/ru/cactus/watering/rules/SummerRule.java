package ru.cactus.watering.rules;

import ru.cactus.watering.Sensor;

import java.time.LocalDate;

public class SummerRule implements WateringRule {
    @Override
    public LocalDate getWateringDate(LocalDate lastWateringDate) throws IllegalStateException {
        int humidity = Sensor.getHumidity();
        if(humidity >= 30) {
            throw new IllegalStateException(String.format("Текущая влажность %d%%, полив не требуется", humidity));
        }
        return lastWateringDate.plusDays(2);
    }
}
