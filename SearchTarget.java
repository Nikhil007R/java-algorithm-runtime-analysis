import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class SearchTarget {
    public static void main(String[] args) {
        int[] sizes = { 1000, 10000, 1000000 };

        for (int size : sizes) {
            int[] data = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(size * 10))
                    .limit(size)
                    .toArray();

            int target = data[ThreadLocalRandom.current().nextInt(size)]; // Pick a random target

            // Linear Search
            measureExecutionTime(() -> linearSearch(data, target), "Linear Search", size);

            // Binary Search (requires sorting)
            Arrays.sort(data);
            measureExecutionTime(() -> binarySearch(data, target), "Binary Search", size);
        }
    }

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    // Measure execution time
    private static void measureExecutionTime(Runnable searchMethod, String method, int size) {
        long start = System.currentTimeMillis();
        searchMethod.run();
        long end = System.currentTimeMillis();
        System.out.println(method + " Time for " + size + " elements: " + (end - start) + " ms");
    }
}
