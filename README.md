# Log File Status Analyzer
A Java-based tool for parsing log files and counting HTTP status code occurrences per time slot (HH:MM), providing insights into web service request patterns.

**Problem Description**<br/>
The objective is to analyze a log file containing API requests and extract the count of occurrences of different HTTP status codes for each unique HH:mm (hour
) time slot in a single day.

**Input Format**<br/>
The log file (logs.txt) contains lines of the following format:<br/>
YYYY:mm:dd hh:mm:ss url status message

**Example of log entries:**<br/>
2024:10:14 00:00:01 /api/createuser 201 Created<br/>
2024:10:14 00:00:01 /api/createuser 401 Unauthorized<br/>
2024:10:14 01:00:01 /api/createuser 200 OK<br/>
2024:10:14 02:00:01 /api/createuser 404 Not found<br/>

**The logs contain:**<br/>
Timestamp: YYYY:mm:dd hh:mm:ss<br/>
URL: The endpoint accessed, e.g., /api/createuser.<br/>
Status: The HTTP status code (e.g., 200, 404).<br/>
Message: A textual description of the status.<br/>

**Expected Output**<br/>
For each unique HH:mm time slot, the program outputs the count of occurrences of each status code.

**Example output:**<br/>
HH:mm status count<br/>
00:00 200 1250<br/>
00:00 404 30<br/>
00:00 201 50<br/>
01:00 200 2600<br/>
01:00 502 23<br/>

**Solution Overview**<br/>
The solution reads the log file, processes each log entry, and extracts the time (HH:mm) and status code. For each time slot, it tracks how many times each status code occurs using a nested HashMap.<br/>

**Steps to Run the Solution**<br/>
1.Ensure you have Java installed on your system.<br/>
2.Place the LogAnalyzer.java file in your working directory.<br/>
3.Place the log file (logs.txt) in the same directory or specify its path in the LogAnalyzer.java file.<br/>






