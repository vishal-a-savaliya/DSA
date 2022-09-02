/*
 
Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.


Example 1:

Input:
N = 5
Arr[] = {1,2,3,-2,5}
Output:
9
Explanation:
Max subarray sum is 9
of elements (1, 2, 3, -2, 5) which 
is a contiguous subarray.
Example 2:

Input:
N = 4
Arr[] = {-1,-2,-3,-4}
Output:
-1
Explanation:
Max subarray sum is -1 
of element (-1)

Your Task:
You don't need to read input or print anything. The task is to complete the function maxSubarraySum() which takes Arr[] and N as input parameters and returns the sum of subarray with maximum sum.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 106
-107 ≤ A[i] ≤ 107
 
*/

// Company Tags
// 24*7 Innovation Labs Accolite Amazon Citrix D-E-Shaw FactSet Flipkart HikeHousing.com MetLife Microsoft Morgan Stanley Ola Cabs Oracle Payu Samsung Snapdeal Teradata Visa Walmart Zoho Google Adobe Arcesium

class Solution {

    // arr: input array
    // n: size of array
    // Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n) {

        // Brute forse Approch
        // Time complexity is O(N^3)
        // find out all the subarray and do sum and find max

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum > max)
                    max = sum;
            }
        }

        // here in O(n^3) solution we can elemenate the third loop by doing sum in
        // secound loop bc the 3rd loop is doing sum of i to j that can be done in 2nd
        // loop

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum = 0;

            for (int j = i; j < n; j++) {

                sum += arr[j];

                if (sum > max)
                    max = sum;
            }
        }

        // best Approch by using kadane's Algo T -> O(N)
        // do the sum while iterating if the sum become negative then do sum = 0 bc if
        // sum is -Ve then that always going to decrese sum if we add that subarray to
        // your new element

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum > max)
                max = sum;

            if (sum < 0)
                sum = 0;

        }

        return max;

    }

}