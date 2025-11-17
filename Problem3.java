// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
Everytime I calculated mid, I checked it is the peak element
If it not, I moved the low to the higher side.
 */

public class Problem3 {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid-1] < nums[mid]) && (mid == nums.length - 1 || nums[mid+1] < nums[mid])) {
                return mid;
            } else if(nums[mid+1] > nums[mid]) {
                low = mid+1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Problem3 oProblem3 = new Problem3();
        int[] nums = { 3,4,5,6,1,2};
        System.out.println(oProblem3.findPeakElement(nums));
    }
}
