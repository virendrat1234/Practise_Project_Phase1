package assignment;

public class CGF {
 
    // Main driver method
    public static void main(String args[])
    {
        // Custom wide-varied inputs to illustrate
        // usage of valueOf() method
        int decimalExample = Integer.parseInt("20");
        int signedPositiveExample = Integer.parseInt("+20");
        int signedNegativeExample = Integer.parseInt("-20");
        int radixExample = Integer.parseInt("20", 16);
        int stringExample = Integer.parseInt("geeks", 29);
 
        // It will raise NumberFormatException
        String invalidArguments = "";
        int emptyString
            = Integer.parseInt(invalidArguments);
        int outOfRangeOfInteger
            = Integer.parseInt("geeksforgeeks", 29);
        int domainOfNumberSystem
            = Integer.parseInt("geeks", 28);
 
        // Print commands on console
        System.out.println(decimalExample);
        System.out.println(signedPositiveExample);
        System.out.println(signedNegativeExample);
        System.out.println(radixExample);
        System.out.println(stringExample);
    }
}


