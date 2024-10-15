import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogAnalyzer {
    public static void main(String[] args) {
        // Create a HashMap to store the counts of status for each HH:mm
        Map<String, Map<String, Integer>> timeStatusMap = new HashMap<>();

        // Read the logs file
        String filePath = "logs.txt"; // File path and name where logs are stored
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Process each line of the log file
            while ((line = br.readLine()) != null) {
                // Split the log line into parts
                String[] parts = line.split(" ");
                if (parts.length < 4) continue;

                // Extract the time (HH:mm) from the second part of the line (YYYY:mm:dd HH:mm:ss)
                String dateTime = parts[1]; 
                String time = dateTime.substring(0, 5); 

                // Extract the status code from the 4th part
                String status = parts[3]; 

                // Step 5: Update the timeStatusMap
                timeStatusMap.putIfAbsent(time, new HashMap<>());
                Map<String, Integer> statusCount = timeStatusMap.get(time);
                statusCount.put(status, statusCount.getOrDefault(status, 0) + 1);
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        // Print the results
        for (String time : timeStatusMap.keySet()) {
            Map<String, Integer> statusCount = timeStatusMap.get(time);
            for (String status : statusCount.keySet()) {
                System.out.println(time + " " + status + " " + statusCount.get(status));
            }
        }
    }
}
