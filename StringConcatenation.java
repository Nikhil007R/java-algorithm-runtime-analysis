public class StringConcatenation {
    public static void main(String[] args) {
        int[] sizes = { 1000, 10000, 1000000 };

        for (int size : sizes) {
            System.out.println("\nOperations Count: " + size);

            // String (Inefficient - O(N²))
            if (size <= 10000) { // Avoid excessive delays for large N
                measureExecutionTime(() -> concatWithString(size), "String Concatenation");
            } else {
                System.out.println("String Concatenation: Unfeasible (>30m)");
            }

            // StringBuilder (Efficient - O(N))
            measureExecutionTime(() -> concatWithStringBuilder(size), "StringBuilder Concatenation");

            // StringBuffer (Thread-safe - O(N))
            measureExecutionTime(() -> concatWithStringBuffer(size), "StringBuffer Concatenation");
        }
    }

    // Using String (Inefficient)
    public static void concatWithString(int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "A"; // Creates a new String object each time
        }
    }

    // Using StringBuilder (Efficient for single-threaded)
    public static void concatWithStringBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("A");
        }
    }

    // Using StringBuffer (Thread-safe but slightly slower)
    public static void concatWithStringBuffer(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("A");
        }
    }

    // Measure execution time
    private static void measureExecutionTime(Runnable method, String methodName) {
        long start = System.nanoTime();
        method.run();
        long end = System.nanoTime();
        double duration = (end - start) / 1_000_000.0; // Convert to milliseconds
        System.out.println(methodName + " Time: " + duration + " ms");
    }
}
