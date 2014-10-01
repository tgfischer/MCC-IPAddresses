package ip_addresses;

public class IP {
	public int[] nums;										// Stores the different parts of the IP address
	
	public IP() {
		this.nums = new int[4];
	}
	
	/**
	 * Used to set the values of the IP address
	 * @param ip - A string containing the 4 parts of the IP address, separated by periods (.)
	 * @return Whether or not the IP is valid
	 */
	public boolean setIP(String ip) {
		String[] values = ip.split("\\.");					// Split the IP at the periods and store the items in an array
		
		if (values.length != 4) return false;				// Return false if there are not 4 parts in the array
		
		for (int i = 0; i < values.length; i++) {			// Iterate through all the parts of the IP address
			int value = Integer.parseInt(values[i]);		// Convert the part to an integer
			
			if (value < 0 || value > 255) return false;		// Check if this part is less than 0 or greater than 255
			
		this.nums[i] = value;								// Save this part to this objects IP address
		}
		
		return true;										// Return that this IP is valid
	}

}
