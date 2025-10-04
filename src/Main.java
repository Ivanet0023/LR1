import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N (amount of first Luke numbers): ");
        int N = sc.nextInt();

        LucasNumber[] lucas = new LucasNumber[N];
        if (N >= 1) lucas[0] = new LucasNumber(1, 1); // L1
        if (N >= 2) lucas[1] = new LucasNumber(2, 3); // L2

        for (int i = 2; i < N; i++) {
            long nextValue = lucas[i - 1].getValue() + lucas[i - 2].getValue();
            lucas[i] = new LucasNumber(i + 1, nextValue);
        }

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

        if (!found) {
            System.out.println("There is no numbers that follow the rule");
        }
    }
}
