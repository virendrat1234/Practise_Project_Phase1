package assignment;

public class MainAClass {
	MainAClass() {
	}

	void msg() {
		System.out.println("Hello java1");
	}
	public static void main(String args[]) {
		MainAClass obj = new MainAClass();// Compile Time Error
		obj.msg();
	}
}