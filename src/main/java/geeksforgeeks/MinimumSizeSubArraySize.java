package geeksforgeeks;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of
 * which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 *
 * O(n) Solution
 */
public class MinimumSizeSubArraySize {

    public int[] findMinimumSubarraySumsToTarget(int[] arr, int target){

        int start = 0;
        int end =0;
        int sum = 0;
        int minWindow = arr.length+1;
        int finalStart = 0;
        int finalEnd = 0;
        while(end<arr.length) {

            while (sum < target && end<arr.length) {
                sum += arr[end];
                if(end == arr.length-1 && start==0)
                    return new int[]{0}; // can not reach sum return 0
                end++;
            }

            while (sum > target && start<arr.length) {
                sum -= arr[start];
                start++;
            }

            sum -=start;
            start--;

            if (end - start < minWindow) {
                minWindow = end - start;
                finalEnd = end;
                finalStart = start;
            }
        }

            int[] result = new int[finalEnd-finalStart];
            int ind = 0;
            for(int i=finalStart;i<finalEnd;i++){
                result[ind] = arr[i];
                ind++;
            }
            return result;
    }
}
