package ru.cactus.watering.rules;

import java.time.LocalDate;

public class WinterRule implements WateringRule{
    @Override
    public LocalDate getWateringDate(LocalDate lastWateringDate) {
        return lastWateringDate.plusMonths(1);
    }
}
