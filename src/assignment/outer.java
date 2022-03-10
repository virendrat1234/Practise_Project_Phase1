package assignment;

public class outer {
 
    // Class 2
    // Simple nested inner class
    class Inner {
 
        // show() method of inner class
        public void show()
        {
 
            // Print statement
            System.out.println("In a nested class method");
        }
    }

    // Main driver method
    public static void main(String[] args)
    {
 
        // Note how inner class object is created inside
        // main()
        outer.Inner in = new outer().new Inner();
 
        // Calling show() method over above object created
        in.show();
    }
}
 


