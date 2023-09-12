package de.silke.cinematic.point;

import lombok.Data;

@Data
public class PointChecker {
    public static boolean isValid;

    /**
     * Проверка на int
     * @param value значение
     * @return true если значение является int, иначе false
     */
    public static boolean isInt(String value) {
        try {
            Integer.parseInt(value);
            isValid = true;
        } catch (NumberFormatException e) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean isBetween(int value, int min, int max) {
        return value >= min && value <= max;
    }
}
