/*
 * 
 * Given an array arr[] and an integer K where K is smaller than size of array,
 * the task is to find the Kth smallest element in the given array. It is given
 * that all array elements are distinct.
 * 
 * Example 1:
 * 
 * Input:
 * N = 6
 * arr[] = 7 10 4 3 20 15
 * K = 3
 * Output : 7
 * 
 * Explanation :
 * 3rd smallest element in the given
 * array is 7.
 * Example 2:
 * 
 * Input:
 * N = 5
 * arr[] = 7 10 4 20 15
 * K = 4
 * Output : 15
 * 
 * Explanation :
 * 4th smallest element in the given
 * array is 15.
 * Your Task:
 * You don't have to read input or print anything. Your task is to complete the
 * function kthSmallest() which takes the array arr[], integers l and r denoting
 * the starting and ending index of the array and an integer K as input and
 * returns the Kth smallest element.
 * 
 * 
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(log(n))
 * 
 * Constraints:
 * 1 <= N <= 105
 * 1 <= arr[i] <= 105
 * 1 <= K <= N
 * 
 */

// COMPANY TAG
// ABCO Accolite Amazon Cisco Hike Microsoft Snapdeal VMWare Google Adobe

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int arr[] = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            int k = sc.nextInt();
            Solution ob = new Solution();
            out.println(ob.kthSmallest(arr, 0, n - 1, k));
        }
        out.flush();
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {

    // the brute force approach
    public static int kthSmallest(int[] arr, int l, int r, int k) {

        Arrays.sort(arr);

        return arr[l + k - 1];
    }

    // using priority queue
    // The time complexity is O(N logN)

    public static int kthSmallest(int[] arr, int l, int r, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = l; i <= r; i++) {
            pq.add(arr[i]);
        }

        for (; k > 1;) {
            pq.poll();
            k--;
        }

        return pq.poll();

    }

    // Quick select algorithm
    public static int kthSmallest(int[] arr, int l, int r, int k) {

        int partation_index = partation(arr, l, r);

        if (partation_index == k - 1) {
            return arr[k - 1];
        }

        else if (partation_index > k - 1) {
            return kthSmallest(arr, l, partation_index - 1, k);
        }

        else {
            return kthSmallest(arr, partation_index + 1, r, k);
        }

    }

    public static int partation(int[] arr, int l, int r) {

        if (l == r) {
            return l;
        }

        int pivot = arr[r];

        // swapping less element from pivot to the left side of pivot

        for (int i = l; i < r; i++) {

            if (arr[i] < pivot) {

                // swap
                int stored_val = arr[i];
                arr[i] = arr[l];
                arr[l] = stored_val;
                l++;

            }

        }

        // swapping pivot and the l to put pivot at posotion

        arr[r] = arr[l];
        arr[l] = pivot;

        return l;
    }

}
