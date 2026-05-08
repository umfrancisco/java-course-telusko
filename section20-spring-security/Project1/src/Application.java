
public class Application {
	public static void main(String[] args) {
		var machine = new Machine();
		String hex = machine.toHexadecimal(100);
		System.out.println(hex);
	}
}

