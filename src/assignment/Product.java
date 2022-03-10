package assignment;

public class Product {
 
    // Answers product queries given as two arrays
    // lower[] and upper[].   
    static void findProduct(long[] arr, int[] lower,
                                        int[] upper)
    {
        int n = arr.length;
        long[] preProd = new long[n];
        int[] countZeros = new int[n];
 
        long prod = 1; // stores the product
 
        // keeps count of zeros
        int count = 0;
        for (int i = 0; i < n; i++) {
 
            // if arr[i] is 0, we increment count and
            // do not multiply it with the product
            if (arr[i] == 0)
                count++;
            else
                prod *= arr[i];
 
            // store the value of prod in dp
            preProd[i] = prod;
 
            // store the value of count in countZeros
            countZeros[i] = count;
        }
 
        // We have preprocessed the array, let us
        // answer queries now.
        for (int i = 0; i < lower.length; i++) {
            int l = lower[i];
            int u = upper[i];
 
            // range starts from first element
            if (l == 1)
            {
                // range does not contain any zero
                if (countZeros[u - 1] == 0)
                    System.out.println(preProd[u - 1]);
                else
                    System.out.println(0);
            }
 
            else // range starts from any other index
            {
                // no difference in countZeros indicates that
                // there are no zeros in the range
                if (countZeros[u - 1] - countZeros[l - 2] == 0)
                    System.out.println(preProd[u - 1] / preProd[l - 2]);
 
                else // zeros are present in the range
                    System.out.println(0);
            }
        }
    }
 
    public static void main(String[] args)
    {
        long[] arr = new long[] { 0, 2, 3, 4, 5 };
        int[] lower = {1, 2};
        int[] upper = {3, 2};    
        findProduct(arr, lower, upper);
    }
}


