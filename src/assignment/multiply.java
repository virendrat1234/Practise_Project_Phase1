package assignment;

public class multiply {
    void mul(int a, int b) {
        System.out.println("Sum of two=" + (a * b));
    }

    void mul(int a, int b, int c) {
        System.out.println("Sum of three=" + (a * b * c));
    }
    
    
    public static void main(String args[]) {
    	multiply m = new multiply();
    	m.mul(6, 10);
    	m.mul(10, 6, 5);
    }
}


