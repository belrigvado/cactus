package ru.cactus.watering.rules;

import java.time.LocalDate;

/**
 * Интерфейс правила полива
 */
public interface WateringRule {
    LocalDate getWateringDate(LocalDate lastWateringDate) throws IllegalStateException;
}
