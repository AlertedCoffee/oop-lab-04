import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public final class Main {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        System.out.println("Среднее: " + StreamTasks.average(numbers));

        List<String> words = List.of("hello", "world");
        System.out.println("Префикс: " + StreamTasks.uppercaseWithPrefix(words));

        List<Integer> withDuplicates = List.of(1, 2, 2, 3, 4, 4, 5);
        System.out.println("Квадраты уникальных: " + StreamTasks.squaresOfUnique(withDuplicates));

        System.out.println("Последний элемент: " + StreamTasks.lastElement(List.of("a", "b", "c")));

        System.out.println("Сумма чётных: " + StreamTasks.sumOfEvens(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println("Сумма без чётных: " + StreamTasks.sumOfEvens(new int[]{1, 3, 5}));

        Map<Character, String> mapped = StreamTasks.toMapByFirstChar(List.of("apple", "banana"));
        System.out.println("Map: " + mapped);

        try {
            StreamTasks.lastElement(List.of());
        } catch (NoSuchElementException exception) {
            System.out.println("Пустая коллекция: " + exception.getMessage());
        }
    }

    private Main() {
    }
}
