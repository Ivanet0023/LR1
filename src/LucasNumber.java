/**
 * Представляє одне число Люка, зберігаючи його індекс та значення.
 * Також містить методи, для перевірки числа до завдання*
 */
public class LucasNumber {

    /** Індекс числа в послідовності Люка (L_n). */
    private int index;

    /** Значення числа Люка. */
    private long value;

    /**
     * Створює новий екземпляр числа Люка.
     *
     * @param index Порядковий номер числа в послідовності.
     * @param value Значення числа.
     */
    public LucasNumber(int index, long value) {
        this.index = index;
        this.value = value;
    }

    /**
     * Повертає індекс числа.
     * @return індекс n для L_n.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Повертає значення числа.
     * @return значення числа Люка.
     */
    public long getValue() {
        return value;
    }

    /**
     * Перевіряє, чи можна представити число у формі w^3 + 1,
     * де w є цілим числом.
     * @return true, якщо число є кубом цілого числа плюс один, інакше false.
     */
    public boolean cubeCalc() {
        if (value < 1) return false;
        long w3 = Math.round(Math.cbrt(value - 1));
        return w3 * w3 * w3 + 1 == value;
    }

    /**
     * Повертає текстове представлення об'єкта.
     * Формат: "Luke numb: [індекс] = [значення]".
     * @return Рядок, що описує число Люка.
     */
    @Override
    public String toString() {
        return "Luke numb: " + index + " = " + value;
    }
}
