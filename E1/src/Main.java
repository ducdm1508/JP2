import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(123);
        numbers.add(456);
        numbers.add(789);
        numbers.add(124);
        numbers.add(12262735);
        numbers.add(1263892533);

        Set<Integer> divisbleBy3 = new HashSet<>();

        numbers.forEach(number -> {
            if (isSumDivisibleBy3(number)) {
                divisbleBy3.add(number);
            }
        });
        System.out.println("Các số có th chia hết cho 3 là: " + divisbleBy3);

    }

    public static boolean isSumDivisibleBy3(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        while (sum >= 3) {
            sum -= 3;
        }

        return sum == 0;
    }
}
