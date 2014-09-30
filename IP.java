package ip_addresses;

public class IP {
	public int[] nums;
	
	public IP() {
		nums = new int[4];
	}
	
	public boolean setIP(String ip) {
		String[] values = ip.split("\\.");
		
		if (values.length != 4) return false;
		
		for (int i = 0; i < values.length; i++) {
			int value = Integer.parseInt(values[i]);
			
			if (value < 0 || value > 255) return false;
			
			nums[i] = value;
		}
		
		return true;
	}

}
