import java.util.Scanner;

/**
 * Головний клас програми, що демонструє роботу з числами Люка.
 * Клас зчитує з консолі кількість N, генерує перші N чисел Люка,
 * а потім перевіряє, які з них задовольняють умову L_n = w^3 + 1.
 */
public class Main {

    /**
     * Точка входу в програму.
     * Метод виконує наступні дії:
     * 1. Запитує у користувача кількість перших чисел Люка для перевірки.
     * 2. Створює та заповнює масив чисел Люка.
     * 3. Виводить згенеровану послідовність на екран.
     * 4. Перевіряє кожне число на відповідність умові w^3 + 1 та виводить результат.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N (amount of first Luke numbers): ");
        int N = sc.nextInt();

        // Створення об'єктів класу LucasNumber
        // Значення першого та другого числа Люка задаються
        LucasNumber[] lucas = new LucasNumber[N];
        if (N >= 1) lucas[0] = new LucasNumber(1, 1); // L1
        if (N >= 2) lucas[1] = new LucasNumber(2, 3); // L2

        // Генерація чисел люка
        for (int i = 2; i < N; i++) {
            long nextValue = lucas[i - 1].getValue() + lucas[i - 2].getValue();
            lucas[i] = new LucasNumber(i + 1, nextValue);
        }

        // Початок виведення чисел, кількість яких вказав користувач
        System.out.println("\nFirst " + N + " Luke numbers:");
        for (LucasNumber i : lucas) {
            System.out.println(i);
        }

        // Перевірка на умову
        System.out.println("\nCheck if Ln =  w^3 + 1:");
        boolean found = false;
        for (LucasNumber i : lucas) {
            if (i.cubeCalc()) {
                long w = Math.round(Math.cbrt(i.getValue() - 1));
                System.out.println(i + " = " + w + "^3 + 1");
                found = true;
            }
        }
        // Вивід при невдачі
        if (!found) {
            System.out.println("There is no numbers that follow the rule");
        }
    }
}