public class FibonacciComparison {
    public static void main(String[] args) {
        int[] testCases = { 10, 30, 50 };

        for (int n : testCases) {
            System.out.println("\nFibonacci(" + n + ")");

            // Recursive Fibonacci (Avoid for large N)
            if (n <= 30) { // Avoid excessive computation
                measureExecutionTime(() -> System.out.println("Recursive: " + fibonacciRecursive(n)),
                        "Recursive Fibonacci");
            } else {
                System.out.println("Recursive Fibonacci: Unfeasible (>1hr)");
            }

            // Iterative Fibonacci (Efficient)
            measureExecutionTime(() -> System.out.println("Iterative: " + fibonacciIterative(n)),
                    "Iterative Fibonacci");
        }
    }

    // Recursive Fibonacci (O(2ⁿ))
    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
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
