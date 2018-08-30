// https://www.geeksforgeeks.org/jump-search/

/* 
Time Complexity : O(√n)
Auxiliary Space : O(1)

Important points:
Works only sorted arrays.
The optimal size of a block to be jumped is O(√ n). This makes the time complexity of Jump Search O(√ n).
The time complexity of Jump Search is between Linear Search ( ( O(n) ) and Binary Search ( O (Log n) ).
Binary Search is better than Jump Search, but Jump search has an advantage that we traverse back only once 
(Binary Search may require up to O(Log n) jumps, consider a situation where the element to be search is 
the smallest element or smaller than the smallest). So in a systems where jumping back is costly, we use Jump Search.

Let’s consider the following array: (0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610). Length of the array is 16. Jump search will find the value of 55 with the following steps assuming that the block size to be jumped is 4.
STEP 1: Jump from index 0 to index 4;
STEP 2: Jump from index 4 to index 8;
STEP 3: Jump from index 8 to index 16;
STEP 4: Since the element at index 16 is greater than 55 we will jump back a step to come to index 9.
STEP 5: Perform linear search from index 9 to get the element 55.

*/

public class JumpSearch
{
    public static int jumpSearch(int[] arr, int x)
    {
        int n = arr.length;
 
        // Finding block size to be jumped
        int step = (int)Math.floor(Math.sqrt(n));
 
        // Finding the block where element is
        // present (if it is present)
        int prev = 0;
        while (arr[Math.min(step, n)-1] < x)
        {
            prev = step;
            step += (int)Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }
 
        // Doing a linear search for x in block
        // beginning with prev.
        while (arr[prev] < x)
        {
            prev++;
 
            // If we reached next block or end of
            // array, element is not present.
            if (prev == Math.min(step, n))
                return -1;
        }
 
        // If element is found
        if (arr[prev] == x)
            return prev;
 
        return -1;
    }
 
    // Driver program to test function
    public static void main(String [ ] args)
    {
        int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21,
                     34, 55, 89, 144, 233, 377, 610};
        int x = 55;
 
        // Find the index of 'x' using Jump Search
        int index = jumpSearch(arr, x);
 
        // Print the index where 'x' is located
        System.out.println("\nNumber " + x +
                            " is at index " + index);
    }
}
