
/**
 * Write a description of testLogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class tester {
    
    public void testLogAnalyzer(){
    LogAnalyzer le = new LogAnalyzer();
    le.readFile("testData/short-test_log");
    le.printAll();
   }
   public void testUniqIP(){
       LogAnalyzer la = new LogAnalyzer();
       la.readFile("testData/weblog2_log");
       int uniqueIPs = la.countUniqueIPs();
       System.out.println("There are " + uniqueIPs + " unique IPs");
    }
    public void testuniqueIPVisitsOnDay() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("testData/weblog2_log");
        ArrayList<String> IPa = la.uniqueIPVisitsOnDay("Sep 24");
        ArrayList<String> IPb = la.uniqueIPVisitsOnDay("Sep 30");
        System.out.println(IPa.toString());
        System.out.println(IPb.toString());
    }
    
    public void testuniqueIPVisitsOnDay2() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("testData/weblog2_log");
        ArrayList<String> IP = la.uniqueIPVisitsOnDay("Mar 17");
        System.out.println(IP.size());
        System.out.println(IP.toString());
    }
    
    public void testcountUniqueIPsInRange() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("testData/weblog2_log");
        int countIPs = la.countUniqueIPsInRange(200,299);
        System.out.println("There are " + countIPs + " unique IP addresses that have a status code from 200 to 299");
        countIPs = la.countUniqueIPsInRange(300,399);
        System.out.println("There are " + countIPs + " unique IP addresses that have a status code from 300 to 399");
    }
    
    public void testcountUniqueIPsInRange2() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("testData/weblog2_log");
        int countIPs = la.countUniqueIPsInRange(200,299);
        System.out.println("There are " + countIPs + " unique IP addresses that have a status code from 200 to 299");
    }
    
    public void testCounts(){
       LogAnalyzer la = new LogAnalyzer();
       la.readFile("testData/weblog2_log");
       HashMap<String,Integer> counts = la.countVisitsPerIP();
       System.out.println(counts);
    }
    	public void testcountVisitsPerIP() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("testData/weblog2_log");
		System.out.println(la.countVisitsPerIP());
	}
	
	public void testmostNumberVisitsByIP() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("testData/weblog2_log");
		System.out.println(la.mostNumberVisitsByIP(la.countVisitsPerIP()));
	}
	
	public void testiPsMostVisits() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("testData/weblog2_log");
		ArrayList<String> list = la.iPsMostVisits(la.countVisitsPerIP());
		for (int i=0; i< list.size();i++) 
			System.out.print(list.get(i) + " ");
		System.out.println();
	}
	
	public void testiPsForDays() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("testData/weblog3-short_log");
		HashMap<String, ArrayList<String>> map = la.iPsForDays();
		for (Map.Entry<String, ArrayList<String>> e : map.entrySet()) {
			System.out.println(e.getKey() + " maps to " + e.getValue().size() + " IP address(es)");
		}
	}
	
	public void testdayWithMostIPVisits() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("testData/weblog2_log");
		HashMap<String, ArrayList<String>> map = la.iPsForDays();
		System.out.println(la.dayWithMostIPVisits(map));
	}
	
	public void testiPsWithMostVisitsOnDay() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("testData/weblog2_log");
		HashMap<String, ArrayList<String>> map = la.iPsForDays();
		System.out.println(la.iPsWithMostVisitsOnDay(map, "Sep 30"));
	}
}
