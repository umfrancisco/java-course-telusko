
public class Machine {
	
	public String toHexadecimal(int num) {
		if (num == 0) {
			return "0";
		}
		String hex = "";
		while (num > 0) {
			int res = num % 16;
			switch (res) {
				case 10 -> hex += "A";
				case 11 -> hex += "B";
				case 12 -> hex += "C";
				case 13 -> hex += "D";
				case 14 -> hex += "E";
				case 15 -> hex += "F";
				default -> hex += res+"";
			}
			num = num / 16;
		}
		return reverse(hex);
	}
	
	public String toBinary(int num) {
		if (num == 0) {
			return "0";
		}
		String bin = "";
		while (num > 0) {
			bin += (num % 2)+"";
			num = num / 2;
		}
		return reverse(bin);
	}
	
	public static String reverse(String data) {
		String reversed = "";
		int size = data.length();
		for (int i = 0; i < size; i++) {
			reversed += data.charAt(size - 1 - i);
		}
		return reversed;
	}
}
