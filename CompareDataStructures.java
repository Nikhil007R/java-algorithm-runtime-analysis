import java.util.*;

public class CompareDataStructures {
    public static void main(String[] args) {
        int N = 1000000; // Dataset size
        Random rand = new Random();

        // Generate random dataset
        int[] array = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            int num = rand.nextInt(N * 10); // Ensure diverse numbers
            array[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }

        // Select a random search target
        int searchElement = array[N / 2];

        long start, end;

        // Array Search (O(N)) - Linear Search
        start = System.nanoTime();
        boolean foundInArray = linearSearch(array, searchElement);
        end = System.nanoTime();
        System.out.println("Array Search (Linear) found: " + foundInArray +
                " | Time: " + (end - start) / 1000000.0 + " ms");

        // HashSet Search (O(1))
        start = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(searchElement);
        end = System.nanoTime();
        System.out.println("HashSet Search (O(1)) found: " + foundInHashSet +
                " | Time: " + (end - start) / 1000000.0 + " ms");

        // TreeSet Search (O(log N))
        start = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(searchElement);
        end = System.nanoTime();
        System.out.println("TreeSet Search (O(log N)) found: " + foundInTreeSet +
                " | Time: " + (end - start) / 1000000.0 + " ms");
    }

    // Linear Search (O(N)) for Array
    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target)
                return true;
        }
        return false;
    }
}