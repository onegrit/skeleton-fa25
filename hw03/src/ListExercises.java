import java.util.ArrayList;
import java.util.List;

public class ListExercises {
    /** Returns the total sum in a list of integers */
    public static int sum(List<Integer> L) {
        int total = 0;
        for (Integer i : L) {
            total += i;
        }
        return total;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> even_numbers = new ArrayList<>();
        for (Integer integer : L) {
            if (integer % 2 == 0) {
                even_numbers.add(integer);
            }
        }
        return even_numbers;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> common_list = new ArrayList<>();
        for (Integer integer : L1) {
            if (L2.contains(integer)) {
                common_list.add(integer);
            }
        }

        return common_list;
    }

    public static int countOccurrencesOfWord(List<String> words, String w) {
        int occues = 0;
        for (String word : words) {
            if (word.contains(w)) {
                occues++;
            }
        }
        return occues;
    }

    /**
     * Returns the number of occurrences of the given character in a list of
     * strings.
     */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int total = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); ++i) {
                if (c == word.charAt(i)) {
                    total++;
                }
            }
        }
        return total;
    }
}
