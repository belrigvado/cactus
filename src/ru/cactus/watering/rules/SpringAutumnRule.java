package ru.cactus.watering.rules;

import java.time.LocalDate;

public class SpringAutumnRule implements WateringRule{
    @Override
    public LocalDate getWateringDate(LocalDate lastWateringDate) {
        return lastWateringDate.plusWeeks(1);
    }
}
