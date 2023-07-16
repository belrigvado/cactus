package ru.cactus.watering;

import ru.cactus.watering.rules.WateringRule;
import ru.cactus.watering.rules.WateringRuleFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Класс с основной логикой программы
 */
public class WateringSchedule {

    // Константа, описывающая формат даты
    private static final String DATE_FORMAT = "dd.MM.yyyy";

    /**
     * Метод определения следующей даты полива
     */
    public void determineNextDate() {
        LocalDate lastDate = readLastDate(); // Определяем последнюю дату полива на основании ввода пользователя
        WateringRule wateringRule = WateringRuleFactory.getWateringRule(); // Определяем правило полива по текущей дате

        /* Раскомментировать, если определять правило по последней дате полива
        WateringRule wateringRule = WateringRuleFactory.getWateringRule(lastDate.getMonth());
        */

        try {
            LocalDate nextDate = wateringRule.getWateringDate(lastDate); // Вызываем метод определения следующей даты полива
            System.out.println("Следующая дата полива: " + nextDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
        } catch (IllegalStateException ex) { // Если дата не может быть определена, выводим сообщение
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Метод считывания даты последнего полива
     */
    private LocalDate readLastDate() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE_FORMAT); // Устанавливаем формат даты, который ожидается
        System.out.print("Введите дату последнего полива (дд.мм.гггг): ");
        while (true) { // Повторяем ввод, пока не будет получен верный формат
            String userInput = scanner.next(); // Считываем ввод в виде строки
            try {
                return LocalDate.parse(userInput, dateFormat); // Если удается запарсить дату, то выходим из метода
            } catch (DateTimeParseException e) { // Если возникла ошибка парсинга, то повторяем ввод
                System.out.print("Неверный формат даты! Повторите ввод (дд.мм.гггг): ");
            }
        }
    }
}
