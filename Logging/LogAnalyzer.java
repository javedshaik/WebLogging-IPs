
/**
 * Write a description of LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;
import java.util.Iterator;
import java.util.HashMap;


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
    public HashMap<String, Integer> countVisitsPerIP(){
        HashMap<String,Integer> counts = new HashMap<String,Integer>();
        for(LogEntry le: records){
            String ip = le.getIpAddress();
            if(!counts.containsKey(ip)){
                counts.put(ip,1);
            }
            else{
                counts.put(ip,counts.get(ip) + 1);
            }
        }
        return counts;
    }
    public int mostNumberVisitsByIP(HashMap<String, Integer> map){
        return Collections.max(map.values());
    }
    public ArrayList<String> iPsMostVisits(HashMap<String, Integer>map){
    ArrayList<String> ipAddress = new ArrayList<String>();
		int max = mostNumberVisitsByIP(map);
		Iterator it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        if (max == (int)pair.getValue()) {
	        	ipAddress.add((String)pair.getKey());
	        }
	        it.remove();
	    }
	    return ipAddress;
    
}
public HashMap<String, ArrayList<String>> iPsForDays() {
		HashMap<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(LogEntry le: records) {
			String ip = le.getIpAddress();
			String date = le.getAccessTime().toString().substring(4, 10);
			ArrayList<String> ipAddressList = new ArrayList<String>();
			if (!map.containsKey(date)) {
				ipAddressList.add(ip);
				map.put(date, ipAddressList);
			}
			else {
				ArrayList<String> currentipAddress = map.get(date);
				currentipAddress.add(ip);
				map.put(date, currentipAddress);
			}
		}
		return map;
	}
	
	public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map) {
		String day ="";
		int size = 0;
		for (Map.Entry<String, ArrayList<String>> e : map.entrySet()) {
			if (size < e.getValue().size()){
				size = e.getValue().size();
				day = e.getKey();
			}
		}
		return day;
	}
	
	public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map, String day) {
		ArrayList<String> list = map.get(day);
		HashMap<String, Integer> countIP = new HashMap<String, Integer>();
		for (String ip: list){
			if (!countIP.containsKey(ip))
				countIP.put(ip, 1);
			else
				countIP.put(ip, countIP.get(ip)+1);
		}
		ArrayList<String> ipMostVisits = iPsMostVisits(countIP);
		return ipMostVisits;
	}

}