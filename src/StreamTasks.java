import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public final class StreamTasks {

    private StreamTasks() {
    }

    public static double average(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static List<String> uppercaseWithPrefix(List<String> strings) {
        return strings.stream()
                .map(value -> "_new_" + value.toUpperCase())
                .toList();
    }

    public static List<Integer> squaresOfUnique(List<Integer> numbers) {
        Map<Integer, Long> counts = numbers.stream()
                .collect(Collectors.groupingBy(number -> number, Collectors.counting()));

        return numbers.stream()
                .filter(number -> counts.get(number) == 1L)
                .map(number -> number * number)
                .toList();
    }

    public static <T> T lastElement(Collection<T> collection) {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new NoSuchElementException("Коллекция пуста"));
    }

    public static int sumOfEvens(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(number -> number % 2 == 0)
                .sum();
    }

    public static Map<Character, String> toMapByFirstChar(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toMap(
                        StreamTasks::firstChar,
                        value -> value.substring(1),
                        (left, right) -> {
                            throw new IllegalStateException("Повторяющийся первый символ");
                        },
                        LinkedHashMap::new
                ));
    }

    private static Character firstChar(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("Строка не должна быть пустой");
        }
        return value.charAt(0);
    }
}
