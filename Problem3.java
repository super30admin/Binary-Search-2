// Time Complexity : O(log n)
// Space Complexity : O(1) constance space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, initially I was running into time limit exceeding, then tried to debug the code
//I came up with recursion approach as I thought that there could be answer on either side of mid and not just one side
//We need to check either side until we find the answer

public class Problem3 {
    public int findPeakElement(int[] nums) {
        //base case
        if(nums == null || nums.length == 0) return -1;

        //declare low and high
        int low = 0;
        int high = nums.length - 1;

        return binarySearch(nums, low, high);
    }

    public int binarySearch(int[] nums, int low, int high){
        //base case
        if(nums == null || nums.length == 0 || low > high) return -1;

        if(low == high){
            return low;
        }
        int mid = low + (high-low)/2;
        if(nums[mid] > nums[mid + 1]){
            return binarySearch(nums, low, mid);
        }
        return binarySearch(nums, mid + 1, high);

    }
}
