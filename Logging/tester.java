
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
    le.readFile("short-test_log");
    le.printAll();
   }
   public void testUniqIP(){
       LogAnalyzer la = new LogAnalyzer();
       la.readFile("short-test_log");
       int uniqueIPs = la.countUniqueIPs();
       System.out.println("There are " + uniqueIPs + " unique IPs");
    }
    public void testuniqueIPVisitsOnDay() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("weblog-short_log");
		ArrayList<String> IPa = la.uniqueIPVisitsOnDay("Sep 14");
		ArrayList<String> IPb = la.uniqueIPVisitsOnDay("Sep 30");
		System.out.println(IPa.toString());
		System.out.println(IPb.toString());
	}
	
	public void testuniqueIPVisitsOnDay2() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("weblog1_log");
		ArrayList<String> IP = la.uniqueIPVisitsOnDay("Mar 17");
		System.out.println(IP.size());
		System.out.println(IP.toString());
	}
	
	public void testcountUniqueIPsInRange() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("short-test_log");
		int countIPs = la.countUniqueIPsInRange(200,299);
		System.out.println("There are " + countIPs + " unique IP addresses that have a status code from 200 to 299");
	    countIPs = la.countUniqueIPsInRange(300,399);
		System.out.println("There are " + countIPs + " unique IP addresses that have a status code from 300 to 399");
	}
	
	public void testcountUniqueIPsInRange2() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("weblog1_log");
		int countIPs = la.countUniqueIPsInRange(200,299);
		System.out.println("There are " + countIPs + " unique IP addresses that have a status code from 200 to 299");
	}
}
