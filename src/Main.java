import java.util.Scanner;

/** Клас, що представляє число Фібоначчі.*/
class FibonacciNumber {
    private int index;
    private int value;

    /**Конструктор класу FibonacciNumber.
     * @param index номер числа Фібоначчі.
     * @param value значення числа Фібоначчі.*/
    public FibonacciNumber(int index, int value) {
        this.index = index;
        this.value = value;
    }

    /** Повертає рядок у форматі "F(N) = result".
     * @return рядок у форматі "F(N) = result".*/
    public String toString() {
        return "F(" + index + ") = " + value;
    }
}

/**Головний клас програми, що обчислює число Фібоначчі для введеного числа N.*/
public class Main {

    /**
     * Головний метод програми.
     * Запитує користувача на введення значення N та виводить відповідне число Фібоначчі.
     *
     * @param args аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть значення N: ");
        int N = scanner.nextInt();

        FibonacciNumber result = new FibonacciNumber(N, fibonacci(N));
        System.out.println(result);
    }

    /**
     * Обчислює число Фібоначчі для заданого N.
     *
     * @param N число, для якого обчислюється число Фібоначчі. Може бути як додатним, так і від'ємним.
     * @return число Фібоначчі для N.
     */
    public static int fibonacci(int N) {
        if (N == 0) {
            return 0;
        } else if (N > 0) {
            return positiveFibonacci(N);
        } else {
            return negativeFibonacci(N);
        }
    }

    /**
     * Обчислює число Фібоначчі для додатного числа N.
     *
     * @param N додатне число.
     * @return число Фібоначчі для додатного числа N.
     */
    private static int positiveFibonacci(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        int tzm1 = 1, tzm2 = 1, current = 1;
        for (int i = 3; i <= N; i++) {
            current = tzm1 + tzm2;
            tzm2 = tzm1;
            tzm1 = current;
        }
        return current;
    }

    /**
     * Обчислює число Фібоначчі для негативного числа N.
     * Використовується властивість, що F(-N) = (-1)^(N+1) * F(N).
     *
     * @param N негативне число (береться абсолютне значення для обчислення).
     * @return число Фібоначчі для негативного числа N, з відповідним знаком.
     */
    private static int negativeFibonacci(int N) {
        N = Math.abs(N);
        int fib = positiveFibonacci(N);
        return (N % 2 == 0) ? -fib : fib;
    }
}