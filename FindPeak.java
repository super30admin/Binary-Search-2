// Find the peak element in the array

// Time Complexity : O(log n) as we are using binary search
// Space Complexity : O(1) as we are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// This is a binary search problem where we need to find the peak element in the array.
// we have to reach the peak before going down
// elements out of bounds are -infinity
// array can have multiple peak, return any one
// we compare the mid element with its neighbours to determine if it is the peak element
// if it is not the peak element, we move towards the higher number

public class FindPeak {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2; // identify the mid
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == high || nums[mid] > nums[mid + 1])) // check the peak element(means greater than both the neighbour)
            {
                return mid;
            } else if(nums[mid + 1] > nums[mid]) { // when not at peak move towards the higher number
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // 3434
    }
    public static void main(String[] args) {
        FindPeak findPeak = new FindPeak();
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(findPeak.findPeakElement(nums));
    }
}
