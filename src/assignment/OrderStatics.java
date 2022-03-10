package assignment;


import java.util.Random;

public final class OrderStatics {

    private OrderStatics() {}

    /**
     * Returns the {@code order}th order statistics of the array {@code array}. 
     * If {@code order == 0}, returns the minimum element; if 
     * {@code order == 1}, returns the second smallest element, and so on.
     * 
     * @param array the array to search.
     * @param order the order of the element to search. 
     * @return the <code>order</code>th smallest element.
     */
    public static int randomizedSelect(int[] array, int order) {
        checkOrder(order, array);
        Random random = new Random();
        return randomizedSelect(array, 0, array.length - 1, order + 1, random);
    }

    /**
     * Checks that the requested order is within array bounds.
     * 
     * @param order the order to check.
     * @param array the array to search.
     */
    private static void checkOrder(int order, int[] array) {
        if (order < 0) {
            throw new IndexOutOfBoundsException("Negative order: " + order);
        }

        if (order >= array.length) {
            throw new IndexOutOfBoundsException(
                    "Order is too large (" + order + "). Must be at most " +
                    (array.length - 1) + ".");
        }
    }

    /**
     * Performs a randomized selection of an element with order {@code order}.
     * 
     * @param array      the array holding the range to search.
     * @param startIndex the index of the leftmost element of the array range.
     * @param endIndex   the index of the rightmost element of the array range.
     * @param order      the requested order.
     * @param random     the random number generator.
     * 
     * @return the <code>order</code>th smallest element.
     */
    private static int randomizedSelect(int[] array,
                                        int startIndex,
                                        int endIndex,
                                        int order,
                                        Random random) {
        if (startIndex == endIndex) {
            return array[startIndex];
        }

        int pivotIndex = randomizedPartition(array,
                                             startIndex, 
                                             endIndex, 
                                             random);
        int k = pivotIndex - startIndex + 1;

        if (order == k) {
            return array[pivotIndex];
        } else if (order < k) {
            return randomizedSelect(array, 
                                    startIndex, 
                                    pivotIndex - 1, 
                                    order, 
                                    random);
        } else {
            return randomizedSelect(array,
                                    pivotIndex + 1,
                                    endIndex,
                                    order - k,
                                    random);
        }
    }

    private static int randomizedPartition(int[] array,
                                           int startIndex,
                                           int endIndex,
                                           Random random) {
        int rangeLength = endIndex - startIndex + 1;
        int i = startIndex + random.nextInt(rangeLength);
        swap(array, endIndex, i);
        return partition(array, startIndex, endIndex);
    }

    private static int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[endIndex];
        int i = startIndex - 1;

        for (int j = startIndex; j < endIndex; ++j) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, endIndex);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

