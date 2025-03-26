import java.io.*;

public class FileReading {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Nikhil Rawat\\OneDrive\\Desktop\\example.txt"; // Update with your actual file
                                                                                     // path

        // Measure time for FileReader
        long startTime1 = System.nanoTime();
        readWithFileReader(filePath);
        long endTime1 = System.nanoTime();
        long fileReaderTime = (endTime1 - startTime1) / 1000000; // Convert to ms

        // Measure time for InputStreamReader
        long startTime2 = System.nanoTime();
        readWithInputStreamReader(filePath);
        long endTime2 = System.nanoTime();
        long inputStreamReaderTime = (endTime2 - startTime2) / 1000000; // Convert to ms

        // Print results
        System.out.println("FileReader Time: " + fileReaderTime + " ms");
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime + " ms");
    }

    // Using FileReader (Character Stream)
    private static void readWithFileReader(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.read() != -1) {
            } // Read each character
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Using InputStreamReader (Byte Stream + Character Conversion)
    private static void readWithInputStreamReader(String filePath) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            while (reader.read() != -1) {
            } // Read each character
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}