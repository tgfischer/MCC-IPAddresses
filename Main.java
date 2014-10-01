package ip_addresses;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
	public static void main(String[] args) {
		try {
			// This opens the JudgeInput text file for reading
			BufferedReader reader = new BufferedReader(new FileReader("JudgeInput.txt"));
			
			String line;									// Stores the line that is read from the text file
			
			while ((line = reader.readLine()) != null) {	// Iterates through all of the lines in the text file
				String[] ips = line.split(" ");				// Splits the line at each space, and save the items in an array
				
				IP start = new IP();				// Create a new start IP object
				start.setIP(ips[0]);				// Set up the underlying array in the IP object
				
				IP end = new IP();					// Create a new end IP object
				end.setIP(ips[1]);					// Set up the underlying array in the IP object
				
				IP check = new IP();				// Create a new IP that you will be checking against the start and end IPs
				
				if (!check.setIP(ips[2])) {			// Set up the underlying array in the IP object, and check if the IP is valid
					System.out.println("InValid");	// Print out that the IP is invalid
					continue;						// Skip to the next set of IPs
				}
				
				if (checkInRange(start, end, check)) System.out.println("InRange");		// If the IP that you are checking is in the subnet
				else 								 System.out.println("OutRange");	// If the IP that you are checking is not in the subnet
			}
			
			reader.close();		// Close the buffered reader
		} catch (Exception e) { // Catches all exceptions (Was easier since I was pressed for time...)
			e.printStackTrace();
		}
	}
	
	/**
	 * Checks to see if the 'check' IP address is in the subnet (defined by the start IP and the end IP)
	 * @param start - the lower bound for the subnet range
	 * @param end   - the upper bound for the subnet range
	 * @param check - the IP you are checking
	 * @return Whether or not the IP is in the subnet
	 */
	public static boolean checkInRange(IP start, IP end, IP check) {
		for (int i = 0; i < 4; i++) { 	// Iterates through the 4 parts of the IP addresses
			// Checks if this part of the IP is in the range, and it is not 0
			if ((check.nums[i] < start.nums[i] || check.nums[i] > end.nums[i]) && check.nums[i] != 0) 
				return false; 			// Return that this IP is not in the subnet
		}
		
		return true;					// Return that this IP is in the subnet
	}
}