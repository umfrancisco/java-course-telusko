import java.util.UUID;

public class Application {
	public static void main(String[] args) {
		Machine.getId(100, "BR");
	}
}

class Machine {
	public static void getId(int size, String prefix) {
		for (int i = 0; i < size; i++) {
			String code = UUID.randomUUID().toString().substring(0, 8);
			System.out.println(prefix+code);
		}
	}
}