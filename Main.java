package ip_addresses;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("JudgeInput.txt"));
			
			String line;
			
			while ((line = reader.readLine()) != null) {
				String[] ips = line.split(" ");
				
				IP start = new IP();
				start.setIP(ips[0]);
				
				IP end = new IP();
				end.setIP(ips[1]);
				
				IP check = new IP();
				
				if (!check.setIP(ips[2])) {
					System.out.println("InValid");
					continue;
				}
				
				boolean output = checkInRange(start, end, check);
				if (output) System.out.println("InRange");
				else System.out.println("OutRange");
			}
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean checkInRange(IP start, IP end, IP check) {
		for (int i = 0; i < 4; i++) {
			if ((check.nums[i] < start.nums[i] || check.nums[i] > end.nums[i]) && check.nums[i] != 0) 
				return false; 
		}
		
		return true;
	}
}