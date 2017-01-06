
/**
 * Write a description of LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
import java.util.ArrayList;
public class LogAnalyzer {
    private ArrayList<LogEntry> records;
    public LogAnalyzer(){
        this.records = new ArrayList<LogEntry>();
    }
    public void readFile(String filename){
        FileResource fr = new FileResource(filename);
        for(String line: fr.lines()){
            LogEntry x = WebLogParser.parseEntry(line);
            records.add(x);
    }
}
   public void printAll(){
        for(LogEntry le: records){
            System.out.println(le);
        }
    }
 public int countUniqueIPs(){
     ArrayList<String> uniqueIPs = new ArrayList<String>();
     for(LogEntry le: records){
         String ipAddr = le.getIpAddress();
         if(!uniqueIPs.contains(ipAddr)){
             uniqueIPs.add(ipAddr);
            }
        }
        return uniqueIPs.size();
    }
    public void printAllHigherThanNum(int num){
        for(LogEntry le: records){
            if(le.getStatusCode() > num){
                System.out.println(le);
            }
        }
    }
    public ArrayList<String> uniqueIPVisitsOnDay(String someday){
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for (LogEntry le: records) {
			String ipAddress = le.getIpAddress();
			String accessTime = le.getAccessTime().toString();
			if (someday.equals(accessTime.substring(4, 10))) {
				if (!uniqueIPs.contains(ipAddress)) {
					uniqueIPs.add(ipAddress);
				}
			}
		}
		return uniqueIPs;
    }
    public int countUniqueIPsInRange(int low, int high){
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for(LogEntry le: records){
        String ipAddress = le.getIpAddress();
        int statusCode = le.getStatusCode();
        
        if(statusCode >= low && statusCode <= high){
            if(!uniqueIPs.contains(ipAddress)){
                  uniqueIPs.add(ipAddress);
                }
        }
              
        }
        return uniqueIPs.size();
    }
}
