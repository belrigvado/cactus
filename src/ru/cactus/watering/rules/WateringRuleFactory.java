package ru.cactus.watering.rules;

import java.time.LocalDate;
import java.time.Month;

/**
 * Класс для определения правила полива в зависимости от даты
 */
public class WateringRuleFactory {

    /**
     * Переопределение метода getWateringRule с указанием текущего месяца
     */
    public static WateringRule getWateringRule() {
        return getWateringRule(LocalDate.now().getMonth());
    }

    /**
     * Метод, возвращающий правило полива
     */
    public static WateringRule getWateringRule(Month month) {
        switch (month) {
            case DECEMBER: // Если зима
            case JANUARY:
            case FEBRUARY:
                return new WinterRule();
            case JUNE: // Если лето
            case JULY:
            case AUGUST:
                return new SummerRule();
            default: // Если осень или весна
                return new SpringAutumnRule();
        }
    }
}
